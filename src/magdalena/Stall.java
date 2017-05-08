package magdalena;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-04-21.
 */

//Część
public class Stall {
    
    private static int counter;
    
    /**
     * Numer boksu
     */
    private int stallNumber;

    /**
     * Stajnia, w której boks jest
     */
    private Stable stable;

    /**
     * Konie, który mieszka w boksie
     */
    private List<Horse> horsesInStall = new ArrayList<>();
    
    private Stall(Stable stable){
        this.stable = stable;
        this.stallNumber = counter++;
    }

    //Tu się upewniam, że boks nie zostanie utworzony bez stajni
    public static Stall createStall(Stable stable) throws Exception {
        if(stable == null){
            throw new Exception("Podana stajnia nie istnieje");
        }

        Stall s = new Stall(stable);
        stable.addStall(s);

        return s;
    }

    //Tu dodaję konia do boksu, o ile już w nim nie mieszka
    public void addHorse(Horse horse) throws Exception {
        if(horsesInStall.size() < 2 && !horsesInStall.contains(horse)) {
            horsesInStall.add(horse);

            horse.addStall(this);
        }
    }

    //Usuwam konia z boksu
    public void removeHorse(Horse horse) throws Exception {
        if(!horsesInStall.contains(horse)){
            throw new Exception("W tym boksie nie ma konia o podanym id");
        }
        horse.removeStall();
        horsesInStall.remove(horse);
    }



    public int getStallNumber() {
        return stallNumber;
    }

    public Stable getStable() {
        return stable;
    }

    public List<Horse> getHorsesInStall() {
        return horsesInStall;
    }

    @Override
    public String toString() {
        return "Boks numer " + stallNumber +
                " mieści się w stajni " + stable.getStableName();
    }

    public void removeStable(Stable stable) {
    }


}
