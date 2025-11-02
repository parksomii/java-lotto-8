package lotto.model.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottosTest {
    @Test
    @DisplayName("여러 개의 로또를 올바르게 보관한다")
    void add_multiple_lottos() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(11,12,13,14,15,16));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        assertThat(lottos.tickets())
                .extracting(Lotto::getNumbers)
                .containsExactly(
                        List.of(1,2,3,4,5,6),
                        List.of(11,12,13,14,15,16)
                );
    }
}
