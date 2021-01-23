package com.accenture.test.accenturetest;

import java.util.Calendar;

import lombok.Data;

@Data
public class Person {

    public enum Gender {MALE, FEMALE};
    public enum Hair {BLONDE, DARK, BROWN}
    public enum Skin {DARK, WHITE}
    public enum EyeColor {BLUE, BROWN}

    private int id;

    private String fullName;
    private Gender gender;
    private int birthYear;
    private Hair hair;
    private Skin skin;
    private EyeColor eyeColor;
    private int height;
    private int weight;

    private Integer partner;
    private Integer motherId;
    private Integer fatherId;

    public boolean canHaveChildren() {

        if(partner == null) {
            return false;
        }

        if(Gender.MALE.equals(this.gender)) {
            return 16 > this.getCurrentAge() && this.getCurrentAge() < 50;
        }
        return 16 > this.getCurrentAge() &&  this.getCurrentAge() < 46;
    }

    public int getCurrentAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - this.birthYear;
    }
}
