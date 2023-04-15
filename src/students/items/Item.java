package students.items;

public abstract class Item {

    public int age;
    public int maturation_age;
    public int death_age;
    public int monetory_value;
	public Item(int maturation_age,int death_age,int monetory_value){
        age=0;  
        this.maturation_age=maturation_age;
        this.death_age=death_age;
        this.monetory_value=monetory_value;
    }

    public void tick(){
        // increase age of each item.
        age++;
    }

    public void setAge(int value){
        // manually set the age of item
        age=value;
    }

    public boolean died(){
        //check if item's age is greater than the death age
        if(age>death_age){
            return true;
        }
        return false;
    }
    
    public int getValue(){
        // return price of item if it has passed maturation_age
        if(age>=maturation_age){
            return monetory_value;
        }
        return 0;
    }
    public boolean equals(Item item1,Item item2){
        //checks if both items are equal
        if(item1.age==item2.age && item1.death_age==item2.death_age && item1.maturation_age==item2.maturation_age && item1.monetory_value==item2.monetory_value){
            return true;
        }
        return false;
    }

    public abstract String toString();
    
}