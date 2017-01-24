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
