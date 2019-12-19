package com.kavisid.practical.example.retrofit.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MultipleResource {
    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perPage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("data")
    public List<DataRecords> data = null;

    public class DataRecords {
        @SerializedName("id")
        public Integer id;
        @SerializedName("name")
        public String name;
        @SerializedName("year")
        public Integer year;
        @SerializedName("color")
        public String color;
    }

}
