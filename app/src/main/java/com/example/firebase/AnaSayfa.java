package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AnaSayfa extends AppCompatActivity {

    TextView yumurtakcal,salatalikkcal,domateskcal,peynirkcal,zeytinkcal,mercimekkcal,pilavkcal,tavukkcal,cobankcal,
    sekerparekcal,ezogelinkcal,iclikoftekcal,mantikcal,marulkcal,cilekkcal;


    EditText yumurta,salatalik,domates,peynir,zeytin,merco,pirpilav,firtavuk,cobansalata,sekertatli,ezocorba,iclikofte,
    manti,marulsalata,cilek;

    Button hesapla_btn;

    DatabaseReference myRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);

        hesapla_btn = findViewById(R.id.hesapla_btn);

        yumurtakcal = findViewById(R.id.yumurtakcal);
        salatalikkcal = findViewById(R.id.salatalikkcal);
        domateskcal = findViewById(R.id.domateskcal);
        peynirkcal = findViewById(R.id.peynirkcal);
        zeytinkcal = findViewById(R.id.zeytinkcal);
        mercimekkcal = findViewById(R.id.mercimekkcal);
        pilavkcal = findViewById(R.id.pilavkcal);
        tavukkcal = findViewById(R.id.tavukkcal);
        cobankcal = findViewById(R.id.cobankcal);
        sekerparekcal = findViewById(R.id.sekerparekcal);
        ezogelinkcal = findViewById(R.id.ezogelinkcal);
        iclikoftekcal = findViewById(R.id.iclikoftekcal);
        marulkcal = findViewById(R.id.marulkcal);
        mantikcal = findViewById(R.id.mantikcal);
        cilekkcal = findViewById(R.id.cilekkcal);

        yumurta = findViewById(R.id.yumurta);
        salatalik = findViewById(R.id.salatalik);
        domates = findViewById(R.id.domates);
        peynir = findViewById(R.id.peynir);
        zeytin = findViewById(R.id.zeytin);
        merco = findViewById(R.id.mercorba);
        pirpilav = findViewById(R.id.pirpilav);
        firtavuk = findViewById(R.id.firtavuk);
        cobansalata = findViewById(R.id.cobansalata);
        sekertatli = findViewById(R.id.sekertatli);
        ezocorba = findViewById(R.id.ezocorba);
        iclikofte = findViewById(R.id.iclikofte);
        marulsalata = findViewById(R.id.marulsalata);
        manti = findViewById(R.id.manti);
        cilek = findViewById(R.id.cilek);

        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-dc0c6-default-rtdb.firebaseio.com/");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("Kahvalti")){
                    yumurtakcal.setText(String.valueOf(snapshot.child("Kahvalti").child("Haşlanmış Yumurta").getValue()));
                    salatalikkcal.setText(String.valueOf(snapshot.child("Kahvalti").child("Salatalık").getValue()));
                    domateskcal.setText(String.valueOf(snapshot.child("Kahvalti").child("Domates").getValue()));
                    peynirkcal.setText(String.valueOf(snapshot.child("Kahvalti").child("Peynir").getValue()));
                    zeytinkcal.setText(String.valueOf(snapshot.child("Kahvalti").child("Zeytin").getValue()));
                }
                if(snapshot.hasChild("Ögle")){
                    mercimekkcal.setText(String.valueOf(snapshot.child("Ögle").child("Mercimek Çorbası").getValue()));
                    tavukkcal.setText(String.valueOf(snapshot.child("Ögle").child("Pirinç Pilavı").getValue()));
                    pilavkcal.setText(String.valueOf(snapshot.child("Ögle").child("Fırında Tavuk").getValue()));
                    cobankcal.setText(String.valueOf(snapshot.child("Ögle").child("Çoban Salata").getValue()));
                    sekerparekcal.setText(String.valueOf(snapshot.child("Ögle").child("Şekerpare").getValue()));
                }
                if(snapshot.hasChild("Aksam")){
                    ezogelinkcal.setText(String.valueOf(snapshot.child("Aksam").child("Ezogelin Çorbası").getValue()));
                    mantikcal.setText(String.valueOf(snapshot.child("Aksam").child("Mantı").getValue()));
                    iclikoftekcal.setText(String.valueOf(snapshot.child("Aksam").child("İçli köfte").getValue()));
                    marulkcal.setText(String.valueOf(snapshot.child("Aksam").child("Marul Salatası").getValue()));
                    cilekkcal.setText(String.valueOf(snapshot.child("Aksam").child("Çilek").getValue()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        hesapla_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(yumurta.getText().toString().equals(""))
                    yumurta.setText("0");
                if(domates.getText().toString().equals(""))
                    domates.setText("0");
                if(salatalik.getText().toString().equals(""))
                    salatalik.setText("0");
                if(peynir.getText().toString().equals(""))
                    peynir.setText("0");
                if(zeytin.getText().toString().equals(""))
                    zeytin.setText("0");
                if(merco.getText().toString().equals(""))
                    merco.setText("0");
                if(pirpilav.getText().toString().equals(""))
                    pirpilav.setText("0");
                if(firtavuk.getText().toString().equals(""))
                    firtavuk.setText("0");
                if(cobansalata.getText().toString().equals(""))
                    cobansalata.setText("0");
                if(sekertatli.getText().toString().equals(""))
                    sekertatli.setText("0");
                if(ezocorba.getText().toString().equals(""))
                    ezocorba.setText("0");
                if(manti.getText().toString().equals(""))
                    manti.setText("0");
                if(iclikofte.getText().toString().equals(""))
                    iclikofte.setText("0");
                if(marulsalata.getText().toString().equals(""))
                    marulsalata.setText("0");
                if(cilek.getText().toString().equals(""))
                    cilek.setText("0");



                int sabahkalori = Integer.parseInt(yumurta.getText().toString()) * Integer.parseInt(yumurtakcal.getText().toString()) +
                        Integer.parseInt(domates.getText().toString()) * Integer.parseInt(domateskcal.getText().toString()) +
                        Integer.parseInt(salatalik.getText().toString()) * Integer.parseInt(salatalikkcal.getText().toString()) +
                        Integer.parseInt(peynir.getText().toString()) * Integer.parseInt(peynirkcal.getText().toString()) +
                        Integer.parseInt(zeytin.getText().toString()) * Integer.parseInt(zeytinkcal.getText().toString());

                int oglekalori = Integer.parseInt(merco.getText().toString()) * Integer.parseInt(mercimekkcal.getText().toString()) +
                        Integer.parseInt(pirpilav.getText().toString()) * Integer.parseInt(pilavkcal.getText().toString()) +
                        Integer.parseInt(firtavuk.getText().toString()) * Integer.parseInt(tavukkcal.getText().toString()) +
                        Integer.parseInt(cobansalata.getText().toString()) * Integer.parseInt(cobankcal.getText().toString()) +
                        Integer.parseInt(sekertatli.getText().toString()) * Integer.parseInt(sekerparekcal.getText().toString());

                int aksamkalori = Integer.parseInt(ezocorba.getText().toString()) * Integer.parseInt(ezogelinkcal.getText().toString()) +
                        Integer.parseInt(manti.getText().toString()) * Integer.parseInt(mantikcal.getText().toString()) +
                        Integer.parseInt(iclikofte.getText().toString()) * Integer.parseInt(iclikofte.getText().toString()) +
                        Integer.parseInt(marulsalata.getText().toString()) * Integer.parseInt(marulkcal.getText().toString()) +
                        Integer.parseInt(cilek.getText().toString()) * Integer.parseInt(cilekkcal.getText().toString());

                int toplamkalori = sabahkalori + oglekalori + aksamkalori;

                Intent intent = new Intent(AnaSayfa.this,SonucSayfasi.class);
                intent.putExtra("sabah",sabahkalori);
                intent.putExtra("ogle",oglekalori);
                intent.putExtra("aksam",aksamkalori);
                intent.putExtra("toplam",toplamkalori);
                startActivity(intent);





            }
        });








    }
}