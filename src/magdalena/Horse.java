package magdalena;

import java.util.Date;
import java.util.HashSet;

public class Horse {

    private static HashSet<Horse> allHorses = new HashSet<Horse>();

    private Stall stall;

    private Meadow meadow;

    /**
     * Imię
     */
    private String name;

    /**
     * Data urodzenia
     */
    private Date birthDate;

    /**
     * Numer paszportu
     */
    private String passportNumber;

    /**
     * Płeć
     */
    private String gender;

    /**
     * Właściciel
     */
    private Owner owner;

    public Horse(String name, Date birthDate, String passportNumber, String gender) throws Exception {
        this.name = name;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.gender = gender;
        if (!isPassportDifferent(passportNumber, allHorses)) {
            throw new Exception("Koń o podanym numerze paszportu już istnieje");
        }
        allHorses.add(this);
    }

    private boolean isPassportDifferent(String passportNumber, HashSet<Horse> allHorses) {
        for (Horse h : allHorses) {
            if (h.getPassportNumber().equals(passportNumber)) {
                return false;
            }
        }
        return true;
    }

    public void addStall(Stall stall) throws Exception {
        if (this.stall == null && this.meadow == null) {
            this.stall = stall;
            stall.addHorse(this);
        }else{
            throw new Exception("Koń już ma gdzie mieszkać");
        }
    }

    public void addMeadow(Meadow meadow) throws Exception {
        if (this.stall == null && this.meadow == null) {
            this.meadow = meadow;
            meadow.addHorse(this);
        }else{
            throw new Exception("Koń już ma gdzie mieszkać");
        }
    }

    public void removeStall() {
        this.stall = null;
    }

    public void setOwner(Owner owner) throws Exception {
        if (this.owner == null) {
            this.owner = owner;
            owner.addHorse(this);
        }
    }

    public void removeMeadow() {
        this.meadow = null;
    }

    public String getHorsesStall() {
        return "Koń " + name + " mieszka w boksie " + stall.getStallNumber();
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void removeOwner() {
        this.owner = null;
    }

    public Owner getOwner() {
        return owner;
    }


    @Override
    public String toString() {
        return name + ", " + birthDate +
                ", " + passportNumber +
                ", " + gender;
    }


}