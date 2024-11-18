# Proceso de instalación de Hibernate
1. Descargar las librerías de Hibernate
* Descarga Hibernate: Ve al sitio oficial de Hibernate: https://hibernate.org/orm/. Descarga la última versión del paquete Hibernate en formato ZIP.
* Librerías necesarias: Dentro del ZIP, ubica las librerías básicas:
    * hibernate-core-<version>.jar
    * Dependencias adicionales, como: antlr, dom4j, javassist, javax.persistence, entre otras.
2. Crear un proyecto en NetBeans
3. Agregar Hibernate al proyecto:
* Proyecto sin Maven (Java SE tradicional):
    * Haz clic derecho sobre el proyecto y selecciona: Properties > Libraries.
    * En la pestaña Compile, selecciona Add JAR/Folder y agrega las librerías descargadas de Hibernate.
* Proyecto con Maven:
    * Abre el archivo pom.xml.
    * Agrega las dependencias de Hibernate al bloque <dependencies>. Asegúrate de ajustar las versiones según las más recientes.
