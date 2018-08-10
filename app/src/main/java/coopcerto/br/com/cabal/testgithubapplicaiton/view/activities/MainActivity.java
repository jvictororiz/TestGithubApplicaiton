package coopcerto.br.com.cabal.testgithubapplicaiton.view.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.controller.RepositoryController;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.util.AnimationUtils;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.adapters.TabsAdapter;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.fragment.FavoritesRepositoriesFragment;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.fragment.IssuesFragment;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.fragment.PullRequestFragment;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.objects.ErroResponse;

public class MainActivity extends SuperActivity {
    private SearchView searchView;
    private ViewGroup llBody;
    private TabLayout tabFragments;
    private ViewPager pagerFragments;
    private PullRequestFragment pullRequestFragment;
    private IssuesFragment issuesFragment;
    private FavoritesRepositoriesFragment favoritesRepositoriesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        configViews();
        setEventSearchView();
        tabFragments.setVisibility(View.GONE);

    }

    private void setEventSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                hideKeyboard();
                if (queryValid(query)) {
                    showPagerFragments();
                    getIssues(query);
                    getPullRequests(query);
                    return true;
                } else {
                    Toast.makeText(MainActivity.this, R.string.erro_repository_invalid, Toast.LENGTH_SHORT).show();
                    return false;
                }

            }

            @Override
            public boolean onQueryTextChange(String query) {
                return false;
            }
        });
    }

    private void showPagerFragments() {
        AnimationUtils.setToVisible(llBody, tabFragments);
    }

    private void configViews() {
        searchView.onActionViewExpanded();
        pullRequestFragment = PullRequestFragment.newInstance();
        issuesFragment = IssuesFragment.newInstance();
        favoritesRepositoriesFragment = FavoritesRepositoriesFragment.newInstance();
        initFragments();
    }

    private void initFragments() {
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.add(pullRequestFragment, getString(R.string.tab_pull_request));
        adapter.add(issuesFragment, getString(R.string.tab_issue));
        adapter.add(favoritesRepositoriesFragment, getString(R.string.tab_favorites_repositories));
        pagerFragments.setAdapter(adapter);
        tabFragments.setupWithViewPager(pagerFragments);
    }

    private void getPullRequests(String query) {
        RepositoryController.findPullRequestByRpository(query, new OnCallbackCompletedListener<List<RepositoriesReponse>>(this, false) {
            @Override
            public void onSuccess(List<RepositoriesReponse> response) {
                if (response != null && !response.isEmpty()) {
                    pullRequestFragment.refreshListPulls(response);
                } else {
                    Toast.makeText(MainActivity.this, R.string.pull_empty, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getIssues(String query) {
        RepositoryController.findIssuesByRepository(query, new OnCallbackCompletedListener<List<RepositoriesReponse>>(this, false) {
            @Override
            public void onSuccess(List<RepositoriesReponse> response) {
                if (response != null && !response.isEmpty()) {
                    issuesFragment.refreshListPulls(response);
                } else {
                    Toast.makeText(MainActivity.this, R.string.issues_empty, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean queryValid(String query) {
        return query.contains("/") && query.length() >= 3 && query.indexOf("/") != 0 && query.indexOf("/") != query.length() - 1;
    }

    private void setViews() {
        llBody = findViewById(R.id.ll_body);
        searchView = findViewById(R.id.search_view);
        tabFragments = findViewById(R.id.tab_fragments);
        pagerFragments = findViewById(R.id.pager_fragment);
    }
}
