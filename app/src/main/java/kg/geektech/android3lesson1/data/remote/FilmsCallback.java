package kg.geektech.android3lesson1.data.remote;

import java.util.List;

import kg.geektech.android3lesson1.data.models.Film;

public interface FilmsCallback {

    void success(List<Film> films);
    void failure(String msg);
}
