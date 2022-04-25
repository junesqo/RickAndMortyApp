package kg.junesqo.rickandmortyapp.ui.character_detail;

import android.os.Bundle;

import androidx.annotation.Nullable;

import kg.junesqo.rickandmortyapp.base.BaseFragment;
import kg.junesqo.rickandmortyapp.databinding.FragmentCharacterDetailBinding;

public class CharacterDetailFragment extends BaseFragment<FragmentCharacterDetailBinding> {

    private CharacterDetailFragmentArgs args;
    @Override
    protected FragmentCharacterDetailBinding bind() {
        return FragmentCharacterDetailBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = CharacterDetailFragmentArgs.fromBundle(getArguments());
    }

    @Override
    protected void setupViews() {
        binding.characterId.setText(String.valueOf(args.getCharacterId()));
    }

    @Override
    protected void callRequests() {

    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {

    }
}
