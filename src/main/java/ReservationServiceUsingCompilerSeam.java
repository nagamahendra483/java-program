
import java.util.List;

public class ReservationServiceUsingCompilerSeam {
	private RankingService rankingService;
	private final boolean isTestMode;

	public ReservationServiceUsingCompilerSeam(boolean testMode) {
		this.isTestMode = testMode;
	}

	public RankingService getRankingService() {
		return rankingService;
	}
	
	public void reserve (List<Customer> customers) {
		if (isTestMode) {
			this.rankingService = new FakeRankingService();
		} else {
			this.rankingService = new RankingService();
		}
		rankingService.setAllCustomersRank(customers);
	}
		
}
