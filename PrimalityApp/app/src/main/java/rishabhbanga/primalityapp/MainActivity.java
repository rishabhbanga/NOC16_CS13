package rishabhbanga.primalityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button tbutton;
    private Button fbutton;
    private Button nbutton;

    private TextView tvnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbutton = (Button) findViewById(R.id.btntrue);
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rand = tvnumber.getText().toString();
                int random = Integer.parseInt(rand);
                boolean checkPrime = isPrime(random);

                if (checkPrime) {
                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                }

            }
        });


        fbutton = (Button) findViewById(R.id.btnfalse);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String rand = tvnumber.getText().toString();
                int random = Integer.parseInt(rand);
                boolean checkPrime = isPrime(random);

                if (checkPrime) {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                }

            }
        });

        nbutton = (Button) findViewById(R.id.btnnext);
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvnumber.setText(Integer.toString(generateNumber()));

            }
        });


        tvnumber = (TextView) findViewById(R.id.random_number);
        tvnumber.setText(Integer.toString(generateNumber()));

    }

    private int generateNumber() {

        Random r = new Random();
        int random_number = r.nextInt(10000);
        return random_number;
    }

    // will contain true or false values for the first 10,000 integers
    boolean[] primes=new boolean[10000];

    public boolean isPrime(int n) {
        //setting up the prime sieve method
        Arrays.fill(primes, true);        // assume all integers are prime.
        primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
        for (int i = 2; i < primes.length; i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
        return primes[n];
    }
}