package numeric;

public class FixedPointIterationMethod {

 private double X0, Es, trueValue, Et;
 private int imax;
 public FixedPointIterationMethod(double X0, double Es, int imax, double trueValue) {
  this.X0=X0;
  this.Es=Es;
  this.imax=imax;
  this.trueValue=trueValue;
 }
 
 public double gValue(double x)
 {
  return Math.exp(-x);
 }
 
 public void FixedIterMethod(){
   
  double Xr =this.X0;
  double xrOld=0;
  double Ea=0;
  System.out.println("\n\n-------------------------------------------------------------------------");
  System.out.println("Iteration\t\tXi\t\t\tEa(%)\t\tEt(%)");
  System.out.println("-------------------------------------------------------------------------");
  
  for(int iter=0;iter <= imax;iter++)
  {
   Xr = gValue(Xr);

   if(Xr != 0)
   {
    
    Ea = (Math.abs((Xr-xrOld)/Xr))*100;
   }
   
   if(iter==0) 
   {
     Et = (Math.abs((trueValue-xrOld)/trueValue)*100);
    System.out.printf("%d\t\t%.0f\t\t\t\t%.3f\n",iter, xrOld, Et);
   }
   xrOld = Xr;
   
   Et = (Math.abs((trueValue-xrOld)/trueValue)*100);
   
   if(Ea<=Es)
    break;
    System.out.printf("%d\t\t%.6f\t\t%.3f\t\t%.3f\n",iter+1, xrOld, Ea, Et);
   
  }
  
  System.out.println("-------------------------------------------------------------------------");
  System.out.println("-------------------------------------------------------------------------"); 
  
 }
}
