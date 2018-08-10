package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.interfaces;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepositoryService {

    @GET("repos/{login}/{nameRep}/pulls")
    Call<List<RepositoriesReponse>> findPullRequestByRepository(@Path("login") String login, @Path("nameRep") String name, @Query("direction") String direction);

    @GET("repos/{login}/{nameRep}/issues")
    Call<List<RepositoriesReponse>> findIssuesByRepository(@Path("login") String login, @Path("nameRep") String name, @Query("direction") String direction);
}
