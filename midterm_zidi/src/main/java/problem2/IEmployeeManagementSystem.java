package problem2;


/**
 * The interface Employee management system.
 */
public interface IEmployeeManagementSystem {
    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    boolean isEmpty();

    /**
     * Count int.
     *
     * @return the int
     */
    int count();

    /**
     * Append.
     *
     * @param employee the employee
     * @throws DuplicateEmployeeException the duplicate employee exception
     */
    void append(Employee employee) throws DuplicateEmployeeException;

    /**
     * Remove.
     *
     * @param employee the employee
     * @throws EmployeeNotFoundException the employee not found exception
     */
    void remove(Employee employee) throws EmployeeNotFoundException;

    /**
     * Contains boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    Boolean checkEmployee(Employee employee);

    /**
     * Find employee.
     *
     * @param yearJoinedCompany the year joined company
     * @return the employee
     * @throws DuplicateEmployeeException the duplicate employee exception
     */
    EmployeeManagementSystem findEmployeeByYear(Integer yearJoinedCompany) throws DuplicateEmployeeException;


    /**
     * Find employee by salary employee management system.
     *
     * @param annualEarnings the annual earnings
     * @return the employee management system
     * @throws DuplicateEmployeeException the duplicate employee exception
     */
    EmployeeManagementSystem findEmployeeBySalary(Double annualEarnings) throws DuplicateEmployeeException;

    EmployeeManagementSystem findEmployeeByPromotionYear(Integer yearLastPromoted) throws DuplicateEmployeeException;
    /**
     * Gets employee by id.
     *
     * @param employeeID the employee id
     * @return the employee by id
     */
    Employee getEmployeeByID(String employeeID) throws InvalidEmployeeIDException;

}
