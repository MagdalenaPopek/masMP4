package magdalena;

import java.util.ArrayList;

/**
 * Created by Magdalena on 2017-05-08.
 */
public class HorseCompetition {

    private static int counter;
    private Horse horse;
    private Competition competition;

    private ArrayList<HorseCompetition> horsesAndComps = new ArrayList<>();

    /**
     * Numer startowy
     */
    private int id;

    public HorseCompetition(Horse horse, Competition competition) {
        this.id = counter++;
        if (horse.getRidingSchool() == null) {
            this.horse = horse;
            this.competition = competition;
            this.horse.setIsShowHorse(this);
            this.competition.setShowHorse(this);
            horsesAndComps.add(this);
        }
    }

   /* public HorseCompetition createHorseCompetition(Horse horse, Competition competition){
        if(horse.getRidingSchool() == null){
            HorseCompetition hc = new HorseCompetition(horse, competition);
        }
        return hc;
    }*/

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public void setHorse(Horse horse) {
        if (horse.getRidingSchool() == null)
            this.horse = horse;
    }

    public void remove() {
        if (horsesAndComps.contains(this)) {
            horsesAndComps.clear();
            horse.removeShowHorse();
            competition.removeShowHorse(this);
        }
    }

    @Override
    public String toString() {
        return "Koń " + horse.getName() +
                ", zawody " + competition.getName() +
                ", id " + id;
    }
}
