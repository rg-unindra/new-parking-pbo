/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.kendaraan;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import parking.database.DatabaseClient;
import parking.database.DatabaseMethod;
import parking.kendaraan.Kendaraan;
/**
 *
 * @author Farhan Fadila
 */
public class KendaraanClient extends DatabaseClient implements DatabaseMethod<Kendaraan> {
    
    final String tableName = "jenis_kendaraan";
    
    public KendaraanClient() {
        if(con == null) {
            start();
        }
    }

    @Override
    public Kendaraan get(String id) {
        Kendaraan temp = null;
        ResultSet result = executeQuery("SELECT * FROM " + tableName + " WHERE kode_jenis = " + id);

        try {
          if(result.next()) {
              temp = new Kendaraan(result.getString(1), result.getString(2), result.getInt(3));
          }
        } catch (SQLException ex) {
           Logger.getLogger(KendaraanClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    @Override
    public List<Kendaraan> getList() {
        List<Kendaraan> temp = new ArrayList<>();
        
        ResultSet result = executeQuery("SELECT * FROM " + tableName);

        try {
            while(result.next()) {
               temp.add(new Kendaraan(result.getString(1), result.getString(2), result.getInt(3)));
            }
        } catch (SQLException ex) {
           Logger.getLogger(KendaraanClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    @Override
    public void create(Kendaraan kendaraan) {
        String query = "INSERT INTO  " + tableName + " (nama_jenis, tarif) VALUES " + kendaraan.toStringObject();
        executeQuery2(query);
        System.out.println("DATA BERHASIL DITAMBAHKAN");
    }

    @Override
    public void delete(String id) {
         executeQuery2("DELETE FROM " + tableName + " WHERE kode_jenis = " + id);
    }

    @Override
    public List<Kendaraan> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
