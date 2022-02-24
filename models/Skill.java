package models;

public class Skill{
    int level;
    String name;
    void levelUp(){
        level++;
    }
    public Skill(String name, int level) {
        this.level = level;
        this.name = name;
    }

    @Override
    public boolean equals(Role role) {
        return name==role.name;
    }
}