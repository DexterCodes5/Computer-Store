
public class Laptop extends Computer {
	private String display;
	private String keyboard;
	private String mouse;
	
	Laptop(String _id, int _price, String _make, String _CPU, String _GPU, String _display, String _keyboard, String _mouse) {
		super(_id, _price, _make, _CPU, _GPU);
		display = _display;
		keyboard = _keyboard;
		mouse = _mouse;
	}
	
	// Getters
	String getId() {
		return id;
	}
	int getPrice() {
		return price;
	}
	String getSpecs() {
		return "Laptop: make: " + make + " CPU: " + CPU + " GPU: " + GPU + "\ndisplay: " + display + " keyboard: " + keyboard + " mouse: " + mouse;
	}
	public String toString() {
		return "Laptop: id: " + id + " price: " + price + " make: " + make + " CPU: " + CPU + " GPU: " + GPU + "\ndisplay: " + display + " keyboard: " + keyboard + " mouse: " + mouse;
	}
	
}
