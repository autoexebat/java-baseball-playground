package calculator;

import java.util.Scanner;

public class CalculatorManager {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("계산식을 입력하세요.");
            String input = scanner.nextLine();
            StringCalculator stringCalculator = new StringCalculator();
            double result = stringCalculator.calculate(input);
            System.out.println("결과 : " + result);
        }
    }
}
