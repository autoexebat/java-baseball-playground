package baseball.view;

import baseball.Judgement;

public class OutputView {
    public void output(Judgement judgement) {
        if(judgement.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        String format = String.format("%d볼 %d스트라이크", judgement.getBall(), judgement.getStrike());
        System.out.println(format);
    }
}
