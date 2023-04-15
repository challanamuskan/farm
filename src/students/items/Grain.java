package students.items;

public class Grain extends Food{

    // setting the count tpo get the total instance pf the class
   
    private static int count=0;  
	public Grain(){
        super(2, 6, 2);
        count++;
    }
    public static int getGenerationCount(){
        return count;
    }
    @Override
    public String toString(){
        if(age<maturation_age){
            return "g";
        }
        return "G";
    }
}
