public class Employee {
    private static int counterEmployee = 0;
    private int id;
    private String fullName;
    private int department;
    private double salary;

    public Employee(String fullName, int department, double salary) {
        ++counterEmployee;
        this.id = counterEmployee;
        this.fullName = fullName;
        this.department = department;
        this.salary = (double)((int)(salary * 100.0)) / 100.0;
    }

    public int getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = (double)((int)(salary * 100.0)) / 100.0;
    }
}