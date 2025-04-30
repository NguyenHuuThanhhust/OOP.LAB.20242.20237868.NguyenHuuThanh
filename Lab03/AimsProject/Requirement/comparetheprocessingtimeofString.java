package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import java.util.Scanner;

public class aims {

    public static void String() {               //String
    	System.out.println("String");
    	long start = System.nanoTime();
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3\n> ");
        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000.0;
        System.out.printf(" Runtime(String): %.6f ms\n", duration);
    }

    public static void StringBuffer() {             //StringBuffer
    	System.out.println("String Buffer");
    	long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        sb.append("AIMS:\n");
        sb.append("--------------------------------\n");
        sb.append("1. View store\n");
        sb.append("2. Update store\n");
        sb.append("3. See current cart\n");
        sb.append("0. Exit\n");
        sb.append("--------------------------------\n");
        sb.append("Please choose a number: 0-1-2-3\n> ");
        System.out.print(sb.toString());
        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000.0;
        System.out.printf(" Runtime(StringBuffer): %.6f ms\n", duration);
        
    }
    public static void StringBuilder() {  // StringBuilder
    	System.out.println("String Builder");
    	long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        sb.append("AIMS:\n");
        sb.append("--------------------------------\n");
        sb.append("1. View store\n");
        sb.append("2. Update store\n");
        sb.append("3. See current cart\n");
        sb.append("0. Exit\n");
        sb.append("--------------------------------\n");
        sb.append("Please choose a number: 0-1-2-3\n> ");
        System.out.print(sb.toString());
        long end = System.nanoTime();
        double duration = (end - start) / 1_000_000.0;
        System.out.printf("Runtime (StringBuilder): %.6f ms\n", duration);
        
    }
    
    public static void main(String[] args) {
            String();
            StringBuffer();
            StringBuilder();
            
        }
}