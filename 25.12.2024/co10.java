import java.io.*;
import java.util.*;
public class Solution{

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();

        StringTokenizer sT=new StringTokenizer(s, "[ !,?._'@]+");
        System.out.println(sT.countTokens());
        while(sT.hasMoreTokens()){
            System.out.println(sT.nextToken());
        }
        scan.close();
    }
}
