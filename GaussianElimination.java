import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;

public class GaussianElimination
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
  public static void backSub(double A[][])
  {
    double z=round(A[2][3]/A[2][2],6);
    double y=round((A[1][3]-A[1][2]*z)/A[1][1],6);
    double x=round((A[0][3]-(A[0][1]*y+A[0][2]*z))/A[0][0],6);
    System.out.println("X="+String.format("%.3f", x));
    System.out.println("Y="+String.format("%.3f", y));
    System.out.println("Z="+String.format("%.3f", z));
  }
  //adding r1=r2-r3
  public static void addRow(double A[][],int r1, int r2,int r3)
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
      A[r1][i] = round(A[r2][i]/d,6);
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
      swapingRow(A,0,1);
    if(A[2][0]==0&&A[2][1]!=0)
      swapingRow(A,1,2);
    if(A[0][0]==0&&A[0][1]==0)
      swapingRow(A,2,0);
    if(A[1][0]==0&&A[1][0]==0)
      swapingRow(A,1,2);
  }
  public static void gussElim(double A[][])
  {
    checkArray(A);
    if(A[0][0]!=0)
      divRow(A,0,0,A[0][0]);
    if(A[1][0]!=0)
      divRow(A,1,1,A[1][0]);
    if(A[2][0]!=0)
      divRow(A,2,2,A[2][0]);
    if(A[1][0]!=0)
      addRow(A,1,1,0);
    if(A[2][0]!=0)
      addRow(A,2,2,0);
    //
    if(A[1][1]!=0)
      divRow(A,1,1,A[1][1]);
    if(A[2][1]!=0)
      divRow(A,2,2,A[2][1]);
    if(A[2][1]!=0)
      addRow(A,2,2,1);
  }
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Please Input ");
    System.out.println("A1 x +B1 y +C1 z= K1\nA2 x +B2 y +C2 z= K2\nA3 x +B3 y +C3 z= K3\n");
    
    double A[][]=new double[20][20];
    
    for(int i=0;i<3;i++)
    {
      for(int j=0;j<4;j++)
      {
        A[i][j]=sc.nextDouble();
      }
    }
    printArray(A);
    System.out.println("------------------");
    gussElim(A);
    printArray(A);
    backSub(A);
  }
}