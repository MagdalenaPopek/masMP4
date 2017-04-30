package magdalena;

import java.util.Date;


/**
 * Created by Magdalena on 2017-04-22.
 */

public abstract class Employee extends User {


    /**
     * Data zatrudnienia
     */
    private Date hireDate;

    /**
     * Pensja
     */

    private double salary;

    /**
     * User
     */
    private User user;


    public Employee(User user, Date hireDate, double salary) {
        super(user.getName(), user.getSurname(), user.getBirthDate(), user.getPhoneNumber());
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Employee(String name, String surname, Date birthDate, String phoneNumber, Date hireDate, double salary) {
        super(name, surname, birthDate, phoneNumber);
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    protected double getIncome(){
        return this.salary;
    }

    @Override
    public String toString() {
        return "Pracownik " + getName()
                + " " + getSurname()
                + " zatrudniony " + hireDate;
    }

    public User getUser() {
        return user;
    }
}