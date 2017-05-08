package magdalena;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {

        //Tu tworzę datę, bo potem za dużo zabawy z dodawaniem nowych dat urodzenia etc
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse("2007-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Stable stajenka = new Stable("stajenka", "Okopowa 5, Warszawa", "1234567");


        Employee alicja = new Employee(new Person("Alicja", "Nowa", date, "1233"), date, 1275);
        Employee ewa = new Employee(new Person("Ewa", "K", date, "1443"), date, 2375);
        stajenka.addEmployee(alicja, RoleType.pracujeW);
        System.out.println("Alicja " + alicja.getRoleType());
        ewa.addStable(stajenka, RoleType.pracujeW);
        System.out.println("Ewa " + ewa.getRoleType());
        System.out.println("Ewa stajnia " + ewa.getStable());
        stajenka.addEmployee(alicja, RoleType.jestPrezesem);
        System.out.println("Alicja " + alicja.getRoleType());
        stajenka.getEmpRoles();
        System.out.println("Alicja stajnia " + alicja.getStable());

        Person uno = new Person("Uno", "Uno", date, "111");
        Person dos = new Person("Dos", "Dos", date, "222");
        Competition comp = new Competition(date, "Jeden");
        Contestant jeden = new Contestant(uno, comp);
        Contestant dwa = new Contestant(dos, comp);
        comp.getContestantsInComp();

        System.out.println("==============");
        Meadow m = Meadow.createMeadow(stajenka, 24.6, 3);
        Stall s = Stall.createStall(stajenka);
        Horse h = new Horse("K", date, "11111", "k");
        h.addMeadow(m);
        s.addHorse(h);
        m.getHorsesOnMeadow();


    }
}
