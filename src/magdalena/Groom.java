
package magdalena;

import java.util.Date;


/**
 * Created by Magdalena on 2017-04-22.
 */

public class Groom extends Employee {


    /**
     * Premia od ilości wykonanych zadań
     */

    private double tasksBonus = 20;

    public Groom(Employee emp, double tasksBonus) {
        super(emp.getUser(), emp.getHireDate(), emp.getSalary());
        this.tasksBonus = tasksBonus;
    }

    public Groom(User user, Date hireDate, double salary) {
        super(user, hireDate, salary);
    }

    public Groom(String name, String surname, Date birthDate, String phoneNumber, Date hireDate, double salary) {
        super(name, surname, birthDate, phoneNumber, hireDate, salary);
    }

    public double getTasksBonus() {
        return tasksBonus;
    }

    public void setTasksBonus(double tasksBonus) {
        this.tasksBonus = tasksBonus;
    }

    @Override
    public double getIncome() {
        return getSalary() + getSalary() * tasksBonus / 100;
    }

    @Override
    public String toString() {
        return "Stajenny " + name + " " + surname;
    }
}

