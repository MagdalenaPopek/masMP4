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

        /**
         * KLASA ABSTRAKCYJNA I POLIMORFIZM METOD
         */
        System.out.println("----------ABSTRAKCYJNA I POLIMORFIZM----------");
        Employee emp = new Groom("A", "B", date, "12222", date, 1000);
        Employee emp2 = new Instructor("D", "B", date, "22223445", date, 1000, "22222", "33333");
        System.out.println(emp + " " + emp.getIncome());
        System.out.println(emp2 + " " + emp2.getIncome());

        /**
         * OVERLAPPING
         */
        System.out.println("----------OVERLAPPING----------");
        /*User testUser = new User("Anna", "K", date, "333");
        Client ok = Client.createClient(testUser, 152, LevelType.advanced);
        Contestant.createContestant(testUser);
        testUser.showAllPeople();
        System.out.println(a.getUser());*/
        Client a = Client.createClient("A", "B", date, "11111", 173, LevelType.advanced);
        User u = new User("My", "new", date, "4444", 172, LevelType.advanced);
        u.showAllPeople();
/*
        Contestant.createContestant(a.getUser());
        a.getUser().showAllPeople();*/


        /**
         * WIELODZIEDZICZENIE
         */
        System.out.println("----------WIELODZIEDZICZENIE----------");
        Competition cross = new CrossCountry("Memo", CompetitionLevel.C, date, 123.0, 7, 2);
        System.out.println(cross);
        cross.setPrize(20);
        System.out.println(cross.getPrize());

        /**
         * WIELOASPEKTOWE
         */
        System.out.println("----------WIELOASPEKTOWE----------");
        cross.toString();
        System.out.println(cross.getCompetitionType());

        /**
         * DYNAMIC
         */
        System.out.println("----------DYNAMICZNE----------");
        User us = new User("A", "K", date, "000");
        Employee groom = new Groom(us, date, 12334);
        System.out.println(groom);
        groom = new Instructor(groom, "1222", "12226");
        System.out.println(groom);
    }
}
