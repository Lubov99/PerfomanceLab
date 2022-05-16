import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) throws IOException {

        int[] numbers = new int[100000];

        int lenght = 0;
        int answer = 0;
        int k = 0;

        Path path1 = Paths.get(args[0]);   //"X:/qqq/f1.txt"
        Scanner scan1 = new Scanner(path1);
        int q =0;
        while (scan1.hasNextInt()){
            numbers[q] = scan1.nextInt();
            q = q +1;
        }
        lenght = q;
        int[] numbers1 = Arrays.copyOfRange(numbers, 0, lenght);
        Arrays.sort(numbers1);



        if ((numbers1.length % 2) == 0) {
            int cen = 0;
            cen = (numbers1[numbers1.length / 2] + numbers1[(numbers1.length / 2) - 1]) / 2;


            int count1 = numbers1.length / 2 - 1;
            while (count1 >= 0){
                answer = answer + cen - numbers1[count1];

                count1 = count1 -1;
            }

            int count2 = numbers1.length - 1;
            while (count2 > numbers1.length / 2 - 1){

                answer = answer + numbers1[count2] - cen;
                count2 = count2 -1;
            }


        }
        else {
            int count3 = numbers1.length - 1;
            while (count3 > numbers1.length / 2){
                answer = answer + numbers1[count3] - numbers1[numbers1.length / 2];
                count3 = count3-1;
            }

            int count4 = (lenght / 2) - 1;
            while (count4>=0){
                answer = answer + numbers1[numbers1.length / 2] - numbers1[count4];
                count4 = count4-1;
            }

        }

        System.out.println(answer);
    }
}
