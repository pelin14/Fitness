package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText kullaniciadi, parola;
    private Button kayit_btn, giris_btn;
    private String kullanici, sifre, ad;
    private DatabaseReference myRef;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kullaniciadi = findViewById(R.id.kullaniciadi);
        parola = findViewById(R.id.parola);
        kayit_btn = findViewById(R.id.kayit_btn);
        giris_btn = findViewById(R.id.giris_btn);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-dc0c6-default-rtdb.firebaseio.com/");

        kayit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);

            }
        });

        giris_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullanici = kullaniciadi.getText().toString();
                sifre = parola.getText().toString();

                if (TextUtils.isEmpty(kullanici) || TextUtils.isEmpty(sifre)) {
                    Toast.makeText(MainActivity.this, "email ya da şifre girin", Toast.LENGTH_SHORT).show();
                } else{

                    myRef.child("Kullanicilar").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(kullanici)){

                                final String gelensifre = snapshot.child(kullanici).child("sifre").getValue(String.class);

                                if(gelensifre.equals(sifre)){
                                    Toast.makeText(MainActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,AnaSayfa.class);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(MainActivity.this, "Yanlış Şifre !", Toast.LENGTH_SHORT).show();
                                }

                            }else{
                                Toast.makeText(MainActivity.this, "Yanlış Kullanıcı adı!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });
    }
}