
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			System.out.println("Đĩa \"" + disc.getTitle() + "\" đã được thêm vào giỏ.");
		} else {
			System.out.println("Giỏ đã đầy.");
		}
	}

	public void RemoveDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("Giỏ đang trống.");
			return;
		}
		for (int i = 0; i < qtyOrdered && itemsOrdered[i] != null; i++) {
			if (itemsOrdered[i].equals(disc)) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				System.out.println("Đĩa \"" + disc.getTitle() + "\" đã được loại bỏ.");
				qtyOrdered--;
				return;
			}
		}
		System.out.println("Đĩa \"" + disc.getTitle() + "\" không có trong giỏ. Không thể loại bỏ.");
	}

	public float TotalCost() {
		if (qtyOrdered == 0) {
			return 0;
		}
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered && itemsOrdered[i] != null; i++) {
			totalCost += itemsOrdered[i].getCost();
		}
		return totalCost;
	}
}
