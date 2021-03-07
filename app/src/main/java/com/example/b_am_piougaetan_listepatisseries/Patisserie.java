package com.example.b_am_piougaetan_listepatisseries;

public class Patisserie {
    private String patisserieName;
    private String patisserieDescription;
    private int patisserieId;


    // Constructor
    public Patisserie(String patisserieName, String patisserieDescription, int patisserieId) {
        this.patisserieName = patisserieName;
        this.patisserieDescription = patisserieDescription;
        this.patisserieId = patisserieId;
    }

    public Patisserie() {
        patisserieName = null;
        patisserieDescription = null;
        patisserieId = 0;
    }


    // Getters (Assesseurs)
    public String getPatisserieName() {
        return patisserieName;
    }

    public String getPatisserieDescription() {
        return patisserieDescription;
    }

    public int getPatisserieId() {
        return patisserieId;
    }


    // Setters (Mutateurs)
    public void setPatisserieName(String patisserieName) {
        this.patisserieName = patisserieName;
    }

    public void setPatisserieDescription(String patisserieDescription) {
        this.patisserieDescription = patisserieDescription;
    }

    public void setPatisserieId(int patisserieId) {
        this.patisserieId = patisserieId;
    }
}
