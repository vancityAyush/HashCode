package models;

import java.util.ArrayList;

public class Project {
    String name;
    int daysToComplete,score,bestBefore,noOfRoles;
    ArrayList<Role> roles;

    public Project(String name, int daysToComplete, int score, int bestBefore, int noOfRoles) {
        this.name = name;
        this.daysToComplete = daysToComplete;
        this.score = score;
        this.bestBefore = bestBefore;
        this.noOfRoles = noOfRoles;
        roles = new ArrayList<>();
    }

    void addRole(String role, int levelRequired){
        roles.add(new Role(levelRequired, role));
    }

    @Override
    public String toString() {
        return "Project : "+name+"\t"+"Best Before  : "+bestBefore;

    }
}
