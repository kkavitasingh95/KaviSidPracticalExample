package com.kavisid.practical.example.retrofit;

import com.kavisid.practical.example.R;
import com.kavisid.practical.example.retrofit.pojo.MultipleResource;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MultipleResourceAdapter extends RecyclerView.Adapter<MultipleResourceAdapter.MyViewHolder> {

    private List<MultipleResource.DataRecords> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, year;

        public MyViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.id);
            name = (TextView) view.findViewById(R.id.name);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public MultipleResourceAdapter(List<MultipleResource.DataRecords> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MultipleResource.DataRecords movie = moviesList.get(position);
        holder.id.setText(movie.id.toString());
        holder.name.setText(movie.name);
        holder.year.setText(movie.year.toString());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
