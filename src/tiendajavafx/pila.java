/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendajavafx;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class pila {
    private Stack<productos> pila;
    public pila(){
        this.pila = new Stack<>();
    }
    public void setPushProducto (productos p){
        if(id(p.idprodu) != null){
            JOptionPane.showMessageDialog(null, "Ya existe un producto con este ID!");
        }else if(nombre(p.nomprodu) != null){
            JOptionPane.showMessageDialog(null, "Ya existe un producto con este Nombre!");
        }else{
            pila.push(p);
            JOptionPane.showMessageDialog(null, "Producto registrado!");
        }
    }
    public productos id(String id){
        productos idb = new productos();
        int i = 0;
        while(i<pila.size()){
            idb = (productos) pila.get(i);
            if(idb.idprodu.equals(id))
                return idb;
            i++;
        }
        idb = null;
        return idb;
    }
    public productos nombre(String nombre){
        productos nombreb = new productos();
        int i = 0;
        while(i<pila.size()){
            nombreb = (productos) pila.get(i);
            if(nombreb.nomprodu.equals(nombre))
                return nombreb;
            i++;
        }
        nombreb = null;
        return nombreb;
    }
}
