package magdalena;

import java.util.Date;
import java.util.HashSet;

/**
 * Created by Magdalena on 2017-04-22.
 */

public class Contestant extends User {

    private static int counter;

    /**
     * Numer zawodnika
     */

    private int contestantNumber;

    /**
     * User
     */
    private User user;

    private static HashSet<User> allUsers = new HashSet<>();

    private Contestant(User user) {
        super(user.getName(), user.getSurname(), user.getBirthDate(), user.getPhoneNumber());
        this.contestantNumber = counter++;
    }

    public User getUser() {
        return user;
    }

    public static Contestant createContestant(User user) throws Exception {
        if (user == null || allUsers.contains(user)) {
            throw new Exception("ERROR");
        }
        Contestant c = new Contestant(user);
        c.user = user;
        user.setContestant(c);
        allUsers.add(user);

        return c;
    }

    public static Contestant createContestant(String name, String surname, Date birthDate, String phoneNumber, int height, LevelType level) throws Exception {
        User u = new User(name, surname, birthDate, phoneNumber);
        Contestant c = new Contestant(u);
        u.setContestant(c);
        allUsers.add(c);

        return c;
    }

    public int getContestantNumber() {
        return contestantNumber;
    }

    public static void removeUser(User user){
        if(allUsers.contains(user)){
            allUsers.remove(user);
            user.removeContestant(user.getContestant());
        }
    }

    @Override
    public String toString() {
        return "Zawodnik " + getName()
                + " " + getSurname()
                + " o numerze startowym " + contestantNumber;
    }
}
