/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import EstructuraDatos.Categoria;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import EstructuraDatos.Cliente;
import EstructuraDatos.Medicamento;
import EstructuraDatos.Parafarmacia;
import EstructuraDatos.Producto;
import EstructuraDatos.TipoMedicamento;
import javafx.event.Event;
import Utilidades.ValidarDatos;
import Utilidades.ES;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author chema aka José Manuel Martínez Romera
 * Version 1.0
 */
public class FxmlVistaController implements Initializable {
    
    private int punteroClientes = 0;
    private int punteroProductos = 0;
    private int punteroAniadirClientes = 10;
    private int punteroAniadirProductos = 10;
    private String ventana = "Clientes";
    
    public static final String ruta1 = "datos.txt"; //ruta1 hace referencia al archvio de datos
    public static final String ruta2 = "errores.txt"; //ruta2 hace referencai al archivo de errores
    
    Cliente c1 = new Cliente("65148574J", "Laura Martínez Valverde", "Calle La Desesperanza", "680674128");
    Cliente c2 = new Cliente("45812748A", "Lucía Romera Baeza", "Glorieta Sirenas, 69", "691478264");
    Cliente c3 = new Cliente("42174829K", "Pedro Casas Oliver", "Avenida Kanto", "741267485");
    Cliente[] clientes = {c1, c2, c3};
    
    Medicamento m1 = new Medicamento("1457894257", "Ibuprofeno", "1 cada 8 horas. Quita fiebre y malestar.", (float) 2.40, 20,TipoMedicamento.ANALGESICOS, "cada 8 horas","fiebre");
    Medicamento m2 = new Medicamento("2254781395", "Nolotil", "1 cada 8 horas. Quita malestar de cuerpo.", (float) 1.4, 25, TipoMedicamento.ANTIACIDOS, "cada 2 horas", "mucosa");
    Medicamento m3 = new Medicamento("1548912358", "Paracetamol", "1 cada 8 horas. Elimina malestar de cuerpo.", 2, 50, TipoMedicamento.ANTIALERGICOS, "cada 4 horas", "dolor de cabeza");
    
    Parafarmacia p1 = new Parafarmacia("1245630784", "Crema cara", "Aplicar sobre la piel", (float) 52.5, 63, Categoria.FACIAL, 8, (float) 12);
    Parafarmacia p2 = new Parafarmacia("5465630784", "Gel dermo", "Aplicar sobre todo el cuerpo", (float) 512.5, 503, Categoria.GELES, 1, (float) 80);
    Parafarmacia p3 = new Parafarmacia("8655630784", "Crema cara", "Solo sobre cabello", (float) 82.5, 10, Categoria.CABELLO, 2, (float) 40);

    Producto[] productos = {m1, m2, m3, p1, p2, p3};
    
    private Label label;
    @FXML
    private TextField textNif;
    @FXML
    private TextField clienteTelefono;
    @FXML
    private TextField clienteDireccion;
    @FXML
    private TextField clienteNombre;
    @FXML
    private TextField productoCodigo;
    @FXML
    private TextField productoNombre;
    @FXML
    private TextField productoDescripcion;
    @FXML
    private TextField productoPrecio;
    @FXML
    private TextField productoProd;
    @FXML
    private TextField pagina;
    @FXML
    private TextField PanelClientes;
    @FXML
    private TextField tipoProducto;
    @FXML
    private TextField PanelProductos;
    
    

    void initialize() {
        //TODO
    }
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    /**
     * Se va a encargar de mostrar el primer registro
     *
     * @param event
     */
    @FXML
    private void primero(ActionEvent event) {
        if (ventana.equals("Clientes")) {
            punteroClientes = 0;
            Cliente aux = clientes[punteroClientes];
            if (aux != null) {
                pagina.setText(String.valueOf(punteroClientes + 1));
                textNif.setText(aux.getId());
                clienteNombre.setText(aux.getNombre());
                clienteDireccion.setText(aux.getDireccion());
                clienteTelefono.setText(aux.getTelefono());
            } else {
                pagina.setText(String.valueOf(punteroClientes + 1));
                textNif.setText("");
                clienteNombre.setText("");
                clienteDireccion.setText("");
                clienteTelefono.setText("");
            }
        } else {
            punteroProductos = 0;
            Producto aux = productos[punteroProductos];
            if (aux != null) {
                if (aux instanceof Medicamento) {
                    tipoProducto.setText("Medicamento");
                } else {
                    tipoProducto.setText("Parafarmacia");
                }
                pagina.setText(String.valueOf(punteroProductos + 1));
                productoCodigo.setText(aux.getCodigo());
                productoNombre.setText(aux.getNombre());
                productoDescripcion.setText(aux.getDescripcion());
                productoPrecio.setText(String.valueOf(aux.getPrecio()));
                productoProd.setText(String.valueOf(aux.getUnidades()));
            } else {
                tipoProducto.setText("");
                pagina.setText(String.valueOf(punteroProductos + 1));
                productoCodigo.setText("");
                productoNombre.setText("");
                productoDescripcion.setText("");
                productoPrecio.setText("");
                productoProd.setText("");
            }
        }
    }
    /**
     * Se encargará de mostrar el registro anterior
     *
     * @param event
     */
    @FXML
    private void anterior(ActionEvent event) {
        if (ventana.equals("Clientes")) {
            if (punteroClientes != 0) {
                punteroClientes--;
            }
            Cliente aux = clientes[punteroClientes];
            if (aux != null) {
                pagina.setText(String.valueOf(punteroClientes + 1));
                textNif.setText(aux.getId());
                clienteNombre.setText(aux.getNombre());
                clienteDireccion.setText(aux.getDireccion());
                clienteTelefono.setText(aux.getTelefono());
            } else {
                pagina.setText(String.valueOf(punteroClientes + 1));
                textNif.setText("");
                clienteNombre.setText("");
                clienteDireccion.setText("");
                clienteTelefono.setText("");
            }
        } else {
            if (punteroProductos != 0) {
                punteroProductos--;
            }
            Producto aux = productos[punteroProductos];
            if (aux != null) {
                if (aux instanceof Medicamento) {
                    tipoProducto.setText("Medicamento");
                } else {
                    tipoProducto.setText("Parafarmacia");
                }
                pagina.setText(String.valueOf(punteroProductos + 1));
                productoCodigo.setText(aux.getCodigo());
                productoNombre.setText(aux.getNombre());
                productoDescripcion.setText(aux.getDescripcion());
                productoPrecio.setText(String.valueOf(aux.getPrecio()));
                productoProd.setText(String.valueOf(aux.getUnidades()));
            } else {
                tipoProducto.setText("");
                pagina.setText(String.valueOf(punteroProductos + 1));
                productoCodigo.setText("");
                productoNombre.setText("");
                productoDescripcion.setText("");
                productoPrecio.setText("");
                productoProd.setText("");
            }
        }
    }
    /**
     * Permite avanzar entre los registros
     *
     * @param event
     */
    @FXML
    private void avanzar(ActionEvent event) {
        if (ventana.equals("Clientes")) {
            if (punteroClientes != clientes.length - 1) {
                punteroClientes++;
            }
            Cliente aux = clientes[punteroClientes];
            if (aux != null) {
                pagina.setText(String.valueOf(punteroClientes + 1));
                textNif.setText(aux.getId());
                clienteNombre.setText(aux.getNombre());
                clienteDireccion.setText(aux.getDireccion());
                clienteTelefono.setText(aux.getTelefono());
            } else {
                pagina.setText(String.valueOf(punteroClientes + 1));
                textNif.setText("");
                clienteNombre.setText("");
                clienteDireccion.setText("");
                clienteTelefono.setText("");
            }
        } else {
            if (punteroProductos != productos.length - 1) {
                punteroProductos++;
            }
            Producto aux = productos[punteroProductos];
            if (aux != null) {
                if (aux instanceof Medicamento) {
                    tipoProducto.setText("Medicamento");
                } else {
                    tipoProducto.setText("Parafarmacia");
                }
                pagina.setText(String.valueOf(punteroProductos + 1));
                productoCodigo.setText(aux.getCodigo());
                productoNombre.setText(aux.getNombre());
                productoDescripcion.setText(aux.getDescripcion());
                productoPrecio.setText(String.valueOf(aux.getPrecio()));
                productoProd.setText(String.valueOf(aux.getUnidades()));
            } else {
                tipoProducto.setText("");
                pagina.setText(String.valueOf(punteroProductos + 1));
                productoCodigo.setText("");
                productoNombre.setText("");
                productoDescripcion.setText("");
                productoPrecio.setText("");
                productoProd.setText("");
            }
        }
    }
     /**
     * Podremos comprobar si estamos en el último registro del array.
     *
     * @param event
     */
    @FXML
    private void ultimo(ActionEvent event) {
        if (ventana.equals("Clientes")) {
            punteroClientes = clientes.length - 1;
            Cliente aux = clientes[punteroClientes];
            if (aux != null) {
                pagina.setText(String.valueOf(punteroClientes + 1));
                textNif.setText(aux.getId());
                clienteNombre.setText(aux.getNombre());
                clienteDireccion.setText(aux.getDireccion());
                clienteTelefono.setText(aux.getTelefono());
            } else {
                pagina.setText(String.valueOf(punteroClientes + 1));
                textNif.setText("");
                clienteNombre.setText("");
                clienteDireccion.setText("");
                clienteTelefono.setText("");
            }
        } else {
            punteroProductos = productos.length - 1;
            Producto aux = productos[punteroProductos];
            if (aux != null) {
                if (aux instanceof Medicamento) {
                    tipoProducto.setText("Medicamento");
                } else {
                    tipoProducto.setText("Parafarmacia");
                }
                pagina.setText(String.valueOf(punteroProductos + 1));
                productoCodigo.setText(aux.getCodigo());
                productoNombre.setText(aux.getNombre());
                productoDescripcion.setText(aux.getDescripcion());
                productoPrecio.setText(String.valueOf(aux.getPrecio()));
                productoProd.setText(String.valueOf(aux.getUnidades()));
            } else {
                tipoProducto.setText("");
                pagina.setText(String.valueOf(punteroProductos + 1));
                productoCodigo.setText("");
                productoNombre.setText("");
                productoDescripcion.setText("");
                productoPrecio.setText("");
                productoProd.setText("");
            }
        }
    }
     /**
     * Se modificará el array de clientes y de productos
     *
     * @param event
     */
    @FXML
    private void modificar(ActionEvent event) {
        int puntero = Integer.parseInt(pagina.getText()) - 1;
        if (ventana.equals("Clientes")) {
            String nif = textNif.getText();
            String nombre = clienteNombre.getText();
            String direccion = clienteDireccion.getText();
            String telefono = clienteTelefono.getText();
            Cliente aux = clientes[puntero];
            aux.setNombre(nombre);
            aux.setDireccion(direccion);
            if (ValidarDatos.validarNif(nif)) {
                aux.setId(nif);
            }
            if (ValidarDatos.comprobarTlf(telefono)) {
                aux.setTelefono(telefono);
            }
            clientes[puntero] = aux;
            textNif.setText(aux.getId());
            clienteNombre.setText(aux.getNombre());
            clienteDireccion.setText(aux.getDireccion());
            clienteTelefono.setText(aux.getTelefono());
        } else {
            String codigo = productoCodigo.getText();
            String nombre = productoNombre.getText();
            String descripcion = productoDescripcion.getText();
            float precio = Float.parseFloat(productoPrecio.getText());
            int unidades = Integer.parseInt(productoProd.getText());
            Producto aux = productos[puntero];
            aux.setNombre(nombre);
            aux.setDescripcion(descripcion);
            aux.setPrecio(precio);
            aux.setUnidades(unidades);
            if (ValidarDatos.comprobarCodigo(codigo)) {
                aux.setCodigo(codigo);
            }
            productos[puntero] = aux;
            productoCodigo.setText(aux.getCodigo());
            productoNombre.setText(aux.getNombre());
            productoDescripcion.setText(aux.getDescripcion());
            productoPrecio.setText(String.valueOf(aux.getPrecio()));
            productoProd.setText(String.valueOf(aux.getCodigo()));
        }
    }
    /**
 * Método de ventana clientes que se ecargará de darle los datos
 * @param event 
 */
    @FXML
    private void ventanaClientes(Event event) {
        ventana = "Clientes";
        pagina.setText(String.valueOf(punteroClientes + 1));
        Cliente aux = clientes[punteroClientes];
        if (aux != null) {
            textNif.setText(aux.getId());
            clienteNombre.setText(aux.getNombre());
            clienteDireccion.setText(aux.getDireccion());
            clienteTelefono.setText(aux.getTelefono());
        } else {
            textNif.setText("");
            clienteNombre.setText("");
            clienteDireccion.setText("");
            clienteTelefono.setText("");
       }
    }
     /**
 * Método de ventana productos que se ecargará de darle los datos
 * @param event 
 */
    @FXML
    private void ventanaProductos(Event event) {
        ventana = "Productos";
        pagina.setText(String.valueOf(punteroProductos + 1));
        Producto aux = productos[punteroProductos];
        if (aux != null) {
            if (aux instanceof Medicamento) {   
                tipoProducto.setText("Medicamento");
            } else {
                tipoProducto.setText("Parafarmacia");
            }
            productoCodigo.setText(aux.getCodigo());
            productoNombre.setText(aux.getNombre());
            productoDescripcion.setText(aux.getDescripcion());
            productoPrecio.setText(String.valueOf(aux.getPrecio()));
            productoProd.setText(String.valueOf(aux.getUnidades()));
        } else {
            productoCodigo.setText("");
            productoNombre.setText("");
            productoDescripcion.setText("");
            productoPrecio.setText("");
            productoProd.setText("");
       }
    }
    /**
     * Se va a encargar de aniadir datos, tanto clientes/productos
     * @param event 
     */
    @FXML
    private void añadir(ActionEvent event) {
        if (ventana.equals("Clientes")) {
            String nif = textNif.getText();
            String nombre = clienteNombre.getText();
            String direccion = clienteDireccion.getText();
            String telefono = clienteTelefono.getText();
            Cliente aux = new Cliente(nif, nombre, direccion, telefono);
            if (punteroAniadirClientes >= clientes.length) {
                Cliente[] duplicado = new Cliente[clientes.length * 2];
                for (int i = 0; i < clientes.length; i++) {
                    duplicado[i] = clientes[i];
                }
                clientes = duplicado;
            }
            clientes[punteroAniadirClientes++] = aux;
        } else { //estamos en la ventana de productos
            String tipo = tipoProducto.getText();
            String codigo = productoCodigo.getText();
            String nombre = productoNombre.getText();
            String descripcion = productoDescripcion.getText();
            float precio = Float.parseFloat(productoPrecio.getText());
            int cantidad = Integer.parseInt(productoProd.getText());
            Producto aux = null;
            if (tipo.equals("Medicamento")) {
                aux = new Medicamento(codigo,nombre,descripcion,precio,cantidad,TipoMedicamento.ANALGESICOS,"1 cada 8 horas","Dolor de cabeza");
            } else {
                aux = new Parafarmacia(codigo,nombre,descripcion,precio,cantidad,Categoria.GELES,12,(float) 18.5);
            }
            if (punteroAniadirProductos >= productos.length) {
                Producto[] duplicado = new Producto[productos.length * 2]; //duplicaré el array 
                for (int i = 0; i < productos.length; i++) {
                    duplicado[i] = productos[i];
                }
                productos = duplicado;
            }
            productos[punteroAniadirProductos++] = aux;
        }
        
    }

    /**
     * Se va a encargar de cerrar la aplicación en el panel "Archivo>Close".
     *
     * @param event
     */
    @FXML
    private void cerrarPrograma(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    /**
     * Se va a encargar de mostrar la información en el panel "Acerca de".
     *
     * @param event
     */
    @FXML
    private void mostrarInformación(ActionEvent event) {
         if (ventana.equals("Clientes")) {
            PanelClientes.setText("App desarrollada por José Manuel Martínez Romera. Versión 1.0");
            PanelClientes.setStyle("-fx-text-fill: green;-fx-font-size: 10px;");
        } else {
            PanelProductos.setText("App desarrollada por José Manuel Martínez Romera. Versión 1.0");
            PanelProductos.setStyle("-fx-text-fill: green;-fx-font-size: 10px;");
        }
        
    }
    
    /**
     * Se va a encargar de cargar los datos
     * @param event 
     */
    @FXML
    private void cargarDatos(ActionEvent event) {
        Object aux = ES.leerArchivo(ruta1, ruta2); //Está llamando a la ruta1, ruta2, dentro de un objeto
        int punteroClientes = 0; //He creado los punteros de clientes y productos desde cero para recorrer luego el while
        int punteroProudctos = 0;
        while (aux != null) { //si no es null va a recorrerlo
            if (aux instanceof Cliente) { //Con instanceof comprobaré si es de esa clase
                clientes[punteroClientes++] = (Cliente) aux;
            } else if (aux instanceof Producto) {
                productos[punteroProductos++] = (Producto) aux;
            }
            aux = ES.leerArchivo(ruta1, ruta2); //Los datos auxiliares se guardarán en ruta1 y ruta2 (archivo de texto y de errores).
        }
    }
    
        /**
     * Se va a encargar de guardar los datos
     * @param event 
     */
    @FXML
    private void guardarDatos(ActionEvent event) {
        for (int i = 0; i < clientes.length; i++) { //recorrido del array clientes, para rellenar el archivo texto con estos datos
            ES.escribirArchivo(ruta1, clientes[i], ruta2); //Está llamando a los valores de escribirArchivo
        }
        for (int i = 0; i < productos.length; i++) { //lo mismo con productos
            ES.escribirArchivo(ruta1, productos[i], ruta2);
        }
    }
    
    /**
     * Se va a encargar de eliminar un registro del array, tanto de clientes como de productos
     * @param event 
     */

    @FXML
    private void eliminarRegistro(ActionEvent event) {
        int posicion = Integer.parseInt(pagina.getText()) - 1; /*Cogemos la página en la que estamos, pero esta 
        siempre será una posición más que la que ocupa en el array*/
        if (ventana.equals("Clientes")) {
            while (clientes[posicion] != null && posicion < clientes.length - 1) {  //hasta que no hayamos llegado al final del array, a su último elemento
                clientes[posicion] = clientes[posicion + 1];
                posicion++;
                System.out.println("Eliminando cliente...");
            }
            clientes[posicion] = null; /*Como puede darse el caso de que tuviéramos el array completo, 
            posicion + 1 llegaria a .length entonces se saldría de la los límites, no entraria ese caso en el bucle 
            y el último elemento estaría repetido, por lo que lo eliminamos poniéndolo a null*/
            ventanaClientes(event);
        } else {
            while (productos[posicion] != null && posicion < productos.length - 1) { //He seguido la misma lógica que con clientes
                productos[posicion] = productos[posicion + 1];
                posicion++;
                System.out.println("Eliminando producto...");
            }
            productos[posicion] = null;
            ventanaProductos(event);
        }
        
    }

}
