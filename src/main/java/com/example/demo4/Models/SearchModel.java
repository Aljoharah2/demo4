package com.example.demo4.Models;

import java.util.Arrays;

public class SearchModel {


    private Result[] results;
    private int total_results;

    public SearchModel(Result[] results, int total_results) {
        this.results = results;
        this.total_results=total_results;
    }

    public SearchModel(Result[] results) {
        this.results = results;
    }

    public SearchModel(int total_results) {
        this.total_results = total_results;
    }

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public int getTotal_results() {
        return total_results;
    }

    @Override
    public String toString() {
        return "SearchModel{" +
                "results=" + Arrays.toString(results) +
                ", total_results=" + total_results +
                '}';
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }


}
