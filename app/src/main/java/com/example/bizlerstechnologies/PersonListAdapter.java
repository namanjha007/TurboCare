package com.example.bizlerstechnologies;

import android.app.Person;
import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

class PersonListAdapter extends ArrayAdapter<Vehicle> {

    private static final String TAG = "PersonListAdapter";
    private Context mContext;
    int mResource;

    public PersonListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Vehicle> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String number = getItem(position).getNumber();
        String make = getItem(position).getMake();
        String model = getItem(position).getModel();
        String variant = getItem(position).getVariant();
        String image = getItem(position).getImage();

        Vehicle person = new Vehicle(number, make, model, variant, image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        TextView textView = (TextView)  convertView.findViewById(R.id.textView1);
        TextView textView1 = (TextView)  convertView.findViewById(R.id.textView2);
        TextView textView2 = (TextView)  convertView.findViewById(R.id.textView3);
        TextView textView3 = (TextView)  convertView.findViewById(R.id.textView4);

        textView.setText(number);
        textView1.setText(make);
        textView2.setText(model);
        textView3.setText(variant);

        Uri uri = Uri.parse(image);
        Picasso.get().load(uri).into(imageView);

        return convertView;

    }
}
