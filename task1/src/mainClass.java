import java.lang.reflect.Array;

public class mainClass {
    public static void main(String[] args) {


        int n = 4;
        int m = 3;
        n = Integer.parseInt(args[0]);
        m = Integer.parseInt(args[1]);
        //System.out.println(n);
        //System.out.println(m);
        int answer = 1;
        int ar[] = new int[100000];
        int k = 1;

        int r = 0;
        while (r<n){
        ar[r] = r + 1;
        r = r + 1;
        }

        String ret = "1";
        answer = 0;
        while (answer!=1){

            int i = m;
            int j = k-1;
            while (i>0){
                k=ar[j];
                j = j+1;
                if(j==n){
                    j=0;
                }

                i = i-1;
            }
            answer=k;
            if(answer !=1){
                ret = ret + answer;
            }

        }

        System.out.println(ret);

    }
}
