/**
 * The Employee class represents a factory worker and calculates
 * their salary components such as taxes, bonuses, and salary raises.
 */
public class Employee {
    // Attributes of the Employee
    String name;
    double salary;
    int workHours;
    int hireYear;

    /**
     * Constructor to initialize the employee's attributes.
     */
    Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    /**
     * Calculates the tax applied to the employee's salary.
     * If salary is less than 1000, no tax is applied.
     * If salary is 1000 or more, a 3% tax is applied.
     */
    double tax() {
        if (this.salary < 1000) {
            return 0;
        } else {
            return this.salary * 0.03; // 3% tax rate
        }
    }

    /**
     * Calculates the bonus payment based on weekly work hours.
     * Employees get 30 units of bonus for each hour worked over 40 hours.
     */
    double bonus() {
        if (this.workHours > 40) {
            return (this.workHours - 40) * 30; // 30 per extra hour
        }
        return 0;
    }

    /**
     * Calculates the salary raise based on the years of employment.
     * The reference current year is set to 2021 as per requirements.
     */
    double raiseSalary() {
        int yearsWorked = 2021 - this.hireYear;

        if (yearsWorked < 10) {
            return this.salary * 0.05; // 5% raise for less than 10 years
        } else if (yearsWorked > 9 && yearsWorked < 20) {
            return this.salary * 0.10; // 10% raise for 10 to 19 years
        } else {
            return this.salary * 0.15; // 15% raise for 20+ years
        }
    }

    /**
     * Returns a formatted string representation of the employee's financial data.
     * This method overrides the standard toString() method.
     */
    @Override
    public String toString() {
        // Execute calculations and store results in local variables
        double tax = tax();
        double bonus = bonus();
        double raise = raiseSalary();

        // Calculate transitional and final salary states
        double salaryWithTaxAndBonus = this.salary - tax + bonus;
        double totalSalary = salaryWithTaxAndBonus + raise;

        return "Name : " + this.name +
                "\nBase Salary : " + this.salary +
                "\nWeekly Work Hours : " + this.workHours +
                "\nHire Year : " + this.hireYear +
                "\nTax Deduction : " + tax +
                "\nBonus Earned : " + bonus +
                "\nSalary Increase : " + raise +
                "\nSalary with Tax and Bonus : " + salaryWithTaxAndBonus +
                "\nTotal Salary : " + totalSalary;
    }
}