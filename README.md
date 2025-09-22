# Automatización de Pruebas - Banca Ficticia

Proyecto de SELENIUM WEBDRIVER automatización de pruebas para el sitio web de Banca Ficticia implementando Selenium WebDriver con Java.

## Requisitos del Sistema
- Java JDK 17
- Apache Maven 3.6.0+
- Google Chrome (última versión estable)

## Configuración del Proyecto

1. Clonar el repositorio
2. Instalar dependencias:
```bash
mvn clean install

Ejecución de Pruebas
Para ejecutar todas las pruebas:

bash
mvn test
Para ejecutar una prueba específica:

bash
mvn test -Dtest=BancaFicticiaTest#nombreDelMetodoDePrueba
Casos de Prueba Implementados
Login exitoso con usuario válido

Verifica el acceso al sistema con credenciales válidas

Valida que se muestra el nombre de usuario correctamente

Login fallido con credenciales incorrectas

Verifica el mensaje de error con credenciales inválidas

Valida que no se permite el acceso

Consulta de saldo tras iniciar sesión

Accede a la sección de consulta de saldo

Verifica que se muestra la información del saldo

Transferencia bancaria exitosa

Realiza una transferencia con datos válidos

Verifica el mensaje de confirmación

Transferencia con saldo insuficiente

Intenta transferir un monto mayor al saldo disponible

Verifica el mensaje de error correspondiente

Logout y retorno al formulario de login

Cierra la sesión activa

Verifica que se redirige al formulario de login

Estructura del Proyecto
src/test/java/com/bancaFicticia/BancaFicticiaTest.java: Clase principal de pruebas

src/test/java/com/bancaFicticia/pages/: Package con clases Page Object

BasePage.java: Clase base para pages

LoginPage.java: Interacción con formulario de login

MenuPage.java: Interacción con menú principal

TransferPage.java: Interacción con formulario de transferencia

BalancePage.java: Interacción con consulta de saldo

pom.xml: Configuración de Maven con dependencias

Tecnologías Utilizadas
Selenium WebDriver 4.21.0

WebDriverManager 5.8.0

JUnit Jupiter 5.10.2

Maven Surefire Plugin 3.2.5
