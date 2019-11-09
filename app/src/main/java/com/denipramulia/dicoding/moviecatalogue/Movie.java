package com.denipramulia.dicoding.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title, overview, user_score, status, original_language, runtime, genres, year;

    String getYear() {
        return year;
    }

    void setYear(String year) {
        this.year = year;
    }

    String getUser_score() {
        return user_score;
    }

    void setUser_score(String user_score) {
        this.user_score = user_score;
    }

    String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    String getOriginal_language() {
        return original_language;
    }

    void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    String getRuntime() {
        return runtime;
    }

    void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    String getGenres() {
        return genres;
    }

    void setGenres(String genres) {
        this.genres = genres;
    }

    int getPoster() {
        return poster;
    }

    void setPoster(int poster) {
        this.poster = poster;
    }

    private int poster;

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getOverview() {
        return overview;
    }

    void setOverview(String overview) {
        this.overview = overview;
    }

    Movie() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.user_score);
        dest.writeString(this.status);
        dest.writeString(this.original_language);
        dest.writeString(this.runtime);
        dest.writeString(this.genres);
        dest.writeString(this.year);
        dest.writeInt(this.poster);
    }

    private Movie(Parcel in) {
        this.title = in.readString();
        this.overview = in.readString();
        this.user_score = in.readString();
        this.status = in.readString();
        this.original_language = in.readString();
        this.runtime = in.readString();
        this.genres = in.readString();
        this.year = in.readString();
        this.poster = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
