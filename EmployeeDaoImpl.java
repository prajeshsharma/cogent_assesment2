import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeDaoImpl implements EmployeeDao {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Employee> employees = new LinkedHashMap<>();

    @Override
    public void createEmployee() {
        Employee employee = new Employee();
        System.out.println("Enter employee name");
        employee.setName(sc.nextLine());
        System.out.println("Enter employee address");
        employee.setAddress(sc.nextLine());
        System.out.println("Enter employee email");
        String email = sc.nextLine();
        while (isInvalidEmail(email)) {
            System.out.println("Enter valid email");
            email = sc.nextLine();
        }
        employee.setEmail(email);
        System.out.println("Enter Salary");
        employee.setSalary(sc.nextDouble());
        sc.nextLine();
        employees.put(employee.getId(), employee);
    }

    @Override
    public void updateEmployee() {
        System.out.println("Enter ID of employee");
        int id = sc.nextInt();
        sc.nextLine();
        if (employees.containsKey(id)) {
            System.out.println("Enter new name");
            employees.get(id).setName(sc.nextLine());
            System.out.println("Enter new address");
            employees.get(id).setAddress(sc.nextLine());
            System.out.println("Enter new email");
            String email = sc.nextLine();
            while (isInvalidEmail(email)) {
                System.out.println("Enter valid email");
                email = sc.nextLine();
            }
            employees.get(id).setEmail(email);
            System.out.println("Enter new salary");
            employees.get(id).setSalary(sc.nextDouble());
            sc.nextLine();
        } else System.out.println("ID not found");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Enter employee ID");
        int id = sc.nextInt();
        sc.nextLine();
        if (employees.containsKey(id)) employees.remove(id);
        else System.out.println("ID not found");
    }

    @Override
    public void readEmployees() {
        employees.values().forEach(System.out::println);
    }

    @Override
    public void searchEmployee() {
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println(employees.containsKey(id) ? employees.get(id).toString() : "ID not found");

    }

    @Override
    public void sortEmployee() {
        List<Employee> employeeList = new ArrayList<>(employees.values());
        Collections.sort(employeeList);
        for (Employee employee : employeeList) System.out.println(employee);
    }

    public static boolean isInvalidEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

}
