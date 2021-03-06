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
     * Powierzchnia, nie może być mniejsza niż 3000ha
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

    private Meadow(Stable stable, double area) throws Exception {
        this.stable = stable;
        this.area = area;
        this.setMaxHorsesNumber();
        this.id = counter++;
    }

    //Tu się upewniam, że pastwisko nie zostanie utworzone bez stajni
    public static Meadow createMeadow(Stable stable, double area) throws Exception {
        if(stable == null){
            throw new Exception("Podana stajnia nie istnieje");
        }

        Meadow m = new Meadow(stable, area);
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

    private void setMaxHorsesNumber(){
        if(this.area/3000 < 1){
            System.out.println("Pastwisko musi mieć minimum 3000m2");
        }
       this.maxHorsesNumber = (int)this.area/3000;
    }

    public int getMaxHorsesNumber() {
        return maxHorsesNumber;
    }
}
