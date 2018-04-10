package com.dr.SamirAbbas.models;

/**
 * Created by Anurag on 4/9/2018.
 */

public class DoctorInfo {
    private String docName;
    private String docQualification;
    private String docOccupation;
    private boolean isAvailable;
    private String docExperience;
    private String profile;

    public DoctorInfo(String docName, String docQualification, String docOccupation, String docExperience) {
        this.docName = docName;
        this.docQualification = docQualification;
        this.docOccupation = docOccupation;
        this.docExperience = docExperience;

    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocQualification() {
        return docQualification;
    }

    public void setDocQualification(String docQualification) {
        this.docQualification = docQualification;
    }

    public String getDocOccupation() {
        return docOccupation;
    }

    public void setDocOccupation(String docOccupation) {
        this.docOccupation = docOccupation;
    }

    public boolean isAvalable() {
        return isAvailable;
    }

    public void setAvalable(boolean avalable) {
        isAvailable = avalable;
    }

    public String getDocExperience() {
        return docExperience;
    }

    public void setDocExperience(String docExperience) {
        this.docExperience = docExperience;
    }
}
