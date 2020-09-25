
public abstract class Tiket {
	
	String name, departure, arrival, type;
	int price;

	public Tiket() {
		// TODO Auto-generated constructor stub
	}

	public Tiket(String type, String name, String departure, String arrival, int price) {
		super();
		this.type = type;
		this.name = name;
		this.departure = departure;
		this.arrival = arrival;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	abstract int countPrice();
	
}
