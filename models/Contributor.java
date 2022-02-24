package models;

import java.util.ArrayList;
public class Contributor {
    String name;
    int noOfSkills;
    ArrayList<Skill> skills;
    public Contributor(String name,int noOfSkills){
        this.name=name;
        this.noOfSkills=noOfSkills;
        skills = new ArrayList<>();
    }
    public void addSkill(String name, int level){
        Skill newSkill = new Skill(name, level);
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

    @Override
    public String toString() {
        return name+"\t"+noOfSkills+"\t";
    }
}
