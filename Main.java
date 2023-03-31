import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Menu");
            System.out.println("1: Create employee");
            System.out.println("2: Update employee");
            System.out.println("3: Delete employee");
            System.out.println("4: Print all employees");
            System.out.println("5: Search employee");
            System.out.println("6: Sort employee");
            System.out.println("7: exit");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) employeeDao.createEmployee(); // create employee
            else if (choice == 2) employeeDao.updateEmployee(); // update employee
            else if (choice == 3) employeeDao.deleteEmployee();// delete employee
            else if (choice == 4) employeeDao.readEmployees(); // print all employees
            else if (choice == 5) employeeDao.searchEmployee(); // search employee by ID
            else if (choice == 6) employeeDao.sortEmployee(); // sort employees by name
        } while (choice != 7);
        System.out.println("Goodbye!!!");
    }
}
