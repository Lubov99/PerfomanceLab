import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainClass {
    public static void main(String[] args) throws IOException {
       String[] values =  new String[9000];
       // Path path1 = Paths.get(args[0]);   //"X:/qqq/f1.txt"
        Path path1 = Paths.get(args[1]);   //"X:/qqq/f1.txt"
        Scanner scan1 = new Scanner(path1);

        String val = "";
        while (scan1.hasNextLine()){
            val = val + scan1.nextLine();
        }
        Pattern pattern7 = Pattern.compile("id\": (.*?),");
        Matcher matcher7 = pattern7.matcher(val);
        Pattern pattern8 = Pattern.compile("value\": (.*?)}");
        Matcher matcher8 = pattern8.matcher(val);
        int q=0;
        while (matcher7.find()&&matcher8.find()){
            int start7=matcher7.start();
            int end7=matcher7.end();
            int start8=matcher8.start();
            int end8=matcher8.end();
            values[q]= val.substring(start7,end7) + val.substring(start8,end8);
            q=q+1;
        }

      //  System.out.println(Arrays.toString(values));

        String report = "";
        //Path path2 = Paths.get(args[1]);   //"X:/qqq/f1.txt"
        Path path2 = Paths.get(args[0]);   //"X:/qqq/f1.txt"
        Scanner scan2 = new Scanner(path2);
        int a =0;
        while (scan2.hasNextLine()){
            String Case2 = scan2.nextLine();
            if(a!=0){
                report = report + "\n" + Case2;
            }
            else {
                report = report +  Case2;
            }
            a = a+1;
        }
        Pattern pattern = Pattern.compile("id\": (.+?),");
        Matcher matcher = pattern.matcher(report);
        Pattern pattern2 = Pattern.compile("value\": \"\"");
        Matcher matcher2 = pattern2.matcher(report);
        String[] toRep = new String[1000];
        String[] rep = new String[1000];
        int rr =0;
        while (matcher.find()){



            int start=matcher.start();
            int end=matcher.end();
            String id = report.substring(start,end);
          //  System.out.println("найден айди" + id);

            int p = 0;
            while (p < q){
                if(values[p].contains(id)){
                    //System.out.println("найден айди в ответах");
                    String res = "";
                    Pattern pattern3 = Pattern.compile("value\": \"(.*?)\"");
                    Matcher matcher3 = pattern3.matcher(values[p]);
                    matcher3.find();
                    int start3=matcher3.start();
                    int end3=matcher3.end();
                    res = values[p].substring(start3+8,end3);

                    matcher2.find();
                    int start2=matcher2.start();
                    int end2=matcher2.end();
                    //res = report.substring(start2+8,end2);
                    System.out.println("res "+res);
                    String toReplace = report.substring(start,end2);
                    toRep[rr]=toReplace;
                    System.out.println("to replace "+toReplace);
                    String replace = toReplace.replace("\"\"",res);
                    rep[rr] = replace;
                    System.out.println("replace "+replace);
                    rr=rr+1;
                    //report = report.replace(toReplace,replace);
                }
                p = p+1;
            }



        }
        System.out.println(report);


        int kk = 0;
        while (kk<rr){
            report = report.replace(toRep[kk],rep[kk]);
            System.out.println("toRep "+toRep[kk]);
            System.out.println("rep " + rep[kk]);

            kk=kk+1;

        }

        System.out.println(report);
        File file = new File("report.json");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(report);
        writer.flush();
        //writer.close();

    }
}
