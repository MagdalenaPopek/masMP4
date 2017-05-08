package magdalena;

import java.util.ArrayList;

/**
 * Created by Magdalena on 2017-04-21.
 */

//Atrybut asocjacji Person ----- Competition
public class Contestant {

    private static int counter;

    /**
     * Osoba - uczestnik
     */
    Person person;

    /**
     * Zawody
     */
    Competition competition;

    /**
     * Numer zawodnika
     */
    private int contestantNumber;

    private ArrayList<Contestant> contestants = new ArrayList<>();

    public Contestant(Person person, Competition competition) throws Exception {
        this.person = person;
        this.competition = competition;
        this.contestantNumber = counter++;
        this.person.setContestant(this);
        this.competition.setContestant(this);
        contestants.add(this);
    }

    public int getContestantNumber() {
        return contestantNumber;
    }

    @Override
    public String toString() {
        return "Uczestnik numer " + contestantNumber;
    }

    public void setCompetition(Competition competition) throws Exception {
        if(this.competition == null) {
            this.competition = competition;
            competition.setContestant(this);
        }
    }

    public void setPerson(Person person) throws Exception {
        if (this.person == null) {
            this.person = person;
            person.setContestant(this);
        }
    }
}
