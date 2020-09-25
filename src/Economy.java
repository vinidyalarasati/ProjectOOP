  import java.util.Random;

public class Economy extends Tiket {

	Random rand = new Random();
	
	public Economy() {
		// TODO Auto-generated constructor stub
	}

	public Economy(String type, String name, String departure, String arrival, int price) {
		super(type, name, departure, arrival, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	int countPrice() {
		// TODO Auto-generated method stub
		int price = 0;
		
		price = rand.nextInt(200000)+500000;
		
		return price;
	}

}
