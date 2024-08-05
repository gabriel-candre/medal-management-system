package controller;

import entities.*;
import controller.*;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    CountryController cc = new CountryController();

    public void mainMenu() {
        System.out.println("1 - Add country");
        System.out.println("2 - Show ranking");
        System.out.println("0 - Terminate");
        System.out.print("Option: ");
    }

    public void management(int option) {
        while(option != 0) {
            switch (option) {
                case 1:

                    System.out.print("Country id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Country name: ");
                    String name = sc.nextLine();

                    Country c = new Country(id, name);
                    cc.addCountry(c);
                    break;
                default:
                    break;
            }
            System.out.println("-----");
            mainMenu();
            option = sc.nextInt();
            System.out.println("-----");
        }
    }

}
