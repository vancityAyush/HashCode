package models;

public class Skill{
    private int level;
    String name;
    void levelUp(){
        level++;
    }
    public Skill(String name, int level) {
        this.level = level;
        this.name = name;
    }

    public boolean equals(Role role) {
        return name==role.name;
    }
}