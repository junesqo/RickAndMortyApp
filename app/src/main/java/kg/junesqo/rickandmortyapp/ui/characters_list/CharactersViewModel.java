package kg.junesqo.rickandmortyapp.ui.characters_list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import kg.junesqo.rickandmortyapp.common.Resource;
import kg.junesqo.rickandmortyapp.data.model.MainResponse;
import kg.junesqo.rickandmortyapp.data.repositories.MainRepositoryImpl;

@HiltViewModel
public class CharactersViewModel extends ViewModel {

    public LiveData<Resource<MainResponse>> liveData;

    private MainRepositoryImpl repository;

    @Inject
    public CharactersViewModel(MainRepositoryImpl repository) {
        this.repository = repository;
    }

    public void getCharacters() {
        liveData = repository.getCharacters();
    }

}
