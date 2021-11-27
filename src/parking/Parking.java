/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.List;
import parking.petugas.PetugasController;
import parking.petugas.Petugas;
/**
 *
 * @author Farhan Fadila
 */
public class Parking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PetugasController petugasController = new PetugasController();
       
       List<Petugas> petugas =  petugasController.getList();
       
       for(int i = 0; i < petugas.size(); i++) {
           System.out.println(petugas.get(i));
       }
       
       Petugas a = new Petugas("", "Agung", "siang");
       
       petugasController.create(a);
       petugasController.delete("4");
    }
}
