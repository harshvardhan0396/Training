import java.lang.*;
public class division{
	public static void main(String[] args) {
		float nume = 58, deno = 3,count=0,new_nume=0,count1=0;
        //using try block for any error
        try{
            if(deno == 0 || nume == 0){
                //throwing an Exception using throw
                throw new Exception();
            }
            else{
                //loop for finding Quotient before decimal
                while(nume>=deno){
                    nume= nume-deno;
                    count++;
                }
                new_nume = nume;
                //loop to multiply reminder with 10
                while(count1<9){
                    new_nume=new_nume+nume;
                    count1++;
                }
                //loop for finding Quotient after decimal
                count1=0;
                while(new_nume>=deno){
                    new_nume = new_nume-deno;
                    count1++;
                }
                //Using Math.round function for roundoff value
                System.out.println(Math.round(count)+"."+Math.round(count1));
            }
        }
        //catching an exception in catch
        catch(Exception e){
            System.out.println("Numerator or Denominator value cannot be '0' : " +e);
        }
        
	}
}