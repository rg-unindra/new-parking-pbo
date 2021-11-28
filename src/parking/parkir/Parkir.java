/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.parkir;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import parking.database.DatabaseObject;
import parking.kendaraan.Kendaraan;
import parking.kendaraan.KendaraanController;
import parking.petugas.Petugas;
import parking.petugas.PetugasController;
import java.util.concurrent.TimeUnit;
import parking.utils.Utils;

/**
 *
 * @author Farhan Fadila
 */
public class Parkir implements DatabaseObject {
    public String id;
    public long tanggalMasuk;
    public long tanggalKeluar;
    public String platNomor;
    public String idPetugasMasuk;
    public String idPetugasKeluar;
    public String idJenis;
    
    final private Scanner input = new Scanner(System.in);
    final private ParkirController parkirController = new ParkirController();
    final private SimpleDateFormat crunchifyFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
    final private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
 
    
    
    public Parkir(String id, long tanggalMasuk, long tanggalKeluar, String platNomor, String idPetugasMasuk, String idPetugasKeluar, String idJenis) {
       this.id = id;
       this.tanggalMasuk = tanggalMasuk;
       this.tanggalKeluar = tanggalKeluar;
       this.platNomor = platNomor;
       this.idPetugasMasuk = idPetugasMasuk;
       this.idPetugasKeluar = idPetugasKeluar;
       this.idJenis = idJenis;
    }
    
    public void item(int index, boolean withTanggalKeluar) {
        String additionalInfo =   withTanggalKeluar == true ?  " | Tanggal Keluar" + df.format(convertToDate(tanggalMasuk)) : "";
        System.out.println(index + ". " + platNomor + " | Tanggal Masuk " + df.format(convertToDate(tanggalMasuk)) + additionalInfo);
    }
    
    public void menu() {
        int pilihan = 0;
        System.out.println();
        System.out.println("== Pilihan Parkir ==");
        System.out.println("1. Masuk Parkir");
        System.out.println("2. Keluar");
        System.out.println("3. Daftar Parkir");
        System.out.println("===================");
        System.out.print("Masukkan Pilihan: ");
        pilihan = input.nextInt();
        
        System.out.println();
        input.nextLine();
        switch(pilihan) {
            case 1:
               Kendaraan kendaraan = new Kendaraan("", "", 0);
               System.out.println("== Masuk Parkir ==");
               System.out.print("Plat Nomor: ");
               platNomor = input.nextLine();
               System.out.println("= Pilih Jenis Kendaraan = ");
               idJenis = kendaraan.pilihKendaraan().id;
               System.out.print(idPetugasMasuk);
               tanggalMasuk = timeNow();
               parkirController.create(this);
            break;
            case 2:
               System.out.println("== Keluar Parkir ==");
               Parkir parkir = pilihDaftarParkir();
                if(parkir != null) {
                    parkir = parkirController.keluarParkir(parkir);
                   cetakStruk(parkir);
                }
                
            break;
            case 3:
              lihatDaftarParkir();
            break;
            default:
               System.out.println("Maaf plihan Anda tidak tersedia!");
            break;
        }
    }
    
    public void lihatDaftarParkir() {
        System.out.println("== Daftar Parkir ==");
        List<Parkir> daftarParkir = parkirController.getAll();
        for(int i = 0; i < daftarParkir.size(); i++) {
            daftarParkir.get(i).item( i + 1, true);
        }
        System.out.println("===================");
    }
    
    public Parkir pilihDaftarParkir() {
        int pilihan = 0;
        Parkir parkir = null;
        System.out.println("== Daftar kendaraan yang masih parkir ==");
        List<Parkir> daftarParkir = parkirController.getList();
        if(daftarParkir.size() > 0) {
             for(int i = 0; i < daftarParkir.size(); i++) {
            daftarParkir.get(i).item( i + 1, false);
        }
        System.out.println("===================");
        System.out.print("Masukkan Pilihan: ");
        pilihan = input.nextInt();

        if(pilihan > daftarParkir.size() + 1) {
           System.out.println("Maaf plihan Anda tidak tersedia!");
         } else {
           parkir = daftarParkir.get(pilihan - 1);
           parkir.idPetugasKeluar = idPetugasKeluar;
           parkir.tanggalKeluar = timeNow();
         }
            return parkir;
        } else {
            System.out.println("Daftar kendaraan yang masih parkir kosong!");
            return null;
        }
    }
    
    private void cetakStruk(Parkir parkir) {
        final PetugasController petugasController = new PetugasController();
        final KendaraanController kendaraanController = new KendaraanController();
       
        
        Kendaraan kendaraan = kendaraanController.get(parkir.idJenis);
        Petugas petugasMasuk = petugasController.get(parkir.idPetugasMasuk);
        Petugas petugasKeluar = petugasController.get(parkir.idPetugasMasuk);
        
       
        Date masuk = null, keluar = null;
        long diffrenceInHour = 1;
        try{
          masuk =  convertToDate(parkir.tanggalMasuk);
          keluar =  convertToDate(parkir.tanggalKeluar);
          long temp = parkir.tanggalKeluar - parkir.tanggalMasuk;
          TimeUnit timeUnit = TimeUnit.HOURS;
          diffrenceInHour =  timeUnit.convert(temp, TimeUnit.MILLISECONDS);
        } catch(Exception ex) {
            System.out.print(ex);
        }
        
         Number totalHarga = diffrenceInHour == 0 ? 1 * kendaraan.tarif : diffrenceInHour * kendaraan.tarif;
         
         System.out.println("\n==== STRUK PARKIR ===");
         System.out.println("Plat Nomor " + parkir.platNomor);
         System.out.println("Tanggal Masuk " + df.format(masuk));
         System.out.println("Tanggal Keluar " + df.format(masuk));
         System.out.println("---------------------");
         System.out.println("Petugas Masuk " + petugasMasuk.nama);
         System.out.println("Petugas Keluar " + petugasKeluar.nama);
         System.out.println("---------------------");
         System.out.println("Total Harga " + Utils.toRupiah(totalHarga));
         System.out.println();
         System.out.println("Terima Kasih telah parkir di tempat Kami");
         System.out.println("Parking");
    }

    public String toMasukParkirObject() {
      long temp = timeNow();
      return "("+ temp  + ",'" + platNomor  + "','" + idPetugasMasuk + "','" + idJenis + "')";
    }

    public String keluarParkirObject() {
      long temp = timeNow();
      return "tanggal_keluar = " + temp + ", kode_petugas_keluar = '" + idPetugasKeluar + "' ";
    }
    
    public Date convertToDate(Long value) {
        return new Date(value);
    }

    long timeNow() {
       try {
            Date today = Calendar.getInstance().getTime();
            String currentTime = crunchifyFormat.format(today);
            Date date = crunchifyFormat.parse(currentTime);
            return date.getTime();
       } catch(Exception e) {
            System.out.println(e);
       }
       return 0;
    }

    @Override
    public String toStringObject() {
       return "('"+ tanggalMasuk  + "','" + tanggalKeluar + "')";
    }

    
    
    @Override
    public String toString() {
       return tanggalMasuk + "\t" + tanggalKeluar;
    }
}
