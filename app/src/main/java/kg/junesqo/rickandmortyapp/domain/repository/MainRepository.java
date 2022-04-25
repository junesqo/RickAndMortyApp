package kg.junesqo.rickandmortyapp.domain.repository;

import androidx.lifecycle.MutableLiveData;

import kg.junesqo.rickandmortyapp.common.Resource;
import kg.junesqo.rickandmortyapp.data.model.MainResponse;

public interface MainRepository {

    MutableLiveData<Resource<MainResponse>> getCharacters();

}
