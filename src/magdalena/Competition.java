package magdalena;

import java.util.*;

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
    private ArrayList<HorseCompetition> horsesInComp = new ArrayList<>();
    private Map<Contestant, HorseCompetition> contestantHorseMap = new HashMap<>();



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

    public void setShowHorse(HorseCompetition horseCompetition) {
        if(!horsesInComp.contains(horseCompetition)) {
            horsesInComp.add(horseCompetition);
            horseCompetition.setCompetition(this);
        }
    }

    public void removeShowHorse(HorseCompetition hc){
        if(horsesInComp.contains(hc)){
            horsesInComp.remove(hc);
        }
    }

    public void showHorses(){
        for(HorseCompetition h : horsesInComp){
            System.out.println(h);
        }
    }

    /*public void setContestantHorse(Contestant contestant, HorseCompetition horse) throws Exception {
        if(contestantsInComp.contains(contestant) && contestantHorseMap.containsKey(contestant)) {
            contestantHorseMap.put(contestant, horse);
        }
    }*/

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
