package controller;

import entities.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryController {

    private List<Country> countries = new ArrayList<>();

    public CountryController () {}

    public void addCountry(Country c) {
        countries.add(c);
    }
}
