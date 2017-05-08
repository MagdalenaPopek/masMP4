package magdalena;

import java.util.Date;
import java.util.HashSet;


/**
 * Created by Magdalena on 2017-05-03.
 */

public class Employee extends Person {

    private static HashSet<Employee> allEmployees = new HashSet<>();

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
     * Rola w stajni
     */
    private RoleType roleType;

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

    public void addStable(Stable stable, RoleType roleType) throws Exception {
        if(this.stable == null) {
            this.stable = stable;
            this.roleType = roleType;
            stable.addEmployee(this, roleType);
        }
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

    public Stable getStable() {
        return stable;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public RoleType getRoleType() {
        return roleType;
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