public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees = initialDataEmploees(employees);

        //1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
        getInfoAboutEmploees(employees);

        //2, Посчитать сумму затрат на зарплаты в месяц.
        double salaryCosts = getsalaryCosts(employees);
        System.out.println("Сумма затрат на зарплату = " + salaryCosts);

        //3. Найти сотрудника с минимальной зарплатой.
        Employee employeeWithMinSalary = getEmployeeWithMinSalary(employees);
        System.out.println("Сотрудник с минимальной зарплатой id = " + employeeWithMinSalary.getId() + "; сумма = " + employeeWithMinSalary.getSalary());

        //4. Найти сотрудника с максимальной зарплатой.
        Employee employeeWithMaxSalary = getEmployeeWithMaxSalary(employees);
        System.out.println("Сотрудник с максимальной зарплатой id = " + employeeWithMaxSalary.getId() + "; сумма = " + employeeWithMaxSalary.getSalary());

        //5 Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
        double averageSalary = (double)((int)(getsalaryCosts(employees) / (double)employees.length * 100.0)) / 100.0;
        System.out.println("Средняя зараплата " + averageSalary);

        //6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
        String[] fullnames = getFullnames(employees);
    }

    public static void getInfoAboutEmploees(Employee[] employees) {
        System.out.println("Main.getInfoAboutEmploees");

        for(int i = 0; i < employees.length; ++i) {
            System.out.print(employees[i].getId() + " ");
            System.out.print(employees[i].getFullName() + " ");
            System.out.print(employees[i].getDepartment() + " ");
            System.out.print(employees[i].getSalary() + " ");
            System.out.println();
        }

    }

    public static double getsalaryCosts(Employee[] employees) {
        System.out.println("Main.salaryCosts");
        double sum = 0.0;

        for(int i = 0; i < employees.length; ++i) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }

        return sum;
    }

    public static Employee getEmployeeWithMinSalary(Employee[] employees) {
        System.out.println("Main.getEmployeeWithMinSalary");
        double minSum = employees[0].getSalary();
        Employee employeeWithMinSalary = employees[0];

        for(int i = 0; i < employees.length; ++i) {
            if (minSum > employees[i].getSalary()) {
                minSum = employees[i].getSalary();
                employeeWithMinSalary = employees[i];
            }
        }

        return employeeWithMinSalary;
    }

    public static Employee getEmployeeWithMaxSalary(Employee[] employees) {
        System.out.println("Main.getEmployeeWithMaxSalary");
        double maxSum = employees[0].getSalary();
        Employee employeeWithMaxSalary = employees[0];

        for(int i = 0; i < employees.length; ++i) {
            if (maxSum < employees[i].getSalary()) {
                maxSum = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }

        return employeeWithMaxSalary;
    }

    public static String[] getFullnames(Employee[] employees) {
        String[] fullnames = new String[employees.length];

        for(int i = 0; i < employees.length; ++i) {
            fullnames[i] = employees[i].getFullName();
            System.out.println(fullnames[i]);
        }

        return fullnames;
    }

    public static Employee[] initialDataEmploees(Employee[] employees) {
        System.out.println("Main.initialEmploees");

        for(int i = 0; i < employees.length; ++i) {
            employees[i] = new Employee("Сотрудник_ФИО_" + i, (int)(Math.random() * 4.0) + 1, Math.random() * 120000.0 + 20000.0);
        }

        System.out.println("Generated emploees: " + employees.length);
        return employees;
    }
}