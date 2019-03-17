package id.workshop.newworkshop;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Vibrator vib;
    ImageView imgTasbih;
//    Button reset, klik;
    TextView hasil;
    int step;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        imgTasbih = findViewById(R.id.imgTasbih);
//        reset = findViewById(R.id.reset);
//        klik  = findViewById(R.id.klik);
        hasil = findViewById(R.id.tvHasil);
        step = 1;
    }



    public void klik(View view){

        int angka = Integer.parseInt(hasil.getText().toString());
        if (angka < 33) {
            if (step == 1){
                imgTasbih.setImageResource(R.mipmap.subhanallah);
            }else if(step == 2) {
                imgTasbih.setImageResource(R.mipmap.alhamdulillah);
            }else if(step == 3){
                imgTasbih.setImageResource(R.mipmap.allah);
            }
            angka++;
            vib.vibrate(250);
        }
        else{
            if (step == 3){
                step = 1;
            }else{
                step++;
            }
            angka = 0;
            vib.vibrate(500);
        }


        hasil.setText(Integer.toString(angka));

    }

    public void reset(View view){

        hasil.setText("0");
        step = 1;
        imgTasbih.setImageResource(R.mipmap.subhanallah);
    }
}
