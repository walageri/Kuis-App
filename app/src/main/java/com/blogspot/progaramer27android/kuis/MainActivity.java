package com.blogspot.progaramer27android.kuis;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.a)
    Button a;
    @InjectView(R.id.b)
    Button b;
    @InjectView(R.id.c)
    Button c;
    @InjectView(R.id.d)
    Button d;
    @InjectView(R.id.score)
    TextView scoreview;
    @InjectView(R.id.soal)
    TextView soalview;
    @InjectView(R.id.timer)
    TextView timerview;
    Timer timer;
    Pertanyaan pertanyaan = new Pertanyaan();
    private String jawabanbenar;
    private int score = 0;
    int nomor = 0;
    //private int semuasoal = pertanyaan.soal.length;
    //Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        timer=new Timer(120000,1000);
        timer.start();
//        r=new Random();
//        updateSoal(r.nextInt(semuasoal));
//        updateSoal(new Integer(semuasoal));
        updateSoal(nomor);
        scoreview.setText("Score: " + score);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                try {
                    if (a.getText() == jawabanbenar) {
                        score++;
                        nomor++;
                        scoreview.setText("Score: " + score);
                        Toast.makeText(MainActivity.this, "Benar", Toast.LENGTH_SHORT).show();
                        updateSoal(nomor);
                        //updateSoal(r.nextInt(semuasoal));
                        //updateSoal(new Integer(semuasoal));
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                        nomor++;
                        updateSoal(nomor);
                    }
                } catch (Exception e) {
                    if (nomor == 10) {
                        gameOver();
                    }
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                try {
                    if (b.getText() == jawabanbenar) {
                        score++;
                        nomor++;
                        scoreview.setText("Score: " + score);
                        updateSoal(nomor);
                        //updateSoal(new Integer(semuasoal));
                        //updateSoal(r.nextInt(semuasoal));
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                        nomor++;
                        updateSoal(nomor);
                    }
                } catch (Exception e) {
                    if (nomor == 10) {
                        gameOver();
                    }
                }
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                try {
                    if (c.getText() == jawabanbenar) {
                        score++;
                        nomor++;
                        updateSoal(nomor);
                        scoreview.setText("Score: " + score);
                        //updateSoal(new Integer(semuasoal));
                        //updateSoal(r.nextInt(semuasoal));
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                        nomor++;
                        updateSoal(nomor);
                    }
                } catch (Exception e) {
                    if (nomor == 10) {
                        gameOver();
                    }
                }
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.start();
                try {
                    if (d.getText() == jawabanbenar) {
                        score++;
                        nomor++;
                        updateSoal(nomor);
                        scoreview.setText("Score: " + score);
                        //updateSoal(new Integer(semuasoal));
                        //updateSoal(r.nextInt(semuasoal));
                    } else {
                        Toast.makeText(MainActivity.this, "Salah", Toast.LENGTH_SHORT).show();
                        nomor++;
                        updateSoal(nomor);
                    }
                } catch (Exception e) {
                    if (nomor == 10) {
                        gameOver();
                    }
                }
            }
        });

    }
    private void updateSoal(int num) {
        soalview.setText(pertanyaan.getsoal(num));
        a.setText(pertanyaan.getpilihan1(num));
        b.setText(pertanyaan.getpilihan2(num));
        c.setText(pertanyaan.getpilihan3(num));
        d.setText(pertanyaan.getpilihan4(num));
        jawabanbenar = pertanyaan.getjawaban(num);
    }

    private void gameOver() {
        timer.cancel();
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("SELAMAT !!! Nialimu Adalah : " + score + "Points ")
                .setCancelable(false)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        b.show();
    }
    Long waktuberjalan;
    public class Timer extends CountDownTimer {
        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long l) {
            timerview.setText(""+(l/1000));
            waktuberjalan=l;
        }
        @Override
        public void onFinish() {
            timerview.setText("Selesai");
            gameOver();

        }
    }

    @Override
    public void onBackPressed() {

    }

//    @Override
//    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        outState.putInt("number",nomor);
//        outState.putString("score",scoreview.getText().toString());
//        outState.putLong("l",waktuberjalan);
//        super.onSaveInstanceState(outState, outPersistentState);
//        Log.i("Instace state","onSaveInstacenState");
//    }
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.i("Instace state","onRestoreInstanceState");
//        scoreview.setText(savedInstanceState.getString("score"));
//        Integer.getInteger(savedInstanceState.getString("number"));
//        Long.getLong(waktuberjalan.toString());
//
//    }
}