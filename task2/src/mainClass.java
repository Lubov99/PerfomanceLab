import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) throws IOException {


        double point[][]= new double[101][2];
        double circle[] = new double[2];
        double R = 10;

        String p1 = "";
        String p2 = "";
        p1 = args[0];
        p2 = args[1];
        String str1 = "";
        Path path1 = Paths.get(p1);   //"X:/qqq/f1.txt"
        Scanner scan1 = new Scanner(path1);
        int i1 = 0;
        while (scan1.hasNextLine()){
            str1 = scan1.nextLine();
            str1 = str1.replace('.',',');
            Scanner scan11 = new Scanner(str1);
            if(i1==0){
                int i2 = 0;

                while (scan11.hasNextDouble()){
                    circle[i2]=scan11.nextDouble();
                    i2 = i2+1;
                }
            }
            if(i1==1){
                R =scan11.nextDouble();
            }
            i1 = i1 +1;
        }
        String str2 = "";
        Path path2 = Paths.get(p2); //X:/qqq/f2.txt
        Scanner scan2 = new Scanner(path2);
        int l1 = 0;
        while (scan2.hasNextLine()){
            str2 = scan2.nextLine();
            str2 = str2.replace('.',',');
            Scanner scan21 = new Scanner(str2);

                int l2 = 0;

                while (scan21.hasNextDouble()){
                    point[l1][l2]=scan21.nextDouble();
                    l2 = l2+1;
                }

                if(l2==0){
                    break;
                }

                l1 = l1 +1;
        }

        int num = l1-1;
        int i = 0;
        double answer;
        String ret = "";


while (i <= num){
    answer = ((point[i][0] - (circle[0])) * (point[i][0] - (circle[0]))) + ((point[i][1] - (circle[1])) * (point[i][1] - (circle[1])));
    if (answer < (R * R)){
        ret = ret + "1\n";
        i=i+1;
        continue;
    }
    if (answer == (R * R)){
        ret = ret + "0\n";
        i=i+1;
        continue;
    }else{
        ret = ret + "2\n";
        i=i+1;
        continue;
    }


}

        System.out.println(ret);


    }
}
