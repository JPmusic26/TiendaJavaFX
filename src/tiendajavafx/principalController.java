/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package tiendajavafx;

import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class principalController implements Initializable {
    
    public pila pilap = new pila();
    
    Calendar calendario = new GregorianCalendar();
    int dia = calendario.get(Calendar.DATE);
    int mes = calendario.get(Calendar.MONTH);
    int año = calendario.get(Calendar.YEAR);
    
    @FXML
    private TableView<productos> tabla;
    
    @FXML
    private TableColumn<productos, String> idprodu;
    
    @FXML
    private TableColumn<productos, String> nomprodu;
    
    @FXML
    private TableColumn<productos, String> lote;
    
    @FXML
    private TableColumn<productos, String> vence;
    
    @FXML
    private TableColumn<productos, Float> precio;
    
    public static ObservableList<productos> Productos = FXCollections.observableArrayList();
    
    public static String fecha;
    
    @FXML
    private TextField tlote, tvence, tid, tprecio, tnombre;
    
    @FXML
    private Button registrar, m1dia, m10dias, M1dia, M10dias, cerrar;
    
    @FXML
    private MenuItem bid, bnom, bflote, bfvence, bprecio;
    
    @FXML
    private void evento (ActionEvent e){
        Object evt = e.getSource();
        if (evt.equals(registrar)){
            String id = tid.getText();
            String Nom = tnombre.getText();
            String flote = tlote.getText();
            String fvence = tvence.getText();
            float preci = Float.parseFloat(tprecio.getText());
            productos p = new productos(id, Nom, flote, fvence, preci);
            pilap.setPushProducto(p);
            tid.setText("");
            tnombre.setText("");
            tprecio.setText("");
        }
        if (evt.equals(m1dia)){
            calendario.add(Calendar.DATE, -1);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            tlote.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
            fecha = tlote.getText();
            calendario.add(Calendar.DATE, 31);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            tvence.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, -31);
            pilap.productoexpirado();
        }
        if(evt.equals(m10dias)){
            calendario.add(Calendar.DATE, -10);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            tlote.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
            fecha = tlote.getText();
            calendario.add(Calendar.DATE, 31);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            tvence.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, -31);
            pilap.productoexpirado();
        }
        if(evt.equals(M1dia)){
            calendario.add(Calendar.DATE, 1);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            tlote.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
            fecha = tlote.getText();
            calendario.add(Calendar.DATE, 31);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            tvence.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, -31);
            pilap.productoexpirado();
        }
        if(evt.equals(M10dias)){
            calendario.add(Calendar.DATE, 10);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            tlote.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
            fecha = tlote.getText();
            calendario.add(Calendar.DATE, 31);
            dia = calendario.get(Calendar.DATE);
            mes = calendario.get(Calendar.MONTH);
            año = calendario.get(Calendar.YEAR);
            tvence.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
            calendario.add(Calendar.DATE, -31);
            pilap.productoexpirado();
        }
        if(evt.equals(cerrar)){
            System.exit(0);
        }
    }
    
    @FXML
    private void eventob (KeyEvent e){
        Object evt = e.getSource();
        if(evt.equals(tid) || evt.equals(tprecio)){
            if(!Character.isDigit(e.getCharacter().charAt(0))){
                e.consume();
            }
        }
        if(evt.equals(tnombre)){
            if(evt.equals(tnombre)){
                if(!Character.isLetter(e.getCharacter().charAt(0))){
                    e.consume();
                }
            }
        }
    }
    
    @FXML
    private void eventoc (ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(bid)){
            String id = JOptionPane.showInputDialog("Ingrese el ID que desea buscar:");
            productos idb = pilap.id(id);
            JOptionPane.showMessageDialog(null, "El producto con la fecha lote buscada es:\n"
                                                    + "ID: " + idb.idprodu + "\n"
                                                    + "Nombre: " + idb.nomprodu + "\n"
                                                    + "Fecha lote: " + idb.lote + "\n"
                                                    + "Fecha vencimiento: " + idb.vence + "\n"
                                                    + "Precio: " + idb.precio);
        }
        if(evt.equals(bnom)){
            String nom = JOptionPane.showInputDialog("Ingrese el ID que desea buscar:");
            productos nomb = pilap.nombre(nom);
            JOptionPane.showMessageDialog(null, "El producto con la fecha lote buscada es:\n"
                                                    + "ID: " + nomb.idprodu + "\n"
                                                    + "Nombre: " + nomb.nomprodu + "\n"
                                                    + "Fecha lote: " + nomb.lote + "\n"
                                                    + "Fecha vencimiento: " + nomb.vence + "\n"
                                                    + "Precio: " + nomb.precio);
        }
        if(evt.equals(bflote)){
            String flote = JOptionPane.showInputDialog("Ingrese la fecha lote que desea buscar:");
            pilap.buscarFechal(flote);
        }
        if(evt.equals(bfvence)){
            String fvence = JOptionPane.showInputDialog("Ingrese la fecha de vencimiento que desea buscar:");
            pilap.buscarFechal(fvence);
        }
        if(evt.equals(bprecio)){
            float preciob = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del producto que desea buscar:"));
            pilap.buscarprecio(preciob);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calendario.add(Calendar.DATE, 31);
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
        tvence.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
        calendario.add(Calendar.DATE, -31);
        dia = calendario.get(Calendar.DATE);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
        tlote.setText(String.valueOf(dia)+ "/" + String.valueOf(mes+1)+ "/" + String.valueOf(año));
        fecha = tlote.getText();
        idprodu.setCellValueFactory(new PropertyValueFactory<productos, String>("idprodu"));
        nomprodu.setCellValueFactory(new PropertyValueFactory<productos, String>("nomprodu"));
        lote.setCellValueFactory(new PropertyValueFactory<productos, String>("lote"));
        vence.setCellValueFactory(new PropertyValueFactory<productos, String>("vence"));
        precio.setCellValueFactory(new PropertyValueFactory<productos, Float>("precio"));
        tabla.setItems(Productos);
        // TODO
    }    
    
}
