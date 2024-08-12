package controller;

import entities.Country;
import utils.Ranking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryController {

    Scanner sc = new Scanner(System.in);

    private List<Country> countries = new ArrayList<>();
    private String fileName = "countries.txt";

    public CountryController () {loadCountry();}

    public void addCountry(Country c) {
        countries.add(c);
        saveCountry();
    }

    private void saveCountry() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Country c : countries) {
                bw.write(c.toFile());
                bw.newLine();
            }
        } catch(IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    private void loadCountry() {
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
                String line;
                while ((line = br.readLine()) != null) {
                    Country c = Country.fromFile(line);
                    countries.add(c);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } catch (IOException e) {
                System.out.println("Error loading countries: " + e.getMessage());
            }
        } else {
            try {
                file.createNewFile();
                System.out.println("File created: " + file);
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }

    public void removeCountry(int id) {
        boolean countryFound = false;

        for (Country c : countries) {
            if (c.getIdCountry() == id) {
                countries.remove(c);
                countryFound = true;
                saveCountry();
                break;
            }
        }
        if (countryFound) {
            System.out.println("Country removed!");
        } else {
            System.out.println("Country not found!");
        }
    }

    public String getCountry(int id) {
        for (Country c : countries) {
            if (c.getIdCountry() == id) {
                return c.toString();
            }
        }
        System.out.println("Country not found!");
        return null;
    }

    public String listAllCountries() {
        if (countries.isEmpty()) {
            return "No country found";
        } else {
            for (Country c : countries) {
                System.out.println(c.toString());
            }
        }
        return null;
    }

    public void addGoldMedal(int countryId) {

        boolean countryFound = false;
        for (Country c : countries) {
            if (c.getIdCountry() == countryId) {
                countryFound = true;
                System.out.print("Gold Medals to " + c.getName() + ": ");
                int medals = sc.nextInt();
                c.addGoldMedal(medals);
                System.out.println("Added " + medals + " Gold Medal(s) to " + c.getName());
                System.out.println("Updated " + c.getName() + " medals:\n" + c.getGoldMedals() + "|" + c.getSilverMedals() + "|" + c.getBronzeMedals());
                saveCountry();
                System.out.println("-----");
            }
        }
        if (!countryFound) {
            System.out.println("Country not found!");
        }
    }

    public void addSilverMedal(int countryId) {
        boolean countryFound = false;
        for (Country c : countries) {
            if (c.getIdCountry() == countryId) {
                countryFound = true;
                System.out.print("Silver Medals to " + c.getName() + ": ");
                int medals = sc.nextInt();
                c.addSilverMedal(medals);
                System.out.println("Added " + medals + " Silver Medal(s) to " + c.getName());
                System.out.println("Updated " + c.getName() + " medals:\n" + c.getGoldMedals() + "|" + c.getSilverMedals() + "|" + c.getBronzeMedals());
                saveCountry();
                System.out.println("-----");
            }
        }
        if (!countryFound) {
            System.out.println("Country not found!");
        }
    }

    public void addBronzeMedal(int countryId) {
        boolean countryFound = false;
        for (Country c : countries) {
            if (c.getIdCountry() == countryId) {
                countryFound = true;
                System.out.print("Bronze Medals to " + c.getName() + ": ");
                int medals = sc.nextInt();
                c.addBronzeMedal(medals);
                System.out.println("Added " + medals + " Bronze Medal(s) to " + c.getName());
                System.out.println("Updated " + c.getName() + " medals:\n" + c.getGoldMedals() + "|" + c.getSilverMedals() + "|" + c.getBronzeMedals());
                saveCountry();
                System.out.println("-----");
            }
        }
        if (!countryFound) {
            System.out.println("Country not found!");
        }
    }

    public void resetAllMedals() {
        for (Country c : countries) {
            c.setGoldMedals(0);
            c.setSilverMedals(0);
            c.setBronzeMedals(0);
            saveCountry();
        }

        System.out.println("All medals reseted.");
        System.out.println("Updated country list: ");
        listAllCountries();
        System.out.println("-----");
    }

    public void resetCountryMedals(int id){
        boolean countryFound = false;
        for (Country c : countries) {
            if (c.getIdCountry() == id) {
                System.out.print("PLEASE, CONFIRM ALL " + c.getName() + "'s MEDALS RESET (y/n): ");
                char countryAllReset = sc.next().charAt(0);
                while (countryAllReset != 'y' && countryAllReset != 'Y' && countryAllReset != 'n' && countryAllReset != 'N') {
                    System.out.print("PLEASE, CONFIRM ALL " + c.getName() + "'s MEDALS RESET (y/n): ");
                    countryAllReset = sc.next().charAt(0);
                }
                switch (countryAllReset) {
                    case 'y':
                    case 'Y':
                        c.setGoldMedals(0);
                        c.setSilverMedals(0);
                        c.setBronzeMedals(0);
                        System.out.println(c.getName() + "'s medal(s) reseted.");
                        saveCountry();
                        System.out.println("-----");
                        break;
                    case 'n':
                    case 'N':
                        System.out.println(c.getName() + "'s MEDALS HAVE NOT BEEN RESET.");
                        System.out.println("-----");
                        break;
                }
                countryFound = true;
            }
        }

        if (!countryFound) {
            System.out.println("Country not found!");
        }
    }

    public void resetCountryGoldMedals(int id) {
        boolean countryFound = false;

        for (Country c : countries) {
            if (c.getIdCountry() == id) {
                System.out.print("PLEASE, CONFIRM ALL " + c.getName() + "'s GOLD MEDALS RESET (y/n): ");
                char countryGoldReset = sc.next().charAt(0);
                while (countryGoldReset != 'y' && countryGoldReset != 'Y' && countryGoldReset != 'n' && countryGoldReset != 'N') {
                    System.out.print("PLEASE, CONFIRM ALL " + c.getName() + "'s MEDALS RESET (y/n): ");
                    countryGoldReset = sc.next().charAt(0);
                }
                switch (countryGoldReset) {
                    case 'y':
                    case 'Y':
                        c.setGoldMedals(0);
                        System.out.println(c.getName() + "'s Gold Medals reseted.");
                        System.out.println("Updated " + c.getName() + " medals:\n" + c.getGoldMedals() + "|" + c.getSilverMedals() + "|" + c.getBronzeMedals());
                        saveCountry();
                        System.out.println("-----");
                        break;
                    case 'n':
                    case 'N':
                        System.out.println(c.getName() + "'s GOLD MEDALS HAVE NOT BEEN RESET.");
                        System.out.println("-----");
                        break;
                }
                countryFound = true;
            }
        }
        if (!countryFound) {
            System.out.println("Country not found.");
        }
    }

    public void resetCountrySilverMedals(int id) {
        boolean countryFound = false;

        for (Country c : countries) {
            if (c.getIdCountry() == id) {
                System.out.print("PLEASE, CONFIRM ALL " + c.getName() + "'s SILVER MEDALS RESET (y/n): ");
                char countrySilverReset = sc.next().charAt(0);
                while (countrySilverReset != 'y' && countrySilverReset != 'Y' && countrySilverReset != 'n' && countrySilverReset != 'N') {
                    System.out.print("PLEASE, CONFIRM ALL " + c.getName() + "'s SILVER MEDALS RESET (y/n): ");
                    countrySilverReset = sc.next().charAt(0);
                }
                switch (countrySilverReset) {
                    case 'y':
                    case 'Y':
                        c.setSilverMedals(0);
                        System.out.println(c.getName() + "'s Silver Medals reseted.");
                        System.out.println("Updated " + c.getName() + " medals:\n" + c.getGoldMedals() + "|" + c.getSilverMedals() + "|" + c.getBronzeMedals());
                        saveCountry();
                        System.out.println("-----");
                        break;
                    case 'n':
                    case 'N':
                        System.out.println(c.getName() + "'s SILVER MEDALS HAVE NOT BEEN RESET.");
                        System.out.println("-----");
                        break;
                }
                countryFound = true;
            }
        }
        if (!countryFound) {
            System.out.println("Country not found.");
        }
    }

    public void resetCountryBronzeMedals(int id) {
        boolean countryFound = false;

        for (Country c : countries) {
            if (c.getIdCountry() == id) {
                System.out.print("PLEASE, CONFIRM ALL " + c.getName() + "'s SILVER MEDALS RESET (y/n): ");
                char countryBronzeReset = sc.next().charAt(0);
                while (countryBronzeReset != 'y' && countryBronzeReset != 'Y' && countryBronzeReset != 'n' && countryBronzeReset != 'N') {
                    System.out.print("PLEASE, CONFIRM ALL " + c.getName() + "'s SILVER MEDALS RESET (y/n): ");
                    countryBronzeReset = sc.next().charAt(0);
                }
                switch (countryBronzeReset) {
                    case 'y':
                    case 'Y':
                        c.setBronzeMedals(0);
                        System.out.println(c.getName() + "'s Bronze Medals reseted.");
                        System.out.println("Updated " + c.getName() + " medals:\n" + c.getGoldMedals() + "|" + c.getSilverMedals() + "|" + c.getBronzeMedals());
                        saveCountry();
                        System.out.println("-----");
                        break;
                    case 'n':
                    case 'N':
                        System.out.println(c.getName() + "'s BRONZE MEDALS HAVE NOT BEEN RESET.");
                        System.out.println("-----");
                        break;
                }
                countryFound = true;
            }
        }
        if (!countryFound) {
            System.out.println("Country not found.");
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void printRanking() {
        Ranking ranking = new Ranking();
        ranking.returnRanking(countries);
    }
}
