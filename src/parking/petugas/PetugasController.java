/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.petugas;

import java.util.List;
import parking.database.DatabaseMethod;
/**
 *
 * @author Farhan Fadila
 */
public class PetugasController implements DatabaseMethod<Petugas> {
    
    PetugasClient petugasClient = null;
    
    public PetugasController() {
        if(petugasClient == null) {
            petugasClient = new PetugasClient();
        }
    }

    @Override
    public Petugas get(String id) {
       return petugasClient.get(id);
    }

    @Override
    public List<Petugas> getList() {
       return petugasClient.getList();
    }

    @Override
    public void create(Petugas object) {
       petugasClient.create(object);
    }

    @Override
    public void delete(String id) {
       petugasClient.delete(id);
    }

    @Override
    public List<Petugas> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
