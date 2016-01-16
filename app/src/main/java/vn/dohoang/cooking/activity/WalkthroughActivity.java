package vn.dohoang.cooking.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import vn.dohoang.cooking.R;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class WalkthroughActivity extends AppIntro2 {
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(AppIntroFragment.newInstance(
                getResources().getString(R.string.title_walkthrough_01),
                getResources().getString(R.string.description_walkthrough_01),
                R.drawable.icon_walkthrough_01,
                ContextCompat.getColor(this, R.color.color_walkthrough_01),
                Color.WHITE,
                ContextCompat.getColor(this, R.color.color_desc_walkthrough)));
        addSlide(AppIntroFragment.newInstance(
                getResources().getString(R.string.title_walkthrough_02),
                getResources().getString(R.string.description_walkthrough_02),
                R.drawable.icon_walkthrough_02,
                ContextCompat.getColor(this, R.color.color_walkthrough_02),
                Color.WHITE,
                ContextCompat.getColor(this, R.color.color_desc_walkthrough)));
        addSlide(AppIntroFragment.newInstance(
                getResources().getString(R.string.title_walkthrough_03),
                getResources().getString(R.string.description_walkthrough_03),
                R.drawable.icon_walkthrough_03,
                ContextCompat.getColor(this, R.color.color_walkthrough_03),
                Color.WHITE,
                ContextCompat.getColor(this, R.color.color_desc_walkthrough)));

        setZoomAnimation();
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        Intent intent = new Intent(this, FoodDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSlideChanged() {

    }
}
