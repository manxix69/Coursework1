public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        EmployeeBook employeeBook = new EmployeeBook(employees.length);
        employees = employeeBook.getEmployees();

        //Базовая сложность
        //1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).
        employeeBook.getInfoAboutEmployees();

        //2, Посчитать сумму затрат на зарплаты в месяц.
        double salaryCosts = employeeBook.getSalaryCosts();
        System.out.println("Сумма затрат на зарплату = " + salaryCosts);

        //3. Найти сотрудника с минимальной зарплатой.
        Employee employeeWithMinSalary = employeeBook.getEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой id = " + employeeWithMinSalary.getId() + "; сумма = " + employeeWithMinSalary.getSalary());

        //4. Найти сотрудника с максимальной зарплатой.
        Employee employeeWithMaxSalary = employeeBook.getEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой id = " + employeeWithMaxSalary.getId() + "; сумма = " + employeeWithMaxSalary.getSalary());

        //5 Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
        double averageSalary = (double) ((int) (employeeBook.getSalaryCosts() / (double) employees.length * 100.0)) / 100.0;
        System.out.println("Средняя зараплата " + averageSalary);

        //6. Получить Ф. И. О. всех сотрудников (вывести в консоль).
        String[] fullNames = employeeBook.getFullNames();

        //ПОВЫШЕННАЯ СЛОЖНОСТЬ
        //1Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
        double percentIncrease = 12.56465;
        employeeBook.increaseEmployeeSalariesByPercent(percentIncrease);

        //2 1 сотрудник с минимальной зарплатой, по отделу
        int department = 4;
        Employee employeeWithMinSalaryInDepartment = employeeBook.getEmployeeWithMinSalary(department);
        System.out.println("в отделе " + employeeWithMinSalaryInDepartment.getDepartment() + " сотрудник с минимальной зарплатой id = " + employeeWithMinSalaryInDepartment.getId() + "; сумма = " + employeeWithMinSalaryInDepartment.getSalary());

        //2 2 сотрудник с максимальной зарплатой,, по отделу
        Employee employeeWithMaxSalaryInDepartment = employeeBook.getEmployeeWithMaxSalary(department);
        System.out.println("в отделе " + employeeWithMaxSalaryInDepartment.getDepartment() + " сотрудник с максимальной зарплатой id = " + employeeWithMaxSalaryInDepartment.getId() + "; сумма = " + employeeWithMaxSalaryInDepartment.getSalary());

        //2 3 сумма затрат на зарплату по отделу
        double salaryCostsInDepartment = employeeBook.getSalaryCosts(department);
        System.out.println("в отделе " + department + " сумма затрат на зарплату = " + salaryCostsInDepartment);

        // 2 4 средняя зарплата по отделу,
        double averageSalaryInDepartment = (double) ((int) (employeeBook.getSalaryCosts(department) / (double) employeeBook.getCountEmployeesInDepartment(department) * 100.0)) / 100.0;
        System.out.println("в отделе " + department + " средняя зараплата " + averageSalaryInDepartment);

        // 2 5  в отделе Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
        percentIncrease = 0.12;
        employeeBook.increaseEmployeeSalariesByPercent(percentIncrease, department);

        // 2 6 Напечатать всех сотрудников отдела (все данные, кроме отдела).
        employeeBook.getInfoAboutEmployees(department);

        // 3 1 Получить в качестве параметра число и найти: Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
        double salaryLessThan = 50_000.00;
        employeeBook.getInfoAboutEmployeesWithSalaryLessThan(salaryLessThan);

        // 3 2 Получить в качестве параметра число и найти: Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль)
        double salaryEqualsOrGreaterThan = 60_000.00;
        employeeBook.getInfoAboutEmployeesSalaryEqualsOrGreaterThan(salaryEqualsOrGreaterThan);

        //ОЧЕНЬ СЛОЖНО
        //4 1 - Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
        //Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее. Искать нужно всегда с начала, так как возможно добавление в ячейку удаленных ранее сотрудников.
        // Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
        // сначала удалим кого-нибудь а потом добави

        employeeBook.deleteEmployee(employees[1].getFullName(), employees[2].getId());
        employeeBook.deleteEmployee(employees[2].getFullName());
        employeeBook.deleteEmployee(employees[3].getId());

        Employee employee = new Employee("Иванов Иван Иванович", 3, 375_000);
        Employee employee1 = new Employee("Иванов Петр Иванович", 3, 103_000);
        Employee employee2 = new Employee("Иванов Андей Иванович", 2, 215_000);
        Employee employee3 = new Employee("Иванов Сергей Иванович", 2, 214_000);

        employeeBook.addEmployee(employee);
        employeeBook.addEmployee(employee1);
        employeeBook.addEmployee(employee2);
        employeeBook.addEmployee(employee3);

        //5. Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
        //    1. Изменить зарплату.
        //    2. Изменить отдел.
        //    Придумать архитектуру. Сделать или два метода, или один, но продумать его.

        employeeBook.changeEmployeeByFullName("Иванов Петр Иванович",278_000.0, 2);

        System.out.println(employee1);

        //6. Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
        //-
        employeeBook.getInfoAboutEmployees();

    }


}