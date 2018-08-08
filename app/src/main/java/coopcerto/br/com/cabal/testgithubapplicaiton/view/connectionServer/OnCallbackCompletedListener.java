package coopcerto.br.com.cabal.testgithubapplicaiton.view.connectionServer;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import coopcerto.br.com.cabal.testgithubapplicaiton.R;
import coopcerto.br.com.cabal.testgithubapplicaiton.util.AlertUtils;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.activities.SuperActivity;
import coopcerto.br.com.cabal.testgithubapplicaiton.view.objects.ErroResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class OnCallbackCompletedListener<T> implements OnCallbackListener<T>, Callback<T>, Serializable {
    private static final String ERRO_TIMEOUT = "timeout";
    private SuperActivity activity;
    private boolean loadDialog;
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

    public void showLoad() {
        AlertUtils.showLoadingDialog(activity);

    }


    private void hideLoad() {
        AlertUtils.hideLoadingDialog(activity);

    }

    public void showError(String s) {
        AlertUtils.showAlert(s, activity);
    }

}
