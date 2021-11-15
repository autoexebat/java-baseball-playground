package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private InputView inputView;
    private OutputView outputView;
    private boolean playground;
    private boolean restart;
    private int ballCount;

    public BaseballGame(GameOption option) {
        this.inputView = option.getInputView();
        this.outputView = option.getOutputView();
        this.ballCount = option.getBallNumber();
        this.playground = true;
        this.restart = true;
    }

    private void playGround(Computer computer) {
        String input = inputView.input();
        Player player = new Player(input);

        Referee referee = new Referee(ballCount);
        Judgement judgement = referee.judgement(computer.getBalls(), player.getBalls());

        outputView.output(judgement);

        if(judgement.getStrike() == 3) {
            this.playground = false;
        }
    }

    private void gameStart() {
        Computer computer = new Computer(ballCount);
        while(playground) {
            playGround(computer);
        }

        String start = inputView.start();
        if(!"1".equals(start)) {
            System.exit(0);
        }

        this.playground = true;
        this.restart = true;
    }

    public void play() {
        while(restart) {
            gameStart();
        }
    }

}
