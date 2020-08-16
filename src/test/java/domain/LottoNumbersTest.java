package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("번호(Number)가 6개의 다른 값이 아니면 예외를 반환한다.")
    void numbersExceptionTest(String input) {
        String[] split = input.split(",");
        Set<Number> collect = Arrays.stream(split)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toSet());
        assertThatThrownBy(() -> new LottoNumbers(collect))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6=1,2,3,4,5,6", "2,3,4,5,6,7=2,3,4,5,6", "10,24,26,32,27,1=1"}, delimiter = '=')
    @DisplayName("자신이 가진 로또 번호와 제공된 로또 번호에서 일치하는 번호 리스트를 제공한다.")
    void getContainNumbersTest(String input, String expectedInput) {
        Set<Number> numbers = makeInputToNumbers(input);
        Set<Number> winningNumbers = makeInputToNumbers("1,2,3,4,5,6");

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbers);

        Set<Number> actual = lottoNumbers.getContainNumbers(winningLottoNumbers);

        Set<Number> expected = makeInputToNumbers(expectedInput);

        assertThat(actual).isEqualTo(expected);
    }

    private Set<Number> makeInputToNumbers(String input) {
        String[] split = input.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toSet());
    }

}