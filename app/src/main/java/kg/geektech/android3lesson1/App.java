package kg.geektech.android3lesson1;

import android.app.Application;

import kg.geektech.android3lesson1.data.remote.FilmsApi;
import kg.geektech.android3lesson1.data.remote.FilmsApiClient;
import kg.geektech.android3lesson1.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmsApi api;
    public static FilmsApiClient client;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmsApi();
        client = new FilmsApiClient();
    }
}
