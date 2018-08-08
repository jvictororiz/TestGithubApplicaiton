package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.interfaces;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.PullRequestResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PullService {

    @GET("repos/{login}/{name}/pulls")
    Call<List<PullRequestResponse>> findPullRequestByName(@Path("login") String login, @Path("name") String name);

}
