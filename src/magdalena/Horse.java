package magdalena;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Horse {

    private static HashSet<Horse> allHorses = new HashSet<Horse>();

    private Stall stall;

    private Meadow meadow;

    /**
     * Szkółka, do której należy koń
     */
    private RidingSchool ridingSchool;

    private boolean isShowHorse;
    private HashSet<HorseCompetition> whereTookPart = new HashSet<>();
    private static HashMap<String, Horse> isUnique = new HashMap<>();

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
        this.setPassportNr(passportNumber);
        allHorses.add(this);
    }

    private void setPassportNr(String passportNumber) throws Exception {
        if(isUnique.containsKey(passportNumber)){
            throw new Exception("Istnieje kon o tym numerze paszportu");
        } else {
            this.isUnique.put(passportNumber, this);
        }
    }



    public void addStall(Stall stall) throws Exception {
        if (this.stall == null && this.meadow == null) {
            this.stall = stall;
            stall.addHorse(this);
        }
    }

    public void addMeadow(Meadow meadow) throws Exception {
        if (this.stall == null && this.meadow == null) {
            this.meadow = meadow;
            meadow.addHorse(this);
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

    public void setIsShowHorse(HorseCompetition horseCompetition) {
        if (this.ridingSchool == null) {
            this.isShowHorse = true;
            horseCompetition.setHorse(this);
        }
    }

    public void removeShowHorse(){
        this.isShowHorse = false;

    }

    public boolean isShowHorse() {
        return isShowHorse;
    }

    public void setRidingSchool(RidingSchool ridingSchool) {
        if (!isShowHorse) {
            this.ridingSchool = ridingSchool;
            ridingSchool.addHorse(this);
        }
    }

    public void removeRidingSchool() {
        if (this.ridingSchool != null) {
            ridingSchool.removeHorse(this);
            this.ridingSchool = null;
        }
    }

    public RidingSchool getRidingSchool() {
        return ridingSchool;
    }
}