import static org.junit.Assert.*;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

public class AgentTest {
  Agent<Residential, Rental> agent;
  Agent<Residential, Rental> agent1;
  Agent<Commercial, Sale> agent2;
  Agent<Property, Contract> agent3;
  Listing<Residential, Rental> listing;
  Listing<Residential, Rental> listing1;
  Listing<Commercial, Sale> listing2;
  Listing<Property, Contract> listing3;
  Rental rental;
  Rental rental1;
  Sale sale;
  Residential residential;
  Residential residential1;
  Commercial commercial;

  @Before
  public void setUp() throws Exception {
    rental = new Rental(3000.0, false, 12);
    rental1 = new Rental(2500.0, true, 13);
    residential = new Residential("111 Ave", 1000, 2,
        2.0);
    residential1 = new Residential("5901 Center Dr", 800, 1,
        1.0);
    sale = new Sale(700000.0, true);
    commercial = new Commercial("100 Ave", 700, 2, true);
    listing = new Listing(residential, rental);
    listing1 = new Listing(residential1,rental1);
    listing2 = new Listing(commercial, sale);
    listing3 = new Listing(residential1, sale);
    agent = new Agent("Nina", null, 0.6, 50000.0);
    agent2 = new Agent("Nina", null, 0.6, 50000.0);
    agent3 = new Agent("Nina", null, 0.6, 50000.0);
  }

  @Test
  public void addListing() throws Exception{
    agent.addListing(listing);
    agent2.addListing(listing2);
    agent3.addListing(listing3);
  }

  @Test (expected = DuplicateListingException.class)
  public void duplicateAdd() throws Exception{
    agent.addListing(listing);
    agent.addListing(listing);
  }

  @Test
  public void completeListing() throws Exception{
    agent.addListing(listing);
    agent.addListing(listing1);
    agent.completeListing(listing1);

    assertEquals(69500.0, agent.getEarnings(), 0.0);
    assertFalse(agent.getCurrentList().contains(listing1));
  }

  @Test (expected = InvalidListingException.class)
  public void invalidCompleteListing() throws Exception {
    agent.addListing(listing);
    agent.addListing(listing1);
    agent.completeListing(listing2);
  }

  @Test
  public void dropListing() throws Exception{
    agent.addListing(listing);
    agent.addListing(listing1);
    agent.dropListing(listing1);

    assertEquals(50000.0, agent.getEarnings(), 0.0);
    assertFalse(agent.getCurrentList().contains(listing1));
  }

  @Test (expected = InvalidListingException.class)
  public void invalidDropListing() throws Exception{
    agent.addListing(listing);
    agent.addListing(listing1);
    agent.dropListing(listing2);
  }

  @Test
  public void getTotalPortfolioValue() throws Exception{
    agent.addListing(listing);
    agent.addListing(listing1);

    assertEquals(41100.0, agent.getTotalPortfolioValue(), 0.0);
  }

  @Test
  public void getName() {
    assertEquals("Nina", agent.getName());
  }

  @Test
  public void getCurrentList() throws Exception{
    HashSet<Listing> listings = new HashSet<>();
    listings.add(listing);
    listings.add(listing1);

    agent.addListing(listing);
    agent.addListing(listing1);

    assertEquals(listings, agent.getCurrentList());
  }

  @Test
  public void getCommissionRate() {
    assertEquals(0.6, agent.getCommissionRate(), 0.0);
  }

  @Test
  public void getEarnings() {
    assertEquals(50000.0, agent.getEarnings(), 0.0);
  }

  @Test
  public void testEquals() throws Exception{
    agent1 = new Agent("Nina", null, 0.6,
        50000.0);
    assertEquals(agent, agent);
    assertEquals(agent, agent1);
    agent1.addListing(listing);
    assertNotEquals(agent, agent1);
    assertNotEquals(null, agent);
    assertNotEquals(agent1, null);
    assertNotEquals(agent, listing);
    agent1 = new Agent("Jessica", null, 0.6,
        50000.0);
    assertNotEquals(agent, agent1);
    agent1 = new Agent("Nina", null, 0.6,
        30000.0);
    assertNotEquals(agent, agent1);
  }

  @Test
  public void testHashCode() throws Exception{
    agent1 = new Agent("Nina", null, 0.6,
        50000.0);
    agent.addListing(listing);
    agent1.addListing(listing);
    assertEquals(agent.hashCode(), agent1.hashCode());
    agent1.addListing(listing1);
    assertNotEquals(agent.hashCode(), agent1.hashCode());
  }

  @Test
  public void testToString() throws Exception{
    agent.addListing(listing);
    String result = "Agent{name='Nina', currentList=[Listing{property=Property{address=111 Ave, "
        + "size=1000}Residential{numOfBedrooms=2, numOfBathrooms=2.0}, contract=Contract{"
        + "price=3000.0, negotiable=false}Rental{leasingTerm=12}}], commissionRate=0.6, "
        + "earnings=50000.0}";
    assertEquals(result, agent.toString());
  }
}
