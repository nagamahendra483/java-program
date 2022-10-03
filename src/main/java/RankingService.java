
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RankingService {

	public int findCustomerRank(Customer customer) {
		return customer.getRank();
	}

	// sort based on who joined first
	public void setAllCustomersRank(List<Customer> customers) {
		customers.sort(Comparator.comparingLong(customer -> customer.getDateJoined().toEpochDay()));
		AtomicInteger rank = new AtomicInteger(1);
		customers.forEach(customer -> {
			customer.setRank(rank.getAndIncrement());
		});
	}
	
}
