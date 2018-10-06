package com.example.haile.hometest.ui.presentation.home.keyword;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.haile.hometest.R;
import com.example.haile.hometest.ui.base.BaseFragment;

import java.util.Arrays;
import java.util.List;

public class KeywordFragment extends BaseFragment {

    private RecyclerView rvKeyword;
    private KeywordAdapter keywordAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.keyword_fragment;
    }

    @Override
    protected void mapView(View view) {
        rvKeyword = view.findViewById(R.id.keyword_fragment_recycler_keyword);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void initData() {
        keywordAdapter = new KeywordAdapter();
        rvKeyword.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvKeyword.setAdapter(keywordAdapter);

        loadData();
    }

    private void loadData(){
        List<String> keyword = Arrays.asList(
                "xiaomi",
                "bitis hunter",
                "bts",
                "balo",
                "bitis hunter x",
                "tai nghe",
                "harry potter",
                "anker",
                "iphone",
                "balo nữ",
                "nguyễn nhật ánh",
                "đắc nhân tâm",
                "ipad",
                "senka",
                "tai nghe bluetooth",
                "son",
                "maybelline",
                "laneige",
                "kem chống nắng",
                "anh chính là thanh xuân của em");
        keywordAdapter.addItems(keyword);
    }
}
