/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.petugas;

import parking.database.DatabaseObject;

/**
 *
 * @author Farhan Fadila
 */
public class Petugas implements DatabaseObject {
    String id;
    String nama;
    String shift;
    
    public Petugas(String id, String nama, String shift) {
       this.id = id;
       this.nama = nama;
       this.shift = shift;
    }

    @Override
    public String toStringObject() {
       return "('"+ nama  + "','" + shift + "')";
    }
    
    @Override
    public String toString() {
       return nama + "\t" + shift;
    }
}
