package com.denipramulia.dicoding.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListMovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    ListMovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_row_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movies = (Movie) getItem(i);
        viewHolder.bind(movies);
        return view;

    }

    void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    private class ViewHolder {
        private TextView txtTitle, txtOverview, txtRuntime, txtDateTime, txtUserScore;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.item_title_movie);
            txtOverview = view.findViewById(R.id.item_detail_movie);
            imgPoster = view.findViewById(R.id.img_item_poster_movie);
            txtRuntime = view.findViewById(R.id.item_length_movie);
            txtDateTime = view.findViewById(R.id.item_year_released_movie);
            txtUserScore = view.findViewById(R.id.item_rating_movie);
        }

        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtOverview.setText(movie.getOverview());
            imgPoster.setImageResource(movie.getPoster());
            txtRuntime.setText(movie.getRuntime());
            txtDateTime.setText(movie.getYear());
            txtUserScore.setText(movie.getUser_score());
        }
    }
}
