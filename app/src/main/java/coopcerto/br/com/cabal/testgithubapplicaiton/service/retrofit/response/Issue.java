package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response;

import com.google.gson.annotations.SerializedName;

public class Issue {
    private int number;
    private String title;

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
}
