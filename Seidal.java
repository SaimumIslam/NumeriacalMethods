import java.util.*;
import java.math.*;
public class Seidal
{
  public static void main(String arg[])
  {
    double A[][]=new double[4][4];
    double B[]=new double[4];
    double C[]=new double[4];
    double es,eaa;
    Scanner sc=new Scanner(System.in);
    System.out.println("Please Input ");
    System.out.println("A1 x +B1 y +C1 z= K1\nA2 x +B2 y +C2 z= K2\nA3 x +B3 y +C3 z= K3\n");
    for(int i=0;i<3;i++)
    {
      for(int j=0;j<4;j++)
      {
        A[i][j]=sc.nextDouble();
      }
    }
    System.out.println("Please input Es");
    es=sc.nextDouble();
    int iter;
    System.out.println("Please input Number of Iteration");
    iter=sc.nextInt();
    C[0]=C[1]=C[2]=100;
    B[0]=B[1]=B[2]=0;
    
    double a=0,b=0,c=0;
    while((C[0]>es||C[1]>es||C[2]>es) && iter!=0)
    {
      a=x(A,b,c);
      C[0]=ea(a,B[0]);
      B[0]=a;
      b=y(A,a,c);
      C[1]=ea(b,B[1]);
      B[1]=b;
      c=z(A,a,b);
      C[2]=ea(c,B[2]);
      B[2]=c;
      iter--;
    }
    System.out.println("x = "+round(a,6)+"\ny = "+round(b,6)+"\nz = "+round(c,6));
  }
  public static double x(double A[][],double b,double c)
  {
    double ans=(A[0][3]-A[0][1]*b-A[0][2]*c);
    ans=ans/A[0][0];
    return ans;
  }
  public static double y(double A[][],double a,double c)
  {
    double ans=(A[1][3]-A[1][0]*a-A[1][2]*c);
    ans=ans/A[1][1];
    return ans;
  }
  public static double z(double A[][],double a,double b)
  {
    double ans=(A[2][3]-A[2][0]*a-A[2][1]*b);
    ans=ans/A[2][2];
    return ans;
  }
  public static double ea(double pr,double pas)
  {
    double ans=Math.abs(pr-pas);
    ans=ans/pr;
    ans=ans*100;
    return ans;
  }
    public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
}