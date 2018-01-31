package com.example.umarsaeedkhan.fyp_foodies;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Shah on 2017-11-12.
 */

public class AdapterDish extends ArrayAdapter<DishData> {
    ArrayList<DishData> dataList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;

    public AdapterDish(Context c, int resource, ArrayList<DishData> objects) {
        super(c, resource, objects);
        vi = (LayoutInflater) c
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        dataList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design
        View v = convertView;
        if (v == null) {
            holder = new AdapterDish.ViewHolder();
            v = vi.inflate(Resource, null);
            holder.tvDishName= (TextView) v.findViewById(R.id.txtDish);
            holder.tvDishPrice = (TextView) v.findViewById(R.id.txtDishPrice);
            holder.btAddTOCART = (Button) v.findViewById(R.id.btnAddToCart);
            holder.quantity = (Spinner) v.findViewById(R.id.spQuantity);
            ArrayAdapter<CharSequence> arrAdapter = ArrayAdapter.createFromResource(this.getContext(), R.array.numbers, android.R.layout.simple_spinner_dropdown_item);
            arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            holder.quantity.setAdapter(arrAdapter);
            holder.quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            v.setTag(holder);
        } else {
            holder = (AdapterDish.ViewHolder) v.getTag();
        }
//        holder.imageview.setImageResource(R.drawable.ic_launcher);
//        new AdapterRestaurants.DownloadImageTask(holder.imageview).execute(actorList.get(position).getRestImage());
        holder.tvDishName.setText(dataList.get(position).getDishName());
        holder.tvDishPrice.setText("Price " + dataList.get(position).getDishPrice());
        holder.btAddTOCART.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DishesOfSpecificRestaurant ds = new DishesOfSpecificRestaurant();
                ds.addTOCART();
                Toast.makeText(getContext(), "Dish Added", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    static class ViewHolder {
        public TextView tvDishName;
        public TextView tvDishPrice;
        public Button btAddTOCART;
        public Spinner quantity;

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }

}
