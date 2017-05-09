package magdalena;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Magdalena on 2017-04-21.
 */

//Całość
public class Stable {

    /**
     * Nazwa
     */
    private String stableName;

    /**
     * Adres
     */
    private String stableAddress;

    /**
     * NIP
     */
    private String nip;

    /**
     * Boksy
     */
    private Vector<Stall> stalls = new Vector<>();

    private static HashSet<Stall> allStalls = new HashSet<Stall>();

    /**
     * Pastwiska
     */
    private Vector<Meadow> meadows = new Vector<>();
    private static ArrayList<Meadow> allMeadows = new ArrayList<>();

    /**
     * Pracownicy, którzy pracują w stajni i dyrektor
     */
    private ArrayList<Employee> employees = new ArrayList<>();
    private Employee director;

    private static HashSet<Stable> allStables = new HashSet<>();

    public Stable(String stableName, String stableAddress, String nip) {
        this.stableName = stableName;
        this.stableAddress = stableAddress;
        this.nip = nip;
    }

    public void addStall(Stall stall) throws Exception {
        if (!stalls.contains(stall)) {
            if (allStalls.contains(stall)) {
                throw new Exception("Ten boks został już powiązany z inną stajnią: " + stall.getStable());
            }
            stalls.add(stall);
            allStalls.add(stall);
        }
    }

    public void addMeadow(Meadow m) {
        if (!meadows.contains(m) && !allMeadows.contains(m)) {
            meadows.add(m);
            allMeadows.add(m);
        }
    }

    public void addEmployee(Employee emp) throws Exception {
        if (!employees.contains(emp)) {
            employees.add(emp);
            emp.addStable(this);
        }
    }

    public void addDirector(Employee emp) {
        if (employees.contains(emp)) {
            this.director = emp;
            emp.setDirector();

        }
    }

    public void removeDirector(){
        if(this.director != null){
            director.removeDirector();
            this.director = null;
        }
    }

    //Usuwam instancję obiektu Stajnia
    public static void removeStable(Stable stable) {
        if (allStables.contains(stable)) {
            for (Stall stall : stable.getAllStalls()) {
                if (!stall.getHorsesInStall().isEmpty()) {
                    List<Horse> myNew = new ArrayList<>(stall.getHorsesInStall());
                    for (Horse h : myNew) {
                        h.removeStall();
                    }
                    stall.getHorsesInStall().clear();
                }
                stall.removeStable(stable);
            }
            allStalls.clear();
            allStables.remove(stable);

        }
    }


    public void showStalls() {
        String info = "Stajnia " + stableName + ": \n";
        for (Stall s : stalls) {
            info += "boks numer " + s.getStallNumber() + "\n";
        }
        System.out.println(info);
    }

    public static HashSet<Stall> getAllStalls() {
        return allStalls;
    }

    public void showEmployees() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Employee getDirector(){
        return director;
    }

    @Override
    public String toString() {
        return "Stable: " + stableName;
    }

    public String getStableName() {
        return stableName;
    }


}
