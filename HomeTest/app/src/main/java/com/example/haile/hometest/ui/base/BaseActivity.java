package com.example.haile.hometest.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.haile.hometest.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        mapView();
        setListener();
        initData();
    }

    protected abstract int getLayoutResource();

    protected abstract void mapView();

    protected abstract void setListener();

    protected abstract void initData();

    public void addFragment(int layoutId, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(layoutId, fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
    }
}
