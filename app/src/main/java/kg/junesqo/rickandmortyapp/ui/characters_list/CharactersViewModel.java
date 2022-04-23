package kg.junesqo.rickandmortyapp.ui.characters_list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import kg.junesqo.rickandmortyapp.App;
import kg.junesqo.rickandmortyapp.common.Resource;
import kg.junesqo.rickandmortyapp.data.model.MainResponse;

public class CharactersViewModel extends ViewModel {

    public LiveData<Resource<MainResponse>> liveData;

    public void getCharacters() {
        liveData = App.repository.getCharacters();
    }

}
