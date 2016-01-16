package vn.dohoang.cooking.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import vn.dohoang.cooking.AppEnum;
import vn.dohoang.cooking.R;
import vn.dohoang.cooking.adapter.IngredientGroupAdapter;
import vn.dohoang.cooking.adapter.RecipeAdapter;
import vn.dohoang.cooking.object.Ingredient;
import vn.dohoang.cooking.object.IngredientGroup;
import vn.dohoang.cooking.object.Nutrition;
import vn.dohoang.cooking.object.Recipe;
import vn.dohoang.cooking.view.CircularProgressBar;

import java.util.ArrayList;

public class FoodDetailActivity extends AppCompatActivity {
    private TextView mTextViewCoverName;
    private LinearLayout mLayoutIngredientGroupList;
    private LinearLayout mLayoutRecipe;

    private CircularProgressBar mProgressBarProteins;
    private CircularProgressBar mProgressBarCarbohydrate;
    private CircularProgressBar mProgressBarFats;
    private TextView mTextViewProteinsPercent;
    private TextView mTextViewCarbohydratePercent;
    private TextView mTextViewFatsPercent;
    private TextView mTextViewCaloriesPercent;

    private Nutrition mNutrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        mTextViewCoverName = (TextView) findViewById(R.id.text_view_cover_name);
        mLayoutIngredientGroupList = (LinearLayout) findViewById(R.id.layout_ingredient_group_list);
        mLayoutRecipe = (LinearLayout) findViewById(R.id.layout_recipe_list);

        mProgressBarProteins = (CircularProgressBar) findViewById(R.id.circular_progress_bar_proteins);
        mProgressBarCarbohydrate = (CircularProgressBar) findViewById(R.id.circular_progress_bar_carbohydrate);
        mProgressBarFats = (CircularProgressBar) findViewById(R.id.circular_progress_bar_fats);
        mTextViewProteinsPercent = (TextView) findViewById(R.id.text_view_proteins_percent);
        mTextViewCarbohydratePercent = (TextView) findViewById(R.id.text_view_carbohydrate_percent);
        mTextViewFatsPercent = (TextView) findViewById(R.id.text_view_fats_percent);
        mTextViewCaloriesPercent = (TextView) findViewById(R.id.text_view_calories_percent);

        initCoverLayout();
        initNutritionLayout();
        initIngredientLayout();
        initRecipeLayout();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBarProteins.setProgress(mNutrition.getProteinsPercent());
                mProgressBarCarbohydrate.setProgress(mNutrition.getCarbohydratePercent());
                mProgressBarFats.setProgress(mNutrition.getFlatsPercent());

                mTextViewProteinsPercent.setText(mNutrition.getProteinsPercent() + "%");
                mTextViewCarbohydratePercent.setText(mNutrition.getCarbohydratePercent() + "%");
                mTextViewFatsPercent.setText(mNutrition.getFlatsPercent() + "%");
                mTextViewCaloriesPercent.setText(mNutrition.getCaloriesPercent() + "");
            }
        }, 2000);
    }

    private void initCoverLayout() {
        mTextViewCoverName.setText("Gỏi rau má thịt bò");
    }

    private void initNutritionLayout() {
        GradientDrawable drawable = (GradientDrawable) mTextViewCaloriesPercent.getBackground();
        drawable.setColor(ContextCompat.getColor(this, R.color.color_primary_light));

        mNutrition = new Nutrition(65, 24, 6, 240);
    }

    private void initIngredientLayout() {
        ArrayList<IngredientGroup> ingredientGroups = new ArrayList<>();
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Rau má", "200g"));
        ingredients.add(new Ingredient("Hành tây", "1 củ"));
        ingredients.add(new Ingredient("Cà rốt", "1/2 củ"));
        ingredients.add(new Ingredient("Hành khô", "2 củ"));
        ingredientGroups.add(new IngredientGroup(AppEnum.EIngredientType.SALAD, ingredients));

        ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Thịt bò", "150g"));
        ingredientGroups.add(new IngredientGroup(AppEnum.EIngredientType.MEAT, ingredients));

        IngredientGroupAdapter adapter = new IngredientGroupAdapter(mLayoutIngredientGroupList, ingredientGroups);
        ArrayList<View> viewList = adapter.getViewList();
        mLayoutIngredientGroupList.removeAllViews();
        for (int i = viewList.size() - 1; i >= 0; i--) {
            View view = viewList.get(i);
            mLayoutIngredientGroupList.addView(view, 0, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    private void initRecipeLayout() {
        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe(1, "Làm sạch rau má", "Rau má mua về nhặt bỏ lá già, rễ, rửa sạch, ngâm với nước muối loãng khoảng 30 phút, sau đó vớt ra để thật ráo nước.", R.drawable.food_01_r01));
        recipeList.add(new Recipe(2, "Chuẩn bị hành, tỏi", "Hành củ, tỏi bóc vỏ, rửa sạch, bằm nhỏ. Cà rốt gọt vỏ, rửa sạch thái sợi nhỏ. Hành trắng gọt vỏ, rửa sạch thái lát mỏng. Ớt rửa sạch, xắt lát.", R.drawable.food_01_r02));
        recipeList.add(new Recipe(3, "Ướp thịt bò", "Thịt bò rửa sạch, thái lát mỏng, ướp với chút tỏi băm, tiêu và dầu hào khoảng 10 phút cho ngấm.", R.drawable.food_01_r03));
        recipeList.add(new Recipe(4, "Ngâm hành cho bớt hăng", "Lấy 1/3 chén dấm ăn, cho thêm 1 thìa đường vào bát và hòa tan. Sau đó cho hành trắng đã thái mỏng ở trên vào ngâm khoảng 5 phút cho bớt hăng.", R.drawable.food_01_r04));
        recipeList.add(new Recipe(5, "Xào thịt bò", "Bắc chảo lên bếp, khi dầu ăn nóng cho hành, tỏi đã băm nhỏ ở trên vào phi thơm, vớt ra đĩa để riêng. Cũng chảo dầu này cho thịt bò đã ướp vào xào nhanh tay, thịt bò chín tắt bếp cho ra bát cho nguội chút.", R.drawable.food_01_r05));
        recipeList.add(new Recipe(6, "Pha nước mắm trộn gỏi", "Chanh bổ đôi, vắt lấy nước, bỏ hạt. Cho thêm 2 thìa đường, 2 thìa nước mắm, ít tỏi bằm, ớt xắt lát khuấy đều. Tỷ lệ nước trộn gỏi thay đổi tùy theo loại nước mắm bạn sử dụng, sau khi đường tan, nêm nếm cho vừa miệng.", R.drawable.food_01_r06));
        recipeList.add(new Recipe(7, "Trộn gỏi", "Cho rau má, cà rốt thái sợi, hành trắng vào một cái tô lớn. Dưới 2/3 chỗ nước chấm trộn gỏi trên vào hỗn hợp rau trong tô, trộn đều để khoảng 10 phút cho ngấm. Tiếp đó cho thịt bò đã xào chín vào và cho từ từ phần nước chấm còn lại vào, nêm nếm vừa miệng. Cho ra đĩa rắc thêm ít hành, tỏi đã phi thơm ở trên là được. Ăn gỏi rau má thịt bò cùng với nước chấm chua ngọt và đĩa phồng tôm. Chúc bạn thành công!", R.drawable.food_01_r07));
        // specify an adapter (see also next example)
        RecipeAdapter adapter = new RecipeAdapter(mLayoutRecipe, recipeList);
        ArrayList<View> viewList = adapter.getViewList();
        for (int i = viewList.size() - 1; i >= 0; i--) {
            View view = viewList.get(i);
            mLayoutRecipe.addView(view, 0, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }
}
