package models;

import java.util.ArrayList;

public class Project {
    String name;
    int daysToComplete,score,bestBefore,noOfRoles;
    public ArrayList<Role> roles;
    ArrayList<Contributor> assignedContributors;

    public Project(String name, int daysToComplete, int score, int bestBefore, int noOfRoles) {
        this.name = name;
        this.daysToComplete = daysToComplete;
        this.score = score;
        this.bestBefore = bestBefore;
        this.noOfRoles = noOfRoles;
        roles = new ArrayList<>();
        assignedContributors = new ArrayList<>();
    }

    public void addRole(String role, int levelRequired){
        roles.add(new Role(levelRequired, role));
    }

    public boolean assign(Contributor contributor, Role role){  // Assign contributor to role
        if(contributor.canWork(role)){
            role.assignRole(contributor,this);
            System.out.println(contributor.name+" assigned to "+role.name+" for project "+name);
            return true;
        }
        for(Contributor assigned : assignedContributors){
            if(assigned.canMentor(role) && contributor.canWorkWithMentor(role)){
                role.assignRoleWithMentor(contributor,this);
                System.out.println(contributor.name+" assigned to "+role.name+" with mentor "+assigned.name+" for project "+name);
                return true;
            }
        }
        System.out.println(contributor.name+" cannot be assigned to "+role.name+" for project "+name);
        return false;
    }
    @Override
    public String toString() {
        return name;

    }
}
