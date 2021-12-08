package kg.geektech.android3lesson1.ui.films_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.android3lesson1.data.models.Film;
import kg.geektech.android3lesson1.databinding.ItemFilmBinding;
import kg.geektech.android3lesson1.interfaces.MyOnItemClickListeners;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
    private ItemFilmBinding binding;
    private List<Film> list;
    private MyOnItemClickListeners myOnItemClickListeners;

    public FilmsAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<Film> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Film getFilm(int position){
        return list.get(position);
    }

    public void setMyOnItemClickListeners(MyOnItemClickListeners myOnItemClickListeners) {
        this.myOnItemClickListeners = myOnItemClickListeners;
    }










    public class FilmsViewHolder extends RecyclerView.ViewHolder {
        private ItemFilmBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(v ->
                    myOnItemClickListeners.onClick(getAdapterPosition()));
        }

        public void onBind(Film film) {
            binding.title.setText(film.getTitle());
            binding.desc.setText(film.getDescription());
        }
    }
}
