package ladder;

import ladder.domain.PlayersGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PlayersGroupTest {

    private static final List<String> playerNames = Arrays.asList("abc", "ddd", "john", "doe");

    @DisplayName("PlayersGroup 객체 생성 성공 테스트")
    @Test
    public void makePlayersGroupObject() {
        assertThatCode(() -> {
            PlayersGroup.of(playerNames);
        }).doesNotThrowAnyException();
    }

    @DisplayName("PlayersGroup 크기 == playerCounts 일치 테스트")
    @Test
    public void getPlayerCounts() {
        PlayersGroup playersGroup = PlayersGroup.of(playerNames);

        assertThat(playersGroup.getPlayerCounts())
                .isEqualTo(4);
    }

    @DisplayName("Player들의 이름 명단(String)만 추출하는 테스트")
    @Test
    public void getPlayerNames() {
        PlayersGroup playersGroup = PlayersGroup.of(playerNames);

        List<String> pickedPlayerNames = playersGroup.getPlayerNames();

        assertThat(playerNames).isEqualTo(pickedPlayerNames);
    }
}