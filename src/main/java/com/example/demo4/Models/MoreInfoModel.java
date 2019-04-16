package com.example.demo4.Models;

import java.util.Arrays;

public class MoreInfoModel {

    private Boolean adult;
    private int budget;
    private Genres[] genre;
    private String homepage;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private double popularity;
    private Production_companies[] production_companies;
    private Production_countries[] production_countries;
    private int revenue;
    private int runtime;
    private Spoken_languages[] spoken_languages;
    private double vote_average;

    public MoreInfoModel(Boolean adult, int budget, Genres[] genre, String homepage, String imdb_id,
                         String original_language, String original_title, double popularity,
                         Production_companies[] production_companies, Production_countries[] production_countries,
                         int revenue, int runtime, Spoken_languages[] spoken_languages, double vote_average) {
        this.adult = adult;
        this.budget = budget;
        this.genre = genre;
        this.homepage = homepage;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.popularity = popularity;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.vote_average = vote_average;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Genres[] getGenre() {
        return genre;
    }

    public void setGenre(Genres[] genre) {
        this.genre = genre;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public Production_companies[] getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(Production_companies[] production_companies) {
        this.production_companies = production_companies;
    }

    public Production_countries[] getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(Production_countries[] production_countries) {
        this.production_countries = production_countries;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public Spoken_languages[] getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(Spoken_languages[] spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public String toString() {
        return "MoreInfoModel{" +
                "adult=" + adult +
                ", budget=" + budget +
                ", genre=" + Arrays.toString(genre) +
                ", homepage='" + homepage + '\'' +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", popularity=" + popularity +
                ", production_companies=" + Arrays.toString(production_companies) +
                ", production_countries=" + Arrays.toString(production_countries) +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spoken_languages=" + Arrays.toString(spoken_languages) +
                ", vote_average=" + vote_average +
                '}';
    }
}
