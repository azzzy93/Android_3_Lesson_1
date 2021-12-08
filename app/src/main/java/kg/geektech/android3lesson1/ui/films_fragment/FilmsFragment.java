package kg.geektech.android3lesson1.ui.films_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import kg.geektech.android3lesson1.App;
import kg.geektech.android3lesson1.R;
import kg.geektech.android3lesson1.data.models.Film;
import kg.geektech.android3lesson1.data.remote.FilmsCallback;
import kg.geektech.android3lesson1.databinding.FragmentFilmsBinding;
import kg.geektech.android3lesson1.interfaces.MyOnItemClickListeners;

public class FilmsFragment extends Fragment {
    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new FilmsAdapter();
        binding.filmsRv.setAdapter(adapter);

        App.client.getFilms(new FilmsCallback() {
            @Override
            public void success(List<Film> films) {
                adapter.setList(films);
            }

            @Override
            public void failure(String msg) {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setMyOnItemClickListeners(position -> {
            Film film = adapter.getFilm(position);
            Bundle bundle = new Bundle();
            bundle.putString("key_id", film.getId());
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host);
            navController.navigate(R.id.filmDetailFragment, bundle);
        });
    }
}