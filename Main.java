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
            if (choice == 1) { // create employee
                employeeDao.createEmployee();
            } else if (choice == 2) { // update employee
                employeeDao.updateEmployee();
            } else if (choice == 3) { // delete employee
                employeeDao.deleteEmployee();
            } else if (choice == 4) { // print all employees
                employeeDao.readEmployees();
            } else if (choice == 5) {
                employeeDao.searchEmployee();
            } else if (choice == 6) {
                employeeDao.sortEmployee();
            }
        } while (choice != 7);
        System.out.println("Goodbye!!!");


    }
}
