import java.time.LocalDate;

public class Customer {

	private String name;
	private LocalDate dob;
	private LocalDate dateJoined;
	private PlanTier tier;
	private int rank;

	//	constuctor
	//	not instantiated with any rank because rankingservices will do that to a collection of customers
	public Customer (String name, LocalDate dob, LocalDate dateJoined, PlanTier tier) {
		this.name = name;
		this.dob = dob;
		this.dateJoined = dateJoined;
		this.tier = tier;
	}

	//	getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(LocalDate dateJoined) {
		this.dateJoined = dateJoined;
	}

	public PlanTier getTier() {
		return tier;
	}

	public void setTier(PlanTier tier) {
		this.tier = tier;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", dob=" + dob + ", dateJoined=" + dateJoined + ", tier=" + tier + "]";
	}

}
