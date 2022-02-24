import models.Contributor;
import models.Role;

import java.util.*;
import java.io.*;

class main{
    static int nContributors;
    static int nProjects;
    static ArrayList<Contributor> contributorList;

    public static void input() {
        try{
            FileInputStream fstream=new FileInputStream("input/a_an_example.in.txt");
            DataInputStream in=new DataInputStream(fstream);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            String strLine=br.readLine();

            String[] tokens = strLine.split(" ");

            nContributors = Integer.parseInt(tokens[0]);
            nProjects = Integer.parseInt(tokens[1]);

            for(int i = 0; i < nContributors; ++i) {
                strLine = br.readLine();
                tokens = strLine.split(" ");

                String contributorName = tokens[0];
                int nSkills = Integer.parseInt(tokens[1]);
                //System.out.println(contributorName + " " + nSkills + 1);
                Contributor contributorObject = new Contributor(contributorName, nSkills);
                System.out.println(contributorObject.toString());

                for(int j=0; j<nSkills; ++j) {
                    strLine = br.readLine();
                    tokens = strLine.split(" ");

                    String skillName = tokens[0];
                    System.out.println(skillName);
                    int skillLevel = Integer.parseInt(tokens[1]);

                    contributorObject.addSkill(skillName, skillLevel);
                    System.out.println(skillName);
                }


                //contributorList.add(new Contributor(tokens[0], ));
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