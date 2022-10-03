import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class ReservationServiceUsingCompilerSeamTest {
    @Test
    void shouldReturnActualRankingService() {
        ReservationServiceUsingCompilerSeam seam = new ReservationServiceUsingCompilerSeam(false);
        seam.reserve(Collections.emptyList());
        Assertions.assertNotNull(seam.getRankingService());
        Assertions.assertFalse(seam.getRankingService() instanceof FakeRankingService);
    }

    @Test
    void shouldReturnFakeRankingService() {
        ReservationServiceUsingCompilerSeam seam = new ReservationServiceUsingCompilerSeam(true);
        seam.reserve(Collections.emptyList());
        Assertions.assertNotNull(seam.getRankingService());
        Assertions.assertTrue(seam.getRankingService() instanceof FakeRankingService);
    }
}
