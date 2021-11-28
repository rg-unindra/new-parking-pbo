/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.kendaraan;

import parking.database.DatabaseObject;

/**
 *
 * @author Farhan Fadila
 */
public class Kendaraan implements DatabaseObject {
    String id;
    String nama;
    String tarif;
    
    public Kendaraan(String id, String nama, String tarif) {
       this.id = id;
       this.nama = nama;
       this.tarif = tarif;
    }

    @Override
    public String toStringObject() {
       return "('"+ nama  + "', " + tarif + ")";
    }
    
    @Override
    public String toString() {
       return nama + "\t" + tarif;
    }
}
