package models;

public class Skill{
    int level;
    String name;
    void levelUp(){
        level++;
    }

    public Skill(int level, String name) {
        this.level = level;
        this.name = name;
    }
}