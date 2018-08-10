package coopcerto.br.com.cabal.testgithubapplicaiton.model.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;

@Dao
public interface RepositoryDAO {

    @Query("SELECT * FROM repositoriesreponse")
    List<RepositoriesReponse> getRepositories();

    @Insert
    void addRepository(RepositoriesReponse repository);

    @Delete
    void removeRepository(RepositoriesReponse repositoriesReponse);


}
