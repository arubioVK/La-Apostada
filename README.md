# La Apostada
[![Video de Youtube](http://img.youtube.com/vi/wRHiTgAeK6I&t=0s/0.jpg)](http://www.youtube.com/watch?v=wRHiTgAeK6I&t=0s)
## Descripción
Página de apuestas de fútbol, con diversas ligas.

## Funcionalidad Pública
Visualizar los diferentes partidos con sus cuotas correspondientes, además de poder ver el historial de los últimos 10 partidos del equipo.

## Funcionalidad Privada
El usuario previamente logueado, puede realizar su apuesta. Además de ver las apuestas, realizadas con anterioridad, y podrá observar cuales ha ganado y cuales ha perdido.

## Entidades
* **Equipo**: Pertenece a una liga concreta además de contener un historial de sus 10 últimos partidos.
* **Partido**: Relación entre dos equipos en los cuales se incluye 3 cuotas(Victoria Local, Empate, Victoria Visitante).
* **Apuesta**: Relación entre el usuario y el partido, indicando la cantidad apostada.
* **Liga**: Equipos pertenecientes a una categoría concreta y que se enfrentan entre ellos.
* **Usuario**: Dinero disponible que tiene en su cuenta, puede apostar, historial de sus últimas apuestas.

## Integrantes del equipo
|Nombre     |Apellidos       |Correo                    |Cuenta Github
|-----------|----------------|--------------------------|---------------|
|Alejandro  |Morais Tejerina |[a.morais@alumnos.urjc.es](mailto:a.morais@alumnos.urjc.es)  |[alexurjc](https://github.com/alexurjc)
|Pablo      |Muñoz Aceituno  |[p.munozac@alumnos.urjc.es](mailto:p.munozac@alumnos.urjc.es) |[ovejaURJC](https://github.com/ovejaURJC)
|Álvaro     |Rubio Jiménez   |[a.rubioji@alumnos.urjc.es](mailto:a.rubioji@alumnos.urjc.es) |[arubioVK](https://github.com/arubioVK)
 
## Servicio Interno
La página se apoya en un servicio el cual calcula dinámicamente las cuotas de las apuestas que se están llevando a cabo en función de las apuestas que se vayan realizando.

Link al repositorio del Servicio Interno: [La Apostada Interno](https://github.com/alexurjc/La-Apostada-Interno)

## Comunicación con el Servicio Interno
Para comunicar la web con el servicio interno se ha creado una API REST en el servicio interno (mediante JSON).

De momento, se utiliza para apostar.

La web manda una petición `HTTP` con el método `POST` al endpoint `/apuesta` y en el cuerpo se incluye el objeto `Apuesta`.

La respuesta puede ser un `400 Bad Request` porque ha habido un error de validación, un `404 Not Found` porque no ha encontrado el partido o usuario o un `200 OK` que significa que se ha guardado bien.

Además en el caso de los errores, se envia un mensaje de error en el cuerpo de la respuesta.

La web se autentica con el servicio interno mediante HTTP Auth Basic.

## Instrucciones de despligue

### Crear JARs
1) Clonar los dos repositorios (web y servicio interno)

```bash
$ git clone https://github.com/arubioVK/La-Apostada
```

```bash
$ git clone https://github.com/alexurjc/La-Apostada-Interno
```

2) Compilar los dos proyectos

Ejecutar esto en la raiz de cada proyecto:
```bash
$ mvn clean install
```

### Configurar la máquina virtual
1) Instalar Java

```bash
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
```

2) Instalar MySQL
```bash
$ sudo apt-get install mysql-server
```
3) Crear una base de datos
```bash
$ mysql -u root -p
```

```bash
mysql> CREATE DATABASE `la-apostada`;

mysql> USE `la-apostada`;

mysql> CREATE USER 'la_apostada_user'@'localhost' IDENTIFIED BY '98741236';

mysql> GRANT ALL PRIVILEGES ON `la-apostada`.* TO 'la_apostada_user'@'localhost';

mysql> FLUSH PRIVILEGES;
```

### Subir los JARs a la máquina virtual
Una vez compilado los proyectos, se generará un JAR por cada uno en la carpeta `target`.

Dentro de la carpeta `target` de la web:
```bash
$ scp ./la-apostada-0.0.1-SNAPSHOT.jar azureuser@la-apostada.cloudapp.net:/home/azureuser/la-apostada-0.0.1-SNAPSHOT.jar
```

Dentro de la carpeta `target` del servicio interno:
```bash
$ scp ./la-apostada-interno-0.0.1-SNAPSHOT.jar azureuser@la-apostada.cloudapp.net:/home/azureuser/la-apostada-interno-0.0.1-SNAPSHOT.jar
```

### Ejecutar la app
1) Ejecutar el JAR de la web
```bash
$ nohup java -jar ./la-apostada-0.0.1-SNAPSHOT.jar &
```

2) Ejecutar el JAR del servicio interno
```bash
$ nohup java -jar ./la-apostada-interno-0.0.1-SNAPSHOT.jar &
```

### Probar la app
Abrir navegador con la url: `https://la-apostada.cloudapp.net/` o `https://la-apostada.cloudapp.net:8443/`

## Capturas de Pantalla
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/screenshot.jpg)
Esta es la página principal de La Apostada, desde esta página el usuario puede:
- *registrarse*: Lo cual le llevará a la página de registro.
- *apostar*: El usuario tiene la opción de elegir a que partido apostar y el resultado
- *equipos*: Al seleccionar un equipo el usuario es llevado a una página en la que puede ver todos los partidos jugados y por jugar de ese equipo
- *ligas*: Las tres ligas disponibles se pueden consultar desde la mayoría de páginas

![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/screenshot.1.jpg)
Esta página es el resultado de seleccionar el botón de seleccionar liga (en este caso Liga BBVA) al igual que la anterior se puede: registrar, apostar y consultar ligas y equipos. Se muestran los partidos que todavia no se han jugado de esa liga en concreto, como se puede observar hay una opción de "partidos jugados" que muestra los partidos ya jugados y en vez de mostrar cuotas muestra resultados de los partidos:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/screenshot.2.jpg)

Pasamos a la siguiente página resultado de seleccionar un equipo cualquiera:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/screenshot.3.jpg)

Muestra los partidos que jugará ese equipo y los ya jugados si se selecciona la opción "partidos jugados" con sus resultados:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/screenshot.4.jpg)

Al pulsar la opción de registrase seremos dirigidos a esta página donde deberemos instroducir Email,nombre de usuario y contraseña.En caso de que se produzca algun error se mostrará un pequeño aviso informando del error:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/screenshot.5.jpg)

Una vez registrados se podrá acceder a la página de la cuenta donde podremos verlos partidos a los que se ha apostado tanto como a los que se ha apostado y se ha ganado/perdido:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/screenshot.6.jpg)

Por último, la página del admin donde se podremos añadir un resultado de un partido o poner un nuevo partido:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/screenshot.8.jpg)

## Diagrama de Navegación
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/navegacion.jpg)

Las páginas están muy bien comunicadas entre ellas.

## Diagrama de Clases
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/diagrama_clases.png)

## Diagrama Entidad Relación
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/diagrama_er.jpg)

## Diagrama de Clases y Templates
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/diagrama_clases_templates.png)

Leyenda:

|Color		|Tipo			|
|---------------|-----------------------|
|Verde		|@Service		|
|Azul		|@Controller		|
|Naranja	|Repository		|
|Morado		|@Entity		|
|Gris		|@Configuration		|
|Blanco		|@Component		|
|Amarillo	|@ControllerAdvice	|
|Rojo		|Template		|

## Azure

### Estructura en Azure
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/screenshots/EstructuraDef.png)

En la imagen salen los puertos por los que uno se puede conectar desde fuera del "servicion en la nube" de Azure a las máquinas por SSH. Cabe destacar que, también, los puertos `80` y`443` del `balanceador web` es público para que los usuarios puedan acceder a la web.

Pero además usamos estos puertos para comunicarlos entre sí:

| Máquina | Puerto | Descripción |
|---|---|---|
| Balanceador web | 80 | Redirecciona al puerto `443`.
| Balanceador web | 443 | Este es público para acceder desde fuera del "servicion en la nube" de Azure. Se usa para escuchar las peticiones de los usuarios de la web. Se encarga de hacer el SSL handshake y reenviar la petición por HTTP a los nodos web. Utilizando "round robin" para distribuir la carga.
| Nodos de la web | 8080 | Utilizan HTTP para escuchar las peticiones que vienen del balanceador.
| Balanceador Interno | 8080 | Para escuchar las peticiones de las nodos web. Utilizando "round robin" para distribuir la carga.
| Nodos del interno | 8080 | Para escuchar las peticiones que viene del balanceador. Es una API Rest que usa JSON.
| Balanceador BD | 3306 | Para escuchar las peticiones, que vienen de los nodos web o interno, a los nodos de la base de datos. Utilizando "round robin" para distribuir la carga.
| Nodos de la BD | 3306 | Para escuchar las peticiones que vienen del balanceador y resolver las queries.

Además, usamos Hazelcast para la distribución de datos y que la sesión del usuario se mantenga entre peticiones a diferentes nodos web.

Por último, HAProxy proporciona una web para visualizar el estado de los nodos del balanceador. Estos son los puertos:

| Máquina | Puerto |
|---|---|
| Balanceador web | 8801 |
| Balanceador interno | 8821 |
| Balanceador BD | 8841 |

### Despliegue en Azure

Para desplegar en Azure es necesario saber las IPs de las máquinas. Por eso mismo al ejecutar los nodos de la web, o los nodos del servicio interno, se introducen las IPs antes de arrancar los JARs.

Estos son los comandos:

#### Comando para la web

```sh
java -jar ./la-apostada-0.0.1-SNAPSHOT.jar \
 --spring.datasource.url=jdbc:mysql://{MYSQL_IP}/la-apostada?useSSL=false \
 --spring.jpa.hibernate.ddl-auto=validate \
 --server.port=8080 \
 --internal_service.url="http://{INTERNAL_SERVICE_IP}:8080" \
 --hazelcast.member="{HAZELCAST_IP}"
```

#### Comando para el servicio interno

```sh
java -jar ./la-apostada-interno-0.0.1-SNAPSHOT.jar \
 --spring.datasource.url=jdbc:mysql://{MYSQL_IP}/la-apostada?useSSL=false \
 --spring.jpa.hibernate.ddl-auto=validate \
 --server.port=8080
```

