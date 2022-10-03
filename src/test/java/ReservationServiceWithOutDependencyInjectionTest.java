import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class ReservationServiceWithOutDependencyInjectionTest {

    @Test
    void shouldReturnFakeRankingService() {
        RankingServiceFactory.setTestMode(true);
        ReservationServiceWithOutDependencyInjection service = new ReservationServiceWithOutDependencyInjection();
        service.reserve(Collections.emptyList());
        Assertions.assertNotNull(service.getRankingService());
        Assertions.assertTrue(service.getRankingService() instanceof FakeRankingService);
    }

    @Test
    void shouldReturnActualRankingService() {
        RankingServiceFactory.setTestMode(false);
        ReservationServiceWithOutDependencyInjection service = new ReservationServiceWithOutDependencyInjection();
        service.reserve(Collections.emptyList());
        Assertions.assertNotNull(service.getRankingService());
        Assertions.assertFalse(service.getRankingService() instanceof FakeRankingService);
    }
}
