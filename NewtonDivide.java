import java.util.*;
public class NewtonDivide
{
  public static void main(String args[])
  {
    int n;
    Scanner sc=new Scanner(System.in);
    System.out.println("please input the order of polynomial");
    n=sc.nextInt();
    double X[]=new double[n+2];
    double F[]=new double[n+2];
    double R[]=new double[n+1];
    System.out.println("Please input x and f(x)\n  x    f(x)");
    for(int i=0;i<=n;i++)
    {
      X[i]=sc.nextDouble();
      F[i]=sc.nextDouble();
    }
    R[0]=F[0];
    for(int i=1;i<=n;i++)
    {
      R[i]=method(X,F,(n+1)-i,i);
    }
    System.out.println("Please input the value of x");
     double x=sc.nextDouble();
     System.out.println("output");
     outp(R,X,n,x);
  }
  
  public static double method(double X[],double F[],int n,int f)
  {
    int i,j;
    for(i=0,j=f;i<n;i++,j++)
    {
      F[i]=round(fun(F[i],F[i+1],X[i],X[j]),6);
    }
    return F[0];
  }
  public static double fun(double a,double b,double x,double y)
  {
    double ans=a-b;
    ans=ans/(x-y);
    return ans;
  }
  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
  }
  public static void outp(double R[],double X[],int n,double x)
  {
    double sum=0;
    int j=0;
    for(int i=0;i<=n;i++)
    {
      double temp=R[i];
      for(j=0;j<i;j++)
      {
        temp=temp*(x-X[j]);
      }
      sum+=temp;
    }
    System.out.println(sum);
  }
}