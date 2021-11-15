package baseball;

public class Judgement {
    private int strike;
    private int ball;

    public Judgement(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
