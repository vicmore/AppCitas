package com.moniguar.app.citas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterElements extends ArrayAdapter<Elements> {

    public AdapterElements(@NonNull Context context, ArrayList<Elements> gridDate) {
        super(context, 0, gridDate);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.elements, parent, false);
        }
        Elements elementModel = getItem(position);
        TextView Elemnt1 = listitemView.findViewById(R.id.txtCol1);
        TextView  Elemnt2 = listitemView.findViewById(R.id.txtCol2);
        Elemnt1.setText(elementModel.getDate());
        Elemnt2.setText(elementModel.getUser());
        return listitemView;
    }
}
