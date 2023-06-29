/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propio.gestorapartamentos.DTO;

/**
 *
 * @author anton
 */
public class Apartamento {
    
    int id;
    String nom;
    String  descripcio; 
    int num_persones;
    String adresa; 
    int id_municipi;
    int  id_propietari;
    byte destacat;
    Float preu_per_nit; 

    public Apartamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getNum_persones() {
        return num_persones;
    }

    public void setNum_persones(int num_persones) {
        this.num_persones = num_persones;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getId_municipi() {
        return id_municipi;
    }

    public void setId_municipi(int id_municipi) {
        this.id_municipi = id_municipi;
    }

    public int getId_propietari() {
        return id_propietari;
    }

    public void setId_propietari(int id_propietari) {
        this.id_propietari = id_propietari;
    }

    public byte getDestacat() {
        return destacat;
    }

    public void setDestacat(byte destacat) {
        this.destacat = destacat;
    }

    public Float getPreu_per_nit() {
        return preu_per_nit;
    }

    public void setPreu_per_nit(Float preu_per_nit) {
        this.preu_per_nit = preu_per_nit;
    }

       
    
    
}
