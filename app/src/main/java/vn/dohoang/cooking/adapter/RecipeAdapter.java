package vn.dohoang.cooking.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import vn.dohoang.cooking.R;
import vn.dohoang.cooking.object.Recipe;

import java.util.ArrayList;

/**
 * Created by hoangdp on 1/13/2016.
 */
public class RecipeAdapter {
    public static class ViewHolder {
        private Context mContext;
        public View view;
        public TextView txtRecipeNumber;
        public ImageView imgRecipeLine;
        public ImageView imgRecipePhoto;
        public TextView txtRecipeTitle;
        public TextView txtRecipeDescription;

        public ViewHolder(Context c, View v) {
            mContext = c;
            view = v;
            txtRecipeNumber = (TextView) v.findViewById(R.id.text_view_recipe_number);
            imgRecipeLine = (ImageView) v.findViewById(R.id.image_view_recipe_line);
            imgRecipePhoto = (ImageView) v.findViewById(R.id.image_view_recipe_photo);
            txtRecipeTitle = (TextView) v.findViewById(R.id.text_view_recipe_title);
            txtRecipeDescription = (TextView) v.findViewById(R.id.text_view_recipe_description);
        }

        public Context getContext() {
            return mContext;
        }
    }

    private ViewGroup mViewGroup;
    private ArrayList<Recipe> mDataset;
    private ArrayList<View> mViewList;

    public RecipeAdapter(ViewGroup viewGroup, ArrayList<Recipe> dataset) {
        mViewGroup = viewGroup;
        mDataset = dataset;
        mViewList = new ArrayList<>();
        initViews();
    }

    private void initViews() {
        for (int i = 0; i < getItemCount(); i++) {
            ViewHolder viewHolder = onCreateViewHolder(mViewGroup);
            onBindViewHolder(viewHolder, i);
            mViewList.add(viewHolder.view);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_recipe, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(parent.getContext(), v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Recipe recipe = mDataset.get(position);
        GradientDrawable drawable = (GradientDrawable) holder.txtRecipeNumber.getBackground();
        drawable.setColor(ContextCompat.getColor(holder.getContext(), R.color.color_accent));
        holder.txtRecipeNumber.setText(String.valueOf(recipe.getNumber()));
        holder.imgRecipePhoto.setImageResource(recipe.getIdPhoto());
        holder.txtRecipeTitle.setText(recipe.getTitle());
        holder.txtRecipeDescription.setText(recipe.getDescription());
        if (position == mDataset.size() - 1) {
            holder.imgRecipeLine.setVisibility(View.GONE);
        }
    }

    public ArrayList<View> getViewList() {
        return mViewList;
    }

    public int getItemCount() {
        return mDataset.size();
    }
}
