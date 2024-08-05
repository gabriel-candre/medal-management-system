package entities;

public class Country {

    private String name;
    private Integer idCountry;
    private Integer goldMedals;
    private Integer silverMedals;
    private Integer bronzeMedals;
    private Integer rankingPosition;

    public Country() {

    }

    public Country(int idCountry, String name) {
        this.name = name;
        this.idCountry = idCountry;
    }

    public Country(int rankingPosition, String name, int goldMedals, int silverMedals, int bronzeMedals) {
        this.rankingPosition = rankingPosition;
        this.name = name;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
    }

    public Country(String name, Integer idCountry, Integer goldMedal, Integer silverMedals, Integer bronzeMedals, Integer rankingPosition) {
        this.name = name;
        this.idCountry = idCountry;
        this.goldMedals = goldMedal;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
        this.rankingPosition = rankingPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public Integer getGoldMedals() {
        return goldMedals;
    }

    public void setGoldMedal(Integer goldMedal) {
        this.goldMedals = goldMedal;
    }

    public Integer getSilverMedals() {
        return silverMedals;
    }

    public void setSilverMedals(Integer silverMedals) {
        this.silverMedals = silverMedals;
    }

    public Integer getBronzeMedals() {
        return bronzeMedals;
    }

    public void setBronzeMedals(Integer bronzeMedals) {
        this.bronzeMedals = bronzeMedals;
    }

    public Integer getRankingPosition() {
        return rankingPosition;
    }

    public void setRankingPosition(Integer rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    public String toFile() {
        return getName() + ";" + getGoldMedals() + ";" + getSilverMedals() + ";" + getBronzeMedals() + ";" + getRankingPosition();
    }

    public static Country fromFile(String fileString) {
        String [] fields = fileString.split(";");
        String name = fields[0];
        int goldMedals = Integer.parseInt(fields[1]);
        int silverMedals = Integer.parseInt(fields[2]);
        int bronzeMedals = Integer.parseInt(fields[3]);
        int position = Integer.parseInt(fields[4]);
        return new Country(position, name, goldMedals, silverMedals, bronzeMedals);
    }

    @Override
    public String toString() {
        return getName() + " | " + getGoldMedals() + " |" + getSilverMedals() + " | " + getBronzeMedals();
    }
}
