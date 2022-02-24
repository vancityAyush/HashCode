package models;

import java.util.ArrayList;
public class Contributor {
    String name;
    int noOfSkills;
    ArrayList<Skill> skills;
    Contributor(String name,int noOfSkills){
        this.name=name;
        this.noOfSkills=noOfSkills;
    }
    void addSkill(String name, int level){
        Skill newSkill = new Skill(level, name);

    }
}
