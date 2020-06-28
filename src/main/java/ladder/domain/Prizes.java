package ladder.domain;

import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prizes {

    public static final String LADDER_RESULTS_NULL_EXCEPTION = "결과값은 빈값으로 입력할 수 없습니다.";

    private static final String PRIZE_VALUE_FORMAT = "%6s";

    private final List<String> prizes;

    private Prizes(List<String> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(String prizes){
        validatePrizesString(prizes);
        return new Prizes(convertToList(prizes));
    }

    private static void validatePrizesString(String prizes) {
        if (Objects.isNull(prizes) || prizes.isEmpty()){
            throw new IllegalArgumentException(LADDER_RESULTS_NULL_EXCEPTION);
        }
    }

    private static List<String> convertToList(String ladderResults) {
        return Arrays.stream(StringUtil.split(ladderResults))
                     .collect(Collectors.toList());
    }

    public List<String> getPrizes() {
        return prizes;
    }

    public int count(){
        return prizes.size();
    }

    public String getPrizeValue(int prizeLocation) {
        return prizes.get(prizeLocation);
    }

    private static String formatWord(String name) {
        return String.format(PRIZE_VALUE_FORMAT, name);
    }

    @Override
    public String toString() {
        return prizes.stream()
                     .map(result -> formatWord(result))
                     .collect(Collectors.joining());
    }
}