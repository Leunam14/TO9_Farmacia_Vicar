package Utilidades;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase que va a tener los métodos para ES
 * @author José Manuel Martínez Romera
 * Versión 15/12/2020
 */
public class ES {

    /**
     * Metodo que se encarga de realizar la lectura de un numero entero desde
     * teclado usando un try/catch.
     *
     * @return el valor entero leÃ­do desde teclado
     */
    private static final String RUTA_DATOS = "datos.my";
    /**
     * Se va a encargar de leer un archivo de texto
     * @param ruta archivo de texto
     * @param ruta2 archivo de errores
     * @return 
     */
    public static Object leerArchivo(String ruta, String ruta2){
        if(ruta.length() == 0){
            ruta = RUTA_DATOS;
        }
        try {
            // Abrimos el fichero para lectura
            FileInputStream fichero = new FileInputStream(ruta);
            ObjectInputStream ficheroEntrada = new ObjectInputStream(fichero);

            // Recuperar el objeto array del fichero
            Object datos = ficheroEntrada.readObject();
            
            // Cerrar el fichero
            ficheroEntrada.close();
            
            return datos;
        } 
        catch (ClassNotFoundException cnfe) {
             System.out.println("No se pudo acceder a la clase adecuada para revertir la Serialización al leer del fichero.");
             escribirFallo("No se pudo acceder a la clase adecuada para revertir la Serialización al leer del fichero.", ruta2);
        }
        catch (FileNotFoundException fnfe) {
             System.out.println("El fichero no existe.");
             escribirFallo("El fichero no existe.", ruta2);
        }
        catch (IOException ioe) {
             System.out.println("Error de Entrada/Salida: Falló la lectura del fichero. La aplicación sigue funcionando sin haber cargado los datos del archivo, para permitir crearlo de nuevo.");
             escribirFallo("Error de Entrada/Salida: Falló la lectura del fichero. La aplicación sigue funcionando sin haber cargado los datos del archivo, para permitir crearlo de nuevo.", ruta2);
        }   
        
        return null;
    }
    /**
     * Se va a encargar de escribir en el archivo de texto
     * @param ruta
     * @param datos
     * @param ruta2
     * @return dependiendo de si escribe o no en el archivo
     */
    public static boolean escribirArchivo(String ruta, Object datos, String ruta2){
        try {
            if(ruta.length() == 0){
                ruta = RUTA_DATOS;
            }
            // Abrir fichero para escribir en él
            FileOutputStream fichero = new FileOutputStream(new File(ruta));
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(fichero);

            // Escribo el array en el fichero
            ficheroSalida.writeObject(datos);

            ficheroSalida.close();

            return true;

        } 
        catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
            escribirFallo("Error: El fichero no existe. ", ruta2);
        }
        catch (IOException ioe) {
            System.out.println("Error: falló la escritura en el fichero ");
            escribirFallo("Error: falló la escritura en el fichero ", ruta2);
        }
        
        return false;
    }
    /**
     * Se va a encargar de escribir un fallo en el archivo de texto ruta2 asignado para errores
     * @param cadena de tipo string
     * @param ruta2 archivo de texto de errores
     */
    private static void escribirFallo(String cadena, String ruta2) {
        File f = new File(ruta2); //Se le asigna ruta2 aka archivo de texto de errores
        try {
            Scanner sc = new Scanner(f); //El Scanner es para poder leer el archivo
            PrintWriter pw = new PrintWriter(f); //PrintWriter es para escribir en el archivo
            while (sc.hasNextLine()) { //leemos todo el documento, y vamos copiando todo lo que leamos, para dejarlo intacto
                pw.println(sc.nextLine());
            }
            Date fecha = new Date(); //Esto lo he sacado de internet, para poder conseguir la hora y fecha actual tal cual
            DateFormat fechaHoraFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            String cadenaError = "[" + fechaHoraFormat.format(fecha) + "]: " + cadena; //conseguimos la fecha y hora actual
            pw.println(cadenaError); //añadimos al final del documento el último error que se ha producido
            sc.close();
            pw.close();
            
        } catch (FileNotFoundException e) { }
        
    }
     /**
     * Método que se va a encargar de leer un entero
     * @return el número por teclado
     */
    public static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
                
        do{
            try {
                return teclado.nextInt();
            }
            catch(InputMismatchException e){
                System.err.println("Error. No ha introducido un número entero");
                System.out.print("Introduzca un nuevo valor: ");
                teclado.next();
            }
        }while(true);
    }
    
    /**
     * Método que se encarga de realizar la lectura de un número entero desde teclado.
     * @param mensaje texto que se quiere mostrar por pantalla.
     * @return el valor entero leído desde teclado.
     */
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        //int n = leerEntero();
        //return n;
        return leerEntero();
    }
    
    /**
     * Método que se encarga de realizar la lectura de un número entero desde teclado que esté entre dos valores.
     * @param minimo valor mínimo que se admite.
     * @param maximo valor máximo que se admite.
     * @return número entero leído.
     */
    public static int leerEntero(int minimo,int maximo){
        int numero;
        do{
            numero = leerEntero();
            if(numero < minimo || numero > maximo)
                System.out.format("Error. El número debe estar comprendido entre %d y %d (ambos inclusive). Introduzca nuevamente un valor: ", minimo, maximo);
        }while(numero < minimo || numero > maximo);
        
        return numero;
    }
    
    /**
     * Método que se encarga de realizar la lectura de un número entero desde teclado que esté entre dos valores.
     * @param minimo valor mínimo que se admite.
     * @param maximo valor máximo que se admite.
     * @param mensaje texto que se quiere mostrar por pantalla.
     * @return número entero leído.
     */
    public static int leerEntero(int minimo,int maximo, String mensaje){
        System.out.print(mensaje);
        return leerEntero(minimo, maximo);
    }
    
    /**
     * Método que permite leer un caracter desde teclado. Si se introduce más de uno se quedará con el primero.
     * @param mensaje texto que se quiere mostrar por pantalla.
     * @return primer caracter leído.
     */
    public static char leerCaracter(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(mensaje);
        
        return teclado.next().charAt(0);
    }
    
    /**
     * Método que permite la lectura de una cadena de caracteres desde teclado.
     * @param mensaje texto que se quiere mostrar por pantalla.
     * @return cadena de caracteres leída.
     */
    public static String leerCadena(String mensaje){
        
        Scanner teclado = new Scanner(System.in);
        System.out.print(mensaje);
        
        return teclado.nextLine();
       
        
    }
    
    /**
     * Método que escribe un mensaje por pantalla.
     * @param mensaje texto que se quiere mostrar por pantalla.
     */
    public static void escribir(String mensaje){
        System.out.print(mensaje);
    }
    /**
     * Método que se va a encargar de leer un float desde teclado
     * @param mensaje que se va a motrar por pantalla
     * @return float leído
     */
    public static float leerFloat(String mensaje) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println(mensaje);
           
        do{
            try {
                return teclado.nextFloat();
            }
            catch(InputMismatchException e){
                System.err.println("Error. No ha introducido un valor válido");
                System.out.print("Introduzca un nuevo valor: ");
                teclado.next();
            }
        }while(true);
    }
    
    
}