Для возможности удаленной отладки при запуске с помощью Maven 
нужно в папке проекта создать каталог .mvn и добавить в него файл
конфигурации jvm.config (<проект>/.mvn/jvm.config) со следующим значением:

-Xdebug -Xrunjdwp:transport=dt_socket,address=8080,server=y,suspend=y

Билд с проверкой кода: mvn checkstyle:check \
Запуск: mvn jetty:run в папке

Админ (логин : пароль): tyu : tyu \
Юзер (логин : пароль): qwe : qwe