package numeric;

import java.util.Scanner;

public class Main {

 public static void main(String[] args) throws Exception {
  
  int option, methodOption;
  Scanner sc = new Scanner(System.in);

  while(true){
   System.out.println("Select Your Option");
  
   System.out.println("1. Roots of Equation.");
   System.out.print("Please Choose your option: ");
  
   option = sc.nextInt();
  
   System.out.println("");
  
   switch(option) {
   case 1: 
    //roots of equation
    System.out.println("**********************************");
    System.out.println("\tMethods for Roots of Equation:");
    System.out.println("\t\t1. Bracket Method");
    System.out.println("\t\t2. Open Method");
    
    System.out.print("Please choose your method: ");
   
    methodOption  = sc.nextInt();
   
   
    switch(methodOption) {
    
    case 1:
     //bracket method
     System.out.println("\n\t\tBracket Methods:");
     System.out.println("\t\t\t1. Bisection Method.");
     System.out.println("\t\t\t2. False Position Method.");
     System.out.print("Choose your option: ");
     
     int bracketMethodOption = sc.nextInt();
     
      switch(bracketMethodOption) {
       case 1:
        //Bisection method
         System.out.println("\n**********************************\n");
         System.out.println("Main Function, f(c) = ((g*m)/c) * (1 - e^((c/m)*t)");
         double xl, xu, es, trueValue;
         int imax;
         System.out.print("Enter the value of Xl: ");
         xl = sc.nextDouble();
 
         System.out.print("Enter the value of Xu: ");
         xu = sc.nextDouble();
         
         System.out.print("Enter the value of Es: ");
         es = sc.nextDouble();
         
         System.out.print("Enter the value of imax: ");
         imax = sc.nextInt();
         
         System.out.print("Enter the True Value: ");
         trueValue = sc.nextDouble();

         
         BisectionMethod BisecObj = new BisectionMethod(xl, xu, es,imax, trueValue);
           BisecObj.Bisect();
         System.out.println("\n******************************************\n");
        break;
       case 2:
        //false position method 
        
        System.out.println("\n**********************************\n");
        System.out.println("Main Function, f(c) = ((g*m)/c) * (1 - e^(-(c/m)*t)");
        double Xl, Xu, Es, trueValue1;
        int Imax;
        System.out.print("Enter the value of Xl: ");
        Xl = sc.nextDouble();
 
        System.out.print("Enter the value of Xu: ");
        Xu = sc.nextDouble();
        
        System.out.print("Enter the value of Es: ");
        Es = sc.nextDouble();
        
        System.out.print("Enter the value of imax: ");
        Imax = sc.nextInt();
        

        System.out.print("Enter the True Value: ");
        trueValue1 = sc.nextDouble();
        
        FalsePositionMethod FalsePosObj = new FalsePositionMethod(Xl, Xu, Es,Imax, trueValue1);
        FalsePosObj.FalsePosition();
 
              System.out.println("\n******************************************\n");
        break;
       }
     //end bracket method
     break;
     
    case 2:
     //open method
     
     int openOption;
     System.out.println("\t\t1. Fixed Point Itearion.: ");
     System.out.print("Enter your Selection: ");
     openOption = sc.nextInt();
     
     switch(openOption) {
     case 1:
      //fixed point Method
      
      System.out.println("\n**********************************\n");
      System.out.println("Main Function, f(c) = e^(-x)-x");
      double X0, Es, trueValue2;
      int Imax;
      System.out.print("Enter Initial Guess: ");
      X0 = sc.nextDouble();

      System.out.print("Enter the value of Es: ");
      Es = sc.nextDouble();
      
      System.out.print("Enter the value of imax: ");
      Imax = sc.nextInt();
      
      System.out.print("Enter the True Value: ");
      trueValue2 = sc.nextDouble();
      
      FixedPointIterationMethod FixedPointObj = new FixedPointIterationMethod(X0, Es, Imax, trueValue2);
      FixedPointObj.FixedIterMethod();
            System.out.println("\n******************************************\n");
            break;
     }
     
     //end open method
     break;
    }
   break;
   }
   }
   
 }
 
}
