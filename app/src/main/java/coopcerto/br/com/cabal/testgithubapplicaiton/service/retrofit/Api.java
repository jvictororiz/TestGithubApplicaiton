package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.interfaces.RepositoryService;

public class Api {

    public static RepositoryService repositoryService() {
        return RetrofitConfig.getRetrofit().create(RepositoryService.class);
    }
}
