package models;

import java.util.ArrayList;
public class Contributor {
    String name;
    int noOfSkills;
    ArrayList<Skill> skills;
    private  Project currentAssigned;
    private Role currentRole;

    public Contributor(String name,int noOfSkills){
        this.name=name;
        this.noOfSkills=noOfSkills;
        skills = new ArrayList<>();
    }
    public void addSkill(String name, int level){
        Skill newSkill = new Skill(name, level);
        skills.add(newSkill);
    }
    void assign(Project p, Role r){
        if(currentAssigned == null) {
            p.assignedContributors.add(this);
            currentRole = r;
            currentAssigned = p;
        }
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

    public void complete() {
        if(currentAssigned != null) {
            for(Skill skill : skills) {
                if (currentRole.name.equals(skill.name)) {
                    if(currentRole.level >= skill.level) {
                        skill.levelUp();
                    }
                }
            }
            currentAssigned = null;
            currentRole = null;
        }
    }

    @Override
    public String toString() {
        return name+"\t"+noOfSkills+"\t";
    }
}
