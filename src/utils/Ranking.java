package utils;

import java.util.*;

import controller.CountryController;
import entities.*;

public class Ranking {

    private List<Country> countries = new ArrayList<>();

    public Ranking() {

    }

    public Ranking(List<Country> countries) {
        this.countries = countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void returnRanking(List<Country> countries) {
        Collections.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {

                int result = c2.getGoldMedals().compareTo(c1.getGoldMedals());
                if (result != 0) return result;

                result = c2.getSilverMedals().compareTo(c1.getSilverMedals());
                if (result != 0) return result;

                result = c2.getBronzeMedals().compareTo(c1.getBronzeMedals());
                if (result != 0) return result;

                return c1.getName().compareToIgnoreCase(c2.getName());
            }
        });

        System.out.printf("%-5s %-20s %-10s %-10s %-10s\n", "Pos", "Country", "Gold", "Silver", "Bronze");

        for (Country c : countries) {
            System.out.printf("%-5d %-20s %-10d %-10d %-10d\n",c.getRankingPosition(), c.getName(), c.getGoldMedals(), c.getSilverMedals(), c.getBronzeMedals());
        }
    }

}
