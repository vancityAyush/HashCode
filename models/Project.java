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

    public void addRole(String role, int levelRequired){
        roles.add(new Role(levelRequired, role));
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
