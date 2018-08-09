package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response;

import com.google.gson.annotations.SerializedName;

import coopcerto.br.com.cabal.testgithubapplicaiton.model.UserEntry;

public class RepositoriesReponse {

    private int number;
    private String title;
    private boolean locked;
    @SerializedName("html_url")
    private String htmlUrl;
    private UserEntry user;

    public UserEntry getUser() {
        return user;
    }

    public void setUser(UserEntry user) {
        this.user = user;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

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