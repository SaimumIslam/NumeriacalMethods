import java.util.*;
public class LinearRegration
{
  public static void main(String args[])
  {
    int n;
    double x=0,y=0,xx=0,xy=0;
    Scanner sc=new Scanner(System.in);
    System.out.println("please input the number of dataset n = ?");
    n=sc.nextInt();
    double X[]=new double[n+1];
    double Y[]=new double[n+1];
    double XY[]=new double[n+1];
    System.out.println("Please input x and y\n  x  y");
    for(int i=0;i<n;i++)
    {
      X[i]=sc.nextInt();
      Y[i]=sc.nextDouble();
      
      x+=X[i];
      y+=Y[i];
      xx+=X[i]*X[i];
      xy+=X[i]*Y[i];
    }
    System.out.println("Output");
    double ans1=(n*xy)-(x*y);
    ans1=ans1/((n*xx)-(x*x));
    
    double ans2=(x/n)*ans1;
    ans2=(y/n)-ans2;
    System.out.println(ans2+" + "+ans1+"x");
    
    double d[]=new double[2*n+1];
    for(int i=0,j=0;i<2*n;i++,j++)
    {
      d[i]=X[j];
      i++;
      d[i]=ans2+ans1*X[j];
    }
    SimpleGraph f = new SimpleGraph(d);
    f.show();
  }
  public static void printArray(double A[],int n)
  {
    for(int j=0;j<n;j++)
    {
      System.out.print(A[j]+" ");
    }
    System.out.println();
  }
}