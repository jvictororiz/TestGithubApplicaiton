package br.com.cabal.testgithubapplicaiton;

import android.app.Application;
import android.arch.persistence.room.Room;

import br.com.cabal.testgithubapplicaiton.model.persistence.DatabaseApplication;

public class SuperApplication extends Application {
    private static final String DATABASE_NAME = "BASE_GITHUB_PERSISTENCE";

    private static DatabaseApplication databaseApplication;

    private static SuperApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        databaseApplication = Room.databaseBuilder(getApplicationContext(),
                DatabaseApplication.class, DATABASE_NAME).allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();
    }

    public static SuperApplication getInstance() {
        return instance;
    }

    public static void setInstance(SuperApplication instance) {
        SuperApplication.instance = instance;
    }

    public static DatabaseApplication getDatabaseApplication() {
        return databaseApplication;
    }

    public static void setDatabaseApplication(DatabaseApplication databaseApplication) {
        SuperApplication.databaseApplication = databaseApplication;
    }
}
