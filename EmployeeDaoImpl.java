import java.util.*;

public class EmployeeDaoImpl implements EmployeeDao {
    Scanner sc = new Scanner(System.in);
    List<Employee> employees = new ArrayList<>();

    @Override
    public void createEmployee() {
        System.out.println("Enter employee name");
        String name = sc.nextLine();
        System.out.println("Enter employee address");
        String address = sc.nextLine();
        System.out.println("Enter employee email");
        String email = sc.nextLine();
        System.out.println("Enter employee salary");
        Double salary = sc.nextDouble();
        sc.nextLine();
        employees.add(new Employee(employees.size(), name, address, email, salary));
    }

    @Override
    public void updateEmployee() {
        System.out.println("Enter ID of employee");
        int id = sc.nextInt();
        sc.nextLine();
        for (Employee employee : employees)
            if (employee.getNumber() == id) {
                System.out.println("Enter new name");
                employee.setName(sc.nextLine());
                System.out.println("Enter new address");
                employee.setAddress(sc.nextLine());
                System.out.println("Enter new email");
                employee.setEmail(sc.nextLine());
                System.out.println("Enter new salary");
                employee.setSalary(sc.nextDouble());
                sc.nextLine();
                return;
            }
        System.out.println("ID not found");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Enter employee ID");
        int id = sc.nextInt();
        sc.nextLine();
        for (Employee employee : employees)
            if (employee.getNumber() == id) {
                employees.remove(employee);
                return;
            }
        System.out.println("ID not found");
    }

    @Override
    public void readEmployees() {
        for (Employee employee : employees)
            System.out.println(employee.toString());
    }

    @Override
    public void searchEmployee() {
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();
        sc.nextLine();
        for (Employee employee : employees)
            if (employee.getNumber() == id) {
                System.out.println(employee);
                return;
            }
        System.out.println("ID not found");

    }

    @Override
    public void sortEmployee() {
        employees.sort(new SortByName());
    }

}

class SortByName implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
