package models;

public class Role extends Skill{
    boolean isWorkingWithMentor;
    Project projectThisRoleBelongsTo;
    Contributor contributorThisRoleIsAssignedTo;

    public Role(int level, String name) {
        super(name, level);
    }

    void assignRole(Contributor contributor,Project project){
        if(contributor.currentRole==null){
            contributor.currentRole=this;
            project.assignedContributors.add(contributor);
        }
    }
    void assignRoleWithMentor(Contributor contributor,Project project){
        assignRole(contributor,project);
            project.assignedContributors.add(contributor);
        isWorkingWithMentor=true;
    }

    @Override
    public String toString() {
        return name;
    }
}
