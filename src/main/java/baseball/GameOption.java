package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameOption {
    private InputView inputView;
    private OutputView outputView;
    private int ballNumber;

    public GameOption(InputView inputView, OutputView outputView, int ballNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ballNumber = ballNumber;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public int getBallNumber() {
        return ballNumber;
    }
}
