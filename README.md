Тестовый проект для подачи на стажировку!
Тестить ендпоинты строго в Postman!
Swagger для чистой документации!

Файлы с Docker находятся в ветке dev!

Dockerfile:
1) docker build . -t testproject
2) docker pull postgres
3) docker run --name test-postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=testDB -d postgres 
4) docker run -d -p 8080:8080 --name testproject --link test-postgres:postgres testproject

Docker-compose:
1) docker compose -f docker-compose.yml up 
