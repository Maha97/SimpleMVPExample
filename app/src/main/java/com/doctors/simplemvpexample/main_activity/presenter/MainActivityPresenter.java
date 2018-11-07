package com.doctors.simplemvpexample.main_activity.presenter;

import android.view.View;

import com.doctors.simplemvpexample.main_activity.model.User;

public class MainActivityPresenter {

    private User user;
    private View presenterInterface;


    public MainActivityPresenter(View  presenterInterface) {
        this.user=new User();
        this.presenterInterface=presenterInterface;

    }




    public  void updateEmail(String email){
      user.setEmail(email);
      presenterInterface.updateUi(email);

    }
    public void updateFullName(String fullName){
      user.setFullName(fullName);
      presenterInterface.updateUi(fullName);

    }

    public interface View{
           void updateUi(String info);
           void showProgressBar();
           void hideProgressBar();
    }
}



