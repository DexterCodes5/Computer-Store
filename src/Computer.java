
public class Computer extends Item {
	protected String make;
	protected String CPU;
	protected String GPU;
	
	Computer(String _id, int _price, String _make, String _CPU, String _GPU) {
		super(_id, _price);
		make = _make;
		CPU = _CPU;
		GPU = _GPU;
	}
	
	// Getters
		String getId() {
			return id;
		}
		int getPrice() {
			return price;
		}
		String getSpecs() {
			return "Computer: make: " + make + " CPU: " + CPU + " GPU: " + GPU;
		}
		public String toString() {
			return "Computer: id: " + id + " price: " + price + " make: " + make + " CPU: " + CPU + " GPU: " + GPU;
		}
}
