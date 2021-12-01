
package parking;

import java.util.List;
import java.util.Scanner;
import parking.kendaraan.Kendaraan;
import parking.parkir.Parkir;
import parking.petugas.PetugasController;
import parking.petugas.Petugas;
/**
 *
 * @author Parking
 */
public class Parking {

    public static void crash() {
        System.out.println("Maaf plihan Anda tidak tersedia!");
        System.exit(1);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        final PetugasController petugasController = new PetugasController();
        Petugas petugas = null;
        String ulang = "y";
        int pilihan = 0;
        
        System.out.println("== PROGRAM PARKING ==");
        System.out.println("Pilih akses petugas kamu: ");
        
        List<Petugas> daftarPetugas = petugasController.getList();
        for(int i = 0; i < daftarPetugas.size(); i++) {
            daftarPetugas.get(i).item( i + 1);
        }
        
        System.out.println("===================");
        System.out.print("Masukkan Pilihan: ");
        pilihan = input.nextInt();
        
        if(pilihan > daftarPetugas.size() + 1) {
          crash();
        } else {
          petugas = daftarPetugas.get(pilihan - 1);
        }
        
        do {
            System.out.println();
            System.out.println("== Pilihan Menu ==");
            System.out.println("1. Parkir");
            System.out.println("2. Petugas");
            System.out.println("3. Kendaraan");
            System.out.println("===================");
            System.out.print("Masukkan Pilihan: ");
            pilihan = input.nextInt();
                switch(pilihan) {
                case 1:
                     Parkir parkir = new Parkir("", 0, 0, "", petugas.id, petugas.id, "");
                     parkir.menu();
                break;
                case 2:
                     petugas.menu();
                break;
                case 3:
                    Kendaraan kendaraan = new Kendaraan("", "", 0);
                    kendaraan.menu();
                break;
                default:
                    crash();
                break;
            }
            
                
            input.nextLine();
            System.out.println("===================");
            System.out.println("\nUlang Program?");
            System.out.print("pilihan [y/n] : ");
            ulang = input.nextLine();
       } while(ulang.equalsIgnoreCase("y"));
        System.out.println("\nProgram Selesai");
    }
}
