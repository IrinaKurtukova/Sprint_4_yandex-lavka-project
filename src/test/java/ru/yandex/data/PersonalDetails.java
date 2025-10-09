package ru.yandex.data;

public class PersonalDetails {

    public final String name;
    public final String surname;
    public final String address;
    public final String stationName;

    public PersonalDetails(String name, String surname, String address, String stationName) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.stationName = stationName;
    }
}