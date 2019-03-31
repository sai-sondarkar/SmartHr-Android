package edu.itm.aiforhrrecruit.model;

import java.util.List;

public class CompetencyModel {

    public List<String> competencyLevel;
    public String competencyName;


    public CompetencyModel() {
        }

    public List<String> getCompetencyLevel() {
        return competencyLevel;
    }

    public void setCompetencyLevel(List<String> competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    public String getCompetencyName() {
        return competencyName;
    }

    public void setCompetencyName(String competencyName) {
        this.competencyName = competencyName;
    }


}
