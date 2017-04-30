package magdalena;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by Magdalena on 2017-04-27.
 */
public class Client extends User {

    /**
     * Zniżka
     */
    private int discount;

    /**
     * Wzrost
     */
    private int height;

    /**
     * Poziom zaawansowania
     */
    private LevelType level;

    /**
     * User
     */
    private User user;

    private static HashSet<User> allUsers = new HashSet<>();


    private Client(User user, int height, LevelType level) {
        super(user.getName(), user.getSurname(), user.getBirthDate(), user.getPhoneNumber());
        this.height = height;
        this.level = level;
    }

    private Client(String name, String surname, Date birthDate, String phoneNumber, int height, LevelType level){
        super(name, surname, birthDate, phoneNumber);
        this.height = height;
        this.level = level;

    }

    public static Client createClient(User user, int height, LevelType level) throws Exception {
        if (user == null || allUsers.contains(user)) {
            throw new Exception("ERROR");
        }

        Client c = new Client(user, height, level);
        c.user = user;
        user.setClient(c);
        allUsers.add(user);

        return c;
    }

    public static Client createClient(String name, String surname, Date birthDate, String phoneNumber, int height, LevelType level) throws Exception {
        User u = new User(name, surname, birthDate, phoneNumber);
        Client c = new Client(u, height, level);
        c.user = u;
        u.setClient(c);
        allUsers.add(u);

        return c;
    }

    public User getUser() {
        return user;
    }

    public static void removeUser(User user){
        if(allUsers.contains(user)){
            allUsers.remove(user);
            user.removeClient(user.getClient());
        }
    }

    public static HashSet<User> getAllUsers() {
        return allUsers;
    }

    @Override
    public String toString() {
        return "Klient " + name +
                " " + surname +
                ", wzrost " + height +
                ", poziom zaawansowania " + level;
    }
}
