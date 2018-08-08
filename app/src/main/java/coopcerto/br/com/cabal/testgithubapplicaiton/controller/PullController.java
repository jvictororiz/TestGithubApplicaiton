package coopcerto.br.com.cabal.testgithubapplicaiton.controller;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.Api;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.IssueResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.PullRequestResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;

public class PullController {

    public static void findPullRequestByName(String login, String query, OnCallbackCompletedListener<List<PullRequestResponse>> callback) {
        Api.pullService().findPullRequestByName(login, query).enqueue(callback);
    }
}
