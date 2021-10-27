public interface IAgent<T extends Property, U extends Contract> {

  /**
   * Adds an (appropriate) listing to the Agent’s current listing collection.
   * @param listing the listing to be added.
   */
  void addListing(Listing<T, U> listing) throws DuplicateListingException;

  /**
   * This method will be called when an Agent successfully makes a sale / rental of one of their
   * listings. Assuming the listing is part of their collection, this method should remove the
   * Listing from their collection and add their commission earnings to their total earnings amount.
   * @param listing the listing that the Agent completed.
   * @throws InvalidListingException if the listing is not in the collection.
   */
  void completeListing(Listing listing) throws InvalidListingException;

  /**
   * Drop a listing from the Agent’s collection without adjusting their earnings.
   * @param listing the listing need to be dropped.
   * @throws InvalidListingException if the listing is not in the collection.
   */
  void dropListing(Listing listing) throws InvalidListingException;

  /**
   * Calculates the amount of money the Agent would make if they successfully completed all listings
   * in their collection.
   * @return the amount of money the Agent would make if they successfully completed all listings in
   * their collection.
   */
  double getTotalPortfolioValue();
}