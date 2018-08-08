package coopcerto.br.com.cabal.testgithubapplicaiton.view.activities;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.controller.IssueController;
import coopcerto.br.com.cabal.testgithubapplicaiton.controller.PullController;
import coopcerto.br.com.cabal.testgithubapplicaiton.model.Issue;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.IssueResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.PullRequestResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.objects.ErroResponse;

public class MainActivity extends SuperActivity {
    private List<Integer> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strings = new ArrayList<>();
        final String query = "java";

        IssueController.findIssuesByName(query, new OnCallbackCompletedListener<IssueResponse>(this, false) {
            @Override
            public void onSuccess(IssueResponse response) {
                super.onSuccess(response);
                for (Issue issue : response.getItems()) {
                    getPullRequest(issue.getUser().getLogin(), query);
                }
                Log.i("", "");
            }

            @Override
            public void onError(ErroResponse erro) {
                super.onError(erro);
            }

            @Override
            public void onFaild(Throwable erro) {
                super.onFaild(erro);
            }
        });
    }

    public void getPullRequest(String login, String query) {
        PullController.findPullRequestByName(login, query, new OnCallbackCompletedListener<List<PullRequestResponse>>(this) {
            @Override
            public void onSuccess(List<PullRequestResponse> response) {
                super.onSuccess(response);
                if (response != null && !response.isEmpty()) {
                    strings.add(strings.size() + 1);
                }
            }
        });

    }
}
