import java.util.*;

public class Main {
	
	static ArrayList<Computer> list = new ArrayList<>(List.of(
			new Laptop("75FD", 4000, "Apple", "M1 Max", "M1 Max", "16.2inch", "white", "white"),
			new Laptop("43A2", 500, "Asus", "AMD", "AMD", "15.6inch", "black", "touchpad"),
			new Laptop("317B", 700, "Dell", "Intel", "Intel", "13.2inch", "black", "touchpad"),
			new Computer("5F13", 1300, "Alienware", "Intel", "NVidia"),
			new Computer("8G35", 400, "HP", "Intel", "Intel")
			));
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int cash = 5000;
		
		System.out.println("Welcome to the computer store!");
		while (!input.equals("quit")) {
			Menu(cash);
			input = scanner.nextLine();
			
			switch (input) {
				case "print":
					printList();
					break;
				case "add":
					addLaptop(scanner);
					break;
				case "buy":
					cash -= buy(scanner, cash);
					break;
				case "quit":
					break;
				default:
					System.out.println("Invalid input");
			}
		}
		System.out.println("Goodbuy");
		
		scanner.close();
		
		
	}
	
	static void Menu(int cash) {
		System.out.println("	Menu\nEnter print to print the list of laptops\nEnter add to add a laptop(:D)");
		System.out.println("Enter buy to buy a laptop\nEnter quit to quit\n\nCash " + cash);
	}
	
	static void printList() {
		System.out.println("List: ");
		for (Computer l: list) {
			System.out.println(l + "\n");
		}
	}
	
	static void addLaptop(Scanner scanner) {
		String[] info = new String[8];
		
		// Is laptop?
		boolean laptop = false;
		System.out.println("Enter laptop for laptop");
		info[0] = scanner.nextLine();
		if (info[0].equals("laptop")) {
			laptop = true;
		}
		
		if (laptop) {
			for (int i = 0; i < 8; i++) {
				switch (i) {
					case 0:
						System.out.println("Enter id");
						break;
					case 1:
						System.out.println("Enter price (Integer)");
						break;
					case 2:
						System.out.println("Enter make");
						break;
					case 3:
						System.out.println("Enter CPU");
						break;
					case 4:
						System.out.println("Enter GPU");
						break;
					case 5:
						System.out.println("Enter display");
						break;
					case 6:
						System.out.println("Enter keyboard");
						break;
					case 7:
						System.out.println("Enter mouse");
						break;
				}
				info[i] = scanner.nextLine();
				if (i == 1) {
					try {
						Integer.parseInt(info[i]);
					}
					catch (NumberFormatException e) {
						System.out.println("price is not int");
						i--;
					}
				}
			}
			list.add(new Laptop(info[0], Integer.valueOf(info[1]), info[2], info[3], info[4], info[5],
					info[6], info[7]));
			return;
		}
		else {
			for (int i = 0; i < 5; i++) {
				switch (i) {
					case 0:
						System.out.println("Enter id");
						break;
					case 1:
						System.out.println("Enter price");
						break;
					case 2:
						System.out.println("Enter make");
						break;
					case 3:
						System.out.println("Enter CPU");
						break;
					case 4:
						System.out.println("Enter GPU");
						break;
				}
				
				info[i] = scanner.nextLine();
				if (i == 1) {
					try {
						Integer.parseInt(info[i]);
					}
					catch (NumberFormatException e) {
						System.out.println("price is not int");
						i--;
					}
				}
			}
			list.add(new Computer(info[0], Integer.valueOf(info[1]), info[2], info[3], info[4]));
		}
		
	}
	
	static int buy(Scanner scanner, int cash) {
		System.out.println("Enter id");
		String input = scanner.nextLine();
		
		for (int i = 0, n = list.size(); i < n; i++) {
			if (list.get(i).getId().equals(input)) {
				int price = list.get(i).getPrice();
				if (price > cash) {
					System.out.println("Not enough cash");
					return 0;
				}
				list.remove(i);
				return price;
			}
		}
		System.out.println("Wrong id");
		return 0;
	}

}