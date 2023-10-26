/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendajavafx;

/**
 *
 * @author danie
 */
public class productos {
    String idprodu;
    String nomprodu;
    String lote;
    String vence;
    float precio;
    
    public productos(){
        idprodu = "";
        nomprodu = "";
        lote = "";
        vence = "";
        precio = -1;
    }
    public productos (String idprodu, String nomprodu, String lote, String vence, float precio){
        this.idprodu = idprodu;
        this.nomprodu = nomprodu;
        this.lote = lote;
        this.vence = vence;
        this.precio = precio;
    }

    public String getIdprodu() {
        return idprodu;
    }

    public void setIdprodu(String idprodu) {
        this.idprodu = idprodu;
    }

    public String getNomprodu() {
        return nomprodu;
    }

    public void setNomprodu(String nomprodu) {
        this.nomprodu = nomprodu;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getVence() {
        return vence;
    }

    public void setVence(String vence) {
        this.vence = vence;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

   
}
