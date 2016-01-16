package vn.dohoang.cooking.object;

import java.util.ArrayList;

import vn.dohoang.cooking.AppEnum;

/**
 * Created by hoangdp on 1/15/2016.
 */
public class IngredientGroup {
    private AppEnum.EIngredientType mType;
    private ArrayList<Ingredient> mDataset;

    public IngredientGroup(AppEnum.EIngredientType type, ArrayList<Ingredient> dataset) {
        mType = type;
        mDataset = dataset;
    }

    public AppEnum.EIngredientType getType() {
        return mType;
    }

    public void setType(AppEnum.EIngredientType type) {
        mType = type;
    }

    public ArrayList<Ingredient> getDataset() {
        return mDataset;
    }

    public void setDataset(ArrayList<Ingredient> dataset) {
        mDataset = dataset;
    }
}
