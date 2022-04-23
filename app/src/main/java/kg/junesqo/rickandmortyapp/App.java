package kg.junesqo.rickandmortyapp;

import android.app.Application;

import kg.junesqo.rickandmortyapp.data.remote.RetrofitClient;
import kg.junesqo.rickandmortyapp.data.repositories.MainRepository;
import retrofit2.Retrofit;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static MainRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        repository = new MainRepository(retrofitClient.provideApi());
    }
}
