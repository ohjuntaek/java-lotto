package domain;

import java.util.Objects;
import java.util.Random;

public class Number implements Comparable<Number> {
    private static final Random random = new Random();
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("1 이상 45 이하의 값을 입력해주세요.");
        }
    }

    public static Number generateNumber() {
        int randomNumber = random.nextInt(LOTTO_NUMBER_MAX) + LOTTO_NUMBER_MIN;
        return new Number(randomNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override public String toString() {
        return String.valueOf(number);
    }


    @Override public int compareTo(Number o) {
        return this.number - o.number;
    }
}
