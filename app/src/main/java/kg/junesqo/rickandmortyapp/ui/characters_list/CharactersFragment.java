package kg.junesqo.rickandmortyapp.ui.characters_list;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;
import kg.junesqo.rickandmortyapp.base.BaseFragment;
import kg.junesqo.rickandmortyapp.common.OnItemClick;
import kg.junesqo.rickandmortyapp.common.Resource;
import kg.junesqo.rickandmortyapp.data.model.MainResponse;
import kg.junesqo.rickandmortyapp.databinding.FragmentCharactersBinding;
import kg.junesqo.rickandmortyapp.ui.characters_list.CharactersViewModel;

@AndroidEntryPoint
public class CharactersFragment extends BaseFragment<FragmentCharactersBinding> implements OnItemClick<Integer> {

    private CharactersViewModel charactersViewModel;
    private CharacterAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        charactersViewModel = new ViewModelProvider(requireActivity()).get(CharactersViewModel.class);
        adapter = new CharacterAdapter();
        adapter.setListener(this);
    }

    @Override
    protected FragmentCharactersBinding bind() {
        return FragmentCharactersBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {
        binding.recycler.setAdapter(adapter);
    }

    @Override
    protected void callRequests() {
        charactersViewModel.getCharacters();
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        charactersViewModel.liveData.observe(getViewLifecycleOwner(), new Observer<Resource<MainResponse>>() {
            @Override
            public void onChanged(Resource<MainResponse> resource) {
                switch (resource.status) {
                    case LOADING: {
                        binding.recycler.setVisibility(View.GONE);
                        binding.progress.setVisibility(View.VISIBLE);
                        break;
                    }
                    case SUCCESS: {
                        binding.recycler.setVisibility(View.VISIBLE);
                        binding.progress.setVisibility(View.GONE);
                        adapter.setCharacters(resource.data.getResults());
                        break;
                    }
                    case ERROR: {
                        Toast.makeText(requireContext(), resource.msg, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onItemClicked(Integer data) {
        navController.navigate(CharactersFragmentDirections
                .actionCharactersFragmentToCharactersDetailFragment(data));
    }
}
