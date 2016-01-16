package vn.dohoang.cooking.object;

/**
 * Created by hoangdp on 1/16/2016.
 */
public class Nutrition {
    private int proteinsPercent;
    private int carbohydratePercent;
    private int flatsPercent;
    private int caloriesPercent;

    public Nutrition(int proteinsPercent, int carbohydratePercent, int flatsPercent, int caloriesPercent) {
        this.proteinsPercent = proteinsPercent;
        this.carbohydratePercent = carbohydratePercent;
        this.flatsPercent = flatsPercent;
        this.caloriesPercent = caloriesPercent;
    }

    public int getProteinsPercent() {
        return proteinsPercent;
    }

    public void setProteinsPercent(int proteinsPercent) {
        this.proteinsPercent = proteinsPercent;
    }

    public int getCarbohydratePercent() {
        return carbohydratePercent;
    }

    public void setCarbohydratePercent(int carbohydratePercent) {
        this.carbohydratePercent = carbohydratePercent;
    }

    public int getFlatsPercent() {
        return flatsPercent;
    }

    public void setFlatsPercent(int flatsPercent) {
        this.flatsPercent = flatsPercent;
    }

    public int getCaloriesPercent() {
        return caloriesPercent;
    }

    public void setCaloriesPercent(int caloriesPercent) {
        this.caloriesPercent = caloriesPercent;
    }
}
