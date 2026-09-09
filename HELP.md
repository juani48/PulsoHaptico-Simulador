# Guía para usar y entender el simulador

Esta guía explica, con palabras simples, las tecnologías usadas en el proyecto y el flujo necesario para levantar el simulador. No necesitas conocerlas todas para empezar: sigue primero la sección de uso rápido y consulta las demás cuando quieras entender el código.

## 1. Qué hace el proyecto

El proyecto simula un dispositivo vibro-táctil sin necesidad de tener el hardware real. Tiene dos formas de uso:

- Un **panel web** para elegir el escenario de medición y el dataset.
- Una **API HTTP** que otra aplicación puede consultar periódicamente (*polling*) para leer el estado simulado.

El flujo normal es:

1. Iniciar la aplicación.
2. Abrir `http://localhost:8080`.
3. Seleccionar un tipo de medición y un dataset.
4. Consultar `http://localhost:8080/api/get-data` desde la aplicación cliente.

## 2. Uso rápido

### Opción A: Java y Maven

Requisitos:

- Java 21
- Maven 3.9 o superior

Desde la carpeta raíz:

```bash
mvn spring-boot:run
```

Después, abre <http://localhost:8080>.

Para ejecutar una versión empaquetada:

```bash
mvn clean package
java -jar target/bridge.jar
```

### Opción B: Docker Compose

Requisitos:

- Docker
- Docker Compose

Configura las variables locales y levanta los servicios:

```bash
cp .env.example .env
make up
```

El panel estará en <http://localhost:8080>. Para ver los logs:

```bash
make logs
```

Para detener los servicios:

```bash
make down
```

## 3. Tecnologías explicadas

### Java

Java es el lenguaje en el que está escrito el backend. El proyecto usa Java 21, por lo que debes tener esa versión instalada:

```bash
java -version
```

El código Java está en `src/main/java`.

### Maven

Maven administra las dependencias, compila el código, ejecuta las pruebas y genera el archivo `.jar`. La configuración está en `pom.xml`.

Comandos frecuentes:

| Comando | Uso |
|---|---|
| `mvn spring-boot:run` | Inicia la aplicación en desarrollo |
| `mvn test` | Ejecuta las pruebas |
| `mvn clean package` | Limpia, compila y empaqueta la aplicación |

### Spring Boot

Spring Boot simplifica la creación de aplicaciones web Java. La clase `BridgeApplication` es el punto de entrada y la anotación `@SpringBootApplication` configura la aplicación.

En este proyecto, Spring Boot:

- Inicia el servidor web integrado.
- Detecta los controladores y servicios.
- Lee la configuración de `application.properties`.
- Serializa las respuestas Java a JSON.

### Spring MVC

Spring MVC organiza las solicitudes HTTP mediante controladores:

- `RenderController`: muestra el panel Thymeleaf y procesa las selecciones.
- `BridgeController`: expone la API JSON.

Las anotaciones más importantes son:

- `@GetMapping`: atiende solicitudes `GET`.
- `@PostMapping`: atiende solicitudes `POST`.
- `@RestController`: devuelve datos, normalmente JSON.
- `@Controller`: devuelve vistas HTML.
- `@RequestParam`: recibe parámetros enviados por una solicitud.

### Thymeleaf

Thymeleaf es el motor de plantillas HTML usado para construir el panel web. La plantilla está en:

```text
src/main/resources/templates/index.html
```

El controlador envía datos al modelo y Thymeleaf los inserta en el HTML. Por ejemplo, `th:each` repite un formulario para cada escenario disponible.

### HTML y CSS

El HTML define la estructura del panel y el CSS define su apariencia. Los estilos están en:

```text
src/main/resources/static/css/styles.css
```

No hace falta modificar Java para cambiar colores, espacios o tamaños del panel.

### API REST, HTTP y JSON

La API usa HTTP y devuelve JSON. La aplicación cliente puede consultar el estado con:

```bash
curl http://localhost:8080/api/get-data
```

La respuesta contiene `measurement` y `dataset`. La aplicación cliente puede repetir esta consulta cada cierto tiempo; esto es *polling*.

El panel cambia la configuración mediante formularios `POST`:

- `POST /set-measurement`
- `POST /set-dataset`

### OpenAPI y Swagger UI

OpenAPI describe la API de forma estándar. Swagger UI muestra esa descripción en una página interactiva:

<http://localhost:8080/swagger-ui/index.html>

Desde allí puedes revisar y probar los endpoints sin escribir un cliente propio.

### Lombok

Lombok genera código repetitivo durante la compilación. Por ejemplo, `@RequiredArgsConstructor` crea un constructor para las dependencias `final` de un controlador o servicio.

Si el IDE muestra errores sobre métodos o constructores que no ves escritos, verifica que el soporte de Lombok esté habilitado.

### Docker y Docker Compose

Docker ejecuta la aplicación dentro de un contenedor aislado. El `Dockerfile` usa dos etapas:

1. Una imagen con Maven para compilar.
2. Una imagen Java más pequeña para ejecutar el `.jar`.

Docker Compose coordina el contenedor del bridge y el contenedor de ngrok definido en `docker-compose.yml`. Los comandos habituales están resumidos en el `Makefile`.

### ngrok

ngrok crea un túnel desde Internet hacia el servicio local. Es útil cuando una aplicación externa necesita acceder al simulador que corre en tu computadora.

La interfaz local de ngrok está en <http://localhost:4040>. Configura `NGROK_AUTHTOKEN` en `.env` si tu cuenta de ngrok lo requiere. No compartas el archivo `.env`.

### Variables de entorno y CORS

Las variables se leen desde `application.properties`:

| Variable | Propósito | Valor habitual |
|---|---|---|
| `APP_PORT` | Puerto del bridge | `8080` |
| `CORS_ORIGIN` | Origen autorizado para solicitudes del navegador | `*` durante desarrollo |
| `TUNNEL_PORT` | Puerto de la interfaz de ngrok | `4040` |

`CORS` es una regla del navegador que controla qué sitios pueden llamar a la API. En producción conviene reemplazar `*` por el dominio real de la aplicación cliente.

## 4. Cómo se modelan los escenarios

### Tipo de medición

Hay dos escenarios:

- `DEREGULATED`: medición con alta presión arterial.
- `REGULATED`: medición con baja presión arterial.

Se representan en `MeasurementType` y se construyen en `MeasurementDirector`.

> [!DISCLAIMER]
> Las mediciones simuladas no reflejan la realidad y son datos de prueba. No se toman en cuenta estandares médicos.
 
### Tipo de dataset

Cada nombre combina tres características:

- `HS` o `LS`: estado alto o bajo en % de la persona.
- `OE` o `NE`: dentro o fuera de un evento.
- `AS` o `RS`: sensado antiguo o reciente.

Ejemplo: `HSNERS` significa estado alto, fuera de evento y sensado reciente.

Estos valores están definidos en `DatasetType` y se construyen en `DatasetDirector`.

### Patrón Decorator

El patrón **Decorator** permite agregar características a un objeto envolviéndolo con otros objetos, sin crear una clase distinta para cada combinación.

Por ejemplo, un dataset puede componerse así:

```text
Estado alto
  + fuera de evento
    + sensado antiguo
```

Las clases de este patrón están en `decorator/`. Los `Builder` seleccionan la combinación correspondiente al valor elegido en el panel.

### DTO

DTO significa *Data Transfer Object*. Son objetos simples usados para definir la forma de los datos que salen por la API. En este proyecto están en `dto/`, por ejemplo `MeasurementResponse` y `DatasetResponse`.

## 5. Dónde buscar cada cosa

```text
src/main/java/com/pulsohaptico/bridge/
├── controller/   # Entrada HTTP y navegación del panel
├── model/        # Tipos y datos del dominio
├── service/      # Lógica para seleccionar y construir estados
├── decorator/    # Composición de escenarios
├── dto/          # Formato de respuestas JSON
└── config/       # Configuración de CORS y OpenAPI
```

## 6. Problemas frecuentes

### El puerto 8080 está ocupado

Usa otro puerto al iniciar la aplicación:

```bash
APP_PORT=8081 mvn spring-boot:run
```

Luego abre `http://localhost:8081`.

### Maven no encuentra Java

Comprueba que Java 21 esté instalado y que `JAVA_HOME` apunte a esa instalación:

```bash
java -version
echo "$JAVA_HOME"
```

### El panel abre, pero la aplicación cliente recibe un error CORS

Configura `CORS_ORIGIN` con el origen exacto de la aplicación cliente y reinicia el bridge. Durante desarrollo puedes usar `*`, aunque no es recomendable para producción.

### Cambié la selección, pero la API no responde como esperaba

Confirma que estás usando el endpoint completo:

```text
http://localhost:8080/api/get-data
```

Revisa también en el panel qué escenario y dataset aparecen marcados como activos.
