package edu.itm.aiforhrrecruit.model;

public class CandidatesData {

    public String name;
    public int srno;
    public String key;
    public int previous_organisation1;
    public int previous_organisation2;
    public int previous_organisation3;
    public int previous_organisation1_months;
    public int previous_organisation2_months;
    public int previous_organisation3_months;
    public int salaray;
    public int position;
    public String competencies;

    public CandidatesData() {
    }

    public String getCompetencies() {
        return competencies;
    }

    public void setCompetencies(String competencies) {
        this.competencies = competencies;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSrno() {
        return srno;
    }

    public void setSrno(int srno) {
        this.srno = srno;
    }

    public int getPrevious_organisation1() {
        return previous_organisation1;
    }

    public void setPrevious_organisation1(int previous_organisation1) {
        this.previous_organisation1 = previous_organisation1;
    }

    public int getPrevious_organisation2() {
        return previous_organisation2;
    }

    public void setPrevious_organisation2(int previous_organisation2) {
        this.previous_organisation2 = previous_organisation2;
    }

    public int getPrevious_organisation3() {
        return previous_organisation3;
    }

    public void setPrevious_organisation3(int previous_organisation3) {
        this.previous_organisation3 = previous_organisation3;
    }

    public int getPrevious_organisation1_months() {
        return previous_organisation1_months;
    }

    public void setPrevious_organisation1_months(int previous_organisation1_months) {
        this.previous_organisation1_months = previous_organisation1_months;
    }

    public int getPrevious_organisation2_months() {
        return previous_organisation2_months;
    }

    public void setPrevious_organisation2_months(int previous_organisation2_months) {
        this.previous_organisation2_months = previous_organisation2_months;
    }

    public int getPrevious_organisation3_months() {
        return previous_organisation3_months;
    }

    public void setPrevious_organisation3_months(int previous_organisation3_months) {
        this.previous_organisation3_months = previous_organisation3_months;
    }

    public int getSalaray() {
        return salaray;
    }

    public void setSalaray(int salaray) {
        this.salaray = salaray;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


}
