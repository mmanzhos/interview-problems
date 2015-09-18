package variousAlgorithms;

class ParkingLot {
	Spot[] spots;
	final int TOTAL_AMOUNT;
	int currentlyBusy = 0;
	int closestEmpty = 0;
	
	public ParkingLot(int amount) {
		TOTAL_AMOUNT = amount;
		spots = new Spot[TOTAL_AMOUNT];
		fillSpots();
	}
	
	private void fillSpots() {
		for (int i = 0; i < TOTAL_AMOUNT / 2; i++) {
			spots[i] = new UsualSpot('a', i, i);
		}
		for (int i = TOTAL_AMOUNT / 2; i < TOTAL_AMOUNT; i++) {
			spots[i] = new UsualSpot('b', i, i + TOTAL_AMOUNT/2);
		}
	}
	
	public boolean allowCarEnterence(Car car) {
		if (currentlyBusy > TOTAL_AMOUNT || closestEmpty >= TOTAL_AMOUNT) {
			System.out.println("Error in placement. All spots are busy.");
			return false;
		}
		if (spots[closestEmpty].type != car.type) {
			System.out.println("Incorrect types");
			return false;
		}
		spots[closestEmpty].placeCar(car);
		spots[closestEmpty].overallNumber = closestEmpty;
		currentlyBusy++;
		System.out.println("Car was placed with the overall number of " + closestEmpty);
		closestEmpty++;
		return true;
	}
	
	public void carLeft(Spot spot) {
		for (Spot s : spots) {
			if (spot == s) {
				currentlyBusy--;
				closestEmpty = s.overallNumber;
				s.removeCar();
				System.out.println("Car left place #" + closestEmpty);
			}
		}
	}
	
	
}

class Car {

	SpotType type;
	
	
	public Car(SpotType t) {
		type = t;
	}
	
	public Car(int h, int l, int w) {
		type = defineType();
	}
	
	
	public SpotType defineType() {
		return SpotType.USUAL;
	}
	
}

abstract class Spot {
	SpotType type;
	char sector;
	int number;
	int overallNumber;
	Car car;
	
	Spot(char s, int n, int overallNumber) {
		sector = s;
		number = n;
		this.overallNumber = overallNumber;
	}
	void placeCar(Car c) {
		car = c;
	}
	void removeCar() {
		car = null;
	}
	
	boolean isBusy() { return car != null; }
}

class UsualSpot extends Spot {
	
	public UsualSpot(char s, int n, int overallNumber) {
		super(s, n, overallNumber);
		type = SpotType.USUAL;
	}
	
}

enum SpotType {
	USUAL;
}


public class OOD_ParkingLot {

	public static void main(String[] args) {
		ParkingLot pl = new ParkingLot(4);
		Car c1 = new Car(1, 2, 3);
		Car c2 = new Car(1, 2, 3);
		Car c3 = new Car(1, 2, 3);
		Car c4 = new Car(1, 2, 3);
		Car c5 = new Car(1, 2, 3);
		pl.allowCarEnterence(c1);
		pl.allowCarEnterence(c2);
		pl.allowCarEnterence(c3);
		pl.allowCarEnterence(c4);
		pl.carLeft(pl.spots[0]);
		pl.allowCarEnterence(c5);
	}

}
