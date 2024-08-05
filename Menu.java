import java.util.ArrayList;
import java.util.List;
import java.util.*;

abstract class MenuItem {
	private String id;
	private String name;
	private int price;
	
	public MenuItem(String id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public abstract String getType();
}

class Dish extends MenuItem {
	private String cuisineType;
	
	public Dish(String id, String name, int price, String cuisineType) {
		super(id, name, price);
		this.cuisineType = cuisineType;
	}
	
	public String getCuisineType() {
		return cuisineType;
	}
	
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	
	@Override 
	public String getType() {
		return "Dish";
	}
}

class Drink extends MenuItem { 
	private String isAlcoholic;
	
	public Drink(String id, String name, int price, String isAlcoholic) {
		super(id, name, price);
		this.isAlcoholic = isAlcoholic;
	}
	
	public String getIsAlcoholic() {
		return isAlcoholic;
	}
	
	public void setIsAlcoholic(String isAlcoholic) {
		this.isAlcoholic = isAlcoholic;
	}
	
	@Override 
	public String getType() {
		return "Drink";
	}
}

class Menu {
	
	private List<MenuItem> menus;
	
	public Menu() {
		this.menus = new ArrayList<>();
	}
	
	public void addMenu(MenuItem menu) {
		menus.add(menu);
	}
	
	public void removeItem(String id) {
		menus.removeIf(menus -> menus.getId().equals(id));
	}
	
	public void displayItems() {
		for (MenuItem menu : menus) {
			System.out.println("ID: " + menu.getId() + " Name: " + menu.getName() + " Price: " + menu.getPrice());
			
			if (menus instanceof Dish) {
				System.out.println("Dish: " + ((Dish) menus).getCuisineType());
			} else if (menus instanceof Drink) {
				System.out.println("Drink: " + ((Drink) menus).getIsAlcoholic());
			}
			
		}
	}

public static void main(String[] args) {
		Menu menu = new Menu();
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("Restaurant Management System");
			System.out.println("1. ADD DISH");
			System.out.println("2. ADD DRINK");
			System.out.println("3. REMOVE ITEM");
			System.out.println("4. DISPLAY ITEM");
			System.out.println("5. EXIT");
			
			int decis = Integer.parseInt(s.nextLine());
			
			switch(decis) {
			case 1:
				System.out.println("Enter Dish ID: ");
				String dishId = s.nextLine();
				System.out.println("Enter Dish Name: ");
				String dishName = s.nextLine();		
				System.out.println("Enter Dish Price: ");
				int dishPrice = s.nextInt();
				System.out.println("Enter Cuisine Type: ");
				String csType = s.nextLine();
				
				menu.addMenu(new Dish (dishId, dishName, dishPrice, csType));
				break;
				
			case 2:
				System.out.println("Enter Drink ID: ");
				String drinkId = s.nextLine();
				System.out.println("Enter Drink Name: ");
				String drinkName = s.nextLine();
				System.out.println("Enter Drink Price: ");
				int drinkPrice = s.nextInt();
				System.out.println("Is the Drink Alcoholic?: ");
				String isAlco = s.nextLine();
				
				menu.addMenu(new Drink (drinkId, drinkName, drinkPrice, isAlco));
				break;
				
			case 3:
				System.out.println("Enter ID to Remove: ");
				String removeId = s.nextLine();
				
				menu.removeItem(removeId);
				break;
			case 4:
				menu.displayItems();
				break;
			default:
				System.out.println("BYE BYE");
				s.close();
				return;
			}
		}
	}
}
