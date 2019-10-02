import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;

public class GaussianElimination1
{
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}

  public static void printArray(double A[][],int n)
  {
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<=n;j++)
      {
        System.out.print(A[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static void backSub(double A[][],int n)
  {
    double z=round(A[2][3]/A[2][2],6);
    double y=round((A[1][3]-A[1][2]*z)/A[1][1],6);
    double x=round((A[0][3]-(A[0][1]*y+A[0][2]*z))/A[0][0],6);
    System.out.println("X="+String.format("%.3f", x));
    System.out.println("Y="+String.format("%.3f", y));
    System.out.println("Z="+String.format("%.3f", z));
  }
  public static void gussElim(double A[][],int n)
  {
    for(int i=0;i<n;i++)
    {
      int id=i;
      for(int j=i+1;j<n;j++)
      {
        if(Math.abs(A[j][i])>Math.abs(A[id][i]))
          id=i;
      }
      if(id!=i)
        {
          for(int j=i;j<=n;j++)
          {
            //swap(A[i][j],A[id][j]);
          }
        }
      for(int j=0;j<=n;j++)
      {
        if(j!=i)
        {
         // factor=A[][];
        }
        
      }
      
    }
  }
  public static void main(String[] args)
  {
    int n;
    Scanner sc=new Scanner(System.in);
    
    System.out.println("Please Input the number of equation u want to solve");
    n=sc.nextInt();
    System.out.println("A1 x +B1 y +C1 z= K1\nA2 x +B2 y +C2 z= K2\nA3 x +B3 y +C3 z= K3\nformat");
    int max=n+2;
    double A[][]=new double[max][max];
    
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<=n;j++)
      {
        A[i][j]=sc.nextDouble();
      }
    }
    //printArray(A);
    System.out.println("------------------");
   // gussElim(A,n);
    //printArray(A);
    //backSub(A);
  }
}