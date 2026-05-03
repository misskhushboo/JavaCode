package com.assessment.parkinglot.enums;

public enum SpotSize {
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE");
    String spotType;
    SpotSize(String spotType){
        this.spotType = spotType;
    }
}
