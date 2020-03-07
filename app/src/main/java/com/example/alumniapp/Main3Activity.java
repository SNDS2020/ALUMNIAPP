package com.example.alumniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {

    EditText rname,remail,rphone,rpassword,rusername;
    Button rsubmit;


    DatabaseReference reff;
    UserHelperClass userhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rname= findViewById(R.id.reg_name);
        remail= findViewById(R.id.reg_email);
        rphone=findViewById(R.id.reg_phone);
        rusername=findViewById(R.id.reg_username);
        rpassword=findViewById(R.id.reg_password);
        rsubmit=findViewById(R.id.button3);
        userhelper= new UserHelperClass();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reff= database.getReference("UserHelperClass");

        rsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //String name=rname.getText().toString();
                //String emailId=remail.getText().toString();
                /*if(name.isEmpty()){
                    rname.setError("Name is empty");
                    rname.requestFocus();
                }
                else if(emailId.isEmpty()){
                    remail.setError("email is empty");
                    rname.requestFocus();
                }*/
                /*else if(!(name.isEmpty()&&emailId.isEmpty())){*/
                //get values
                String personname=rname.getText().toString().trim();
                String phoneNo=rphone.getText().toString().trim();
                String email=remail.getText().toString().trim();
                String password=rpassword.getText().toString().trim();
                String username=rusername.getText().toString().trim();

                UserHelperClass helperclass=new UserHelperClass();
                reff.child(username).setValue(helperclass);

                userhelper.setName(personname);
                userhelper.setPhoneNo(phoneNo);
                userhelper.setEmail(email);
                userhelper.setPassword(password);
                userhelper.setUsername(username);

                reff.push().setValue(userhelper);
                Toast.makeText(Main3Activity.this,"data inserted sucessfully",Toast.LENGTH_LONG).show();


            }
        });
    }


}
