package com.lantel.app.mvp;

import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lantel.crmparent.R;

import androidx.annotation.NonNull;

public class AppPresenter extends AppContract.Presenter implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG1 = "APresenter";

    @Override
    public void onCrete() {
       // Log.d(TAG1, "onCrete: ");
    }

    @Override
    public void onStart() { }

    @Override
    public void onResume() {
       // Log.d(TAG1, "onResume: ");
    }

    @Override
    public void onPause() {
       // Log.d(TAG1, "onPause: ");
    }

    @Override
    public void onStop() {
        //Log.d(TAG1, "onStop: ");
    }

    @Override
    public void onDestroy() {
        //Log.d(TAG1, "onDestroy: ");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.item_home:
                mView.navigate(R.id.action_home);
                break;
            case R.id.item_study:
                mView.navigate(R.id.action_study);
                break;
            case R.id.item_growup:
                mView.navigate(R.id.action_growup);
                break;
            case R.id.item_mine:
                mView.navigate(R.id.action_mine);
                break;
        }
        return true;
    }
}
