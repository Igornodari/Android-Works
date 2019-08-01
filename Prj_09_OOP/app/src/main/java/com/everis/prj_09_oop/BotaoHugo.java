package com.everis.prj_09_oop;

import android.text.Editable;
import android.text.TextWatcher;

public class BotaoHugo {

    interface IBB{
        void click();
        void maiscoisa();
    }

    private IBB delegate;

    public void setOnClickListener(IBB delegate) {
        this.delegate = delegate;
    }

    public void performClick(){
        if (delegate != null){
            delegate.click();
        }
    }

    private TextWatcher txtDesconto = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };




}
