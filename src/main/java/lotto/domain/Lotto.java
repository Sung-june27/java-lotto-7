package lotto.domain;

import java.util.List;
import lotto.common.constants.ErrorMessages;
import lotto.common.Winning;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.INCORRECT_WINNING_NUMBER_COUNT);
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER_FOUND);
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        List<Integer> after = numbers.stream().distinct().toList();
        return numbers.size() != after.size();
    }

    // TODO: 추가 기능 구현
    public Winning checkWinnings(List<Integer> winningNumbers, int bonus) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }

        if (count == 5 && numbers.contains(bonus)) {
            count = 7;
        }

        return Winning.of(count);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}