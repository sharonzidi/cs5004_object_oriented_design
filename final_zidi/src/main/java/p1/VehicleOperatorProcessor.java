package p1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VehicleOperatorProcessor {
  private List<VehicleOperator> operators;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    VehicleOperatorProcessor that = (VehicleOperatorProcessor) o;
    return Objects.equals(operators, that.operators);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operators);
  }

  @Override
  public String toString() {
    return "VehicleOperatorProcessor{" +
            "operators=" + operators +
            '}';
  }

  public VehicleOperatorProcessor(List<VehicleOperator> operators) {
    this.operators = operators;
  }

  private VehicleOperatorProcessor(VehicleOperator operator1, VehicleOperator operator2){
    this.operators.add(operator1);
    this.operators.add(operator2);
  }

  /**
   * This is a filter method which take the input of operator, make and vehicle model.
   * To find all operators' vehicle that have the same make and model as input.
   * @param operator the Vehicle Operator.
   * @param make a string represent the make method of the vehicle.
   * @param model a string the model of the vehicle.
   * @return List<Vehicle> a list of vehicle.
   */
  public static List<Vehicle> mysteryMethod(VehicleOperator operator, String make, String model){
    return operator.getOperatedVehicles().stream()
        .filter(x -> x.getMake().equals(make) && x.getModel().equals(model))
        .collect(Collectors.toList());
  }

  /**
   * filterByManufacturingYear function is to return the list of names of all VehicleOperators who operate at least one vehicle
   * older than or equal to the input argument manufacturingYear.
   * @param manufacturingYear a LocalDate the represent the manufacturing year of the vehicle.
   * @return List<String> a list of vehicle operators' name.
   */
  public List<String> filterByManufacturingYear(LocalDate manufacturingYear){
    List<String> res = new ArrayList<>();

    operators.stream().forEach(x -> {
      List<Vehicle> cars = x.getOperatedVehicles().stream().filter(v -> v.getYearManufactured().compareTo(manufacturingYear) <= 0).collect(Collectors.toList());
      if(cars.size() > 0) {
        res.add(x.getName());
      }
    });
    return res;
  }
}
