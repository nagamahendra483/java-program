
import java.util.List;

public class ReservationServiceWithOutDependencyInjection {
	private final RankingService rankingService;

	public ReservationServiceWithOutDependencyInjection() {
		this.rankingService = RankingServiceFactory.getRankingService();
	}

	public RankingService getRankingService() {
		return rankingService;
	}
	
	public void reserve (List<Customer> customers) {
		rankingService.setAllCustomersRank(customers);
	}
		
}
