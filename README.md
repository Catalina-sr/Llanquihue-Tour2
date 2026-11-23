# LlanquihueTour — Laboratorio Semana 5

Autor del proyecto
Nombre: Catalina Soto Repol
Asignatura: Desarrollo Orientado a Objetos I
Institución: Duoc UC

## Descripción del proyecto

LlanquihueTour es un sistema desarrollado en Java que permite gestionar personas relacionadas con una empresa de turismo.
El proyecto aplica programación orientada a objetos, organización modular mediante paquetes, uso de colecciones ArrayList y
lectura de datos desde un archivo CSV.

## Cómo ejecutar el proyecto

1. Descargar el proyecto desde el repositorio de GitHub utilizando la opción **Code → Download ZIP**, o clonarlo desde IntelliJ IDEA.
2. Descomprimir el archivo descargado en una carpeta del computador.
3. Abrir IntelliJ IDEA y seleccionar **File → Open**.
4. Buscar y seleccionar la carpeta principal `LlanquihueTour`, donde se encuentra el archivo `pom.xml`.
5. Esperar a que IntelliJ IDEA cargue el proyecto Maven y sus dependencias.
6. Verificar que el proyecto tenga configurado un JDK compatible.
7. Comprobar que el archivo `personas.csv` esté ubicado en `src/main/resources`.
8. Navegar hasta `src/main/java/cl/duoc/llanquihuetour/ui/Main.java`.
9. Abrir la clase `Main.java` y presionar el botón **Run** (triángulo verde) para ejecutar el programa.
10. Los resultados se mostrarán en la consola de IntelliJ IDEA.

**Ubicación de la clase principal:**

`src/main/java/cl/duoc/llanquihuetour/ui/Main.java`

## Estructura del proyecto

```text
LlanquihueTour/
├── src/
│   └── main/
│       ├── java/
│       │   └── cl/duoc/llanquihuetour/
│       │       ├── model/
│       │       │   ├── Persona.java
│       │       │   ├── Direccion.java
│       │       │   ├── Empleado.java
│       │       │   ├── Cliente.java
│       │       │   ├── GuiaTuristico.java
│       │       │   └── Operador.java
│       │       ├── data/
│       │       │   └── GestorPersonas.java
│       │       └── ui/
│       │           └── Main.java
│       └── resources/
│           └── personas.csv
├── test/
├── pom.xml
└── README.md
```

## Paquetes del proyecto

- **model:** contiene las clases que representan a las personas, sus datos y sus respectivas especializaciones.
- **data:** contiene la clase `GestorPersonas`, encargada de administrar la información y cargar los registros desde el archivo CSV.
- **ui:** contiene la clase principal `Main`, desde donde se ejecuta el programa.

## Funcionalidades

- Cargar personas desde un archivo CSV.
- Mostrar los registros almacenados.
- Buscar personas por nombre, sin distinguir entre mayúsculas y minúsculas.
- Buscar personas según su tipo.
- Agregar nuevos registros.
- Eliminar registros.
- Reemplazar información de personas.
- Contar la cantidad de personas registradas.
- Manejar excepciones y validar los datos ingresados.

## Archivo CSV

Los datos se almacenan en `personas.csv`, utilizando punto y coma como separador.

El archivo contiene información organizada en cuatro categorías:

- Empleados.
- Clientes.
- Guías turísticos.
- Operadores.

## Conceptos aplicados

- Programación orientada a objetos.
- Encapsulamiento.
- Herencia.
- Composición.
- Colecciones ArrayList.
- Organización modular mediante paquetes.
- Validación de datos.
- Manejo de excepciones.
- Lectura de archivos CSV.

## Objetivo académico

El objetivo del proyecto es aplicar los contenidos aprendidos durante la asignatura, 
desarrollando una aplicación modular en Java que permita organizar y administrar información mediante clases,
colecciones y archivos externos.
