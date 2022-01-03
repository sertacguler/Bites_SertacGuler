package sertac_guler;

public class Main {

	public static void main(String[] args) {

		ZoneCounter zCounter = new ZoneCounter();

		MapInterface myMap = new MyMap();
		try {
			zCounter.Init(myMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
