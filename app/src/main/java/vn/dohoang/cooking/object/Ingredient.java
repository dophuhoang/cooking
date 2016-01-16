package vn.dohoang.cooking.object;

/**
 * Created by hoangdp on 1/13/2016.
 */
public class Ingredient {
    private String mName;
    private String mValue;

    public Ingredient() {
        mName = "";
        mValue = "";
    }

    public Ingredient(String name, String value) {
        mName = name;
        mValue = value;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
