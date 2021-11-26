/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import parking.petugas.PetugasClient;
/**
 *
 * @author Farhan Fadila
 */
public class Parking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PetugasClient petugasClient = new PetugasClient();
       
       petugasClient.getList();
       
       
    }
    
}
