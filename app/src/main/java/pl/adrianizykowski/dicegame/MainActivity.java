package pl.adrianizykowski.dicegame;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int sumaWynikow = 0;
    private int licznikRzutow = 0;
    private Button przyciskRzut, przyciskReset;
    private TextView kostkaPierwsza, kostkaDruga, kostkaTrzecia, kostkaCzwarta, kostkaPiata;
    private TextView wynikLosowania, wynikGry, liczbaRzutow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przyciskRzut = findViewById(R.id.rzutBtn);
        przyciskReset = findViewById(R.id.resetBtn);
        kostkaPierwsza = findViewById(R.id.first);
        kostkaDruga = findViewById(R.id.second);
        kostkaTrzecia = findViewById(R.id.third);
        kostkaCzwarta = findViewById(R.id.fourth);
        kostkaPiata = findViewById(R.id.fifth);
        wynikLosowania = findViewById(R.id.wynikTegoLos);
        wynikGry = findViewById(R.id.wynikGry);
        liczbaRzutow = findViewById(R.id.liczbaRzutow);

        przyciskRzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rzucKostkami();
            }
        });

        przyciskReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetujGre();
            }
        });
    }

    public void rzucKostkami() {
        Random losowanie = new Random();
        int[] wynikiKostek = new int[5];

        for (int i = 0; i < 5; i++) {
            wynikiKostek[i] = losowanie.nextInt(6) + 1;
        }

        pokazWyniki(wynikiKostek);

        int wynikRzutu = 0;
        for (int wynik : wynikiKostek) {
            wynikRzutu += wynik;
        }

        aktualizujWynik(wynikRzutu);
        aktualizujLicznikRzutow();
    }

    public void resetujGre() {
        kostkaPierwsza.setText("?");
        kostkaDruga.setText("?");
        kostkaTrzecia.setText("?");
        kostkaCzwarta.setText("?");
        kostkaPiata.setText("?");

        sumaWynikow = 0;
        licznikRzutow = 0;
        wynikLosowania.setText("Wynik tego losowania: 0");
        wynikGry.setText("Wynik gry: 0");
        liczbaRzutow.setText("Liczba rzutów: 0");
    }

    public void aktualizujWynik(int nowyWynik) {
        sumaWynikow += nowyWynik;
        wynikLosowania.setText("Wynik tego losowania: " + nowyWynik);
        wynikGry.setText("Wynik gry: " + sumaWynikow);
    }

    public void aktualizujLicznikRzutow() {
        licznikRzutow++;
        liczbaRzutow.setText("Liczba rzutów: " + licznikRzutow);
    }

    public void pokazWyniki(int[] wynikiKostek) {
        kostkaPierwsza.setText(String.valueOf(wynikiKostek[0]));
        kostkaDruga.setText(String.valueOf(wynikiKostek[1]));
        kostkaTrzecia.setText(String.valueOf(wynikiKostek[2]));
        kostkaCzwarta.setText(String.valueOf(wynikiKostek[3]));
        kostkaPiata.setText(String.valueOf(wynikiKostek[4]));
    }
}