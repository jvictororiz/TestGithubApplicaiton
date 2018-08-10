package br.com.cabal.testgithubapplicaiton.retrofit;

import br.com.cabal.testgithubapplicaiton.retrofit.interfaces.RepositoryService;

public class Api {

    public static RepositoryService repositoryService() {
        return RetrofitConfig.getRetrofit().create(RepositoryService.class);
    }
}
