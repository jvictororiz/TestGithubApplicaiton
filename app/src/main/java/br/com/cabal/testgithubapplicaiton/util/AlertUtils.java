package br.com.cabal.testgithubapplicaiton.util;

import android.widget.Toast;

import br.com.cabal.testgithubapplicaiton.view.activities.SuperActivity;

public class AlertUtils {
    public static void showAlert(String message, SuperActivity activity) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();

    }

    public static void showLoadingDialog(SuperActivity activity) {
        Toast.makeText(activity, "Carregando", Toast.LENGTH_SHORT).show();
    }

    public static void hideLoadingDialog(SuperActivity activity) {

    }
}
