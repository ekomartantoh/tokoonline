package com.ekomartantoh.tokoonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Menu extends AppCompatActivity {
    private ListView lvItem;
    private String[] namaBarang= new String[]{
            "Kopi Kapal Api", "Kopi ABC Susu","Gulaku 1 Kg"
    };
    private int gambarBARANG[]={
            R.drawable.kapalapi, R.drawable.abcsusu, R.drawable.gulaku
    };
    private  double hargaBarang[]={
            8000, 9000, 12000
    };

    private String nmBrg;
    private int gbrBrg;
    private double hrgBrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle("OStore"); //tampil title
        getSupportActionBar().setTitle("List Barang"); //tampil subtitle

        lvItem= (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter (Menu.this, gambarBARANG, namaBarang, hargaBarang);
        //step2

        lvItem.setAdapter(adapter);
        //menset data di dalam list view

        //step3
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gbrBrg=gambarBARANG[position];
                nmBrg=namaBarang[position];
                hrgBrg=hargaBarang[position];
                Intent i = new Intent(Menu.this, detailProduk.class);
                i.putExtra("namaBarang", nmBrg);
                i.putExtra("gambarBarang", gbrBrg);
                i.putExtra("hargaBarang", hrgBrg);
                startActivity(i);
            }
        });
    }
}
