package pairs;

public class HighScore extends Pair<String, Integer> {
    public HighScore(String username, Integer score) {
        super(username, score);
    }

    public String getUsername() {
        return super.getFirst();
    }

    public void setUsername(String username) {
        this.first = username;
    }

    public Integer getScore() {
        return super.getSecond();
    }

    public void setScore(Integer score) {
        super.second = score;
    }

    @Override
    public String toString() {
        return this.first + ": " + this.second;
    }
}
