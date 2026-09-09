.PHONY: help up up-dev down restart logs build
DOCKER_COMPOSE_FILE = docker-compose.yml
PANEL_URL = http://localhost:8080
TUNNEL_URL = http://localhost:4040

help:
	@echo "  make up-dev          Levanta el simulador en modo desarrollo"
	@echo "  make up              Igual que up pero en segundo plano"
	@echo "  make down            Apaga todo (bridge + tunel si estaba levantado)"
	@echo "  make restart         Reinicia el bridge y el tunel"
	@echo "  make logs            Ve los logs del bridge en vivo"
	@echo "  make build           Solo construye la imagen, sin levantar nada"

up-dev:
	docker compose -f $(DOCKER_COMPOSE_FILE) up --build
	@echo "Panel visual levantado: $(PANEL_URL)"
	@echo "Para obtener la URL del túnel: $(TUNNEL_URL)"

up:
	docker compose -f $(DOCKER_COMPOSE_FILE) up --build -d
	@echo "Panel visual en segundo plano: $(PANEL_URL)"
	@echo "Para obtener la URL del túnel: $(TUNNEL_URL)"

down:
	docker compose -f $(DOCKER_COMPOSE_FILE) down

restart:
	docker compose -f $(DOCKER_COMPOSE_FILE) down
	docker compose -f $(DOCKER_COMPOSE_FILE) up --build -d

# Ve los logs del bridge en vivo
logs:
	docker compose -f $(DOCKER_COMPOSE_FILE) logs -f bridge

# Solo construye la imagen, sin levantar nada
build:
	docker compose -f $(DOCKER_COMPOSE_FILE) build
