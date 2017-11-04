package com.ekomartantoh.tokoonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class detailProduk extends AppCompatActivity {
    //Buat Variabel
    TextView namaBarang, hargaBarang, quantity, totalHarga, biayaKirim, totalBayar;
    ImageView gambarBarang;
    RadioButton goSend, jne, tiki;
    Button plus, minus;
    double hrgBrg, totHrg, byKrm = 15000, totByr;
    int gmbBrg, qty = 1;
    String nmBrg;

    private void hitung() {
        quantity.setText("" + qty);
        totHrg = qty * hrgBrg;
        totalHarga.setText("Total Harga: " + totHrg);
        biayaKirim.setText("Biaya Kirim: " + byKrm);
        totByr = byKrm + totHrg;
        totalBayar.setText("Total Bayar: " + totByr);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);

        getSupportActionBar().setTitle("Detail Order"); //tampilan Subtittle
        //Menghubungkan variabel view dengan id
        namaBarang = (TextView) findViewById(R.id.nmBrg);
        hargaBarang = (TextView) findViewById(R.id.hrg);
        quantity = (TextView) findViewById(R.id.qty);
        totalHarga = (TextView) findViewById(R.id.totalHarga);
        biayaKirim = (TextView) findViewById(R.id.biayaKirim);
        totalBayar = (TextView) findViewById(R.id.totalBayar);
        gambarBarang = (ImageView) findViewById(R.id.gambarProduk);
        plus = (Button) findViewById(R.id.tambah);
        minus = (Button) findViewById(R.id.kurang);
        goSend = (RadioButton) findViewById(R.id.goSend);
        goSend.setChecked(true);
        jne = (RadioButton) findViewById(R.id.jne);
        tiki = (RadioButton) findViewById(R.id.tiki);
        //Menangkap value dari intent sebelumnya
        gmbBrg = getIntent().getIntExtra("gambarBarang", 0);
        nmBrg = getIntent().getStringExtra("namaBarang");
        hrgBrg = getIntent().getDoubleExtra("hargaBarang", 0);
        //Menampilkan
        gambarBarang.setImageResource(gmbBrg);
        namaBarang.setText(nmBrg);
        hargaBarang.setText(String.valueOf(hrgBrg));
        this.hitung();
        //tombol plus
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qty >= 10) {
                    Toast.makeText(getApplicationContext(), "Maaf quantity tidak boleh lebih dari 10", Toast.LENGTH_SHORT).show();
                } else {
                    qty = qty + 1;
                    hitung();
                }
            }
        });
        //tombol minus
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qty <= 1) {
                    Toast.makeText(getApplicationContext(), "Maaf quantity tidak boleh kurang dari 0", Toast.LENGTH_SHORT).show();
                } else {
                    qty = qty - 1;
                    hitung();
                }
            }
        });
        //Cek Button Pengiriman
        goSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (goSend.isChecked()) {
                    jne.setChecked(false);
                    tiki.setChecked(false);
                    byKrm = 15000;
                    hitung();
                }
            }
        });
        jne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jne.isChecked()) {
                    goSend.setChecked(false);
                    tiki.setChecked(false);
                    byKrm = 20000;
                    hitung();
                }
            }
        });
        tiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tiki.isChecked()) {
                    jne.setChecked(false);
                    goSend.setChecked(false);
                    byKrm = 25000;
                    hitung();
                }
            }
        });
    }
}
