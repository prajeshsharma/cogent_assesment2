public class Employee {
    private static int counter = 1;
    private final int id;
    private String name;
    private String address;
    private String email;
    private Double salary;

    public Employee(String name, String address, String email, Double salary) {
        this.id = ++counter;
        this.name = name;
        this.address = address;
        this.email = email;
        this.salary = Math.round(100 * salary) / 100.0;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
}
