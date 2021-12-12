package statistics.matcher;

public class QueryBuilder {
    
    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new PlaysIn(team);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And(new HasAtLeast(value, category), this.matcher);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And(new HasFewerThan(value, category), this.matcher);
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }

    public Matcher build() {
        return matcher;
    }
}
