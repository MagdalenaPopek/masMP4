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


       /* Employee alicja = new Employee(new Person("Alicja", "Nowa", date, "1233"), date, 1275);
        Employee ewa = new Employee(new Person("Ewa", "K", date, "1443"), date, 2375);
        stajenka.addEmployee(alicja, RoleType.jestPracownikiem);
        System.out.println("Alicja " + alicja.getRoleType());
        ewa.addStable(stajenka, RoleType.jestPracownikiem);
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
        comp.getContestantsInComp();*/

        System.out.println("==============");

        /*Meadow m = Meadow.createMeadow(stajenka, 6600);
        System.out.println(m.getMaxHorsesNumber());
        Stall s = Stall.createStall(stajenka, 24);

        h.addMeadow(m);
        m.getHorsesOnMeadow();*/

       /* Horse h = new Horse("K", date, "11111", "k");
        Competition comp = new Competition(date, "Jeden");
        RidingSchool rs = new RidingSchool("Szkółka");
        h.setRidingSchool(rs);
        h.removeRidingSchool();
        HorseCompetition hc = new HorseCompetition(h, comp);
        hc.remove();
        h.setRidingSchool(rs);
        comp.showHorses();
        rs.showHorses();
        System.out.println(h.isShowHorse());*/

        Person uno = new Person("Uno", "Uno", date, "111");
        Person dos = new Person("Dos", "Dos", date, "222");
        Employee e = new Employee(uno, date, 1233);
        Employee f = new Employee(dos, date, 3333);

        e.addStable(stajenka);
        stajenka.showEmployees();

        e.setDirector();
        System.out.println("Dyrek " + stajenka.getDirector());
        System.out.println(e.isDirector());

        e.removeDirector();
        System.out.println("Dyrek " + stajenka.getDirector());
        System.out.println(e.isDirector());

        /*System.out.println("--------");
        stajenka.addEmployee(e);
        stajenka.addDirector(e);
        System.out.println(e.isDirector());
        System.out.println("Dyrek " + stajenka.getDirector());
        stajenka.removeDirector();
        System.out.println("Dyrek " + stajenka.getDirector());
        stajenka.showEmployees();
        System.out.println(e.isDirector());*/



    }
}
