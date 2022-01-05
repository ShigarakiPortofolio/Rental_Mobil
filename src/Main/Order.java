package Main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Gilang Ramadhan
 */

public class Order extends Mobil {
    String[]    NIK = {"01234"}, 
                nama = {"Test"}, 
                nomorHp = {"01234"}, 
                orderId = {"31122021/000001"},
                orderPlat = {"A"}, 
                tanggalSewa = {"31-Dec-2021"}, 
                tanggalKembali = {"01-Jan-2022"};
    
    Integer[]   lamaSewa = {1}, 
                deposit = {1000},
                totalBayar = {1000},
                statusOrder = {0};
    
    void showMenuOrder() {
        Scanner input = new Scanner(System.in);
        
        String ulang;
        
        do {
            System.out.println("==============================");
            System.out.println("          Menu Order          ");
            System.out.println("==============================");
            System.out.println("1. Tambah Order");
            System.out.println("2. List Order");
            System.out.println("3. Ubah Status Order");
            System.out.println("==============================");
            System.out.print("Pilih Menu: ");

            int menu = input.nextInt();

            switch(menu) {
                case 1:
                    tambahOrder();
                    
                    break;
                case 2:
                    listOrder();

                    break;
                case 3:
                    ubahStatusOrder();

                    break;
                default:
                    System.out.println("Pilihan Menu Order Tidak Tersedia");

                    break;
            }
            
            System.out.println("==============================");            
            System.out.print("Mulai Ulang Menu Order? (Y): ");
            
            ulang = input.next();
        } while(ulang.equalsIgnoreCase("Y"));
    }
    
    void tambahOrder() {
        Scanner input = new Scanner(System.in);
        
        String ulang;
        
        do {
            this.listMobil();

            System.out.println("==============================");
            System.out.println("         Tambah Order         ");
            System.out.println("==============================");

            System.out.print("NIK: ");

            String newNIK = input.nextLine();

            System.out.print("Nama: ");

            String newNama = input.nextLine();

            System.out.print("Nomor HP: ");

            String newNomorHp = input.nextLine();

            System.out.print("Plat Nomor: ");

            String newPlat = input.nextLine();

            int index = Arrays.asList(platNomor).indexOf(newPlat);

            System.out.print("Lama Sewa: ");

            int lama = input.nextInt();

            System.out.print("Deposit: ");

            int newDeposit = input.nextInt();

            if(index != -1 && statusMobil[index] == 1) {
                LocalDateTime tanggal = LocalDateTime.now();

                DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

                DateTimeFormatter formatTanggalOrder = DateTimeFormatter.ofPattern("ddMMyyyy/HHmmss");

                String newTanggalSewa = formatTanggal.format(tanggal);
                String newTanggalKembali = formatTanggal.format(tanggal.plusDays(lama));

                String newOrderId = formatTanggalOrder.format(tanggal);

                NIK = addString(NIK, newNIK);
                nama = addString(nama, newNama);
                nomorHp = addString(nomorHp, newNomorHp);            
                orderId = addString(orderId, newOrderId);
                orderPlat = addString(orderPlat, newPlat);
                tanggalSewa = addString(tanggalSewa, newTanggalSewa);
                tanggalKembali = addString(tanggalKembali, newTanggalKembali);

                lamaSewa = addInteger(lamaSewa, lama);            
                deposit = addInteger(deposit, newDeposit);

                int total = hargaSewa[index] * lama;

                totalBayar = addInteger(totalBayar, total);            
                statusOrder = addInteger(statusOrder, 0);

                statusMobil[index] = 0;

                slipPembayaran(newOrderId, newNIK, newTanggalSewa, newTanggalKembali, platNomor[index], merek[index], hargaSewa[index], newDeposit, total);
            } else {
                System.out.println("==============================");
                System.out.println("Plat Nomor / Status Tidak Tersedia");
            }
        
            System.out.println("==============================");            
            System.out.print("Mulai Ulang Menu Tambah Order? (Y): ");
            
            ulang = input.next();
        } while(ulang.equalsIgnoreCase("Y"));
    }
    
    void slipPembayaran(String orderId, String NIK, String tanggalSewa, String tanggalKembali, String platNomor, String merek, int hargaSewa, int deposit, int totalBayar) {
        System.out.format("================================================================================================================================================= %n");
        System.out.format("                                                                 Slip Pembayaran                                                                  %n");
        System.out.format("================================================================================================================================================= %n");
        
        String tabelFormat = "%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10d | %-10d | %-10d %n";
        
        System.out.format("Order ID        | NIK             | Tanggal Sewa    | Tanggal Kembali | Plat Mobil      | Merek Mobil     | Harga Sewa | Deposit    | Total Bayar %n");
        System.out.format("================================================================================================================================================= %n");
        
        System.out.format(tabelFormat, orderId, NIK, tanggalSewa, tanggalKembali, platNomor, merek, hargaSewa, deposit, totalBayar);
    }
    
    void listOrder() {
        System.out.format("===============================================================================================================================================================================%n");
        System.out.format("                                                                          List Order                                                                                           %n");
        System.out.format("===============================================================================================================================================================================%n");
        System.out.format("Order ID | NIK             | Nama            | Nomor HP        | Plat Mobil      | Tanggal Sewa    | Lama Sewa  | Tanggal Kembali | Total Bayar     | Deposit    | Status           %n");
        System.out.format("===============================================================================================================================================================================%n");
        
        String tabelFormat = "%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10d | %-15s | %-15d | %-10d | %-15s %n";
        
        for (int i = 0; i < NIK.length; i++) {
            System.out.format(tabelFormat, orderId[i], NIK[i], nama[i], nomorHp[i], orderPlat[i], tanggalSewa[i], lamaSewa[i], tanggalKembali[i], totalBayar[i], deposit[i], statusOrder[i] == 1 ? "Selesai" : "Belum Selesai");
        }
    }
    
    void ubahStatusOrder() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("==============================");
        System.out.println("       Ubah Status Order      ");
        System.out.println("==============================");
        
        System.out.print("Order ID: ");
        
        String newOrderId = input.nextLine();
        
        int index = Arrays.asList(orderId).indexOf(newOrderId);
        
        if(index != -1) {
            statusOrder[index] = 1;
        } else {
            System.out.println("==============================");
            System.out.println("Order Id Tidak Tersedia");
        }
    }
}