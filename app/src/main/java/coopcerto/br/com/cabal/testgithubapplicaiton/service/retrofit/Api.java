package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.interfaces.IssueService;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.interfaces.PullService;

public class Api {

    public static IssueService issueService() {
        return RetrofitConfig.getRetrofit().create(IssueService.class);
    }

    public static PullService pullService() {
        return RetrofitConfig.getRetrofit().create(PullService.class);
    }

}
