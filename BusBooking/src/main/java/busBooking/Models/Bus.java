package busBooking.Models;

public class Bus {
	public int busNumber;
	public String name;
	public String source;
	public String destination;
	public String DOJ;
	public int seaterSeats;
	public int sleeperSeats;
	public float seaterPrice;
	public float sleeperPrice;
	public Bus(int busNumber, String name, String source, String destination, String dOJ, int seaterSeats,
			int sleeperSeats, float seaterPrice, float sleeperPrice) {
		super();
		this.busNumber = busNumber;
		this.name = name;
		this.source = source;
		this.destination = destination;
		DOJ = dOJ;
		this.seaterSeats = seaterSeats;
		this.sleeperSeats = sleeperSeats;
		this.seaterPrice = seaterPrice;
		this.sleeperPrice = sleeperPrice;
	}
	

}
