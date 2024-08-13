package controller;

import entities.*;
import controller.*;
import utils.Ranking;

import java.util.Scanner;

public class Menu {

    CountryController cc = new CountryController();
    Ranking rkg = new Ranking();

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
        System.out.println("0 - Back");
        System.out.print("Option: ");
    }

    public void medalMenu() {
        System.out.println("1 - Gold Medal");
        System.out.println("2 - Silver Medal");
        System.out.println("3 - Bronze Medal");
        System.out.println("4 - Reset medals");
        System.out.println("0 - Back");
        System.out.print("Option: ");
    }

    public void medalResetMenu() {
        System.out.println("1 - Reset ALL medals");
        System.out.println("2 - Reset ALL COUNTRY medals");
        System.out.println("3 - Reset country Gold Medals");
        System.out.println("4 - Reset country Silver Medals");
        System.out.println("5 - Reset country Bronze Medals");
        System.out.println("0 - Back");
        System.out.print("Option: ");
    }

    public void management(int option) {
        while(option != 0) {
            switch (option) {
                case 1:
                    countryManagementMenu();
                    int countryManageOpt = sc.nextInt();
                    System.out.println("-----");
                    while (countryManageOpt != 0) {


                    switch (countryManageOpt) {
                        case 1:
                            System.out.print("Country ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Country name: ");
                            String countryName = sc.nextLine();

                            Country c = new Country(id, countryName);
                            cc.addCountry(c);
                            break;

                        case 2:
                            System.out.print("Country ID to remove: ");
                            id = sc.nextInt();
                            cc.removeCountry(id);
                            break;
                        case 3:
                            medalMenu();
                            int medalOpt = sc.nextInt();
                            while (medalOpt != 0 || medalOpt != 0 || medalOpt != 0) {
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
                                    case 4:
                                        medalResetMenu();
                                        int medalResetOpt = sc.nextInt();
                                        while (medalResetOpt != 0) {
                                            switch (medalResetOpt) {
                                                case 1:
                                                    System.out.print("PLEASE, CONFIRM ALL MEDALS RESET (y/n): ");
                                                    char allReset = sc.next().charAt(0);
                                                    while (allReset != 'y' && allReset != 'Y' && allReset != 'n' && allReset != 'N') {
                                                        System.out.println("Invalid option. Try again.");
                                                        System.out.print("PLEASE, CONFIRM ALL MEDALS RESET (y/n): ");
                                                        allReset = sc.next().charAt(0);
                                                    }
                                                    switch (allReset) {
                                                        case 'y':
                                                        case 'Y':
                                                            cc.resetAllMedals();
                                                            break;
                                                        case 'n':
                                                        case 'N':
                                                            System.out.println("MEDALS HAVE NOT BEEN RESETED.");
                                                            break;
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.print("Country ID: ");
                                                    id = sc.nextInt();
                                                    cc.resetCountryMedals(id);
                                                    break;
                                                case 3:
                                                    System.out.print("Country ID: ");
                                                    id = sc.nextInt();
                                                    cc.resetCountryGoldMedals(id);
                                                    break;
                                                case 4:
                                                    System.out.print("Country ID: ");
                                                    id = sc.nextInt();
                                                    cc.resetCountrySilverMedals(id);
                                                    break;
                                                case 5:
                                                    System.out.print("Country ID: ");
                                                    id = sc.nextInt();
                                                    cc.resetCountryBronzeMedals(id);
                                                    break;
                                                default:
                                                    System.out.println("Option invalid. Try again.");
                                                    medalResetMenu();
                                                    medalResetOpt = sc.nextInt();
                                                    break;
                                            }
                                            medalResetMenu();
                                            medalResetOpt = sc.nextInt();
                                        }
                                        break;
                                    default:
                                        System.out.println("Invalid medal option. Please choose a valid medal option.");
                                        medalMenu();
                                        medalOpt = sc.nextInt();
                                        System.out.println("-----");
                                        break;
                                }
                                medalMenu();
                                medalOpt = sc.nextInt();
                                System.out.println("-----");
                            }
                            break;
                        default:
                            System.out.println("Invalid option. Please choose a valid option.");
                            countryManagementMenu();
                            countryManageOpt = sc.nextInt();
                            break;
                    }
                        countryManagementMenu();
                        countryManageOpt = sc.nextInt();
                    }
                    break;
                case 2:
                    cc.printRanking();
                    System.out.println("-----");
                    break;
                case 3:
                    cc.listAllCountries();
                    System.out.println("-----");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    mainMenu();
                    option = sc.nextInt();
                    break;
            }
            mainMenu();
            option = sc.nextInt();
            System.out.println("-----");
        }
    }

}
