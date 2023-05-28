package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText kullaniciadi2,mail,parola2,parola3;
    private Button kayit_btn2;
    private String email,sifre,ad,sifretekrar;
    private DatabaseReference myRef;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        kullaniciadi2 =  findViewById(R.id.kullaniciadi2);
        mail = findViewById(R.id.mail);
        parola2 =  findViewById(R.id.parola2);
        parola3 =  findViewById(R.id.parola3);
        kayit_btn2= findViewById(R.id.kayit_btn2);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-dc0c6-default-rtdb.firebaseio.com/");

        kayit_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ad = kullaniciadi2.getText().toString();
                email = mail.getText().toString();
                sifre = parola2.getText().toString();
                sifretekrar =  parola3.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(sifre) || TextUtils.isEmpty(ad)){
                    Toast.makeText(Register.this, "Lütfen tüğm alanları doldurun", Toast.LENGTH_SHORT).show();
                }
                if(!sifre.equals(sifretekrar)){
                    Toast.makeText(Register.this, "Şifreler uyuşmuyor", Toast.LENGTH_SHORT).show();
                }
                else{
                    myRef.child("Kullanicilar").child(ad).child("isim").setValue(ad);
                    myRef.child("Kullanicilar").child(ad).child("email").setValue(email);
                    myRef.child("Kullanicilar").child(ad).child("sifre").setValue(sifre);
                    Toast.makeText( Register.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}