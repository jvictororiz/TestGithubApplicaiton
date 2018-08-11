package br.com.cabal.testgithubapplicaiton.model.persistence.controller;

import java.util.List;

import br.com.cabal.testgithubapplicaiton.SuperApplication;
import br.com.cabal.testgithubapplicaiton.model.persistence.dao.RepositoryDAO;
import br.com.cabal.testgithubapplicaiton.retrofit.response.RepositoriesReponse;

public class RepositoryPersistenceController implements RepositoryDAO {
    private final RepositoryDAO repositoryDao = SuperApplication.getDatabaseApplication().repositoryDAO();


    @Override
    public List<RepositoriesReponse> getRepositories() {
        return repositoryDao.getRepositories();
    }

    @Override
    public void addRepository(RepositoriesReponse repository) {
        if (!isRegistered(repository)) {
            repositoryDao.addRepository(repository);
        }
    }

    @Override
    public void removeRepository(RepositoriesReponse repositoriesReponse) {
        repositoryDao.removeRepository(repositoriesReponse);
    }

    public boolean isRegistered(RepositoriesReponse repositoriesReponse) {
        for (RepositoriesReponse item : repositoryDao.getRepositories()) {
            if (item.getNumber() == repositoriesReponse.getNumber()) {
                return true;
            }
        }
        return false;
    }
}
