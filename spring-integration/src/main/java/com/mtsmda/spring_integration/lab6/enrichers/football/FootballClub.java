package com.mtsmda.spring_integration.lab6.enrichers.football;

/**
 * Created by dminzat on 11/24/2016.
 */
public class FootballClub {

    private String footballClubName;
    private int place;
    private String footballNextPath;

    public FootballClub() {

    }

    public FootballClub(String footballClubName, int place) {
        this.footballClubName = footballClubName;
        this.place = place;
    }

    public String getFootballClubName() {
        return footballClubName;
    }

    public void setFootballClubName(String footballClubName) {
        this.footballClubName = footballClubName;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getFootballNextPath() {
        return footballNextPath;
    }

    public void setFootballNextPath(String footballNextPath) {
        this.footballNextPath = footballNextPath;
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "footballClubName='" + footballClubName + '\'' +
                ", place=" + place +
                ", footballNextPath='" + footballNextPath + '\'' +
                '}';
    }
}