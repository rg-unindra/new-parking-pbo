/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.kendaraan;

import java.util.List;
import parking.database.DatabaseMethod;
/**
 *
 * @author Parking
 */
public class KendaraanController implements DatabaseMethod<Kendaraan> {
    
    KendaraanClient kendaraanClient = null;
    
    public KendaraanController() {
        if(kendaraanClient == null) {
            kendaraanClient = new KendaraanClient();
        }
    }

    @Override
    public Kendaraan get(String id) {
       return kendaraanClient.get(id);
    }

    @Override
    public List<Kendaraan> getList() {
       return kendaraanClient.getList();
    }

    @Override
    public void create(Kendaraan object) {
       kendaraanClient.create(object);
    }

    @Override
    public void delete(String id) {
       kendaraanClient.delete(id);
    }

    @Override
    public List<Kendaraan> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
