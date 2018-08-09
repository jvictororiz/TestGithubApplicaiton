package coopcerto.br.com.cabal.testgithubapplicaiton.controller;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.Api;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;

public class RepositoryController {
    public static void findPullRequestByRpository(String query, OnCallbackCompletedListener<List<RepositoriesReponse>> callback) {
        Api.repositoryService().findPullRequestByRepository(getLogin(query), getRepositoryName(query)).enqueue(callback);
    }

    public static void findIssuesByRepository(String query, OnCallbackCompletedListener<List<RepositoriesReponse>> callback) {
        Api.repositoryService().findIssuesByRepository(getLogin(query), getRepositoryName(query)).enqueue(callback);
    }

    private static String getLogin(String query) {
        int positionDivision = query.indexOf("/");
        return query.substring(0, positionDivision);
    }

    private static String getRepositoryName(String query) {
        int positionDivision = query.indexOf("/");
        return query.substring(positionDivision+1);
    }
}
