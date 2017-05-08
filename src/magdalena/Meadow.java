package magdalena;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Magdalena on 2017-05-06.
 */
public class Meadow {

    private static int counter;

    /**
     * Id
     */
    private int id;

    /**
     * Powierzchnia
     */
    private double area;

    /**
     * Max ilość koni
     */
    private int maxHorsesNumber;

    /**
     * Stajnia
     */
    private Stable stable;

    /**
     * Konie
     */
    private List<Horse> horsesOnMeadow = new ArrayList<>();

    private Meadow(Stable stable, double area, int maxHorsesNumber) throws Exception {
        this.stable = stable;
        this.area = area;
        if(maxHorsesNumber < 1){
            throw new Exception("Liczba koni musi wynosić co najmniej 1");
        }
        this.maxHorsesNumber = maxHorsesNumber;
        this.id = counter++;
    }

    //Tu się upewniam, że pastwisko nie zostanie utworzone bez stajni
    public static Meadow createMeadow(Stable stable, double area, int maxHorsesNumber) throws Exception {
        if(stable == null){
            throw new Exception("Podana stajnia nie istnieje");
        }

        Meadow m = new Meadow(stable, area, maxHorsesNumber);
        stable.addMeadow(m);

        return m;
    }

    //Tu dodaję konia o ile już w nim nie mieszka
    public void addHorse(Horse horse) throws Exception {
        if(!horsesOnMeadow.contains(horse)) {
            horsesOnMeadow.add(horse);
            horse.addMeadow(this);
        }
    }

    //Usuwam konia
    public void removeHorse(Horse horse) throws Exception {
        if (horsesOnMeadow.contains(horse)) {
            horse.removeMeadow();
            horsesOnMeadow.remove(horse);
        }
    }

    public void getHorsesOnMeadow(){
        for(Horse h : horsesOnMeadow){
            System.out.println(h);
        }
    }
}
