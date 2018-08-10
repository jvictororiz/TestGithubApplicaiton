package br.com.cabal.testgithubapplicaiton.view.connectionServer;

import br.com.cabal.testgithubapplicaiton.view.objects.ErroResponse;

public interface OnCallbackListener<T>{


     void onSuccess(T response);

     void onError(ErroResponse erro);

     void onFaild(Throwable erro);

}
