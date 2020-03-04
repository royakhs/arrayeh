package com.arayeh.hampa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.arayeh.hampa.Interfaces.OnClick;
import com.arayeh.hampa.R;
import com.arayeh.hampa.models.User;


public class RegisterFragmentOne extends Fragment {
    private static OnClick caller;
    private static EditText mEdtPhoneNumber;
    private static EditText mEdtName;
    private static EditText mEdtFamily;
    private static EditText mEdtPassword;
    private static EditText mEdtRePassword;

    public RegisterFragmentOne(OnClick caller) {
        this.caller = caller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register_fragment_one, container, false);
        Button mBtnNext = v.findViewById(R.id.btnNext);
        mEdtName = v.findViewById(R.id.editName);
        mEdtPhoneNumber = v.findViewById(R.id.editPhoneNumber);
        mEdtFamily = v.findViewById(R.id.editFamily);
        mEdtPassword = v.findViewById(R.id.editPassword);
        mEdtRePassword = v.findViewById(R.id.editRePassword);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mEdtPhoneNumber.getText().toString().length()!=11){
                    Toast.makeText(getActivity().getApplicationContext(),"شماره تماس وارد شده صحیح نمی باشد",Toast.LENGTH_SHORT).show();
                }else {
                    if(checkString(mEdtName.getText().toString())==1){
                        Toast.makeText(getActivity().getApplicationContext(),"نام وارد شده کوتاهتر از حد مجاز میباشد",Toast.LENGTH_SHORT).show();

                    }else {
                        if(checkString(mEdtFamily.getText().toString())==1){
                            Toast.makeText(getActivity().getApplicationContext(),"نام خانوادگی وارد شده کوتاهتر از حد مجاز میباشد",Toast.LENGTH_SHORT).show();

                        }else {
                            if(checkString(mEdtPassword.getText().toString())==1){
                                Toast.makeText(getActivity().getApplicationContext(),"رمز وارد شده کوتاهتر از حد مجاز میباشد",Toast.LENGTH_SHORT).show();

                            }else {
                                if(mEdtPassword.getText().toString().equals(mEdtRePassword.getText().toString()))
                                {
                                    User user = new User();
                                    user.setName(mEdtName.getText().toString());
                                    user.setFamily(mEdtFamily.getText().toString());
                                    user.setMobile(mEdtPhoneNumber.getText().toString());
                                    user.setPassword(mEdtPassword.getText().toString());
                                    caller.onOkClick(user);
                                }else {
                                    Toast.makeText(getActivity().getApplicationContext(),"رمزهای وارد شده هم خوانی ندارند.",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }

            }
        });
        return v;
    }
    private int checkString(String s ){
       if(s.length()<2)
          return 1;
       else return  0;
    }
//    public void onButtonClickNedxt(View view) {
//        Toast.makeText(this, "Cancel pressed", Toast.LENGTH_LONG).show();
//    }


}