/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.petugas;

import java.util.List;
import java.util.Scanner;
import parking.database.DatabaseObject;

/**
 *
 * @author Farhan Fadila
 */
public class Petugas implements DatabaseObject {
    public String id;
    public String nama;
    public String shift;
    
    public Petugas(String id, String nama, String shift) {
       this.id = id;
       this.nama = nama;
       this.shift = shift;
    }
    
     final private Scanner input = new Scanner(System.in);
     final private PetugasController petugasController = new PetugasController();
    
    public void item(int index) {
        System.out.println(index + ". " + nama);
    }
    
    public void menu() {
       
        int pilihan = 0;
        System.out.println();
        System.out.println("== Pilihan Petugas ==");
        System.out.println("1. Tambah Data Petugas");
        System.out.println("2. Hapus Data Petugas");
        System.out.println("===================");
        System.out.print("Masukkan Pilihan: ");
        pilihan = input.nextInt();
        
        System.out.println();
        input.nextLine();
        switch(pilihan) {
            case 1:
               System.out.println("== Tambah Data Petugas ==");
               System.out.print("Nama: ");
               nama = input.nextLine();
               System.out.println("Pilih Shift: ");
               System.out.println("1. Siang");
               System.out.println("2. Malam");
               System.out.println("===================");
               System.out.print("Masukkan Pilihan: ");
               shift = input.nextInt() == 1 ? "siang" : "malam";
               Petugas temp = new Petugas("", nama, shift);
               petugasController.create(temp);
            break;
            case 2:
               Petugas petugas = null;
               System.out.println("== Hapus Data Petugas ==");
               List<Petugas> daftarPetugas = petugasController.getList();
               for(int i = 0; i < daftarPetugas.size(); i++) {
                   daftarPetugas.get(i).item( i + 1);
               }
               System.out.println("===================");
               System.out.print("Masukkan Pilihan: ");
               pilihan = input.nextInt();
               
               if(pilihan > daftarPetugas.size() + 1) {
                  System.out.println("Maaf plihan Anda tidak tersedia!");
                } else {
                  petugas = daftarPetugas.get(pilihan - 1);
                }
               
               petugasController.delete(petugas.id);
            break;
            case 3:
                petugasController.get("1");
            break;
            default:
               System.out.println("Maaf plihan Anda tidak tersedia!");
            break;
        }
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
