package students;

import java.util.Scanner;

import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;

public class Farm {

	int field_height;
	int field_width;
	int starting_funds;
	Field field;
	int user_funds;
	

	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		field_height=fieldHeight;
		field_width=fieldWidth;
		starting_funds=startingFunds;
		user_funds=startingFunds;
		// initialising the new fields 
		field=new Field(fieldHeight, fieldWidth);

	}
	
	public void run()
	{
		// while loop is for taking the user input with exception handeling as per the assignemnet 
		while(true){
			System.out.println(field.toString());
			System.out.println("Bank Balance: $"+user_funds);
			System.out.println("Enter your next action");
			System.out.println("t x y: till");
			System.out.println("h x y: harvest");
			System.out.println("p x y: plant");
			System.out.println("f x y: fertilizer");
			System.out.println("s: field summary");
			System.out.println("w: wait");
			System.out.println("q: quit");
			Scanner scanner=new Scanner(System.in);
			try{
				String s=scanner.nextLine();
				String[] arr=s.split(" ");
				String choice=arr[0].toString();
				if(arr.length>1){
				int row=Integer.parseInt(arr[2])-1;
				int column=Integer.parseInt(arr[1])-1;
				//field.tick();
				if(choice.equals("t")){
					field.till(row, column);
					
				}
				else if(choice.equals("h")){
					harvest(row,column);
				}
				else if(choice.equals("p")){
					
					System.out.println("Enter: ");
					System.out.println("-'a' to buy an apple for $2");
					System.out.println("-'g' to buy an grain for $1");
					int food_cost=0;
					String x=scanner.nextLine();
					
					if(x.equals("a")){
						food_cost=2;
					}
					else if(x.equals("g")){
						food_cost=1;
					}
					if(user_funds<food_cost){
						System.out.print("Out of money");
						continue;
					}
					plant(row, column,x);
				}
				else if(choice.equals("f")){
					useFertilizer(row,column);
				}
			}
				else if(choice.equals("s")){
					System.out.print(field.getSummary());
				}
				else if(choice.equals("w")){
					continue;
				}
				else if(choice.equals("q")){
					quit();
				}
			}
			catch(Exception e){
				System.out.println("Incorrect input. Please try again!");
			}
		}
	}

	public void harvest(int row,int column){

		// Harvest food as per the location

		Item item=field.get(row, column);
		if(item instanceof Apples || item instanceof Grain){
			user_funds+=field.getValue();
			System.out.println("Sold "+item.toString()+" for "+field.getValue());
			field.till(row,column);
		}
	}

	public void plant(int row,int column,String food_type){

		// plant apple or grain as per user 
		Item item=field.get(row, column);
		if(item instanceof Soil){
			if(food_type.equals("a")){
			field.plant(row, column, new Apples());
			}
			else if(food_type.equals("g")){
				field.plant(row, column, new Grain());
			}
		}
	}

	public void quit(){
		System.exit(0);
	}

	public void useFertilizer(int row,int column){
		// New Functionality to quickly mature the food to fasten the food growth

		Item item=field.get(row, column);
		if(item instanceof Apples){
			item.setAge(3);
		}
		else if(item instanceof Grain){
			item.setAge(2);
		}
		System.out.println("Item is ready to harvest");
	}
	
}
