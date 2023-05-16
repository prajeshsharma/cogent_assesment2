import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeDaoImpl implements EmployeeDao {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Employee> employees = new LinkedHashMap<>();

    @Override
    public void createEmployee() {
        System.out.println("Enter employee name");
        String name = sc.nextLine();
        System.out.println("Enter employee address");
        String address = sc.nextLine();
        System.out.println("Enter employee email");
        String email = sc.nextLine();
        while (isInvalidEmail(email)) {
            System.out.println("Enter valid email");
            email = sc.nextLine();
        }
        System.out.println("Enter employee salary");
        Double salary = sc.nextDouble();
        sc.nextLine();
        Employee e = new Employee(name, address, email, salary);
        employees.put(e.getId(), e);
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
        if (employees.containsKey(id)) System.out.println(employees.get(id).toString());
        else System.out.println("ID not found");

    }

    @Override
    public void sortEmployee() {
        List<Map.Entry<Integer, Employee>> entries = new ArrayList<>(employees.entrySet());
        entries.sort(Comparator.comparing(e -> e.getValue().getName()));
        for (Map.Entry<Integer, Employee> entry : entries) System.out.println(entry.toString());

    }

    public static boolean isInvalidEmail(String email) {
        // Regular expression pattern for email validation
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return !matcher.matches();
    }

}
