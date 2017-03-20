# La Apostada

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

## Integrantes
|Nombre     |Apellidos       |Correo                    |Cuenta Github
|-----------|----------------|--------------------------|---------------|
|Alejandro  |Morais Tejerina |[a.morais@alumnos.urjc.es](mailto:a.morais@alumnos.urjc.es)  |[alexurjc](https://github.com/alexurjc)
|Pablo      |Muñoz Aceituno  |[p.munozac@alumnos.urjc.es](mailto:p.munozac@alumnos.urjc.es) |[ovejaURJC](https://github.com/ovejaURJC)
|Álvaro     |Rubio Jiménez   |[a.rubioji@alumnos.urjc.es](mailto:a.rubioji@alumnos.urjc.es) |[arubioVK](https://github.com/arubioVK)
 
## Servicio Interno
La página se apoya en un servicio el cual calcula dinámicamente las cuotas de las apuestas que se están llevando a cabo en función de las apuestas que se vayan realizando.

Link al repositorio: [La Apostada Interno](https://github.com/alexurjc/La-Apostada-Interno)

## Comunicación
La comunicación entre el navegador y [la web](https://github.com/arubioVK/La-Apostada) se realiza mediante [Websockets](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/websocket.html).

## Capturas de pantalla
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.jpg)
Esta es la página principal de La Apostada, desde esta página el usuario puede:
- *registrarse*: Lo cual le llevará a la página de registro.
- *apostar*: El usuario tiene la opción de elegir a que partido apostar y el resultado
- *equipos*: Al seleccionar un equipo el usuario es llevado a una página en la que puede ver todos los partidos jugados y por jugar de ese equipo
- *ligas*: Las tres ligas disponibles se pueden consultar desde la mayoría de páginas

![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.1.jpg)
Esta página es el resultado de seleccionar el botón de seleccionar liga (en este caso Liga BBVA) al igual que la anterior se puede: registrar, apostar y consultar ligas y equipos. Se muestran los partidos que todavia no se han jugado de esa liga en concreto, como se puede observar hay una opción de "partidos jugados" que muestra los partidos ya jugados y en vez de mostrar cuotas muestra resultados de los partidos:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.2.jpg)

Pasamos a la siguiente página resultado de seleccionar un equipo cualquiera:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.3.jpg)

Muestra los partidos que jugará ese equipo y los ya jugados si se selecciona la opción "partidos jugados" con sus resultados:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.4.jpg)

Al pulsar la opción de registrase seremos dirigidos a esta página donde deberemos instroducir Email,nombre de usuario y contraseña.En caso de que se produzca algun error se mostrará un pequeño aviso informando del error:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.5.jpg)

Una vez registrados se podrá acceder a la página de la cuenta donde podremos verlos partidos a los que se ha apostado tanto como a los que se ha apostado y se ha ganado/perdido:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.6.jpg)

Por último, la página del admin donde se podremos añadir un resultado de un partido o poner un nuevo partido:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/pagina-admin.png)

## Diagrama de navegación
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.7.jpg)

Las páginas están muy bien comunicadas entre ellas.

## Diagrama de clases
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/Diagramadeclase.png)

## Diagrama Entidad Relación
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/diagrama_er.jpg)
