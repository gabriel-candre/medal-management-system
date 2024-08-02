package controller;

import entities.Country;
import controller.CountryController;

public class Menu {

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

                    break;
                default:
                    break;
            }
        }
    }

}
