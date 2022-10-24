public class Employee {
    private static final int CURRENT_YEAR = 2021;
    private static final int STANDARD_WORK_HOURS = 40;
    private static final int TAX_RATE = 3;
    private static final int BONUS_RATE = 30;

    private final String name;
    private final double salary;
    private final double workHours;
    private final int hireYear;

    public Employee(String name, double salary, double workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {
        if (this.salary < 1000) {
            return 0;
        }

        return (this.salary * TAX_RATE) / 100;
    }

    public double bonus() {
        double workDiff = this.workHours - STANDARD_WORK_HOURS;

        return Math.max(0.0, workDiff) * BONUS_RATE;
    }

    public double raiseSalary() {
        final int YEAR_DIFF = CURRENT_YEAR - this.hireYear;
        int raiseRate;

        if (YEAR_DIFF < 10) {
            raiseRate = 5;
        } else if (YEAR_DIFF < 20) {
            raiseRate = 10;
        } else {
            raiseRate = 15;
        }

        final double SALARY_W_TAX_BONUS = this.salary + this.bonus() - this.tax();
        return (SALARY_W_TAX_BONUS * raiseRate) / 100;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n"
                + "Salary: " + this.salary + "\n"
                + "Work Hours: " + this.workHours + "\n"
                + "Year Hired: " + this.hireYear + "\n"
                + "Tax: " + this.tax() + "\n"
                + "Salary Raise: " + this.raiseSalary() + "\n"
                + "Bonus: " + this.bonus() + "\n"
                + "Salary (Incl. tax and bonus): " + (this.salary + this.bonus() - this.tax()) + "\n"
                + "Total Salary: " + (this.salary + this.bonus()) + "\n";
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Name Surname", 15000.0, 41.0, 2020);

        System.out.println(employee);
    }
}