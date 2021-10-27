
import java.util.HashSet;
import java.util.Objects;

/**
 * Agent Class represents the person who are responsible for adding listings to the company site.
 * @param <T> Property class.
 * @param <U> Contract class.
 */
public class Agent<T extends Property, U extends  Contract> implements IAgent<T, U> {
  private String name;
  private HashSet<Listing<T, U>> currentList;
  private Double commissionRate;
  private Double earnings;

  /**
   * Constructor for Agent Class.
   * @param name Agent's name.
   * @param currentList collection of their current listings.
   * @param commissionRate the percentage of the contract amount that the agent takes as payment if
   * they successfully ell / rent the property in one of their listings.
   * @param earnings the total amount the Agent has earned from their sales / rentals.
   */
  public Agent(String name, HashSet<Listing<T, U>> currentList, Double commissionRate, Double earnings) {

    this.name = name;
    this.currentList = new HashSet<>();
    this.commissionRate = commissionRate;
    this.earnings = earnings;
  }


  /**
   * Adds an (appropriate) listing to the Agent’s current listing collection.
   * @param listing the listing to be added.
   */
  public void addListing(Listing<T, U> listing) throws DuplicateListingException {
    if (currentList.contains(listing)) {
      throw new DuplicateListingException();
    }
    this.currentList.add(listing);
  }

  /**
   * This method will be called when an Agent successfully makes a sale / rental of one of their
   * listings. Assuming the listing is part of their collection, this method should remove the
   * Listing from their collection and add their commission earnings to their total earnings amount.
   * @param listing the listing that the Agent completed.
   * @throws InvalidListingException if the listing is not in the collection.
   */
  @Override
  public void completeListing(Listing listing) throws InvalidListingException {
    if (!this.currentList.contains(listing)) {
      throw new InvalidListingException();
    }
    this.earnings = this.earnings + this.calculateCommission(listing);
    this.currentList.remove(listing);
  }

  /**
   * Drop a listing from the Agent’s collection without adjusting their earnings.
   * @param listing the listing need to be dropped.
   * @throws InvalidListingException if the listing is not in the collection.
   */
  @Override
  public void dropListing(Listing listing) throws InvalidListingException {
    if (!this.currentList.contains(listing)) {
      throw new InvalidListingException();
    }
    this.currentList.remove(listing);
  }

  /**
   * Calculates the amount of money the Agent would make if they successfully completed all listings
   * in their collection.
   * @return the amount of money the Agent would make if they successfully completed all listings in
   * their collection.
   */
  @Override
  public double getTotalPortfolioValue() {
    Double total = 0.0;
    for (Listing i: currentList) {
      total += this.calculateCommission(i);
    }
    return total;
  }

  private Double calculateCommission(Listing listing){
    return this.commissionRate * listing.getContract().calculateTotalGain();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Agent<?, ?> agent = (Agent<?, ?>) o;
    return Objects.equals(getName(), agent.getName()) && Objects
        .equals(getCurrentList(), agent.getCurrentList()) && Objects
        .equals(getCommissionRate(), agent.getCommissionRate()) && Objects
        .equals(getEarnings(), agent.getEarnings());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, currentList, commissionRate, earnings);
  }

  @Override
  public String toString() {
    return "Agent{" +
        "name='" + name + '\'' +
        ", currentList=" + currentList +
        ", commissionRate=" + commissionRate +
        ", earnings=" + earnings +
        '}';
  }

  /**
   * Get Agent name.
   * @return Agent's name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get current listing.
   * @return current listing.
   */
  public HashSet<Listing<T, U>> getCurrentList() {
    return this.currentList;
  }

  /**
   * Get the commission rate.
   * @return the commission rate.
   */
  public Double getCommissionRate() {
    return this.commissionRate;
  }

  /**
   * Get the total earnings.
   * @return the total earnings.
   */
  public Double getEarnings() {
    return this.earnings;
  }
}
