package students.items;

public class UntilledSoil extends Item {


    // Using intergers max value to set maturity_age and death age
    public UntilledSoil(){
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);
    }

    public String toString(){
        return "/";
    }
}
