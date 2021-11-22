
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private String team;
    private int games;

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGames() {
        return games;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return assists + goals;
    }

    @Override
    public String toString() {
        int points = goals + assists;
        return String.format("%-20s  %s\t%3d %s %3d %s %3d", name, team, goals, "+", assists, "=", points);
    }
      
}
