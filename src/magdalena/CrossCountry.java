package magdalena;

import java.util.Date;

/**
 * Created by Magdalena on 2017-04-26.
 */
public class CrossCountry extends ShowJumping implements IEnduranceRiding {

    /**
     * Distance in kilometres
     */
    private double distance;

    public CrossCountry(String compName, CompetitionLevel competitionLevel, Date date, double price, int numberOfObstacles, double distance) {
        super(compName, competitionLevel, date, price, numberOfObstacles);
        this.distance = distance;
    }

    public CrossCountry(String compName, CompetitionLevel competitionLevel, Date date, int maxContestantNumber, int numberOfObstacles, double distance) {
        super(compName, competitionLevel, date, maxContestantNumber, numberOfObstacles);
        this.distance = distance;
    }

    @Override
    public int getObstaclesNumber() {
        return getNumberOfObstacles();

    }

    @Override
    public void setObstaclesNumber(int obstaclesNumber) {
        setNumberOfObstacles(obstaclesNumber);

    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String calculateDifficulty() {
        return null;
    }

    @Override
    public void setPrize(double prize) {
        super.setPrize(prize+getObstaclesNumber()*getDistance());
    }

    @Override
    public String toString() {
        if (getCompetitionType() == CompetitionType.Ogolnopolskie) {
            return "Ogólnopolski bieg przełajowy " +
                    getCompName() +
                    ", klasa " + getCompetitionLevel() +
                    ", data " + getDate() +
                    ", wpisowe " + getPrice() +
                    ", liczba przeszkód " + getObstaclesNumber() +
                    ", dystans " + distance;
        } else
            return "Regionalny bieg przełajowy " +
                    getCompName() +
                    ", klasa " + getCompetitionLevel() +
                    ", data " + getDate() +
                    ", maksymalna liczba zawodników " + getMaxContestantNumber() +
                    ", liczba przeszkód " + getObstaclesNumber() +
                    ", dystans " + distance;
    }
}
