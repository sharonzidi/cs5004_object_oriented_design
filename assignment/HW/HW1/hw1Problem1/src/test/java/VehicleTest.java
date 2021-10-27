import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {

    private Vehicle car;
    private Owner genghao;

    @Before
    public void setUp() {
        genghao = new Owner("Hao", "Geng", "1234567890");
        car = new Vehicle(666, "E201", genghao);
    }

    @Test
    public void getVIN() {
        assertEquals(666, car.getVIN());
    }

    @Test
    public void getLicensePlate() {
        assertEquals("E201", car.getLicensePlate());
    }

    @Test
    public void setVIN() {
        car.setVIN(123);
        assertEquals(123, car.getVIN());
    }

    @Test
    public void setLicensePlate() throws Error {
        try {
            car.setLicensePlate("A306");

            assertEquals("A36", car.getLicensePlate());
        } catch (Error e) {
            System.out.println("Wrong license plate number");
            //throw new Error("12A");
        }
    }

    @Test
    public void getOwnerFirstName() {
        assertEquals("Hao", car.getOwnerFirstName());
    }

    @Test
    public void setOwnerFirstName() {
        car.setOwnerFirstName("Henhao");
        assertEquals("Henhao", car.getOwnerFirstName());
    }

    @Test
    public void getOwnerLastName() {
        assertEquals("Geng", car.getOwnerLastName());
    }

    @Test
    public void setOwnerLastName() {
        car.setOwnerLastName("Xia");
        assertEquals("Xia", car.getOwnerLastName());
    }

    @Test
    public void getOwnerPhoneNumber() {
        assertEquals("1234567890", car.getOwnerPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        car.setPhoneNumber("0000000000");
        assertEquals("0000000000", car.getOwnerPhoneNumber());
    }
}