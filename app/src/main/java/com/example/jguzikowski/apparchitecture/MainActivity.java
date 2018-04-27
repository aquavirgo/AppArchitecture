package com.example.jguzikowski.apparchitecture;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jguzikowski.apparchitecture.viewmodel.UserProfileViewModel;

public class MainActivity extends AppCompatActivity {
    private UserProfileViewModel mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        TextView mNameTextView = (TextView) findViewById(R.id.text);



        final Observer<String> nameObserver = newName -> {
            mNameTextView.setText(newName);
        };


        mModel.getUser().observe(this, nameObserver);
        EditText editText = (EditText) findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mModel.getUser().setValue(charSequence+"");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        Log.d("TG",mModel.getUser().toString());
    }

    public void onStart(View view) {

        Log.d("TAG","Push button");
        String anotherName = "John Doe";

       // mModel.getUser().setValue(anotherName);

    }
}
