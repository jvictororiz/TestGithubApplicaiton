package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.interfaces;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.IssueResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.PullRequestResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IssueService {

    @GET("search/issues")
    Call<IssueResponse> findIssuesByName(@Query("q") String query, @Query("sort") String sort);

}
