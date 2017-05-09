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
     * Powierzchnia
     */
    private double area;
    final static int minArea = 12;
    private int maxNumOfHorses;

    /**
     * Konie, który mieszka w boksie
     */
    private List<Horse> horsesInStall = new ArrayList<>();
    
    private Stall(double area){
        this.area = area;
        this.stallNumber = counter++;
    }

    //Tu się upewniam, że boks nie zostanie utworzony bez stajni
    public static Stall createStall(Stable stable, double area) throws Exception {
        if(stable == null){
            throw new Exception("Podana stajnia nie istnieje");
        }

        Stall s = new Stall(area);
        s.setStable(stable);
        stable.addStall(s);

        return s;
    }


     private void setMaxNumOfHorses(int maxNumOfHorses) {
        this.maxNumOfHorses = (int)this.area/12;
    }

    //Tu dodaję konia do boksu, o ile już w nim nie mieszka
    public void addHorse(Horse horse) throws Exception {
        if(horsesInStall.size() < maxNumOfHorses && !horsesInStall.contains(horse)) {
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

    public void setStable(Stable stable) {
        this.stable = stable;
    }

    public int getStallNumber() {
        return stallNumber;
    }

    public Stable getStable() {
        return stable;
    }

    public void showHorsesInStall() {
        for(Horse h : horsesInStall){
            System.out.println(h);
        }
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
