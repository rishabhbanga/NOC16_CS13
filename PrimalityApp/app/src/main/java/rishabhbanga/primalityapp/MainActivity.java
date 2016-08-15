package rishabhbanga.primalityapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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


        tbutton=(Button) findViewById(R.id.btntrue);
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rand=tvnumber.getText().toString();
                int random =Integer.parseInt(rand);
                boolean checkPrime=isPrime(random);

                if(checkPrime){
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                }


            }
        });


        fbutton=(Button) findViewById(R.id.btnfalse);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String rand=tvnumber.getText().toString();
                int random =Integer.parseInt(rand);
                boolean checkPrime=isPrime(random);

                if(checkPrime){
                    Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                }


            }
        });


        nbutton=(Button) findViewById(R.id.btnnext);
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvnumber.setText(Integer.toString(generateNumber()));

            }
        });


        tvnumber=(TextView) findViewById(R.id.random_number);
        tvnumber.setText(Integer.toString(generateNumber()));

    }


    private int generateNumber(){

        Random r = new Random();
        int random_number = r.nextInt(1000);
        return random_number;
    }


    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}