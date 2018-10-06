package com.example.haile.hometest.ui.presentation.home.keyword;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.haile.hometest.R;
import com.example.haile.hometest.ui.base.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KeywordAdapter extends BaseAdapter<String, KeywordAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_keyword, viewGroup, false);
        return new ViewHolder(view, viewGroup.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String keyword = mItems.get(position);
        viewHolder.setData(keyword, position);
    }

    public static class ViewHolder extends BaseAdapter.ViewHolder<String> {

        private TextView tvKeyword;
        private LinearLayout llParent;

        public ViewHolder(View itemView, Context context) {
            super(itemView, context);
            tvKeyword = itemView.findViewById(R.id.item_keyword_tv_keyword);
            llParent = itemView.findViewById(R.id.item_keyword_parent_view);
        }

        @Override
        protected void setData(String keyword, int position) {
            super.setData(keyword, position);

            //Restore layout params
            tvKeyword.getLayoutParams().width = 0;
            Paint paint = tvKeyword.getPaint();
            float width = paint.measureText(keyword);

            //Define new layout params
            if(keyword.contains(" ")){
                tvKeyword.getLayoutParams().width = (int)((width/2) + context.getResources().getDimension(R.dimen._20sdp));
            } else {
                tvKeyword.getLayoutParams().width = (int)((width) + context.getResources().getDimension(R.dimen._20sdp));
            }
            tvKeyword.setText(keyword);

            //Add random color
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            llParent.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
