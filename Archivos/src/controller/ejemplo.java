
package controller;
import java.util.Scanner;

public class ejemplo {
    
    public static void main(String[] args) {
        String caracter;
        Scanner teclado = new Scanner(System.in);
        caracter = teclado.nextLine();
        for (int i = 0; i < caracter.length(); i++){           
            char character = caracter.charAt(i);           
            int value = (int) character;  
            int value1 = value * 2;
            char value2 = (char) value1; 
            
        }
        
    }
}
