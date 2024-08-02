package entities;

public class Country {

    private String name;
    private Integer goldMedal;
    private Integer silverMedals;
    private Integer bronzeMedals;
    private Integer rankingPosition;

    public Country() {

    }

    public Country(String name, int goldMedal, int silverMedals, int bronzeMedals, int rankingPosition) {
        this.name = name;
        this.goldMedal = goldMedal;
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

    public Integer getGoldMedals() {
        return goldMedal;
    }

    public void setGoldMedals(Integer goldMedal) {
        this.goldMedal = goldMedal;
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

    @Override
    public String toString() {
        return getName() + " | " + getGoldMedals() + " |" + getSilverMedals() + " | " + getBronzeMedals();
    }
}
