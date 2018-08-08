package coopcerto.br.com.cabal.testgithubapplicaiton;

import android.app.Application;

public class SuperApplication extends Application {

    private static SuperApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static SuperApplication getInstance() {
        return instance;
    }

    public static void setInstance(SuperApplication instance) {
        SuperApplication.instance = instance;
    }
}
