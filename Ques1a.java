import java.util.Scanner;
public class Ques1a{
    public static void main(String args[]) {
      int pyramidHeight=5;
      //Scanner sc = new Scanner(System.in);
      //pyramidHeight = sc.nextInt();
      for(int i=0;i<pyramidHeight;i++){
          for(int j=0;j<pyramidHeight-i-1;j++)
            System.out.print(" ");
          for(int j=0;j<i+1;j++)
            System.out.print("* ");
          System.out.println("");
      }
    }
}