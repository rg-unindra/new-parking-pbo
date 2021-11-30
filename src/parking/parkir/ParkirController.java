/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.parkir;

import java.util.List;
import parking.database.DatabaseMethod;
/**
 *
 * @author Parking
 */
public class ParkirController implements DatabaseMethod<Parkir> {
    
    ParkirClient parkirClient = null;
    
    public ParkirController() {
        if(parkirClient == null) {
            parkirClient = new ParkirClient();
        }
    }
    
    public Parkir keluarParkir(Parkir parkir) {
      return  parkirClient.keluarParkir(parkir);
    }

    @Override
    public Parkir get(String id) {
       return parkirClient.get(id);
    }

    @Override
    public List<Parkir> getList() {
       return parkirClient.getList();
    }

    @Override
    public void create(Parkir object) {
       parkirClient.create(object);
    }

    @Override
    public void delete(String id) {
       parkirClient.delete(id);
    }

    @Override
    public List<Parkir> getAll() {
       return parkirClient.getAll();
    }
}
