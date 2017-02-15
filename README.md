# La-Apostada



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
* Nombre: Alejandro  Apellidos: Morais Tejerina Correo: a.morais@alumnos.urjc.es  Cuenta Github: alexurjc
* Nombre: Pablo      Apellidos: Muñoz Aceituno  Correo: p.munozac@alumnos.urjc.es Cuenta Github: ovejaURJC
* Nombre: Álvaro     Apellidos: Rubio Jiménez   Correo: a.rubioji@alumnos.urjc.es Cuenta Github: arubioVK
 
## Servicio Interno
La página se apoya en un servicio el cual calcula dinámicamente las cuotas de las apuestas que se están llevando a cabo en función de las apuestas que se vayan realizando.

## Capturas de pantalla
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.jpg)
Esta es la página principal de La Apostada, desde esta página el usuario puede:
-registrarse: Lo cual le llevará a la página de registro.
-apostar: El usuario tiene la opción de elegir a que partido apostar y el resultado
-equipos: Al seleccionar un equipo el usuario es llevado a una página en la que puede ver todos los partidos jugados y por jugar de ese equipo
-ligas: Las tres ligas disponibles se pueden consultar desde la mayoría de páginas

![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.1.jpg)
Esta página es el resultado de seleccionar el botón de seleccionar liga(en este caso Liga BBVA) al igual que la anterior se puede:registrar,apostar y consultar ligas y equipos. Se muestran los partidos que todavia no se han jugado de esa liga en concreto, como se puede observar hay una opción de "partidos jugados" que muestra los partidos ya jugados y en vez de mostrar cuotas muestra resultados de los partidos:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.2.jpg)


Pasamos a la siguiente página resultado de seleccionar un equipo cualquiera:

![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.3.jpg)
Muestra los partidos que jugará ese equipo y los ya jugados si se selecciona la opción "partidos jugados" con sus resultados:
![Alt text](https://github.com/arubioVK/La-Apostada/blob/master/Screenshots/screenshot.4.jpg)
