package kg.geektech.android3lesson1.ui.film_detail_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import kg.geektech.android3lesson1.App;
import kg.geektech.android3lesson1.R;
import kg.geektech.android3lesson1.data.models.Film;
import kg.geektech.android3lesson1.databinding.FragmentFilmDetailBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {
    private FragmentFilmDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBundle();
    }

    private void getBundle() {
        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String id = bundle.getString("key_id");

            App.api.getFilmId(id).enqueue(new Callback<Film>() {
                @Override
                public void onResponse(Call<Film> call, Response<Film> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        binding.tvTitle.setText(response.body().getTitle());
                        binding.tvOriginalTitle.setText(response.body().getOriginalTitle());
                        binding.releaseDate.setText(response.body().getReleaseDate());
                        binding.tvDesc.setText(response.body().getDescription());
                        String rating = "Rating score: " + response.body().getRtScore();
                        binding.tvRtScore.setText(rating);
                    }
                }

                @Override
                public void onFailure(Call<Film> call, Throwable t) {
                    Log.e("Aziz", t.toString());
                }
            });
        }
    }
}

