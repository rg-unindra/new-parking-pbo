/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.parkir;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parking.database.DatabaseClient;
import parking.database.DatabaseMethod;
/**
 *
 * @author Parking
 */
public class ParkirClient extends DatabaseClient implements DatabaseMethod<Parkir> {
    
    final String tableName = "parkir";
    
    public ParkirClient() {
        if(con == null) {
            start();
        }
    }

    public Parkir keluarParkir(Parkir parkir) {
        String query = "UPDATE " + tableName + " SET " + parkir.toKeluarParkirObject() + " WHERE kode_parkir = " + parkir.id;
        executeQuery2(query);
        return get(parkir.id);
    }

    @Override
    public Parkir get(String id) {
        Parkir temp = null;
        ResultSet result = executeQuery("SELECT * FROM " + tableName + " WHERE kode_parkir = " + id);

        try {
           if(result.next()) {
                temp = new Parkir(result.getString(1), result.getLong(2), result.getLong(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
           }
         } catch (SQLException ex) {
           Logger.getLogger(ParkirClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    @Override
    public List<Parkir> getList() {
        List<Parkir> temp = new ArrayList<>();
        
        ResultSet result = executeQuery("SELECT * FROM " + tableName + " WHERE tanggal_keluar IS NULL");

        try {
            while(result.next()) {
               temp.add(new Parkir(result.getString(1), result.getLong(2), result.getLong(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
        } catch (SQLException ex) {
           Logger.getLogger(ParkirClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    @Override
    public void create(Parkir parkir) {
        String query = "INSERT INTO  " + tableName + " (tanggal_masuk, plat_nomor, kode_petugas_masuk, kode_jenis) VALUES " + parkir.toMasukParkirObject();
        executeQuery2(query);
        System.out.println("DATA PARKIR BERHASIL DITAMBAHKAN");
    }

    @Override
    public void delete(String id) {
         executeQuery2("DELETE FROM " + tableName + " WHERE kode_parkir = " + id);
    }

    @Override
    public List<Parkir> getAll() {
        List<Parkir> temp = new ArrayList<>();
        
        ResultSet result = executeQuery("SELECT * FROM " + tableName);

        try {
            while(result.next()) {
               temp.add(new Parkir(result.getString(1), result.getLong(2), result.getLong(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
            }
        } catch (SQLException ex) {
           Logger.getLogger(ParkirClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }
}
