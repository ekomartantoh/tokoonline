package com.ekomartantoh.tokoonline;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

import static android.R.attr.resource;

/**
 * Created by hp on 24/10/2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    Activity activity;
    int[] gambar;
    String[] barang;
    double[] harga;

    public CustomAdapter(Activity menuActivity, int[] gambarBarang, String[] namaBarang, double[] hargaBarang) {
        super(menuActivity, R.layout.listitem, namaBarang);
        activity = menuActivity;
        gambar = gambarBarang;
        barang = namaBarang;
        harga = hargaBarang;
    }

    @NonNull
    @Override
    public View getView(int posisi, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.listitem, null, true);
        ImageView gambarBarang = (ImageView) view.findViewById(R.id.gbr);
        TextView namaBarang = (TextView) view.findViewById(R.id.brg);
        TextView hargaBarang = (TextView) view.findViewById(R.id.hrg);

        gambarBarang.setImageResource(gambar[posisi]);
        namaBarang.setText(barang[posisi]);
        hargaBarang.setText(String.valueOf(harga[posisi]));

        return view;
    }
}
