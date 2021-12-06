package ohtu;

public class TennisGame {
    
    private int score1 = 0;
    private int score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            score1 += 1;
        else
            score2 += 1;
    }

    public String evenScorePrint() {
        int score = score1;
        String print;

        switch(score) {
            case 0:
                print = "Love-All";
                break;
            case 1:
                print = "Fifteen-All";
                break;
            case 2:
                print = "Thirty-All";
                break;
            case 3:
                print = "Forty-All";
                break;
            default:
                print = "Deuce";
                break;
        }

        return print;
    }

    public boolean gameEven() {
        if(score1 == score2) {
            return true;
        }
        return false;
    }

    public String advantagePrint(String player) {
        String print = "Advantage " + player;
        return print;
    }

    public String winPrint(String player) {
        String print = "Win for " + player;
        return print;
    }

    public String playerWithMorePoints() {
        if(score1 > score2) {
            return player1Name;
        }
        return player2Name;
    }

    public boolean isWin() {
        if(Math.abs(score1 - score2) > 1) {
            return true;
        }
        return false;
    }

    public boolean moreThanFourPoints() {
        if(score1 >=4 || score2 >= 4) {
            return true;
        }
        return false;
    }

    public String moreThanFourPointsPrint() {
        if(isWin()) {
            return winPrint(playerWithMorePoints());
        }
        return advantagePrint(playerWithMorePoints());
    }

    public String lessThanFourPointsPrint() {
        return scoreToPrint(score1) + "-" + scoreToPrint(score2);
    }

    public String scoreToPrint(int score) {
        if(score == 0) {
            return "Love";
        } else if (score == 1) {
            return "Fifteen";
        } else if (score == 2) {
            return "Thirty";
        }
        return "Forty";
    }

    public String getScore() {
        String score = "";
        if (gameEven()) {
            score = evenScorePrint();
        } else if (moreThanFourPoints()) {
            score = moreThanFourPointsPrint();
        } else {
            score = lessThanFourPointsPrint();
        }
        return score;
    }
}