package coopcerto.br.com.cabal.testgithubapplicaiton.view.activities;

import android.os.Bundle;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.controller.RepositoriesController;
import coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response.PullRequestResponse;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer.OnCallbackCompletedListener;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.objects.ErroResponse;

public class MainActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RepositoriesController.getRepositoriesFromName("aplicação em java", new OnCallbackCompletedListener<PullRequestResponse>(this, false) {
            @Override
            public void onSuccess(PullRequestResponse response) {
                super.onSuccess(response);
            }

            @Override
            public void onError(ErroResponse erro) {
                super.onError(erro);
            }

            @Override
            public void onFaild(Throwable erro) {
                super.onFaild(erro);
            }
        });
    }
}
