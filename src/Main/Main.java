package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gilang Ramadhan
 */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String ulang;
                    
        do {
            System.out.println("==============================");
            System.out.println("          Menu Utama          ");
            System.out.println("==============================");
            System.out.println("1. Menu Mobil");
            System.out.println("2. Menu Order");
            System.out.println("==============================");
            System.out.print("Pilih Menu: ");
            
            int menu = input.nextInt();

            switch(menu) {
                case 1:
                    Mobil showMobil = new Mobil();
                    
                    showMobil.showMenuMobil();
                    
                    break;

                case 2:
                    Order showOrder = new Order();
        
                    showOrder.showMenuOrder();
                    
                    break;

                default:
                    System.out.println("Pilihan Menu Tidak Tersedia");

                    break;
            }
            
            System.out.println("==============================");
            System.out.print("Mulai Ulang Program? (Y): ");
            
            ulang = input.next();
        } while(ulang.equalsIgnoreCase("Y"));
    }
    
    public String[] addString(String arr[], String x) {
        List<String> arrList = new ArrayList<>(Arrays.asList(arr));
        
        arrList.add(x);
        
        arr = arrList.toArray(arr);
        
        return arr;
    }
    
    public Integer[] addInteger(Integer arr[], int x) {
        List<Integer> arrList = new ArrayList<>(Arrays.asList(arr));
        
        arrList.add(x);
        
        arr = arrList.toArray(arr);
        
        return arr;
    }
}