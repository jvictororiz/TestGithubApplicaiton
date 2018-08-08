package coopcerto.br.com.cabal.testgithubapplicaiton.controller;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.Api;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.PullRequestResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;

public class RepositoriesController {

    public static void getRepositoriesFromName(String query, OnCallbackCompletedListener<PullRequestResponse> callback) {
        Api.repositoryService().getRpositoriesFromName(query, "cresc").enqueue(callback);
    }
}
