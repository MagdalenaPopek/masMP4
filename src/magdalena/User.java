package magdalena;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Magdalena on 2017-04-22.
 */

//Osoba jest od razu klientem
public class User {

    private static int counter;

    /**
     * Numer (id) użytkownika
     */
    protected int userId;

    /**
     * Imie
     */
    protected String name;

    /**
     * Nazwisko
     */
    protected String surname;

    /**
     * Data urodzenia
     */
    protected Date birthDate;

    /**
     * Numer telefonu
     */
    protected String phoneNumber;

    //-----CLIENT y EL CONCURSANTE
    private Contestant contestant;
//    private Vector<Contestant> contestants = new Vector<>();
//    private static HashSet<Contestant> allConts = new HashSet<>();

    private Client client;
//    private Vector<Client> clients = new Vector<>();
//    private static HashSet<Client> allClients = new HashSet<>();

    private static ArrayList<User> allUsers = new ArrayList<>();
    private List<Object> allObjects = new ArrayList<Object>();

    public User(String name, String surname, Date birthDate, String phoneNumber) {
        this.userId = counter++;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        allUsers.add(this);
    }


    public User(String name, String surname, Date birthDate, String phoneNumber, int height, LevelType level) throws Exception {
        this.userId = counter++;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        allUsers.add(this);
        Contestant.createContestant(this);
        Client.createClient(this, height, level);

    }

    public static void removeUser(User user) {
        if (allUsers.contains(user)) {
            if(user.client != null) {
                Client.removeUser(user);
            }
            if(user.contestant != null){
                Contestant.removeUser(user);
            }

            allUsers.remove(user);
        }
    }

 public void setClient(Client c){
     if(this.client == null){
         this.client = c;
     }
     allObjects.add(c);
 }

 public void setContestant(Contestant cont){
     if(this.contestant == null){
         this.contestant = cont;
     }
     allObjects.add(cont);
 }

    public Contestant getContestant() {
        return contestant;
    }

    public Client getClient() {
        return client;
    }

    public void removeContestant(Contestant contestant){
     //CIALO METODY
 }

 public void removeClient(Client client){
     //CIALO METODY
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
        return "Użtkownik o numerze " + userId +
                ", imię: " + name +
                ", nazwisko: " + surname;
    }

    public void showAllPeople() {
        for (Object o : allObjects) {
            System.out.println(o);
        }

    }
}
