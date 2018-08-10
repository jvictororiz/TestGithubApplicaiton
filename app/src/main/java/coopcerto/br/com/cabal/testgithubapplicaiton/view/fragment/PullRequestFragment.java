package coopcerto.br.com.cabal.testgithubapplicaiton.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.controller.RepositoryController;
import coopcerto.br.com.cabal.testgithubapplicaiton.model.persistence.controller.RepositoryPersistenceController;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.util.AnimationUtils;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.activities.WebViewActivity;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.adapters.RepositoryAdapter;

public class PullRequestFragment extends SuperFragment implements RepositoryAdapter.OnClickButtons {

    private List<RepositoriesReponse> repositoryEntries;
    private RecyclerView recyclerPull;

    public static PullRequestFragment newInstance() {
        Bundle args = new Bundle();
        PullRequestFragment fragment = new PullRequestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pull_request, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (repositoryEntries != null) {
            initList();
        }
    }

    private void initList() {
        recyclerPull.setLayoutManager(new LinearLayoutManager(getActivity()));
        AnimationUtils.configAnimatinoRecyclerView(getActivity(), recyclerPull);
        RepositoryAdapter repositoryAdapter = new RepositoryAdapter(getActivity(), repositoryEntries, this);
        recyclerPull.setAdapter(repositoryAdapter);
    }

    private void setViews() {
        if (getView() != null) {
            recyclerPull = getView().findViewById(R.id.recycler_pull);
        }
    }

    public void refreshListPulls(List<RepositoriesReponse> repositoryEntries) {
        this.repositoryEntries = repositoryEntries;
        initList();
    }

    @Override
    public void clickButotnSave(RepositoriesReponse repositoriesReponse) {
        new RepositoryPersistenceController().addRepository(repositoriesReponse);
        Toast.makeText(getActivity(), R.string.save_sucessfull, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickButtonGoRepository(String repository) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra(WebViewActivity.EXTRA_URL, repository);
        startActivityAnim(intent);
    }
}
