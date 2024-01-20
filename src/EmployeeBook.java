public class EmployeeBook {

    private Employee[] employees;

    private Employee[] initialDataEmployees(int length) {
        System.out.println("EmployeeBook.initialDataEmploees");
        employees = new Employee[length];

        for (int i = 0, j = 1; i < employees.length; i++, j++) {
            employees[i] = new Employee("Сотрудник_ФИО_" + j, (int) (Math.random() * 4.0) + 1, Math.random() * 120000.0 + 20000.0);
        }

        System.out.println("Массив employees[] сгенерирован в количестве: " + employees.length);
        return employees;
    }

    public EmployeeBook(int length) {
        this.employees = initialDataEmployees(length);
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public int getCountEmployeesInDepartment(int department) {
        System.out.println("EmployeeBook.getCountEmployeesInDepartment");
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                counter++;
            }
        }
        return counter;
    }

    public void getInfoAboutEmployees() {
        System.out.println("EmployeeBook.getInfoAboutEmployees");

        for (int i = 0; i < employees.length; ++i) {
            System.out.println(employees[i]);
        }

    }

    public void getInfoAboutEmployees(int department) {
        System.out.println("EmployeeBook.getInfoAboutEmployees");

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i].getDepartment() == department) {
                System.out.println(employees[i]);
            }
        }
    }

    public double getSalaryCosts() {
        System.out.println("EmployeeBook.getSalaryCosts");
        double sum = 0.0;

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i] != null) {
                sum += employees[i].getSalary();
            }
        }

        return sum;
    }

    public double getSalaryCosts(int department) {
        System.out.println("EmployeeBook.getSalaryCosts");
        double sum = 0.0;

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }

        return sum;
    }

    public Employee getEmployeeWithMinSalary() {
        System.out.println("EmployeeBook.getEmployeeWithMinSalary");
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

    public Employee getEmployeeWithMinSalary(int department) {
        System.out.println("EmployeeBook.getEmployeeWithMinSalary");
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

    public Employee getEmployeeWithMaxSalary() {
        System.out.println("EmployeeBook.getEmployeeWithMaxSalary");
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

    public Employee getEmployeeWithMaxSalary(int department) {
        System.out.println("EmployeeBook.getEmployeeWithMaxSalary");
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

    public String[] getFullNames() {
        String[] fullnames = new String[employees.length];

        for (int i = 0; i < employees.length; ++i) {
            fullnames[i] = employees[i].getFullName();
            System.out.println(fullnames[i]);
        }

        return fullnames;
    }

    public void increaseEmployeeSalariesByPercent(double percent) {
        System.out.println("EmployeeBook.increaseEmployeeSalariesByPercent");

        for (int i = 0; i < employees.length; i++) {
            double increasedSalary = employees[i].getSalary() + employees[i].getSalary() * percent / 100.0;
            employees[i].setSalary(increasedSalary);
            System.out.println("ЗП проиндексирована на " + percent + "% и теперь составляет " + employees[i].getSalary());
        }

    }

    public void increaseEmployeeSalariesByPercent(double percent, int departnment) {
        System.out.println("EmployeeBook.increaseEmployeeSalariesByPercent");

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == departnment) {
                double increasedSalary = employees[i].getSalary() + employees[i].getSalary() * percent / 100.0;
                employees[i].setSalary(increasedSalary);
                System.out.println("в отделе " + departnment + " ЗП проиндексирована на " + percent + "% и теперь составляет " + employees[i].getSalary());
            }
        }

    }

    public void getInfoAboutEmployeesWithSalaryLessThan(double sum) {
        System.out.println("EmployeeBook.getInfoAboutEmployeesWithSalaryLessThan");

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i].getSalary() < sum) {
                System.out.print(employees[i].getId() + " ");
                System.out.print(employees[i].getFullName() + " ");
                System.out.print(employees[i].getSalary() + " ");
                System.out.println();
            }
        }
    }

    public void getInfoAboutEmployeesSalaryEqualsOrGreaterThan(double sum) {
        System.out.println("EmployeeBook.getInfoAboutEmployeesSalaryEqualsOrGreaterThan");

        for (int i = 0; i < employees.length; ++i) {
            if (employees[i].getSalary() >= sum) {
                System.out.print(employees[i].getId() + " ");
                System.out.print(employees[i].getFullName() + " ");
                System.out.print(employees[i].getSalary() + " ");
                System.out.println();
            }
        }
    }

    public void deleteEmployee(String fullName, int id) {
        int employeeIndexInArray = getEmployeeIndexInArray(id);
        if (employeeIndexInArray == -1) {
            System.out.println("Не найден сотрудник в Хранилище сотрудников по id = " + id);
            return;
        } else if (employees[employeeIndexInArray].getFullName() != fullName) {
            System.out.println("По найденному сотурднику id  =" + id + " не совпадает ФИО!");
            return;
        } else {
            System.out.println("Из хранилища удаляем: " + employees[employeeIndexInArray]);
            employees[employeeIndexInArray] = null;
        }
    }

    public void deleteEmployee(int id) {
        int employeeIndexInArray = getEmployeeIndexInArray(id);
        if (employeeIndexInArray == -1) {
            System.out.println("Не найден сотрудник в Хранилище сотрудников по id = " + id);
            return;
        } else {
            System.out.println("Из хранилища удаляем: " + employees[employeeIndexInArray]);
            employees[employeeIndexInArray] = null;
        }
    }

    public void deleteEmployee(String fullName) {
        int firstEmployeeIndexInArray = getFullNameIndexInArray(fullName, 0);
        int secondEmployeeIndexInArray = getFullNameIndexInArray(fullName, firstEmployeeIndexInArray + 1);

        if (firstEmployeeIndexInArray == -1) {
            System.out.println("Не найден сотрудник в хранилище сотрудников по ФИО = " + fullName);
            return;
        } else if (secondEmployeeIndexInArray >= 0) {
            System.out.println("В хранилища сотрудников по ФИО = '" + fullName + "' Найдено больше одного сотрудника!");
            return;
        } else {
            System.out.println("Из хранилища удаляем: " + employees[firstEmployeeIndexInArray]);
            employees[firstEmployeeIndexInArray] = null;
        }

    }

    private int getEmployeeIndexInArray(int id) {
        int index = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && id == employees[i].getId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void changeEmployeeByFullName(String fullName, double salary, int department) {
        changeEmployeeByFullName(fullName, salary);
        changeEmployeeByFullName(fullName, department);
    }

    public void changeEmployeeByFullName(String fullName, double salary) {
        Employee employee = employees[getFullNameIndexInArray(fullName, 0)];

        employee.setSalary(salary);
    }
    public void changeEmployeeByFullName(String fullName, int department) {
        Employee employee = employees[getFullNameIndexInArray(fullName, 0)];

        employee.setDepartment(department);
    }

    private int getFullNameIndexInArray(String fullName, int startIndex) {
        if (startIndex < 0) {
            startIndex = 0;
        }
        int resultIndex = -1;
        for (int i = startIndex; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName() == fullName) {
                resultIndex = i;
                break;
            }
        }
        return resultIndex;
    }

    public void addEmployee(Employee employee) {
        boolean employeeadded = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                System.out.println("В хранилище сотрудников добавлен: " + employees[i]);
                employeeadded = true;
                break;
            }
        }
        //System.out.println("employeeadded = " + employeeadded);
        if (employeeadded == false) {
            System.out.println("Для добавления сотрудника недостаточно места в хранилище!");
        }
    }


}