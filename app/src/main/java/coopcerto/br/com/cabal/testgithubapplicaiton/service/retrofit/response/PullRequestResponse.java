package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import coopcerto.br.com.cabal.testgithubapplicaiton.model.Issue;

public class PullRequestResponse {

    private int number;
    private String title;
    private boolean locked;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}