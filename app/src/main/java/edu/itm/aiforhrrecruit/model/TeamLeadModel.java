package edu.itm.aiforhrrecruit.model;

import java.util.Objects;

public class TeamLeadModel {

    public String name;
    public String competencyList;
    public String key;


    public TeamLeadModel() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompetencyList() {
        return competencyList;
    }

    public void setCompetencyList(String competencyList) {
        this.competencyList = competencyList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamLeadModel that = (TeamLeadModel) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
