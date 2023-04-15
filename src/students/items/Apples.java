package students.items;

public class Apples extends Food {

    private static int count=0;

    // Calling base class (Item constructor)
    public Apples(){
        super(3, 5, 3);
        count++;
    }

    public static int getGenerationCount(){
        return count;
    }

    public String toString(){
        if(age<maturation_age){
            return "a";
        }
        return "A";
    }

}
