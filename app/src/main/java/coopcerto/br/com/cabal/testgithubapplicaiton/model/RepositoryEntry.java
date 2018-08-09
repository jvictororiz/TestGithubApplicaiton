package coopcerto.br.com.cabal.testgithubapplicaiton.model;

public class RepositoryEntry {
    private int number;
    private String title;
    private boolean locked;
    private int comments;
    private double score;
    private String body;
    private UserEntry user;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserEntry getUser() {
        return user;
    }

    public void setUser(UserEntry user) {
        this.user = user;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
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
}
