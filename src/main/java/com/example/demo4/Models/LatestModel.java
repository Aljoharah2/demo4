package com.example.demo4.Models;

public class LatestModel {

    private Boolean adult;
    private int budget;
    public static int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private int popularity;
    private String poster_path;
    private String release_date;
    private String status;
    private String title;
    private Boolean video;

    public LatestModel(Boolean adult,int budget,int id,String imdb_id,String original_language,
                       String original_title,String overview,int popularity,String poster_path,String release_date,
                       String status,String title,Boolean video) {
        this.adult= adult;
        this.budget=budget;
        this.id=id;
        this.imdb_id=imdb_id;
        this.original_language=original_language;
        this.original_title=original_title;
        this.overview=overview;
        this.popularity=popularity;
        this.poster_path=poster_path;
        this.release_date=release_date;
        this.status=status;
        this.title=title;
        this.video=video;
    }


    public LatestModel(){}

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "LatestModel{" +
                "adult=" + adult +
                ", budget=" + budget +
                ", id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                '}';
    }
}
