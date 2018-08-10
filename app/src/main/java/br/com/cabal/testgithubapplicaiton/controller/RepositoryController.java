package br.com.cabal.testgithubapplicaiton.controller;

import java.util.List;

import br.com.cabal.testgithubapplicaiton.retrofit.Api;
import br.com.cabal.testgithubapplicaiton.retrofit.response.RepositoriesReponse;
import br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;

public class RepositoryController {
    private static final String ORDER_DEFAULT = "asc";

    public static void findPullRequestByRpository(String query, OnCallbackCompletedListener<List<RepositoriesReponse>> callback) {
        Api.repositoryService().findPullRequestByRepository(getLogin(query), getRepositoryName(query), ORDER_DEFAULT).enqueue(callback);
    }

    public static void findIssuesByRepository(String query, final OnCallbackCompletedListener<List<RepositoriesReponse>> callback) {
        Api.repositoryService().findIssuesByRepository(getLogin(query), getRepositoryName(query), ORDER_DEFAULT).enqueue(callback);
    }

    private static String getLogin(String query) {
        int positionDivision = query.indexOf("/");
        return query.substring(0, positionDivision);
    }

    private static String getRepositoryName(String query) {
        int positionDivision = query.indexOf("/");
        return query.substring(positionDivision + 1);
    }
}
