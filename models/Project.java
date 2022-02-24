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
            assignedContributors.add(contributor);
            return true;
        }
        for(Contributor assigned : assignedContributors){
            if(assigned.canMentor(role) && contributor.canWorkWithMentor(role)){
                assignedContributors.add(contributor);
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String out="Project : "+name+"\t"+"Best Before  : "+bestBefore+"\n";
        for(Role r : roles){
            out+="Role : " + r.name+"\t"+"Level : "+r.level+"\n";
        }
        return out;

    }
}
