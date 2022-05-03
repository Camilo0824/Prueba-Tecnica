# Prueba-Tecnica

El proyecto se realizó con las siguientes herramientas de desarrollo:
*	Para el Back End se realizó por medio del módulo de Spring Framework denominado SpringBoot
*	Para el Front End se realizó por medio del Framework denominado Angular, donde las versiones utilizadas de las herramientas necesarias para el funcionamiento de este son las siguientes:
    * Angular CLI: 13.3.4
    * Node: 16.15.0
    * Package Manager: npm 8.8.0
*	Para la base de datos se usó SQL-sever

Para este proyecto se hace necesario ejecutar tanto el servidor del Back End(puerto 8080) como el del Front End(puerto 4200) para poder levantar la Web App, además de ello también se hace necesario tener la base de datos SQL-server activa(puerto TCP 1433).  

El funcionamiento interno de la Web App se centra en implementar un patrón MVC en Spring Boot junto a JPA, el cual permite interactuar con la base de datos por medio de objetos, generando con ello que no sea necesario hacer uso de instrucciones SQL directas en el código si no que por medio de Anotaciones este proceso se realice automáticamente. Al tener preparado los End Points por medio del controlador en el Back End se procede a realizar la conexión con el puerto de proyecto Fron End, lo que permitirá así que desde la interfaz de usuario se generen peticiones que mediante los End Points del Back End se puedan satisfacer por medio de consultas y respuestas a la base de datos, básicamente lo que se denomina patrón de Modelo, Vista y controlador.  

El funcionamiento general de la Web App se centra en que el usuario mediante elementos de la interfaz pueda seleccionar o arrastrar un archivo .CSV(dado el caso de que no sea de este formato se arroja un error-advertencia), donde al oprimir un botón, dicho archivo se almacena dentro de una carpeta local, y junto a esta acción, también se ejecuta la acción de leer registro por registro del documento cargando e ir guardando dicha información en las tablas de la base de datos, cuyo modelo Relacional se vería de esta forma:  

![Diagrama ER de base de datos (pata de gallo)](https://user-images.githubusercontent.com/99211350/166411154-96e2f15c-ee4e-4d4f-83fc-82013bc28f51.png)

Luego de este proceso la aplicación le entrega al usuario dos tablas, una de Archivos con información general de cada Archivo cargado por el usuario, y una segunda tabla de Registros donde se puede visualizar todos los Registros obtenidos de cada uno de los Archivos cargados. Es importante mencionar que cada tabla cuenta con un buscador que le permitirá al usuario encontrar registros por medio de los atributos más relevantes de estas. Por ejemplo, la tabla de Registros permite buscar por el Id del registro o por el nombre del archivo que tiene relacionado.
