package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PullRequestResponse {
    @SerializedName("total_count")
    private int totalCount;
    private List<Issue> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Issue> getItems() {
        return items;
    }

    public void setItems(List<Issue> items) {
        this.items = items;
    }
}