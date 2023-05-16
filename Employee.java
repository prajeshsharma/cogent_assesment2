public class Employee implements Comparable<Employee> {
    private static int counter = 1;
    private final int id;
    private String name;
    private String address;
    private String email;
    private Double salary;

    public Employee() {
        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Double salary) {
        this.salary = Math.round(100 * salary) / 100.0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "number=" + id +
                ", name='" + name +
                "', address='" + address +
                "', email='" + email +
                "', salary=$" + salary + '}';
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }
}
