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
    public void productoexpirado(){
        String fecha = principalController.fecha;
        for (productos eliminar : pila){
            if(eliminar.vence.equals(fecha)){
                pila.remove(eliminar);
            }
        }
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
    public float sacarpromedio(){
        float suma = 0;
        float promedio = 0;
        for (productos sum : pila){
            suma = sum.precio + suma;
        }
        promedio = suma / pila.size();
        return promedio;
    }
    public void menorprom(){
        float promedio = sacarpromedio();
        for(productos menor : pila){
            if(menor.precio < promedio){
                JOptionPane.showMessageDialog(null, "Los productos con un precio menor al promedio son:\n"
                                                    + "ID: " + menor.idprodu + "\n"
                                                    + "Nombre: " + menor.nomprodu + "\n"
                                                    + "Fecha lote: " + menor.lote + "\n"
                                                    + "Fecha vencimiento: " + menor.vence + "\n"
                                                    + "Precio: " + menor.precio);
            }
        }
    }
    public void mayorprom(){
        float promedio = sacarpromedio();
        for(productos mayor : pila){
            if(mayor.precio > promedio){
                JOptionPane.showMessageDialog(null, "Los productos con un precio menor al promedio son:\n"
                                                    + "ID: " + mayor.idprodu + "\n"
                                                    + "Nombre: " + mayor.nomprodu + "\n"
                                                    + "Fecha lote: " + mayor.lote + "\n"
                                                    + "Fecha vencimiento: " + mayor.vence + "\n"
                                                    + "Precio: " + mayor.precio);
            }
        }
    }
    public void mayorprecio(){
        productos mayor = new productos();
        for (productos lista : pila){
            if(lista.precio > mayor.precio){
                mayor = lista;
            }
        }
        for (productos lista : pila){
            if(lista.precio == mayor.precio){
                JOptionPane.showMessageDialog(null, "Los productos con mayor precio son:\n"
                                                    + "ID: " + lista.idprodu + "\n"
                                                    + "Nombre: " + lista.nomprodu + "\n"
                                                    + "Fecha lote: " + lista.lote + "\n"
                                                    + "Fecha vencimiento: " + lista.vence + "\n"
                                                    + "Precio: " + lista.precio);
            }
        }
    }
    public void menorprecio(){
        productos mayor = new productos();
        for (productos may : pila){
            if(may.precio > mayor.precio){
                mayor = may;
            }
        }
        for (productos men : pila){
            if(men.precio < mayor.precio){
                mayor = men;
            }
        }
        for (productos lista : pila){
            if(lista.precio == mayor.precio){
                JOptionPane.showMessageDialog(null, "Los productos con mayor precio son:\n"
                                                    + "ID: " + lista.idprodu + "\n"
                                                    + "Nombre: " + lista.nomprodu + "\n"
                                                    + "Fecha lote: " + lista.lote + "\n"
                                                    + "Fecha vencimiento: " + lista.vence + "\n"
                                                    + "Precio: " + lista.precio);
            }
        }
    }
}
