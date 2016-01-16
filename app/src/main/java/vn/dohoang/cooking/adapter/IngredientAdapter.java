package vn.dohoang.cooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vn.dohoang.cooking.R;
import vn.dohoang.cooking.object.Ingredient;

import java.util.ArrayList;

/**
 * Created by hoangdp on 1/13/2016.
 */
public class IngredientAdapter {
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder {
        private Context mContext;
        public View view;
        public TextView txtName;
        public TextView txtValue;

        public ViewHolder(Context c, View v) {
            mContext = c;
            view = v;
            txtName = (TextView) v.findViewById(R.id.text_view_ingredient_name);
            txtValue = (TextView) v.findViewById(R.id.text_view_ingredient_value);
        }

        public Context getContext() {
            return mContext;
        }
    }

    private ViewGroup mViewGroup;
    private ArrayList<Ingredient> mDataList;
    private ArrayList<View> mViewList;

    public IngredientAdapter(ViewGroup viewGroup, ArrayList<Ingredient> dataList) {
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_ingredient, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(parent.getContext(), v);
        return vh;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Ingredient ingredient = mDataList.get(position);
        holder.txtName.setText(ingredient.getName());
        holder.txtValue.setText(ingredient.getValue());
    }

    public ArrayList<View> getViewList() {
        return mViewList;
    }

    public int getItemCount() {
        return mDataList.size();
    }
}
