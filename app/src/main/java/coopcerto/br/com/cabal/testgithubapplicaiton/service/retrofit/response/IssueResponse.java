package coopcerto.br.com.cabal.testgithubapplicaiton.service.retrofit.response;

import java.util.List;

public class IssueResponse {
    private List<Issue> items;

    public List<Issue> getItems() {
        return items;
    }

    public void setItems(List<Issue> items) {
        this.items = items;
    }
}
