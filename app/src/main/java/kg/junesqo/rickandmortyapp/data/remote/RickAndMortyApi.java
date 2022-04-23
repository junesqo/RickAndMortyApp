package kg.junesqo.rickandmortyapp.data.remote;

import java.util.List;

import kg.junesqo.rickandmortyapp.data.model.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RickAndMortyApi {

    @GET("character")
    Call<MainResponse> getCharacters();

}
