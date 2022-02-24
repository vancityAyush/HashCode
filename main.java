import java.util.*;
import java.io.*;

import models.*;

class main{
    static int nContributors;
    static int nProjects;

    public static void input() {
        try{
            FileInputStream fstream=new FileInputStream("./input/input_file.txt");
            DataInputStream in=new DataInputStream(fstream);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            String strLine=br.readLine();

            System.out.println(strLine);

            in.close();
        }
        catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    public static void main(String args[]){
        input();
        Role role=new Role(5,"anyh");

    }
}