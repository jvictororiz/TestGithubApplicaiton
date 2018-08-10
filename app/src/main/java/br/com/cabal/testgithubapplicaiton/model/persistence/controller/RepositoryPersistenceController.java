package br.com.cabal.testgithubapplicaiton.model.persistence.controller;

import java.util.List;

import br.com.cabal.testgithubapplicaiton.SuperApplication;
import br.com.cabal.testgithubapplicaiton.model.persistence.dao.RepositoryDAO;
import br.com.cabal.testgithubapplicaiton.retrofit.response.RepositoriesReponse;

public class RepositoryPersistenceController implements RepositoryDAO {
    private final RepositoryDAO cardDao = SuperApplication.getDatabaseApplication().repositoryDAO();


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
