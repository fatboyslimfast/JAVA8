package sybextestbanks.wiley.com.test1;

public class FoodStorage {

	private int apples;

	public synchronized int getAppleCount() {
		return apples;
	}

	public synchronized void stock(int appleStock) {

		apples += appleStock;
	}

	public synchronized void eaten(int eatenCount) {
		synchronized (this) {
			apples -= eatenCount;

		}
	}

	public static void main(String[] args) {
		FoodStorage fs = new FoodStorage();
		fs.stock(20);

		System.out.println("Apple count " + fs.getAppleCount());
		for (int x = 1; x < 7; x++) {
			fs.eaten(x);
			System.out.println("Apple(s) eaten; " + x + " Apple Count; " + fs.getAppleCount());
			fs.stock(x + 3);
			System.out.println("Apple count " + fs.getAppleCount());
		}

	}

}
