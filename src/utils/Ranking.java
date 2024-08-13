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

        int col1Width = 5;  // Largura para a coluna de posição
        int col2Width = 20; // Largura para a coluna de país
        int col3Width = 10; // Largura para a coluna de medalhas de ouro
        int col4Width = 10; // Largura para a coluna de medalhas de prata
        int col5Width = 10; // Largura para a coluna de medalhas de bronze
        int col6Width = 10; // Largura para a coluna de total de medalhas

        System.out.printf("+-%" + col1Width + "s-+-%" + col2Width + "s-+-%" + col3Width + "s-+-%" + col4Width + "s-+-%" + col5Width + "s-+-%" + col6Width + "s-+\n",
                "", "", "", "", "", "");
        System.out.printf("| %-" + col1Width + "s | %-" + col2Width + "s | %-" + col3Width + "s | %-" + col4Width + "s | %-" + col5Width + "s | %-" + col6Width + "s |\n",
                "Pos", "Country", "Gold", "Silver", "Bronze", "Total");
        System.out.printf("+-%" + col1Width + "s-+-%" + col2Width + "s-+-%" + col3Width + "s-+-%" + col4Width + "s-+-%" + col5Width + "s-+-%" + col6Width + "s-+\n",
                "", "", "", "", "", "");

        for (int i = 0; i < countries.size(); i++) {
            Country c = countries.get(i);
            System.out.printf("| %-" + col1Width + "d | %-" + col2Width + "s | %-" + col3Width + "d | %-" + col4Width + "d | %-" + col5Width + "d | %-" + col6Width + "d |\n",
                    i + 1, c.getName(), c.getGoldMedals(), c.getSilverMedals(), c.getBronzeMedals(), c.getTotalMedals());
        }

        System.out.printf("+-%" + col1Width + "s-+-%" + col2Width + "s-+-%" + col3Width + "s-+-%" + col4Width + "s-+-%" + col5Width + "s-+-%" + col6Width + "s-+\n",
                "", "", "", "", "", "");
    }

}
