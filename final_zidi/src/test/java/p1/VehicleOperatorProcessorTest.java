package p1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class VehicleOperatorProcessorTest {
    Vehicle v1;
    Vehicle v2;
    Vehicle v3;
    Vehicle v4;

    VehicleOperator operator1;
    VehicleOperator operator2;
    VehicleOperator operator3;

    VehicleOperatorProcessor vop1;

    @Before
    public void setUp() throws Exception {
        v1 = new Vehicle("1", "US", "Tesla", LocalDate.of(2020, 2, 23), 20.2f);
        v2 = new Vehicle("2", "China", "Tesla", LocalDate.of(2004, 2, 23), 20.2f);
        v3 = new Vehicle("3", "Japan", "Cammery", LocalDate.of(2020, 9, 23), 20.2f);
        v4 = new Vehicle("4", "US", "Tesla", LocalDate.of(2021, 3, 13), 120.2f);
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        vehicleList.add(v1);
        vehicleList.add(v2);
        vehicleList.add(v3);


        List<Vehicle> vehicleList1 = new ArrayList<Vehicle>();
        vehicleList1.add(v4);
        vehicleList1.add(v1);

        operator1 = new VehicleOperator("zi", "001", LocalDate.of(1997, 1, 1), vehicleList);
        operator2 = new VehicleOperator("di", "002", LocalDate.of(1997, 1, 1), vehicleList1);
        operator3 = new VehicleOperator("xia", "003", LocalDate.of(1997, 1, 1), vehicleList);

        List<VehicleOperator> operatorList = new ArrayList<VehicleOperator>();
        operatorList.add(operator1);
        operatorList.add(operator2);

        vop1 = new VehicleOperatorProcessor(operatorList);

    }

    @Test
    public void mysteryMethod() {
        List<Vehicle>  res = vop1.mysteryMethod(operator1, "US", "Tesla");
        assertEquals(1, res.size());
        Vehicle car = res.get(0);
        assertEquals("US", car.getMake());
        assertEquals("Tesla", car.getModel());
        assertEquals("1", car.getVehicleID());

        // Test meet two requirement
        List<Vehicle>  res1 = vop1.mysteryMethod(operator2, "US", "Tesla");
        assertEquals(2, res1.size());
        Vehicle car2 = res1.get(0);
        assertEquals("US", car2.getMake());
        assertEquals("Tesla", car2.getModel());
    }

    @Test
    public void mysteryMethodTestNotFound() {
        List<Vehicle>  res = vop1.mysteryMethod(operator1, "US", "Audi");
        assertEquals(0, res.size());
    }

    @Test
    public void filterByManufacturingYear() {
        List<String>  res = vop1.filterByManufacturingYear(LocalDate.of(2016, 3, 13));
        assertEquals(1, res.size());
        assertEquals("zi", res.get(0));
        List<String>  res2 = vop1.filterByManufacturingYear(LocalDate.of(2021, 3, 13));
        assertEquals(2, res2.size());
        List<String>  res3 = vop1.filterByManufacturingYear(LocalDate.of(1990, 3, 13));
        assertEquals(0, res3.size());
        List<String>  res4 = vop1.filterByManufacturingYear(LocalDate.of(2004, 2, 23));
        assertEquals(1, res4.size());
    }
}