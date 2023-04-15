package students;

import java.util.Random;


import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

public class Field   {
	
	private int height;
	private int width;
	private Item[][] field;

	public Field(int height, int width)
	{
			this.height=height;
			this.width=width;

            // creating a field 


			field = new Item[height][width];
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					field[i][j] = new Soil();
				}
			}
	}

	public void tick () {
        
        for (int i = 0; i < height; i++) {
           
            for (int j = 0; j < width; j++) {
                
                field[i][j].tick();
                Random r = new Random(); // Random class to generate random number

                // generating number with prob. less than 20% to generate weed
                
                if (field[i][j] instanceof Soil && r.nextInt(10 - 1 + 1) + 1 <3) 
                {
                    field[i][j] = new Weed();
                } 
                else if (field[i][j].died()) {
                    field[i][j] = new UntilledSoil();
               
                }


            }
        }
    }
	
	@Override
    public String toString() { // display the field
        String s = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                s = s+field[i][j];
                if (j < width - 1) 
                {
                    s+=" ";
                }
            }
            if (i < height - 1) 
            {
                s= s+"\n";
            }
        }
        return s;
    }

	public void till(int row,int column){
        // setting the soil at location
		field[row][column]=new Soil();
	}

	public Item get(int row,int column){
        //Returning the item at that location
		return field[row][column];
	}
	
    public void plant(int row,int column,Item item){
        // Planting food at that location
        field[row][column]=item;
    }



	public int getValue(){
        // Returning the total value of field
		int total_monetary_value=0;
		for (int i = 0; i < height; i++) 
        {
            for (int j = 0; j < width; j++) 
            {
                    total_monetary_value = total_monetary_value+ field[i][j].getValue();                
            }
        }
        return total_monetary_value; 
	}
	
	public String getSummary() {

        // Printing overall values
        String s = "";
		int total_apples=0;
		int total_grains=0;
		int total_soil=0;
		int total_untilled_soil=0;
		int total_weed=0;
        int total_value = 0;

		for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Item item = field[i][j];
                int value = item.getValue();
                if (item instanceof Apples && ((Apples) item).age>((Apples) item).maturation_age) 
               
                // check if it is a apple and has pass the maturation age
                
                {
                    total_apples++;
                    total_value += value;
                }
                else if (item instanceof Grain && ((Grain) item).age>((Grain) item).maturation_age) 
                {
                    // check if it is a grain and has pass the maturation age
                   
                    total_grains++;
                    total_value += value;
                }
				else if (item instanceof Soil) 
                {
                    total_soil++;
                    total_value += value;
                }
				else if (item instanceof UntilledSoil) 
                {
                    total_untilled_soil++;
                    total_value += value;
                }
				else if (item instanceof Weed) 
                {
                    total_weed++;
                    total_value += value;
                }
            }
        }
		s+="Apples: " + total_apples + "\n";
        s+="Grain: " + total_grains + "\n";
        s+="Soil: " + total_soil + "\n";
        s+="Untilled: " + total_untilled_soil + "\n";
		s+="Weed: " + total_weed + "\n";
        s+="For a total of: $" + total_value + "\n";
		s+="Total apples created:" + total_apples + "\n";
		s+="Total grain created:" + total_grains + "\n";
        return s;
    }
}
