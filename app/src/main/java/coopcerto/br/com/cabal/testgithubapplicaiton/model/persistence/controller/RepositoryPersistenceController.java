package coopcerto.br.com.cabal.testgithubapplicaiton.model.persistence.controller;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.SuperApplication;
import coopcerto.br.com.cabal.testgithubapplicaiton.model.persistence.dao.RepositoryDAO;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.RepositoriesReponse;

public class RepositoryPersistenceController implements RepositoryDAO {
    private RepositoryDAO cardDao = SuperApplication.getDatabaseApplication().repositoryDAO();


    @Override
    public List<RepositoriesReponse> getRepositories() {
        return cardDao.getRepositories();
    }

    @Override
    public void addRepository(RepositoriesReponse repository) {
        cardDao.addRepository(repository);
    }

    @Override
    public void removeRepository(RepositoriesReponse repositoriesReponse) {
        cardDao.removeRepository(repositoriesReponse);

    }
}
