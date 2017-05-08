package magdalena;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Magdalena on 2017-04-07.
 */
public class Competition{

    private static int counter;

    /**
     * Nazwa zawodów
     */
    private String name;

    /**
     * Numer zawodów
     */
    private int competitionNumber;

    /**
     * Data zawodów
     */
    private Date date;

    private ArrayList<Contestant> contestantsInComp = new ArrayList<>();



    public Competition(Date date, String name) {
        this.date = date;
        this.name = name;
        this.competitionNumber = counter++;
    }

    public void setContestant(Contestant contestant) throws Exception {
        if(!contestantsInComp.contains(contestant)) {
            contestantsInComp.add(contestant);
            contestant.setCompetition(this);
        }
    }


    public String getName() {
        return name;
    }

    public int getCompetitionNumber() {
        return competitionNumber;
    }

    public void getContestantsInComp() {
        for(Contestant c : contestantsInComp){
            System.out.println(c);
        }
    }

    @Override
    public String toString() {
        return "Zawody " + name +
                " numer " + competitionNumber +
                ", data " + date;
    }
}
