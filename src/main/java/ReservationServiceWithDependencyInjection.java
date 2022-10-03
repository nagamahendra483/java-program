
import java.util.List;

public class ReservationServiceWithDependencyInjection {
	private final RankingService rankingService;

	public ReservationServiceWithDependencyInjection(RankingService rankingService) {
		this.rankingService = rankingService;
	}

	public RankingService getRankingService() {
		return rankingService;
	}
	
	public void reserve (List<Customer> customers) {
		rankingService.setAllCustomersRank(customers);
	}
		
}
