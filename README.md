# Pulso Háptico Bridge

Simulador Spring Boot de un dispositivo vibro-táctil. Permite seleccionar escenarios de medición y datasets desde un panel web, y expone el estado actual para que una aplicación externa lo consulte mediante polling.

Si no conoces alguna de las tecnologías utilizadas o necesitas una guía paso a paso, consulta [HELP.md](HELP.md).

## Requisitos

- Java 21
- Maven 3.9 o superior
- Docker y Docker Compose (opcional)

## Ejecución local

```bash
mvn spring-boot:run
```

La aplicación queda disponible en <http://localhost:8080>.

También se puede construir y ejecutar el JAR:

```bash
mvn clean package
java -jar target/bridge.jar
```

## Panel web

Abre <http://localhost:8080/> para seleccionar:

- **Tipo de medición:** `DEREGULATED`, `REGULATED`.
- **Tipo de dataset:** `HSNEAS`, `LSNEAS`, `HSOEAS`, `LSOEAS`, `HSNERS` y `LSNERS`.

La configuración inicial es `REGULATED` para la medición y `HSNEAS` para el dataset.


## API

Los endpoints devuelven JSON y no requieren autenticación:

### Consultar el estado actual

```http
GET /api/get-data
```

Respuesta:

```json
{
  "measurement": {
    "offsetDateTime": "2026-09-07T22:00:00-03:00",
    "pulse": 0.25
  },
  "dataset": {
    "onEvent": false,
    "state": 0.8,
    "lastSensing": "2026-09-07T21:59:00-03:00"
  }
}
```

La documentación interactiva está disponible en <http://localhost:8080/swagger-ui/index.html>.

## Configuración

Las propiedades principales se configuran mediante variables de entorno:

| Variable | Valor predeterminado | Descripción |
|---|---:|---|
| `APP_PORT` | `8080` | Puerto HTTP de la aplicación |
| `CORS_ORIGIN` | `*` | Origen permitido para CORS |

Para configurar el entorno local:

```bash
cp .env.example .env
```

Revisa y reemplaza los valores sensibles antes de iniciar los contenedores. No publiques el archivo `.env`.

## Docker Compose

El compose levanta el bridge y un túnel ngrok:

```bash
make up
```

Comandos disponibles:

```bash
make up-dev   # Ejecuta en primer plano
make up       # Ejecuta en segundo plano
make logs     # Muestra los logs del bridge
make restart  # Reinicia los servicios
make down     # Detiene los servicios
make build    # Construye las imágenes
```

El panel se publica en <http://localhost:8080> y la interfaz local de ngrok en <http://localhost:4040>.

## Estructura principal

```text
src/main/java/com/pulsohaptico/bridge/
├── controller/    # Controladores web y API
├── model/         # Tipos y modelos de medición/dataset
├── service/       # Construcción y selección del estado simulado
├── decorator/     # Composición de escenarios y datasets
└── dto/           # Respuestas de la API
```

El panel Thymeleaf está en `src/main/resources/templates/index.html` y sus estilos en `src/main/resources/static/css/styles.css`.

## Validación

```bash
mvn test
```
