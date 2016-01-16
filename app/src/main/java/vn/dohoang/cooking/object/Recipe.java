package vn.dohoang.cooking.object;

/**
 * Created by hoangdp on 1/14/2016.
 */
public class Recipe {
    private int mNumber;
    private String mTitle;
    private String mDescription;
    private int mIdPhoto;

    public Recipe(int number, String title, String description, int idPhoto) {
        mNumber = number;
        mTitle = title;
        mDescription = description;
        mIdPhoto = idPhoto;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getIdPhoto() {
        return mIdPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        mIdPhoto = idPhoto;
    }
}
