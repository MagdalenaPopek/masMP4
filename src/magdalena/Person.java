package magdalena;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by Magdalena on 2017-04-20.
 */
public class Person {

    private static int counter;


    /**
     * Numer (id) użytkownika
     */
    private int userId;

    /**
     * Imie
     */
    private String name;

    /**
     * Nazwisko
     */
    private String surname;

    /**
     * Data urodzenia
     */
    private Date birthDate;

    /**
     * Numer telefonu
     */
    private String phoneNumber;

    private HashSet<Contestant> whereTookPart = new HashSet<>();

    public Person(String name, String surname, Date birthDate, String phoneNumber){
        this.userId = counter++;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public void setContestant(Contestant contestant) throws Exception {
        if(whereTookPart.contains(contestant)){
            throw new Exception("Ta osoba już bierze udział w zawodach");
        }
        whereTookPart.add(contestant);
        contestant.setPerson(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Osoba o numerze użytkownika " + userId +
                ", imię: " + name +
                ", nazwisko: " + surname;
    }
}
