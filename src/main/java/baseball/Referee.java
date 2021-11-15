package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private int count;
    private int strike;
    private int ball;

    public Referee(int count) {
        this.count = count;
    }

    public Judgement judgement(List<Ball> inputBalls, List<Ball> computedBalls) {
        for(int i=0; i<count; i++) {
            Ball b1 = inputBalls.get(i);
            Ball b2 = computedBalls.get(i);
            strikeCheck(b1, b2);
        }

        if(strike == count) {
            return new Judgement(strike, 0);
        }

        for(Ball ball : computedBalls) {
            ballCheck(inputBalls, ball);
        }

        return new Judgement(strike, ball);
    }

    private void strikeCheck(Ball b1, Ball b2) {
        if(b1.equals(b2)) {
            this.strike++;
        }
    }

    private void ballCheck(List<Ball> inputBalls, Ball ball) {
        List<Integer> ballNumbers = inputBalls.stream().map(b -> b.getNumber()).collect(Collectors.toList());
        int position = ball.getPosition();

        if(ballNumbers.contains(ball.getNumber()) && !ball.equals(inputBalls.get(position))) {
            this.ball++;
        }
    }
}
