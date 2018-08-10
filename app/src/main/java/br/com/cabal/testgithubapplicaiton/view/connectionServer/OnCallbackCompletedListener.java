package br.com.cabal.testgithubapplicaiton.view.connectionServer;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import br.com.cabal.testgithubapplicaiton.R;
import br.com.cabal.testgithubapplicaiton.util.AlertUtils;
import br.com.cabal.testgithubapplicaiton.view.activities.SuperActivity;
import br.com.cabal.testgithubapplicaiton.view.objects.ErroResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class OnCallbackCompletedListener<T> implements OnCallbackListener<T>, Callback<T>, Serializable {
    private static final String ERRO_TIMEOUT = "timeout";
    private static final String NETWORK_ERRO = "Unable to resolve host \"api.github.com\": No address associated with hostname";
    private final SuperActivity activity;
    private final boolean loadDialog;
    private static int attemps = 2;

    private static boolean refreshingToken = false;
    private static Map<Call, OnCallbackCompletedListener<?>> waitingToken = new HashMap<>();

    protected OnCallbackCompletedListener(SuperActivity activity, boolean loadDialog) {
        this.activity = activity;
        this.loadDialog = loadDialog;
        if (loadDialog) {
            showLoad();
        }
    }

    protected OnCallbackCompletedListener(SuperActivity activity) {
        this(activity, true);
        if (loadDialog) {
            showLoad();
        }
    }


    @Override
    public void onSuccess(T response) {
        hideLoad();
        try {
            //TODO: SE TIVER MENSAGEM DE SUCESSO
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onError(ErroResponse erro) {
        hideLoad();
        if (erro != null && erro.getMessage() != null) {
            AlertUtils.showAlert(erro.getMessage(), activity);
        }
    }

    @Override
    public void onFaild(Throwable erro) {
        hideLoad();
        treatmentFailure(erro);

        switch (erro.getMessage()) {
            case NETWORK_ERRO:
                Toast.makeText(activity, activity.getString(R.string.erro_connection), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(activity, activity.getString(R.string.erro_default), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        try {
            hideLoad();
            int code = response.code();
            switch (code) {
                case 200:
                    onSuccess(response.body());
                    break;
            }

        } catch (Exception e) {
            hideLoad();
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        hideLoad();
        onFaild(t);
    }


    private ErroResponse getResponse(Response<T> response) {
        if (response != null && response.errorBody() != null) {
            assert response.errorBody() != null;
            return new Gson().fromJson(Objects.requireNonNull(response.errorBody()).charStream(), ErroResponse.class);
        } else {
            return null;
        }
    }


    private void treatmentFailure(Throwable t) {
        hideLoad();
        t.printStackTrace();
        if (t.getMessage() != null && t.getMessage().equals(ERRO_TIMEOUT)) {
            showError("Erro timeout");
        } else {
            showError("Sem conexão");
        }
    }


    public SuperActivity getActivity() {
        return activity;
    }

    public boolean isLoading() {
        return loadDialog;
    }

    private void showLoad() {
        AlertUtils.showLoadingDialog(activity);

    }


    private void hideLoad() {
        AlertUtils.hideLoadingDialog(activity);

    }

    private void showError(String s) {
        AlertUtils.showAlert(s, activity);
    }

}
