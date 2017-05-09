package magdalena;

import java.util.Date;
import java.util.HashSet;


/**
 * Created by Magdalena on 2017-05-03.
 */

public class Employee extends Person {

    private static HashSet<Employee> allEmployees = new HashSet<>();
    final static double maxBonus = 600;

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
    private Person person;

    /**
     * Stajnia
     */
    private Stable stable;

    /**
     * Bonus
     */
    private double bonus;

    private boolean isDirector;

    public Employee(Person person, Date hireDate, double salary) {
        super(person.getName(), person.getSurname(), person.getBirthDate(), person.getPhoneNumber());
        this.hireDate = hireDate;
        this.salary = salary;
        allEmployees.add(this);
    }

    public Employee(String name, String surname, Date birthDate, String phoneNumber, Date hireDate, double salary) {
        super(name, surname, birthDate, phoneNumber);
        this.hireDate = hireDate;
        this.salary = salary;
        allEmployees.add(this);
    }

    public void addStable(Stable stable) throws Exception {
        if (this.stable == null) {
            this.stable = stable;
            stable.addEmployee(this);
        }
    }

    public void setDirector() {
        if (!isDirector && stable.getEmployees().contains(this)) {
            isDirector = true;
            stable.addDirector(this);
        }
    }

    public void removeDirector() {
        if (isDirector && stable.getDirector() != null){
            this.isDirector = false;
            stable.removeDirector();
        }

    }

    public void setBonus(double bonus) throws Exception {
        if (bonus > maxBonus) {
            throw new Exception("Bonus nie może być większy niż 600zł");
        }
        this.bonus = bonus;
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

    protected double getIncome() {
        return this.salary;
    }

    public Stable getStable() {
        return stable;
    }

    public boolean isDirector() {
        return isDirector;
    }



    @Override
    public String toString() {
        return "Pracownik " + getName()
                + " " + getSurname()
                + " zatrudniony " + hireDate;
    }

    public Person getPerson() {
        return person;
    }

}