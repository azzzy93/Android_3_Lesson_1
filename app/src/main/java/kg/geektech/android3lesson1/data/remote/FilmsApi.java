package kg.geektech.android3lesson1.data.remote;

import java.util.List;

import kg.geektech.android3lesson1.data.models.Film;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmsApi {

    @GET("/films")
    Call<List<Film>> getFilms();

    @GET("/films/{id}")
    Call<Film> getFilmId(@Path("id") String id);

}
