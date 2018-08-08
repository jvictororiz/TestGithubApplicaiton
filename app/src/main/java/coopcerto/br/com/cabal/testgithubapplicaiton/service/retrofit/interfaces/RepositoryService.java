package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.interfaces;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.PullRequestResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepositoryService {

    @GET("search/repositories")
    Call<PullRequestResponse> getRpositoriesFromName(@Query("q") String query, @Query("order") String order);

}
