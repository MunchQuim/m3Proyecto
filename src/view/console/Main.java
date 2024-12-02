package view.console;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    
    static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        keyboard.useDelimiter("\n");
        String opcionStr;

        do {
            System.out.println("Victor Hidalgo Sanjurjo");
            System.out.println("1- ");
            System.out.println("2- ");
            System.out.println("3- ");
            System.out.println("4- ");
            System.out.println("5- ");
            System.out.println("6- ");
            System.out.println("7- ");
            System.out.println("8- ");
            System.out.println("9- ");
            System.out.println("10-");
            System.out.println("0- Salir");
            opcionStr = keyboard.next();

            switch (opcionStr) {
                case "0":
                    System.out.println("Chao!");
                    break;
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    break;
                default:
                    System.out.println("Opcion Incorrecta!");
            }
        } while (!opcionStr.equals("0"));
    }
}
