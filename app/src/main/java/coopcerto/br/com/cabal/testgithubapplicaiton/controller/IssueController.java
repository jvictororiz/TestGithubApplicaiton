package coopcerto.br.com.cabal.testgithubapplicaiton.controller;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.Api;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.IssueResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.PullRequestResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;

public class IssueController {

    public static void findIssuesByName(String query, OnCallbackCompletedListener<IssueResponse> callback) {
        Api.issueService().findIssuesByName(query, "created").enqueue(callback);
    }
}
