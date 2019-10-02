import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.DecimalFormat;

public class GaussJordan
{
  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
  public static void printArray(double A[][])
  {
    for(int i=0;i<3;i++)
    {
      for(int j=0;j<4;j++)
      {
        System.out.print(A[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static void result(double A[][])
  {
    System.out.println("X="+String.format("%.3f", A[0][3]));
    System.out.println("Y="+String.format("%.3f", A[1][3]));
    System.out.println("Z="+String.format("%.3f", A[2][3]));
  }
  //adding r1=r2-r3
  public static void subRow(double A[][],int r1, int r2,int r3)
  {
    for(int i=0;i<4;i++)
    {
      A[r1][i] = round(A[r2][i]-A[r3][i],6);
    }
  }
  //adding r1=r2/d;
  public static void divRow(double A[][],int r1, int r2,double d)
  {
    for(int i=0;i<4;i++)
    {
      A[r1][i] =round(A[r2][i]/d, 6);
    }
  }
  public static void swapingRow(double A[][],int od, int nw)
  {
    for(int i=0;i<4;i++)
    {
      double temp = A[od][i];
      A[od][i] = A[nw][i];
      A[nw][i] = temp;
    }
  }
  public static void checkArray(double A[][])
  {
    if(A[0][0]==0&&A[0][1]!=0)
      swapingRow(A,1,0);
    else if(A[0][0]==0&&A[0][2]!=0)
      swapingRow(A,2,0);
    if(A[1][1]==0&&A[1][0]!=0)
      swapingRow(A,0,1);
    else if(A[1][1]==0&&A[1][2]!=0)
      swapingRow(A,2,1);
    if(A[2][2]==0&&A[2][0]!=0)
      swapingRow(A,0,2);
    else if(A[2][2]==0&&A[2][1]!=0)
      swapingRow(A,1,2);
  }
  public static void gussJord(double A[][])
  {
    checkArray(A);
    if(A[0][0]!=0)
      divRow(A,0,0,A[0][0]);
    if(A[1][0]!=0)
      divRow(A,1,1,A[1][0]);
    if(A[2][0]!=0)
      divRow(A,2,2,A[2][0]);
    if(A[1][0]!=0)
      subRow(A,1,1,0);
    if(A[2][0]!=0)
      subRow(A,2,2,0);
    //
        checkArray(A);
    if(A[0][1]!=0)
      divRow(A,0,0,A[0][1]);
    if(A[1][1]!=0)
      divRow(A,1,1,A[1][1]);
    if(A[2][1]!=0)
      divRow(A,2,2,A[2][1]);
    if(A[0][1]!=0)
      subRow(A,0,0,1);
    if(A[2][1]!=0)
      subRow(A,2,2,1);
    //
        checkArray(A);
    if(A[0][2]!=0)
      divRow(A,0,0,A[0][2]);
    if(A[1][2]!=0)
      divRow(A,1,1,A[1][2]);
    if(A[2][2]!=0)
      divRow(A,2,2,A[2][2]);
    if(A[0][2]!=0)
      subRow(A,0,0,2);
    if(A[1][2]!=0)
      subRow(A,1,1,2);
    //
    checkArray(A);
    if(A[0][0]!=0)
      divRow(A,0,0,A[0][0]);
    if(A[1][1]!=0)
      divRow(A,1,1,A[1][1]);
    if(A[2][2]!=0)
      divRow(A,2,2,A[2][2]);
    
  }
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Please Input ");
    System.out.println("A1 x +B1 y +C1 z= K1\nA2 x +B2 y +C2 z= K2\nA3 x +B3 y +C3 z= K3\nformat");
    
    double A[][]=new double[10][10];
    
    for(int i=0;i<3;i++)
    {
      for(int j=0;j<4;j++)
      {
        A[i][j]=sc.nextDouble();
      }
    }
    printArray(A);
    System.out.println("------------------");
    gussJord(A);
    printArray(A);
    result(A);
  }
}