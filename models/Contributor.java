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
        skills.add(newSkill);
    }
    boolean canWork(Role role){
        for(Skill skill : skills){
            if(role.name==skill.name){
                if(role.level>=skill.level)
                    return true;
            }
        }
        return false;
    }
    boolean canWorkWithMentor(Role role){
        for(Skill skill : skills){
            if(skill.name==role.name){
                if(role.level-skill.level==1)
                    return true;
            }
        }
        return false;
    }
}
