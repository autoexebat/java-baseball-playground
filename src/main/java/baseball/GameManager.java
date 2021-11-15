package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameManager {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new GameOption(new InputView(), new OutputView(), 3));
        baseballGame.play();
    }
}
