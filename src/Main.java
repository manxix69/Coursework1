public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees = initialDataEmploees(employees);

        //1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
        getInfoAboutEmployees(employees);

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
        double averageSalary = (double) ((int) (getsalaryCosts(employees) / (double) employees.length * 100.0)) / 100.0;
        System.out.println("Средняя зараплата " + averageSalary);

        //6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
        String[] fullnames = getFullnames(employees);

        //ПОВЫШЕННАЯ СЛОЖНОСТЬ
        //1Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
        double percentIncrease = 12.56465;
        increaseEmployeeSalariesByPercent(employees, percentIncrease);

        //2 1 сотрудник с минимальной зарплатой, по отделу
        int department = 4;
        Employee employeeWithMinSalaryInDepartment = getEmployeeWithMinSalary(employees, department);
        System.out.println("в отделе " + employeeWithMinSalaryInDepartment.getDepartment() + " сотрудник с минимальной зарплатой id = " + employeeWithMinSalaryInDepartment.getId() + "; сумма = " + employeeWithMinSalaryInDepartment.getSalary());

        //2 2 сотрудник с максимальной зарплатой,, по отделу
        Employee employeeWithMaxSalaryInDepartment = getEmployeeWithMaxSalary(employees, department);
        System.out.println("в отделе " + employeeWithMaxSalaryInDepartment.getDepartment() + " сотрудник с максимальной зарплатой id = " + employeeWithMaxSalaryInDepartment.getId() + "; сумма = " + employeeWithMaxSalaryInDepartment.getSalary());

        //2 3 сумма затрат на зарплату по отделу
        double salaryCostsInDepartment = getsalaryCosts(employees, department);
        System.out.println("в отделе " + department + " сумма затрат на зарплату = " + salaryCostsInDepartment);

        // 2 4 средняя зарплата по отделу,
        double averageSalaryInDepartment = (double) ((int) (getsalaryCosts(employees, department) / (double) getCountEmployeesInDepartment(employees, department) * 100.0)) / 100.0;
        System.out.println("в отделе " + department + " средняя зараплата " + averageSalaryInDepartment);

        // 2 5  в отделе Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        percentIncrease = 0.12;
        increaseEmployeeSalariesByPercent(employees, percentIncrease, department);

        // 2 6 Напечатать всех сотрудников отдела (все данные, кроме отдела).
        getInfoAboutEmployees(employees, department);

        // 3 1 Получить в качестве параметра число и найти: Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        double salaryLessThan = 50_000.00;
        getInfoAboutEmployeesWithSalaryLessThan(employees, salaryLessThan);

        // 3 2 Получить в качестве параметра число и найти: Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль)
        double salaryEqualsOrGreaterThan = 60_000.00;
        getInfoAboutEmployeesSalaryEqualsOrGreaterThan(employees, salaryEqualsOrGreaterThan);
    }

    public static int getCountEmployeesInDepartment(Employee[] employees, int department) {
        System.out.println("Main.getCountEmployeesInDepartment");
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                counter++;
            }
        }
        return counter;
    }

    public static void getInfoAboutEmployees(Employee[] employees) {
        System.out.println("Main.getInfoAboutEmployees");

        for (int i = 0; i < employees.length; ++i) {
            System.out.print(employees[i].getId() + " ");
            System.out.print(employees[i].getFullName() + " ");
            System.out.print(employees[i].getDepartment() + " ");
            System.out.print(employees[i].getSalary() + " ");
            System.out.println();
        }

    }

    public static void getInfoAboutEmployees(Employee[] employees, int department) {
        System.out.println("Main.getInfoAboutEmployees");

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i].getDepartment() == department) {
                System.out.print(employees[i].getId() + " ");
                System.out.print(employees[i].getFullName() + " ");
                System.out.print(employees[i].getSalary() + " ");
                System.out.println();
            }
        }
    }

    public static double getsalaryCosts(Employee[] employees) {
        System.out.println("Main.salaryCosts");
        double sum = 0.0;

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }

        return sum;
    }

    public static double getsalaryCosts(Employee[] employees, int department) {
        System.out.println("Main.salaryCosts");
        double sum = 0.0;

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }

        return sum;
    }

    public static Employee getEmployeeWithMinSalary(Employee[] employees) {
        System.out.println("Main.getEmployeeWithMinSalary");
        double minSum = employees[0].getSalary();
        Employee employeeWithMinSalary = employees[0];

        for (int i = 0; i < employees.length; ++i) {
            if (minSum > employees[i].getSalary()) {
                minSum = employees[i].getSalary();
                employeeWithMinSalary = employees[i];
            }
        }

        return employeeWithMinSalary;
    }

    public static Employee getEmployeeWithMinSalary(Employee[] employees, int department) {
        System.out.println("Main.getEmployeeWithMinSalary");
        double minSum = employees[0].getSalary();
        Employee employeeWithMinSalary = employees[0];

        for (int i = 0; i < employees.length; ++i) {
            if (minSum > employees[i].getSalary() && employees[i].getDepartment() == department) {
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

        for (int i = 0; i < employees.length; ++i) {
            if (maxSum < employees[i].getSalary()) {
                maxSum = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }

        return employeeWithMaxSalary;
    }

    public static Employee getEmployeeWithMaxSalary(Employee[] employees, int department) {
        System.out.println("Main.getEmployeeWithMaxSalary");
        double maxSum = employees[0].getSalary();
        Employee employeeWithMaxSalary = employees[0];

        for (int i = 0; i < employees.length; ++i) {
            if (maxSum < employees[i].getSalary() && employees[i].getDepartment() == department) {
                maxSum = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }

        return employeeWithMaxSalary;
    }

    public static String[] getFullnames(Employee[] employees) {
        String[] fullnames = new String[employees.length];

        for (int i = 0; i < employees.length; ++i) {
            fullnames[i] = employees[i].getFullName();
            System.out.println(fullnames[i]);
        }

        return fullnames;
    }

    public static Employee[] initialDataEmploees(Employee[] employees) {
        System.out.println("Main.initialEmploees");

        for (int i = 0, j = 1; i < employees.length; i++, j++) {
            employees[i] = new Employee("Сотрудник_ФИО_" + j, (int) (Math.random() * 4.0) + 1, Math.random() * 120000.0 + 20000.0);
        }

        System.out.println("Массив employees[] сгенерирован в количестве: " + employees.length);
        return employees;
    }

    public static void increaseEmployeeSalariesByPercent(Employee[] employee, double percent) {
        System.out.println("Main.increaseEmployeeSalariesByPercent");

        for (int i = 0; i < employee.length; i++) {
            double increasedSalary = employee[i].getSalary() + employee[i].getSalary() * percent / 100.0;
            employee[i].setSalary(increasedSalary);
            System.out.println("ЗП проиндексирована на " + percent + "% и теперь составляет " + employee[i].getSalary());
        }

    }

    public static void increaseEmployeeSalariesByPercent(Employee[] employee, double percent, int departnment) {
        System.out.println("Main.increaseEmployeeSalariesByPercent");

        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getDepartment() == departnment) {
                double increasedSalary = employee[i].getSalary() + employee[i].getSalary() * percent / 100.0;
                employee[i].setSalary(increasedSalary);
                System.out.println("в отделе " + departnment + " ЗП проиндексирована на " + percent + "% и теперь составляет " + employee[i].getSalary());
            }
        }

    }

    public static void getInfoAboutEmployeesWithSalaryLessThan(Employee[] employees, double sum) {
        System.out.println("Main.getInfoAboutEmployeesWithSalaryLessThan");

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i].getSalary() < sum) {
                System.out.print(employees[i].getId() + " ");
                System.out.print(employees[i].getFullName() + " ");
                System.out.print(employees[i].getSalary() + " ");
                System.out.println();
            }
        }
    }
    public static void getInfoAboutEmployeesSalaryEqualsOrGreaterThan(Employee[] employees, double sum) {
        System.out.println("Main.getInfoAboutEmployeesSalaryEqualsOrGreaterThan");

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i].getSalary() >= sum) {
                System.out.print(employees[i].getId() + " ");
                System.out.print(employees[i].getFullName() + " ");
                System.out.print(employees[i].getSalary() + " ");
                System.out.println();
            }
        }
    }
}