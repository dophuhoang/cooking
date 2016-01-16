package vn.dohoang.cooking.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import vn.dohoang.cooking.R;
import vn.dohoang.cooking.object.IngredientGroup;
import vn.dohoang.cooking.util.CommonUtils;

import java.util.ArrayList;

/**
 * Created by hoangdp on 1/13/2016.
 */
public class IngredientGroupAdapter {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder {
        private Context mContext;
        public View view;
        public ImageView imgType;
        public TextView txtTypeName;
        public LinearLayout layoutList;
        public View viewSeparate;

        public ViewHolder(Context c, View v) {
            mContext = c;
            view = v;
            imgType = (ImageView) v.findViewById(R.id.image_view_ingredient_type);
            txtTypeName = (TextView) v.findViewById(R.id.text_view_ingredient_type_name);
            layoutList = (LinearLayout) v.findViewById(R.id.layout_ingredient_list);
            viewSeparate = v.findViewById(R.id.view_separate);
        }

        public Context getContext() {
            return mContext;
        }
    }

    private ViewGroup mViewGroup;
    private ArrayList<IngredientGroup> mDataList;
    private ArrayList<View> mViewList;

    public IngredientGroupAdapter(ViewGroup viewGroup, ArrayList<IngredientGroup> dataList) {
        mViewGroup = viewGroup;
        mDataList = dataList;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_ingredient_group, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(parent.getContext(), v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        IngredientGroup ingredientGroup = mDataList.get(position);
        holder.imgType.setImageResource(ingredientGroup.getType().drawableId());
        GradientDrawable drawable = (GradientDrawable) holder.imgType.getBackground();
        drawable.setColor(ContextCompat.getColor(holder.getContext(), ingredientGroup.getType().colorId()));
        holder.txtTypeName.setText(ingredientGroup.getType().stringId());
        IngredientAdapter adapter = new IngredientAdapter(holder.layoutList, ingredientGroup.getDataset());
        ArrayList<View> viewList = adapter.getViewList();
        holder.layoutList.removeAllViews();
        for (int i = viewList.size() - 1; i >= 0; i--) {
            View view = viewList.get(i);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, (int) CommonUtils.convertDpToPixel(8, holder.getContext()));
            holder.layoutList.addView(view, 0, params);
        }
        if (position == getItemCount() - 1) {
            holder.viewSeparate.setVisibility(View.GONE);
        }
    }

    public ArrayList<View> getViewList() {
        return mViewList;
    }

    public int getItemCount() {
        return mDataList.size();
    }
}
