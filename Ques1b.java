import java.util.Scanner;
public class Ques1b{
    public static void main(String args[]) {
      int pyramidHeight=5;
      //Scanner sc = new Scanner(System.in);
      //pyramidHeight = sc.nextInt();
      char c = 'A';
      for(int i=0;i<pyramidHeight;i++){
          for(int j=0;j<2*(pyramidHeight-i-1);j++)
            System.out.print(" ");
          for(int j=0;j<i+1;j++,c++)
            System.out.print(c+" " );
          System.out.println("");
          System.out.println("");
      }
    }
}