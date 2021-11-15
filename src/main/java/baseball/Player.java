package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String input;

    public Player(String input) {
        String validate = input.replaceAll("[0-9]", "");
        if(!validate.isEmpty() || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력값이 있습니다.");
        }
        this.input = input;
    }

    public List<Ball> getBalls() {
        List<Ball> balls = new ArrayList<>();
        for(int i=0; i<input.length(); i++) {
            Character ch = input.charAt(i);
            balls.add(new Ball(i, Integer.parseInt(ch.toString())));
        }
        return balls;
    }
}
