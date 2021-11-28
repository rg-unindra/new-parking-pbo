/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.kendaraan;

import java.util.List;
import java.util.Scanner;
import parking.database.DatabaseObject;
import parking.utils.Utils;

/**
 *
 * @author Farhan Fadila
 */
public class Kendaraan implements DatabaseObject {
    public String id;
    public String nama;
    public int tarif;
    
    final private Scanner input = new Scanner(System.in);
    final private  KendaraanController kendaraanController = new KendaraanController();
    
    public Kendaraan(String id, String nama, int tarif) {
       this.id = id;
       this.nama = nama;
       this.tarif = tarif;
    }
    
    public void item(int index) {
        System.out.println(index + ". " + nama + ", " + Utils.toRupiah(tarif));
    }
    
    public void menu() {
        
        int pilihan = 0;
        System.out.println();
        System.out.println("== Pilihan Kendaraan ==");
        System.out.println("1. Tambah Data Kendaraan");
        System.out.println("2. Hapus Data Kendaraan");
        System.out.println("===================");
        System.out.print("Masukkan Pilihan: ");
        pilihan = input.nextInt();
        
        System.out.println();
        input.nextLine();
        switch(pilihan) {
            case 1:
               System.out.println("== Tambah Data Kendaraan ==");
               System.out.print("Nama: ");
               nama = input.nextLine();
               System.out.print("Tarif Perjam: Rp");
               tarif = input.nextInt();
               input.nextLine();
               Kendaraan temp = new Kendaraan("", nama, tarif);
               kendaraanController.create(temp);
            break;
            case 2:
               Kendaraan kendaraan = null;
               System.out.println("== Hapus Data Kendaraan ==");
               
               
               kendaraanController.delete(kendaraan.id);
            break;
            default:
               System.out.println("Maaf plihan Anda tidak tersedia!");
            break;
        }
    }
    
    public Kendaraan pilihKendaraan() {
        int pilihan = 0;
        List<Kendaraan> daftarKendaraan = kendaraanController.getList();
        for(int i = 0; i < daftarKendaraan.size(); i++) {
            daftarKendaraan.get(i).item( i + 1);
        }
        System.out.println("===================");
        System.out.print("Masukkan Pilihan: ");
        pilihan = input.nextInt();

        if(pilihan > daftarKendaraan.size() + 1) {
           System.out.println("Maaf plihan Anda tidak tersedia!");
         } else {
           return  daftarKendaraan.get(pilihan - 1);
         }
        return null;
    }

    @Override
    public String toStringObject() {
       return "('"+ nama  + "', " + tarif + ")";
    }
    
    @Override
    public String toString() {
       return nama + "\t" + tarif;
    }
}
