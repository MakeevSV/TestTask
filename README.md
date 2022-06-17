## Варианты запуска:

1 вариант:
- Перейти в каталог runnable, заполнить файл application.yml своими API ключами.
- Запустить приложение введя в консоли `java -jar alfabank-app.jar --spring.config.location=./application.yml` 

2 вариант:
- Перейти в каталог runnable, заполнить файл application.yml своими API ключами.
- В корне проекта `docker build --build-arg JAR_FILE=runnable/alfabank-app.jar -t alfabank .`
- Для запуска ввести `docker run -p 8080:8080 -v //application.yml:/application.yml alfabank` вместо `//application.yml` указать полный путь к заполненому файлу

## Обращение к сервису
После запуска:
endpoint - `localhost:8080/api/v1/course`
Принимает GET запрос с параметром name (идентификатор валюты), например `localhost:8080/api/v1/course?name=rub`
