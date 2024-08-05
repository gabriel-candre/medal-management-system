package controller;

import entities.Country;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryController {

    private List<Country> countries = new ArrayList<>();
    private String fileName = "countries.txt";

    public CountryController () {}

    public void addCountry(Country c) {
        countries.add(c);
    }

    private void saveCountry() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Country c : countries) {
                bw.write(c.toFile());
                bw.newLine();
            }
        } catch(IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void loadCountry() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created: " + file);
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
                String line;
                while ((line = br.readLine()) != null) {
                    Country c = Country.fromFile(line);
                    countries.add(c);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            } catch (IOException e) {
                System.out.println("Error loading countries :" + e.getMessage());
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
}
