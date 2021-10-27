package p1;

import java.time.LocalDate;
import java.util.List;

public class VehicleOperator {

  private String name;
  private String drivingLicenseNumber;
  private LocalDate dateOfBirth;
  private List<Vehicle> operatedVehicles;

  public VehicleOperator(String name, String drivingLicenseNumber,
                         LocalDate dateOfBirth, List<Vehicle> operatedVehicles) {
    this.name = name;
    this.drivingLicenseNumber = drivingLicenseNumber;
    this.dateOfBirth = dateOfBirth;
    this.operatedVehicles = operatedVehicles;
  }

  public String getName() {
    return name;
  }

  public String getDrivingLicenseNumber() {
    return drivingLicenseNumber;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public List<Vehicle> getOperatedVehicles() {
    return operatedVehicles;
  }
}
