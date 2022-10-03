import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FakeRankingService extends RankingService {

	@Override
	public void setAllCustomersRank(List<Customer> customers) {
		AtomicInteger rank = new AtomicInteger(1);
		customers.forEach(customer -> {
			customer.setRank(rank.getAndIncrement());
		});
	}

}
