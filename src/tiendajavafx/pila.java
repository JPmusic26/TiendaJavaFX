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
    public void buscarFechal(String fechal){
        productos fechalb = new productos();
        int i = 0;
        while(i<pila.size()){
            fechalb = (productos) pila.get(i);
            if(fechalb.lote.equals(fechal)){
                JOptionPane.showMessageDialog(null, "El producto con la fecha lote buscada es:\n"
                                                    + "ID: " + fechalb.idprodu + "\n"
                                                    + "Nombre: " + fechalb.nomprodu + "\n"
                                                    + "Fecha lote: " + fechalb.lote + "\n"
                                                    + "Fecha vencimiento: " + fechalb.vence + "\n"
                                                    + "Precio: " + fechalb.precio);
            }
        }
    }
    public void buscarFechav(String fechav){
        productos venceb = new productos();
        int i = 0;
        while(i<pila.size()){
            venceb = (productos) pila.get(i);
            if(venceb.vence.equals(fechav)){
                JOptionPane.showMessageDialog(null, "El producto con la fecha de vencimiento buscada es:\n"
                                                    + "ID: " + venceb.idprodu + "\n"
                                                    + "Nombre: " + venceb.nomprodu + "\n"
                                                    + "Fecha lote: " + venceb.lote + "\n"
                                                    + "Fecha vencimiento: " + venceb.vence + "\n"
                                                    + "Precio: " + venceb.precio);
            }
        }
    }
    public void buscarprecio(float precio){
        productos preciob = new productos();
        int i = 0;
        while(i<pila.size()){
            preciob = (productos) pila.get(i);
            if(preciob.precio == precio){
                JOptionPane.showMessageDialog(null, "El producto con el precio buscado es:\n"
                                                    + "ID: " + preciob.idprodu + "\n"
                                                    + "Nombre: " + preciob.nomprodu + "\n"
                                                    + "Fecha lote: " + preciob.lote + "\n"
                                                    + "Fecha vencimiento: " + preciob.vence + "\n"
                                                    + "Precio: " + preciob.precio);
            }
        }
    }
}
