
public class Calculations {
    
	public  Calculations(){
		  
	  }
	
   public double BMI (double h,double w){
	   return w/(h*h);
   }
   
   public double maleCalory(double w,double h,double currentAge){
	   return (88.36 + (13.4*w) + (4.8*h*100)-(5.7*currentAge));
   }
   
   public double femaleCalory(double w,double h,double currentAge){
	   return 447.6 + (9.2*w) + (3.1*h*100) - (4.3*currentAge);
   }
   
   public double idealMale(double h){
	   return (h*100-100)*1.15;
   }
   public double idealFemale(double h){
	   return (h*100-110)*1.15;
   }
}
