package com.denipramulia.dicoding.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListMovieAdapter adapter;
    private String[] titleMovies, overviewMovies, genreMovies, lengthMovies, languageMovies,
            statusMovies, userRatingMovies, yearReleaseMovies;
    private TypedArray posterMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ListMovieAdapter(this);

        ListView listView = findViewById(R.id.mov_catalogue);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObjectParcelable = new Intent(MainActivity.this, MovieDetail.class);

                ArrayList<Movie> movies = new ArrayList<>();

                Movie movie = new Movie();
                movie.setPoster(posterMovies.getResourceId(i, -1));
                movie.setTitle(titleMovies[i]);
                movie.setOverview(overviewMovies[i]);
                movie.setGenres(genreMovies[i]);
                movie.setStatus(statusMovies[i]);
                movie.setRuntime(lengthMovies[i]);
                movie.setUser_score(userRatingMovies[i]);
                movie.setOriginal_language(languageMovies[i]);
                movie.setYear(yearReleaseMovies[i]);
                movies.add(movie);

                moveWithObjectParcelable.putParcelableArrayListExtra(MovieDetail.EXTRA_MOVIE, movies);
                startActivity(moveWithObjectParcelable);
            }
        });
    }

    private void prepare(){
        titleMovies = getResources().getStringArray(R.array.title_movies);
        overviewMovies = getResources().getStringArray(R.array.overview_movies);
        posterMovies = getResources().obtainTypedArray(R.array.poster_movies);
        genreMovies = getResources().getStringArray(R.array.genre_movies);
        statusMovies = getResources().getStringArray(R.array.status_movies);
        userRatingMovies = getResources().getStringArray(R.array.user_rating_movies);
        languageMovies = getResources().getStringArray(R.array.language_movies);
        lengthMovies = getResources().getStringArray(R.array.length_movies);
        yearReleaseMovies = getResources().getStringArray(R.array.year_release_movies);
    }

    private void addItem(){
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < titleMovies.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(posterMovies.getResourceId(i, -1));
            movie.setTitle(titleMovies[i]);
            movie.setOverview(overviewMovies[i]);
            movie.setGenres(genreMovies[i]);
            movie.setStatus(statusMovies[i]);
            movie.setRuntime(lengthMovies[i]);
            movie.setUser_score(userRatingMovies[i]);
            movie.setOriginal_language(languageMovies[i]);
            movie.setYear(yearReleaseMovies[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}
