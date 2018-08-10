package coopcerto.br.com.cabal.testgithubapplicaiton.model.persistence;


import android.arch.persistence.room.RoomDatabase;

import coopcerto.br.com.cabal.testgithubapplicaiton.model.persistence.dao.RepositoryDAO;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;

@android.arch.persistence.room.Database(entities = {RepositoriesReponse.class}, version = 1, exportSchema = false)
public abstract class DatabaseApplication extends RoomDatabase {
    public abstract RepositoryDAO repositoryDAO();
}
