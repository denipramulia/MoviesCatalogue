package com.denipramulia.dicoding.moviecatalogue;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MovieDetail extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "Extra_Movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        TextView tViewTitle = findViewById(R.id.txt_title_movie);
        TextView tViewStatus = findViewById(R.id.txt_status_movie);
        TextView tViewUserScore = findViewById(R.id.txt_user_rating_movie);
        TextView tViewGenres = findViewById(R.id.txt_genre_movie);
        TextView textViewRuntime = findViewById(R.id.txt_length_movie);
        TextView tViewLanguage = findViewById(R.id.txt_language_movie);
        TextView tViewOverview = findViewById(R.id.txt_overview_movie);
        ImageView imagePoster = findViewById(R.id.img_poster_movie);

        ArrayList<Movie> movie = getIntent().getParcelableArrayListExtra(EXTRA_MOVIE);

        assert movie != null;
        String title = movie.get(0).getTitle();
        tViewTitle.setText(title);

        String status = movie.get(0).getStatus();
        tViewStatus.setText(status);

        String user_score = movie.get(0).getUser_score();
        tViewUserScore.setText(user_score);

        String genres = movie.get(0).getGenres();
        tViewGenres.setText(genres);

        String runtime = movie.get(0).getRuntime();
        textViewRuntime.setText(runtime);

        String language = movie.get(0).getOriginal_language();
        tViewLanguage.setText(language);

        String overview = movie.get(0).getOverview();
        tViewOverview.setText(overview);

        int path = movie.get(0).getPoster();
        imagePoster.setImageResource(path);

    }
}
