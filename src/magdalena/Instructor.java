
package magdalena;

import java.util.Date;


/**
 * Created by Magdalena on 2017-04-23.
 */

public class Instructor extends Employee {


    /**
     * Numer odznaki
     */

    private String odznakaNumber;


    /**
     * Numer uprawnień
     */

    private String permissionNumber;


    /**
     * Premia od ilości jazd
     */

    private double lessonBonus = 10;

    public Instructor(Employee emp, String odznakaNumber, String permissionNumber) {
        super(emp, emp.getHireDate(), emp.getSalary());
        this.odznakaNumber = odznakaNumber;
        this.permissionNumber = permissionNumber;
    }

    public Instructor(User user, Date hireDate, double salary, String odznakaNumber, String permissionNumber) {
        super(user, hireDate, salary);
        this.odznakaNumber = odznakaNumber;
        this.permissionNumber = permissionNumber;
    }

    public Instructor(String name, String surname, Date birthDate, String phoneNumber, Date hireDate, double salary, String odznakaNumber, String permissionNumber) {
        super(name, surname, birthDate, phoneNumber, hireDate, salary);
        this.odznakaNumber = odznakaNumber;
        this.permissionNumber = permissionNumber;
    }

    public double getLessonBonus() {
        return lessonBonus;
    }

    public void setLessonBonus(double lessonBonus) {
        this.lessonBonus = lessonBonus;
    }


    @Override
    public double getIncome() {
        return getSalary() + lessonBonus;
    }

    @Override
    public String toString() {
        return "Instruktor " + name + " " + surname +
                ", numer odznaki " + odznakaNumber +
                ", numer uprawnien " + permissionNumber;
    }
}

