package models;

import java.util.ArrayList;
public class Contributor {
    String name;
    int noOfSkills;
    ArrayList<Skill> skills;
    private  Project currentAssigned;
    public Contributor(String name,int noOfSkills){
        this.name=name;
        this.noOfSkills=noOfSkills;
        skills = new ArrayList<>();
    }
    public void addSkill(String name, int level){
        Skill newSkill = new Skill(name, level);
        skills.add(newSkill);
    }
    void assign(Project p){
        p.assignedContributors.add(this);
        currentAssigned=p;
    }
    boolean canWork(Role role){
        for(Skill mySkill : skills){
            if(role.name.equals(mySkill.name)){
                if(role.level<=mySkill.level)
                    return true;
            }
        }
        return false;
    }
    boolean canWorkWithMentor(Role role){
        for(Skill skill : skills){
            if(skill.name.equals(role.name)){
                if(role.level-skill.level==1)
                    return true;
            }
        }
        if(role.level==1)
            return true;
        return false;
    }
    boolean canMentor(Role role){
        return canWork(role);
    }

    @Override
    public String toString() {
        return name+"\t"+noOfSkills+"\t";
    }
}
