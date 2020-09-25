import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<Tiket> vecTiket = new Vector<>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		int mainOpt = 0;
		
		do
		{
			do
			{
				cls();
				System.out.println("1. Book Ticket");
				System.out.println("2. Delete Ticket");
				System.out.println("3. View Ticket");
				System.out.println("4. Exit");
				System.out.print("Choose: ");
				try
				{
					mainOpt = scan.nextInt();
				}
				catch (Exception e)
				{
					System.out.println("Invalid input!");
					mainOpt = 0;
				}
				finally
				{
					scan.nextLine();
				}
				
			} while (mainOpt < 1 || mainOpt > 4);
			
			switch (mainOpt)
			{
				case 1:
					cls();
					add();
					break;
				case 2:
					cls();
					view();
					del();
					break;
				case 3:
					cls();
					view(); scan.nextLine();
					break;
			}
		} while(mainOpt != 4);
	}

	public void cls() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 30; i++)
		{
			System.out.println();
		}
	}

	private void del() {
		// TODO Auto-generated method stub
		int delOpt = -1;
		
		do
		{
			System.out.print("Input number to be deleted [1 - " + vecTiket.size() + "]: ");
			try
			{
				delOpt = scan.nextInt();
			}
			catch (Exception e)
			{
				System.out.println("Invalid input!");
				delOpt = -1;
			}
			finally
			{
				scan.nextLine();
			}
		} while(delOpt < 1 || delOpt > vecTiket.size());
		
		vecTiket.remove(delOpt-1);
		System.out.println("Delete successful!"); scan.nextLine();
	}

	private void view() {
		// TODO Auto-generated method stub
		for(int i = 0; i < vecTiket.size(); i++)
		{
			System.out.println("Ticket - " + (i+1) + " - " + vecTiket.get(i).getType());
			System.out.println("Ticket Owner: " + vecTiket.get(i).getName());
			System.out.println("Ticket Departure: " + vecTiket.get(i).getDeparture());
			System.out.println("Ticket Arrival: " + vecTiket.get(i).getArrival());
			System.out.println("Ticket's Price: " + vecTiket.get(i).getPrice());
			
			if(vecTiket.get(i).getType().equals("Business"))
			{
				System.out.println("Chosen Souvenir: " + ((Business) vecTiket.get(i)).getSouvenir());
			}
			
			System.out.println();
		}
	}

	private void add() {
		// TODO Auto-generated method stub
		String type, name, departure, arrival, souvenir;
		int price;
		
		do
		{
			System.out.print("Input ticket type [Economy | Business]: ");
			type = scan.nextLine();
		} while(!type.equals("Economy") && !type.equals("Business") && !type.equals("0"));
		
		if(type.equals("0"))
		{
			return;
		}
		
		do
		{
			System.out.print("Input passanger's name [5 - 20 Characters]: ");
			name = scan.nextLine();
		} while(name.length() < 5 || name.length() > 20);
		
		do
		{
			System.out.print("Input city of departure [Jakarta | Bandung | Bali | Yogyakarta]: ");
			departure = scan.nextLine();
		} while(!departure.equals("Jakarta") && !departure.equals("Bandung") && !departure.equals("Bali") && !departure.equals("Yogyakarta"));
		
		do
		{
			System.out.print("Input city of arrival [Jakarta | Bandung | Bali | Yogyakarta]: ");
			arrival = scan.nextLine();
			
			if(arrival.equals(departure))
			{
				arrival = "";
			}
		} while(!arrival.equals("Jakarta") && !arrival.equals("Bandung") && !arrival.equals("Bali") && !arrival.equals("Yogyakarta"));
		
		if(type.equals("Economy"))
		{
			Economy e = new Economy();
			price = e.countPrice();
			
			vecTiket.add(new Economy(type, name, departure, arrival, price));
			System.out.println("Economy ticket successfully booked!"); scan.nextLine();
		}
		else
		{
			Business b = new Business();
			price = b.countPrice();
			souvenir = b.chooseSouvenir();
			
			vecTiket.add(new Business(type, name, departure, arrival, price, souvenir));
			System.out.println("Business ticket successfully booked!"); scan.nextLine();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
