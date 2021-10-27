import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListingTest {
  Listing<Property,Contract> listingPropertyContract;
  Listing<Commercial,Sale> listingCommercialSale;
  Listing<Commercial,Sale> listingCommercialSaleSecond;
  Property propertyResidential;
  Property propertyCommercial;
  Property propertyCommercialSecond;
  Contract contractRental;
  Contract contractSale;
  Contract contractSaleSecond;
  @Before
  public void setUp() throws Exception {
    propertyCommercial = new Commercial("Wonderland",299,3,true);
    propertyCommercialSecond =
        new Commercial("Earth",199,3,true);
    propertyResidential = new Residential("Rabbit hole",49,2,
        1.5);
    contractRental = new Rental(2727.27,true,8);
    contractSale = new Sale(2233.33,false);
    contractSaleSecond = new Sale(2233.33,true);
    listingPropertyContract = new Listing<>(propertyCommercial,contractRental);//？<>
    listingCommercialSale = new Listing(propertyCommercial,contractSale);//？no <>
    listingCommercialSaleSecond = new Listing(propertyCommercial,contractSaleSecond);//？no <>
  }

  @Test
  public void getProperty() {
    assertTrue(propertyCommercial.equals(listingCommercialSale.getProperty()));
  }
  @Test
  public void testEquals() {
    Listing<Property,Contract> copyListingPropertyContract = listingPropertyContract;
    assertTrue(copyListingPropertyContract.equals(listingPropertyContract));
    assertFalse(listingCommercialSale.equals(listingPropertyContract));
    assertFalse(listingCommercialSale.equals(listingCommercialSaleSecond));
    assertFalse(listingCommercialSale == null);
    assertFalse(listingCommercialSale .equals(listingCommercialSale.contract));
  }

  @Test
  public void testHashCode() {
    Listing<Property,Contract> copyListingPropertyContract = listingPropertyContract;
    assertTrue(copyListingPropertyContract.hashCode() ==
        listingPropertyContract.hashCode());
  }

  @Test
  public void testToString() {
    String result = "Listing{property=Property{address=Wonderland, size=299}Commercial{"
        + "numOfOffice=3, ifRetail=true}, contract=Contract{price=2233.33, "
        + "negotiable=false}Sale{}}";
    assertEquals(result,listingCommercialSale.toString());
  }
}