import java.util.Random;
import java.util.Scanner;

public class Business extends Tiket {

	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	
	String souvenir;
	
	public Business() {
		// TODO Auto-generated constructor stub
	}

	public Business(String type, String name, String departure, String arrival, int price, String souvenir) {
		super(type, name, departure, arrival, price);
		this.souvenir = souvenir;
		// TODO Auto-generated constructor stub
	}

	@Override
	int countPrice() {
		// TODO Auto-generated method stub
		int price = 0;
		int total = 0;
		
		price = rand.nextInt(200000)+500000;
		total = (int)(price * 1.75);
		
		return total;
	}
	
	String chooseSouvenir()
	{
		do
		{
			System.out.print("Choose the souvenir [Key Chain | Magazine | Mini Airplane]: ");
			souvenir = scan.nextLine();
		} while (!souvenir.equals("Key Chain") && !souvenir.equals("Magazine") && !souvenir.equals("Mini Airplane"));
		
		return souvenir;
	}

	public String getSouvenir() {
		return souvenir;
	}
	public void setSouvenir(String souvenir) {
		this.souvenir = souvenir;
	}
	
	

}
