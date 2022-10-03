import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class ReservationServiceWithDependencyInjectionTest {
    @Test
    void shouldInvokeActualRankingService() {
        RankingService rankingService = Mockito.mock(RankingService.class);
        Mockito.doNothing().when(rankingService).setAllCustomersRank(any());
        ReservationServiceWithDependencyInjection service =
                new ReservationServiceWithDependencyInjection(rankingService);
        service.reserve(Collections.emptyList());
        Mockito.verify(rankingService, Mockito.times(1)).setAllCustomersRank(any());
        Assertions.assertFalse(service.getRankingService() instanceof FakeRankingService);
    }
    @Test
    void shouldInvokeFakeRankingService() {
        FakeRankingService rankingService = Mockito.mock(FakeRankingService.class);
        Mockito.doNothing().when(rankingService).setAllCustomersRank(any());
        ReservationServiceWithDependencyInjection service =
                new ReservationServiceWithDependencyInjection(rankingService);
        service.reserve(Collections.emptyList());
        Mockito.verify(rankingService, Mockito.times(1)).setAllCustomersRank(any());
        Assertions.assertTrue(service.getRankingService() instanceof FakeRankingService);
    }

    @Test
    void shouldAssignTheRanksUsingFakeRankingService() {
        FakeRankingService fakeRankingService = new FakeRankingService();
        ReservationServiceWithDependencyInjection service =
                new ReservationServiceWithDependencyInjection(fakeRankingService);
        List<Customer> customers = Arrays.asList(
                new Customer("Test1",LocalDate.of(1998, 8,4), LocalDate.now(), PlanTier.TIER1),
                new Customer("Test2",LocalDate.of(1998, 8,4), LocalDate.now().minusDays(2),PlanTier.TIER1)
        );
        service.reserve(customers);
        Assertions.assertEquals(2, customers.size());
        Customer customer1 = customers.get(0);
        Customer customer2 = customers.get(1);
        Assertions.assertEquals(1, fakeRankingService.findCustomerRank(customer1));
        Assertions.assertEquals("Test1", customer1.getName());
        Assertions.assertEquals(2, fakeRankingService.findCustomerRank(customer2));
        Assertions.assertEquals("Test2", customer2.getName());
    }

    @Test
    void shouldAssignTheRanksUsingActualRankingService() {
        RankingService rankingService = new RankingService();
        ReservationServiceWithDependencyInjection service =
                new ReservationServiceWithDependencyInjection(rankingService);
        List<Customer> customers = Arrays.asList(
                new Customer("Test1",LocalDate.of(1998, 8,4), LocalDate.now(), PlanTier.TIER1),
                new Customer("Test2",LocalDate.of(1998, 8,4), LocalDate.now().minusDays(2),PlanTier.TIER1)
        );
        // should rank based on when customer joined.
        service.reserve(customers);
        Assertions.assertEquals(2, customers.size());
        Customer customer1 = customers.get(0);
        Customer customer2 = customers.get(1);
        // as Test2 joined first he should have the first rank
        Assertions.assertEquals(1, rankingService.findCustomerRank(customer1));
        Assertions.assertEquals("Test2", customer1.getName());
        Assertions.assertEquals(2, rankingService.findCustomerRank(customer2));
        Assertions.assertEquals("Test1", customer2.getName());
    }
}
