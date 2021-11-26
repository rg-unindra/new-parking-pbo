/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.petugas;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parking.Database.DatabaseClient;
import parking.Database.DatabaseMethod;
import parking.petugas.Petugas;
/**
 *
 * @author Farhan Fadila
 */
public class PetugasClient extends DatabaseClient implements DatabaseMethod<Petugas> {
    
    final String tableName = "petugas";
    
    public PetugasClient() {
        if(con == null) {
            start();
        }
    }

    @Override
    public Petugas get(String id) {
        Petugas temp = null;
        ResultSet result = executeQuery("SELECT * FROM " + tableName + " WHERE kode_pegawai = " + id);

        try {
          temp = new Petugas(result.getString(0), result.getString(1), result.getString(2));
        } catch (SQLException ex) {
           Logger.getLogger(PetugasClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    @Override
    public List<Petugas> getList() {
        List<Petugas> temp = new ArrayList<>();
        
        ResultSet result = executeQuery("SELECT * FROM " + tableName);

        try {
            while(result.next()) {
               temp.add(new Petugas(result.getString(1), result.getString(2), result.getString(3)));
            }
        } catch (SQLException ex) {
           Logger.getLogger(PetugasClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    @Override
    public void create(Petugas petugas) {
        executeQuery("INSERT INTO " + tableName + " (nama_pegawai, shift) VALUES (" + petugas.nama + ", " + petugas.shift + ")" );
        System.out.println("DATA PETUGAS BERHASIL DITAMBAHKAN");
    }

    @Override
    public void delete(String id) {
         executeQuery("DELETE FROM " + tableName + " WHERE kode_pegawai = " + id);
    }

}
