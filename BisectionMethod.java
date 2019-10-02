package numeric;

public class BisectionMethod {

	private double Xr, Xl, Xu, Ea, Es, Et, trueValue;
	private int imax, iter;
	public BisectionMethod(double xl, double xu, double es, int imax, double trueValue)
	{
		this.setXl(xl);
		this.setXu(xu);
		this.setEs(es);
		this.setImax(imax);
		this.setTrueValue(trueValue);
	}
	

	public void Bisect()
	{
		
		double xrOld;
		double test;
		double fXl = this.getFunctionalValue(Xl);
		//DecimalFormat digit = new DecimalFormat("0.###");
		System.out.print("\n\n----------------------------------------------------------------------------------------\n");
		System.out.println("Iteration\tXl\t\tXu\t\tXr\t\tEa(%)\t\tEt(%)");
		System.out.println("----------------------------------------------------------------------------------------");
		
		for(iter=0;iter<=imax;iter++)
		{
			
			xrOld = Xr;
			Xr = (Xl+Xu)/2;
			
			double fXr = this.getFunctionalValue(Xr);
			
			if(Xr!=0) Ea = Math.abs((Xr-xrOld)/Xr)*100;
			

			Et = Math.abs((trueValue-Xr)/trueValue)*100;
			
			
			if (iter==0)
			{
				System.out.printf("%d\t\t%.3f\t\t%.3f\t\t%.3f\t\t\t\t%.3f\n",iter+1, Xl, Xu, Xr, Et);
				//System.out.println(iter+".\t\t"+digit.format(Xl)+"\t\t"+digit.format(Xu)+"\t\t"+digit.format(Xr)+"\t\t\t\t"+digit.format(Et));
			}
			else
			{
				System.out.printf("%d\t\t%.3f\t\t%.3f\t\t%.3f\t\t%.3f\t\t%.3f\n",iter+1, Xl, Xu, Xr, Ea, Et);
				//System.out.println(iter+".\t\t"+digit.format(Xl)+"\t\t"+digit.format(Xu)+"\t\t"+digit.format(Xr)+"\t\t"+digit.format(ea)+"\t\t"+digit.format(Et));
			}
			
			test = fXl*fXr;
			
			if(test<0) 
				Xu = Xr;
			else if(test>0)
			{
				Xl = Xr;
				fXl = fXr;
			}
			else Ea = 0;
			
			if(Ea<=Es) break;
		}
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------");
		
		
		// Et = Math.abs((14.75-Xr)/Xr)*100;
		
		// System.out.printf("Roots of the equation is %.3f %n",Xr);
		// System.out.printf("True value of Error is %.3f %n", Et);
	}
	
	
	public double getFunctionalValue(double pointValue)
	{
		double result;
		double a = 667.38/pointValue;
		double expo = Math.exp((-(0.146843*pointValue)));
		result  = (a * (1-expo)) - 40;
		return result;
	}
	
	
	public double getXr()
	{
		return Xr;
		
	}
	public void setXr(double xr)
	{
		this.Xr = xr;
	}
	
	public double getXl()
	{
		return Xl;
		
	}
	public void setXl(double xl)
	{
		this.Xl = xl;
	}
	
	public double getXu()
	{
		return Xu;
		
	}
	public void setXu(double xu)
	{
		this.Xu = xu;
	}
	
	public double getEr()
	{
		return Ea;
		
	}
	public void setEr(double ea)
	{
		this.Ea = ea;
	}
	public double getEa()
	{
		return Et;
		
	}
	public void setEa(double et)
	{
		this.Et = et;
	}
	
	public double getEs()
	{
		return Es;
		
	}
	public void setEs(double es)
	{
		this.Es = es;
	}
	
	public int getImax() {
		return imax;
	}

	public void setImax(int imax) {
		this.imax = imax;
	}

	public int getIter() {
		return iter;
	}

	public void setIter(int iter) {
		this.iter = iter;
	}
	

	public double getTrueValue()
	{
		return trueValue;
		
	}
	public void setTrueValue(double val)
	{
		this.trueValue = val;
	}
	
}

