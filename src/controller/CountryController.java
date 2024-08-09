package controller;

import entities.Country;

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
                System.out.println("Added " + medals + " Gold Medals to " + c.getName());
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
                System.out.println("Added " + medals + " Silver Medals to " + c.getName());
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
                System.out.println("Added " + medals + " Bronze Medals to " + c.getName());
                System.out.println("Updated " + c.getName() + " medals:\n" + c.getGoldMedals() + "|" + c.getSilverMedals() + "|" + c.getBronzeMedals());
                saveCountry();
                System.out.println("-----");
            }
        }
        if (!countryFound) {
            System.out.println("Country not found!");
        }
    }
}
