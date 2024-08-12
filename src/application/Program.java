package application;

import controller.Menu;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();

        menu.mainMenu();
        int option = sc.nextInt();
        System.out.println("-----");
        menu.management(option);


        sc.close();
    }
}