package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Contributor {
    String name;
    int noOfSkills;
    HashMap<String,Skill> skills=new HashMap<>();
    private  Project currentAssigned;
    private Role currentRole;

    public Contributor(String name,int noOfSkills){
        this.name=name;
        this.noOfSkills=noOfSkills;
    }
    public void addSkill(String name, int level){
        Skill newSkill = new Skill(name, level);
        skills.put(name,newSkill);
    }

    public void addSkill(Role role){
        skills.put(role.name,role);
    }
    void assign(Project p, Role r){
        if(currentAssigned == null) {
            p.assignedContributors.add(this);
            currentRole = r;
            currentAssigned = p;
        }
    }
    public boolean canWork(Role role){
        Skill skill = skills.get(role.name);
        if(skill!=null)
            if(role.level<=skill.level)
                return true;
        return false;
    }
    public boolean canWork(Project project){
        for(Role role : project.roles){
            if(canWork(role) || canWorkWithMentor(role))
                return  true;
        }
        return false;
    }
    public ArrayList<Role> rolesEligibleToWork(Project project){
        ArrayList<Role> rolesEligibleToWork=new ArrayList<>();
        for(Role role : project.roles){
            if(canWork(role))
                rolesEligibleToWork.add(role);
        }
        return rolesEligibleToWork;
    }
    boolean canWorkWithMentor(Role role){
        Skill skill = skills.get(role.name);
        if(skill!=null)
                if(role.level-skill.level==1)
                    return true;
        if(role.level==1)
            return true;
        return false;
    }
    boolean canMentor(Role role){
        return canWork(role);
    }

    public void complete() {
        boolean isLevelledUp=false;
        if(currentAssigned != null) {
            Skill skill = skills.get(currentRole.name);
            if(skill!=null)
                    if(currentRole.level >= skill.level) {
                        skill.levelUp();
                        isLevelledUp=true;
            }
            if(currentRole.level==1&&!isLevelledUp){
                this.addSkill(currentRole);
                isLevelledUp=true;
            }
        }
        System.out.println(name+" completed successfully");
        if(isLevelledUp){
            System.out.println(name+" improved "+currentRole.name);
        }
        currentAssigned = null;
        currentRole = null;
    }

    @Override
    public String toString() {
        return name;
    }
}
