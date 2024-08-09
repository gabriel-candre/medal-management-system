package controller;

import entities.*;
import controller.*;

import java.util.Scanner;

public class Menu {

    Classification rank = new Classification();
    CountryController cc = new CountryController();

    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("1 - Manage countries");
        System.out.println("2 - Show ranking");
        System.out.println("3 - List all countries");
        System.out.println("0 - Terminate");
        System.out.print("Option: ");
    }

    public void countryManagementMenu() {
        System.out.println("1 - Add country");
        System.out.println("2 - Remove country");
        System.out.println("3 - Manage medals");
        System.out.println("0 - Cancel");
        System.out.print("Option: ");
    }

    public void management(int option) {
        while(option != 0) {
            switch (option) {
                case 1:
                    countryManagementMenu();
                    int countryManageOpt = sc.nextInt();
                    System.out.println("-----");
                    switch (countryManageOpt) {
                        case 1:
                            System.out.print("Country ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Country acronym: ");
                            String countryAcro = sc.next(".{3}");

                            Country c = new Country(id, countryAcro);
                            cc.addCountry(c);
                            break;

                        case 2:
                            System.out.print("Country ID to remove: ");
                            id = sc.nextInt();
                            cc.removeCountry(id);
                            break;
                        case 3:
                            System.out.println("1 - Gold Medal");
                            System.out.println("2 - Silver Medal");
                            System.out.println("3 - Bronze Medal");
                            System.out.print("Option: ");
                            int medalOpt = sc.nextInt();
                            switch (medalOpt){
                                case 1:
                                    System.out.print("Country ID: ");
                                    id = sc.nextInt();
                                    cc.addGoldMedal(id);
                                    break;
                                case 2:
                                    System.out.print("Country ID: ");
                                    id = sc.nextInt();
                                    cc.addSilverMedal(id);
                                    break;
                                case 3:
                                    System.out.print("Country ID: ");
                                    id = sc.nextInt();
                                    cc.addBronzeMedal(id);
                                    break;
                                default:
                                    break;
                            }

                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    cc.listAllCountries();
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
