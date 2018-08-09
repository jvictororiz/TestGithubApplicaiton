package coopcerto.br.com.cabal.testgithubapplicaiton.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.model.RepositoryEntry;
import coopcerto.br.com.cabal.testgithubapplicaiton.util.AnimationUtils;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.adapters.RepositoryAdapter;

public class PullRequestFragment extends SuperFragment {
    private List<RepositoryEntry> repositoryEntries;
    private RecyclerView recyclerPull;
    private RepositoryAdapter repositoryAdapter;

    public static PullRequestFragment newInstance() {
        Bundle args = new Bundle();
        PullRequestFragment fragment = new PullRequestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_pull_request, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViews();
    }

    private void initList() {
        recyclerPull.setLayoutManager(new LinearLayoutManager(getActivity()));
        AnimationUtils.configAnimatinoRecyclerView(getActivity(), recyclerPull);
        repositoryAdapter = new RepositoryAdapter(getActivity(), repositoryEntries);
        recyclerPull.setAdapter(repositoryAdapter);
    }

    private void setViews() {
        if (getView() != null) {
            recyclerPull = getView().findViewById(R.id.recycler_pull);
        }
    }

    public void refreshListPulls(List<RepositoryEntry> repositoryEntries) {
        this.repositoryEntries = repositoryEntries;
        if (repositoryAdapter == null) {
            initList();
        } else {
            repositoryAdapter.notifyDataSetChanged();
        }
    }
}
