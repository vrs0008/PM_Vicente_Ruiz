package com.example.pm_tema7_tarea1_actividad1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private final Handler handler = new Handler();
    private Runnable actualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button bPlay = findViewById(R.id.bPlay);
        Button bPausa = findViewById(R.id.bPausa);
        TextView tTituloCancion = findViewById(R.id.tTituloCancion);
        TextView tTiempoReproduccion = findViewById(R.id.tTiempoReproduccion);
        TextView tDuracion = findViewById(R.id.tDuracion);

        SeekBar barraReproduccion = findViewById(R.id.barraReproduccion);

        mp = MediaPlayer.create(this, R.raw.matanza_en_el_hotel);

        actualizar = new Runnable() {
            @Override
            public void run() {
                if (mp != null && mp.isPlaying()) {
                    barraReproduccion.setProgress(mp.getCurrentPosition());

                    int minutos = (mp.getCurrentPosition() / 1000) / 60;
                    int segundos = (mp.getCurrentPosition() / 1000) % 60;
                    String tiempoActual = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);
                    tTiempoReproduccion.setText(tiempoActual);
                    handler.postDelayed(this, 1000);
                }
            }
        };

        mp.setOnPreparedListener(mediaPlayer -> {
            barraReproduccion.setMax(mediaPlayer.getDuration());
            int minutos = (mediaPlayer.getDuration() / 1000) / 60;
            int segundos = (mediaPlayer.getDuration() / 1000) % 60;
            String duracionTotal = String.format(Locale.getDefault(), "%02d:%02d", minutos, segundos);
            tDuracion.setText(duracionTotal);
        });

        bPlay.setOnClickListener(v -> {
            tTituloCancion.setText("cancion");
            if (!mp.isPlaying()) {
                mp.start();
                handler.post(actualizar);
            }
        });

        bPausa.setOnClickListener(v -> {
            if (mp.isPlaying()) {
                mp.pause();
                handler.removeCallbacks(actualizar);
            }
        });

        barraReproduccion.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mp.isPlaying()) {
                    mp.pause();
                    handler.removeCallbacks(actualizar);
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.start();
                handler.post(actualizar);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.release();
            mp = null;
        }
        handler.removeCallbacks(actualizar);
    }
}
