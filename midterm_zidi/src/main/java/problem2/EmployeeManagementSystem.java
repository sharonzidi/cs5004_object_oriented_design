package problem2;

import java.security.PublicKey;

public class EmployeeManagementSystem implements IEmployeeManagementSystem {
    private Node head;
    private int numOfNode;

    public EmployeeManagementSystem() {
        this.head = null;
        this.numOfNode = 0;
    }

    public static EmployeeManagementSystem createEmpty() {
        return new EmployeeManagementSystem();
    }

    public boolean isEmpty() {
        Node cur = this.head;
        if (cur == null) {
            return true;
        }
        return false;
    }


    public int count() {
        return numOfNode;
    }

    public void append(Employee employee) throws DuplicateEmployeeException {
        if (employee == null) {
            throw new DuplicateEmployeeException("There's no such an employee");
        }
        Node newNode = new Node(employee, null);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node curNode = this.head;
            while (curNode.getNextNode() != null) {
                curNode = curNode.getNextNode();
            }
            curNode.setNextNode(newNode);
        }
        this.numOfNode++;
    }

    public void remove(Employee employee) throws EmployeeNotFoundException {
        Node dummy = new Node(null, head);
        Node cur = dummy;

        while (cur != null) {
            if (cur.getNextNode() == null || !cur.getNextNode().getEmployee().equals(employee)) {
                cur = cur.getNextNode();
                continue;
            }

            Node next = cur.getNextNode();
            cur.setNextNode(next.getNextNode());
            next.setNextNode(null);

            this.numOfNode--;
        }

        if (cur == null) {
            throw new EmployeeNotFoundException("Employee Not Found!");
        }

        this.head = dummy.getNextNode();
    }


    public Boolean checkEmployee(Employee employee) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.getEmployee().equals(employee)) {
                return true;
            }

            cur = cur.getNextNode();
        }

        return false;
    }


    public EmployeeManagementSystem findEmployeeByYear(Integer yearJoinedCompany) throws DuplicateEmployeeException {
        EmployeeManagementSystem newList = createEmpty();

        Node cur = this.head;
        int i = 0;
        while (i < numOfNode) {
            i++;
            while (!cur.getEmployee().getYearJoinedCompany().equals(yearJoinedCompany)) {
                cur = cur.getNextNode();
            }
            newList.append(cur.getEmployee());
        }
        return newList;
    }


    public EmployeeManagementSystem findEmployeeBySalary(Double annualEarnings) throws DuplicateEmployeeException {
        EmployeeManagementSystem newList = createEmpty();

        Node cur = this.head;
        int i = 0;
        while (i < numOfNode) {
            i++;
            while (!cur.getEmployee().getAnnualEarnings().equals(annualEarnings)) {
                cur = cur.getNextNode();
            }
            newList.append(cur.getEmployee());
        }
        return newList;

    }

    public EmployeeManagementSystem findEmployeeByPromotionYear(Integer yearLastPromoted) throws DuplicateEmployeeException{
        EmployeeManagementSystem newList = createEmpty();

        Node cur = this.head;
        int i = 0;
        while (i < numOfNode) {
            i++;
            while (!cur.getEmployee().getYearLastPromoted().equals(yearLastPromoted)) {
                cur = cur.getNextNode();
            }
            newList.append(cur.getEmployee());
        }
        return newList;

    }

    public Employee getEmployeeByID(String employeeID) throws InvalidEmployeeIDException {
        Node cur = this.head;
        while (!cur.getEmployee().getEmployeeID().equals(employeeID)) {
            cur = cur.getNextNode();
        }

        if (cur.getEmployee() == null) {
            throw new InvalidEmployeeIDException("Invalid ID");
        }
        return cur.getEmployee();
    }
}
