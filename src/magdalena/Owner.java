package magdalena;

import java.util.Map;
import java.util.TreeMap;

//Asocjacja kwalifikowana
public class Owner extends Person{

    /**
     * Opłata
     */
    private double charge;

    /**
     * Konie, które posiada
     */
    private TreeMap<String, Horse> ownerHorseMap = new TreeMap<>();

    public Owner(Person person, double charge) {
        super(person.getName(), person.getSurname(), person.getBirthDate(), person.getPhoneNumber());
        this.charge = charge;
    }

    public void changeCharge(double charge) {
        this.charge = charge;
    }

    //Nie dodawaj konia, jeżeli jest już na liście dany numer paszportu
    public void addHorse(Horse horse) throws Exception {
        if(!ownerHorseMap.containsKey(horse.getPassportNumber())) {
            ownerHorseMap.put(horse.getPassportNumber(), horse);
            if(!horse.getOwner().equals(this)) {
                horse.setOwner(this);
            }
        }
    }


    //Znajdź konia po paszporcie
    public Horse findHorse(String passportNumber) throws Exception {
        if(!ownerHorseMap.containsKey(passportNumber)){
            throw new Exception("Nie odnaleziono konia o podanym numerze paszportu" + passportNumber);
        }
        return ownerHorseMap.get(passportNumber);
    }

    public void showOwnersHorses() {
        for (Map.Entry<String, Horse> entry : ownerHorseMap.entrySet()) {
            String value = entry.getValue().toString();
            System.out.println(getName() + ": " + value);
        }
    }

    public void setCharge(double ch){
        if(ch > 1.1*this.charge){
            System.out.println("Nie można podnieść opłaty jednorazowo o więcej niż 10%");
        }
        this.charge = ch;
    }

    public void removeHorse(Horse horse){
        ownerHorseMap.remove(horse.getPassportNumber(), horse);
    }

    @Override
    public String toString() {
        return  getName() + " " +
                getSurname() + ", " +
                getPhoneNumber();
    }
}