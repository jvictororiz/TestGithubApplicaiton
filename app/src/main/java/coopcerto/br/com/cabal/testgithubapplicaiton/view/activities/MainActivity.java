package coopcerto.br.com.cabal.testgithubapplicaiton.view.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.controller.RepositoryController;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.util.AlertUtils;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;

public class MainActivity extends SuperActivity {
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        searchView.onActionViewExpanded();

    }

    private void setViews() {
        searchView = findViewById(R.id.serach_view);
    }

//    public void click(View view) {
//        String query = edtSearch.getText().toString();
//        if (queryValid(query)) {
//            getIssues(query);
//            getPullRequests(query);
//        } else {
//            AlertUtils.showAlert(getString(R.string.message_erro_search), this);
//        }
//
//    }
//
//    private void getPullRequests(String query) {
//        RepositoryController.findPullRequestByRpository(query, new OnCallbackCompletedListener<List<RepositoriesReponse>>(this, false) {
//            @Override
//            public void onSuccess(List<RepositoriesReponse> response) {
//                super.onSuccess(response);
//            }
//        });
//    }
//
//    private void getIssues(String query) {
//        RepositoryController.findIssuesByRepository(query, new OnCallbackCompletedListener<List<RepositoriesReponse>>(this, false) {
//            @Override
//            public void onSuccess(List<RepositoriesReponse> response) {
//                super.onSuccess(response);
//            }
//        });
//    }
//
//    private boolean queryValid(String query) {
//        return query.contains("/") && query.length() >= 3 && query.indexOf("/") != 0 && query.indexOf("/") != query.length() - 1;
//    }
}
