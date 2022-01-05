package Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gilang Ramadhan
 */

public class Mobil extends Main {
    public String[] merek = {"Test 1", "Test 2"}, platNomor = {"A", "B"};
    
    public Integer[] hargaSewa = {1000, 2000}, statusMobil = {0, 1};
    
    void showMenuMobil() {
        Scanner input = new Scanner(System.in);
        
        String ulang;
        
        do {
            System.out.println("==============================");
            System.out.println("          Menu Mobil          ");
            System.out.println("==============================");
            System.out.println("1. Tambah Mobil");
            System.out.println("2. List Mobil");
            System.out.println("3. Ubah Status Mobil");
            System.out.println("==============================");
            System.out.print("Pilih Menu: ");

            int menu = input.nextInt();

            switch(menu) {
                case 1:
                    tambahMobil();
                    
                    break;

                case 2:
                    listMobil();

                    break;
                    
                case 3:
                    ubahStatus();

                    break;

                default:
                    System.out.println("Pilihan Menu Mobil Tidak Tersedia");

                    break;
            }
            
            System.out.println("==============================");         
            System.out.print("Mulai Ulang Menu Mobil? (Y): ");
            
            ulang = input.next();
        } while(ulang.equalsIgnoreCase("Y"));
    }
    
    void tambahMobil() {
        Scanner input = new Scanner(System.in);
        
        String ulang;
        
        do {
            System.out.println("==============================");
            System.out.println("         Tambah Mobil         ");
            System.out.println("==============================");

            System.out.print("Merek: ");

            String newMerek = input.nextLine();

            System.out.print("Plat Nomor: ");

            String newPlatNomor = input.nextLine();

            int index = Arrays.asList(platNomor).indexOf(newPlatNomor);

            System.out.print("Harga Sewa: ");

            int newhargaSewa = input.nextInt();

            if(index == -1) {
                merek = addString(merek, newMerek);
                platNomor = addString(platNomor, newPlatNomor);

                hargaSewa = addInteger(hargaSewa, newhargaSewa);
                statusMobil = addInteger(statusMobil, 1);
            } else {
                System.out.println("==============================");
                System.out.println("Plat Nomor Sudah Tersedia");
            }
        
            System.out.println("==============================");            
            System.out.print("Mulai Ulang Menu Tambah Mobil? (Y): ");
            
            ulang = input.next();
        } while(ulang.equalsIgnoreCase("Y"));
    }
    
    void listMobil() {
        System.out.format("============================================================================%n");
        System.out.format("                                List Mobil                                  %n");
        System.out.format("============================================================================%n");
        System.out.format("No. | Merek           | Plat Nomor      | Harga Sewa      | Status Mobil    %n");
        System.out.format("============================================================================%n");
        
        String tabelFormat = "%-3d | %-15s | %-15s | %-15d | %-15s %n";
        
        for (int i = 0; i < this.merek.length; i++) {
            System.out.format(tabelFormat, i + 1, this.merek[i], this.platNomor[i], this.hargaSewa[i], this.statusMobil[i] == 1 ? "Tersedia" : "Tidak Tersedia");
        }
    }
    
    void ubahStatus() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("==============================");
        System.out.println("       Ubah Status Mobil      ");
        System.out.println("==============================");
        
        System.out.print("Plat Nomor: ");
        
        String newPlatNomor = input.nextLine();
        
        int index = Arrays.asList(platNomor).indexOf(newPlatNomor);
        
        if(index != -1) {
            statusMobil[index] = 1;
        } else {
            System.out.println("==============================");
            System.out.println("Plat Nomor Tidak Tersedia");
        }
    }
}
