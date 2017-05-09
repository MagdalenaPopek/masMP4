package magdalena;

import java.util.ArrayList;

/**
 * Created by Magdalena on 2017-05-08.
 */
public class RidingSchool {

    /**
     * Nazwa
     */
    private String name;

    /**
     * Konie
     */
    private ArrayList<Horse> horses = new ArrayList<>();

    public RidingSchool(String name){
        this.name = name;
    }

    public void addHorse(Horse horse){
        if(!horse.isShowHorse() && !horses.contains(horse)){
            horses.add(horse);
            horse.setRidingSchool(this);
        }
    }
    public void removeHorse(Horse horse){
        if(horses.contains(horse)){
            horses.remove(horse);
            horse.removeRidingSchool();
        }
    }

    public void showHorses(){
        for(Horse h : horses){
            System.out.println(h);
        }
    }
}
