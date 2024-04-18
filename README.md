# CreadorDeListas
la aplicación genera un excel con la lista de archivos que se encuentren en la ruta deseada.

El programa fue realizado con JDK 17 y maven. No tiene muchos trucos.

en la siguiente linea se ingresa la ruta que se desea listar, respetar el formato para evitar inconvenientes.

   public static void main(String[] args) {
        Path directoryPath = Paths.get("C:\\Ruta\\que\\Se\\Desea");


En la siguiente linea se ingresa el nombre que se desea tener en el archivo. No ingresar espacios en el nombre, no es recomendable.
                     FileOutputStream fileOut = new FileOutputStream("nombres_archivos.xlsx")) {

