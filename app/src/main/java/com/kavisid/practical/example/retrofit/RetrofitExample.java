package com.kavisid.practical.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.kavisid.practical.example.R;
import com.kavisid.practical.example.retrofit.pojo.MovieDetails;
import com.kavisid.practical.example.retrofit.pojo.MultipleResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitExample extends AppCompatActivity {
    APIInterface apiInterface,apiMovieInterface;
    TextView responseText;
    RecyclerView recyclerView,rvMovie;
    private MultipleResourceAdapter mAdapter;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_example);
        responseText = (TextView) findViewById(R.id.responseText);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        rvMovie = (RecyclerView) findViewById(R.id.rv_movie);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        apiMovieInterface = APIClient.getMovieDetails().create(APIInterface.class);
        firstRetrofitExample();
        secondRetrofitExample();
    }

    void firstRetrofitExample(){
        /**
         GET List Resources
         **/
        Call<MultipleResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MultipleResource>() {
            @Override
            public void onResponse(Call<MultipleResource> call, Response<MultipleResource> response) {
                Log.i("Response---", response.code() + "");
                String displayResponse = "";
                MultipleResource resource = response.body();
                Integer text = resource.page;
                Integer total = resource.total;
                Integer perPage = resource.perPage;
                Integer perPages = resource.totalPages;
                List<MultipleResource.DataRecords> dataList = resource.data;

                displayResponse = "Page:" + text + "\nTotal:" + total + "\nTotal Pages:" + perPage + "\nPerPage:" + perPages + "\n";
                responseText.setText(displayResponse+"---------------------------");
               /* for (MultipleResource.DataRecords allData : dataList) {
                    displayResponse += allData.id + " " + allData.name + " " + allData.year + " " + allData.color + "\n";
                }*/

                mAdapter = new MultipleResourceAdapter(dataList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(RetrofitExample.this, LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<MultipleResource> call, Throwable t) {
                call.cancel();
            }
        });
    }

    void secondRetrofitExample(){
        Call<List<MovieDetails>> call = apiMovieInterface.getMovieDetails();
        call.enqueue(new Callback<List<MovieDetails>>() {
            @Override
            public void onResponse(Call<List<MovieDetails>> call, Response<List<MovieDetails>> response) {
                Log.i("Response 2---",response.code()+"");
                List<MovieDetails> movieDetails = response.body();

                movieAdapter = new MovieAdapter(movieDetails);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                rvMovie.setLayoutManager(mLayoutManager);
                rvMovie.setItemAnimator(new DefaultItemAnimator());
                rvMovie.addItemDecoration(new DividerItemDecoration(RetrofitExample.this,LinearLayoutManager.VERTICAL));
                rvMovie.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<List<MovieDetails>> call, Throwable t) {

            }
        });
    }



}
