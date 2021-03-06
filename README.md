# Mutantes

_Proyecto creado con la finalidad de ayudar a magneto a identificar a los mutantes para que lo ayuden en su lucha contra los X-MEN_

## Comenzando 馃殌

_Estas instrucciones te permitir谩n obtener una copia del proyecto en funcionamiento en tu m谩quina local para prop贸sitos de analisis del mismo._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 馃搵麓

_Para la ejecuci贸n del proyecto se requiere como pre-requisito tener instalado JAVA en su versi贸n 11 que lo puedes descargar de la siguiente p谩gina_

```
https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html
```

_Luego de descargado e instalado configurar la variable de entorno JAVA_HOME. Para lo cual puede guiarse de la siguiente p谩gina_

```
https://www.pchardwarepro.com/como-configurar-java_home-en-windows-10/
```

_Tambi茅n descargar apache maven. Para este proyecto se utiliza la versi贸n 3.8.2 por lo que se recomienda instalar la misma para evitar inconvenientes_

```
https://maven.apache.org/download.cgi
```

_Se debe de configurar la variable MAVEN_HOME de forma similar a como se configuro la variable JAVA_HOME_


### Instalaci贸n 馃敡

_Para la instalaci贸n se debe tener los pre-requisito previamente descargados e instalados. Mirar **Pre-requisitos**_

_Como primer paso clonar el proyecto o descargarlo en formato ZIP y descomprimirlo en la ruta del equipo que se desee_

```
git clone https://github.com/xXSergio99Xx/mutantes.git
```

_Luego de descargar y descomprimir el proyecto, abrirlo con su editor de preferencia (Visual Studio Code, Intellij, NetBeans, Eclipse, Spring Suite Tools, etc)._

_Descargar los complementos de Spring Boot en caso de que se requiera_

_Intellij_
```
https://www.jetbrains.com/help/idea/spring-boot.html
```

_Visual Studio Code_
```
https://code.visualstudio.com/docs/java/java-spring-boot
```

_NetBeans_
```
https://www.techgalery.com/2019/01/how-to-create-spring-boot-project-using.html
```

_Eclipse_
```
https://spring.io/tools
```

## Ejecutando las pruebas 鈿欙笍

_Las pruebas unitarias se encuentran en la ruta src/main/test/java/com/mutantes/proyecto._
_Donde se podr谩n ejecutar para validar su exito y que cumplan con m谩s del 80% requerido_

## Despliegue 馃摝

_El proyecto se despliega en HEROKU ya que es una herramiento eficaz y que se conecta muy bien con GitHub para despliegues automaticos. Ademas que su versi贸n gratuitad es bastante funcional para proyectos de aprendizaje_

## EndPoints en CLOUD

_POST /mutant_
```
https://mutanteprueba.herokuapp.com/mutant
```
_Ejemplo JSON_
```
{
  "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
  ]
}
```

_GET /stats_
```
https://mutanteprueba.herokuapp.com/stats
```

_En caso de no tener herramientas como POSTMAN o INSOMNIA para realizar pruebas a los endpoint. Se instalo SWAGGER el cual permite verificar los endpoint del proyecto y probarlos desde esta_

```
https://mutanteprueba.herokuapp.com/swagger-ui/index.html
```

## Construido con 馃洜锔?

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [Java] - Lenguaje de programaci贸n
* [Maven] - Manejador de dependencias
* [H2] - Base de datos en memoria embebida dentro del proyecto

## Autores 鉁掞笍

* **Sergio Andres Rojas Giraldo** - [xXSergio99Xx](https://github.com/xXSergio99Xx)