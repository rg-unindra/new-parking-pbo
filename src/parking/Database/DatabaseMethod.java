/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.database;

import java.util.List;

/**
 *
 * @author Parking
 */
public interface DatabaseMethod<T> {
    T get(String id);
    List<T> getList();
    List<T> getAll();
    
    void create(T object);
    void delete(String id);
}
