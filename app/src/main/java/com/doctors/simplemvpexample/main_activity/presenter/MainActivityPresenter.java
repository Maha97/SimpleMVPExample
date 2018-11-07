package com.doctors.simplemvpexample.main_activity.presenter;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.view.View;

import com.doctors.simplemvpexample.R;
import com.doctors.simplemvpexample.main_activity.model.User;

public class MainActivityPresenter {

    private User user;
    private View presenterInterface;

    private  final String INTENT_EXTRA_TEXT="Extra";

    public MainActivityPresenter(View  presenterInterface) {
        this.user=new User();
        this.presenterInterface=presenterInterface;

    }


    public  void updatefruit(String fruit){
      user.setfruit(fruit);
      presenterInterface.updateUi(user.toString());

    }
    public void updateFullName(String fullName){
      user.setFullName(fullName);
      presenterInterface.updateUi(user.toString());

    }


    public void shareUserData(Activity activity, String userName, String favouriteFruit){

        Intent shareIntent=new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,userName +favouriteFruit);
        shareIntent.setType("text/plain");
        //shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(Intent.createChooser(shareIntent,activity.getResources().getText(R.string.send_to)));


    }

    public interface View{
           void updateUi(String info);
           void showProgressBar();
           void hideProgressBar();
           void shareData();
    }




}



