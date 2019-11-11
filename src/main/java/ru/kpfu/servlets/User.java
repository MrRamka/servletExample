package ru.kpfu.servlets;

public class User {
    private String name;
    private String email;
    private String country;
    private boolean sex;
    private String about;
    private boolean consentForDataProcessing;

    public User(String name, String email, String country, boolean sex, String about, boolean consentForDataProcessing) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.sex = sex;
        this.about = about;
        this.consentForDataProcessing = consentForDataProcessing;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public boolean isSex() {
        return sex;
    }

    public String getAbout() {
        return about;
    }

    public boolean isConsentForDataProcessing() {
        return consentForDataProcessing;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", sex=" + '\'' + (sex ? "Male" : "Female") + '\'' +
                ", about='" + about + '\'' +
                ", consentForDataProcessing=" + (consentForDataProcessing ? "Yes" : "No") +
                '}';
    }
}
