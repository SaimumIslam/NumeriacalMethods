import java.util.*;
public class Lagrange
{
  public static double method(double F[],double X[], double x, int n)
{
    double result = 0;
    for (int i=0;i<=n;i++)
    {
      double y = F[i];
        for (int j=0;j<=n;j++)
        {
            if (j!=i)
                y = y*(x - X[j])/(X[i] - X[j]);
        }
        result += y;
    }
 
    return result;
}
   public static void main(String args[])
  {
    int n;
    double x;
    Scanner sc=new Scanner(System.in);
    System.out.println("please input the order of polynomial");
    n=sc.nextInt();
    System.out.println("please input the value of x");
    x=sc.nextDouble();
    double X[]=new double[n+2];
    double F[]=new double[n+2];
    System.out.println("Please input x and f(x)\n  x    f(x)");
    for(int i=0;i<=n;i++)
    {
      X[i]=sc.nextDouble();
      F[i]=sc.nextDouble();
    }
    System.out.println("Output");
    double res=method(F,X,x,n);
    System.out.println(res);
  }
}
