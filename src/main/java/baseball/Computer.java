package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {
    private int count;

    public Computer(int count) {
        this.count = count;
    }

    public List<Ball> ballGenerate() {
        List<Integer> candidates = IntStream.range(0, 9).boxed().collect(Collectors.toList());
        Collections.shuffle(candidates);
        List<Integer> candidateList = new ArrayList<>(candidates.subList(0, count));

        List<Ball> balls = new ArrayList<>();
        for(int i=0; i<count; i++) {
            balls.add(new Ball(i, candidateList.get(i)));
        }
        return balls;
    }
}
