import models.Contributor;
import models.Project;
import models.Role;

import java.util.*;
import java.io.*;

class main{
    static int nContributors;
    static int nProjects;
    static ArrayList<Contributor> contributorList = new ArrayList<>();
    static ArrayList<Project> projectList = new ArrayList<>();
    static ArrayList<Role> roleList = new ArrayList<>();

    public static void input() {
        try{
            FileInputStream fstream=new FileInputStream("HashCode/input/input_file.txt");
            DataInputStream in=new DataInputStream(fstream);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            String strLine=br.readLine();

            String[] tokens = strLine.split(" ");

            nContributors = Integer.parseInt(tokens[0]);
            nProjects = Integer.parseInt(tokens[1]);

            for(int i = 0; i < nContributors; ++i) {  //CONTRIBUTOR LOOP
                strLine = br.readLine();
                tokens = strLine.split(" ");

                String contributorName = tokens[0];
                int nSkills = Integer.parseInt(tokens[1]);
                //System.out.println(contributorName + " " + nSkills + 1);
                Contributor contributorObject = new Contributor(contributorName, nSkills);

                for(int j=0; j<nSkills; ++j) { // SKILL LOOP
                    strLine = br.readLine();
                    tokens = strLine.split(" ");

                    String skillName = tokens[0];
                    int skillLevel = Integer.parseInt(tokens[1]);
                    contributorObject.addSkill(skillName, skillLevel);
                }
                contributorList.add(contributorObject);
            }

            for(int i=0; i<nProjects; ++i) {
                strLine = br.readLine();
                tokens = strLine.split(" ");

                String projectName = tokens[0];
                int noOfDays = Integer.parseInt(tokens[1]);
                int score = Integer.parseInt(tokens[2]);
                int bestBefore = Integer.parseInt(tokens[3]);
                int noOfRoles = Integer.parseInt(tokens[4]);

                Project tempObject = new Project(projectName, noOfDays, score, bestBefore, noOfRoles);

                for(int j=0; j<noOfRoles; ++j) {
                    strLine = br.readLine();

                    tokens = strLine.split(" ");
                    tempObject.addRole(tokens[0], Integer.parseInt(tokens[1]));

                }
                System.out.println(tempObject.toString());
            }
            in.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]){
        input();

    }
}