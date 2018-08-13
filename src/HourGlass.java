import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HourGlass {
	/**
	 * Create random hour-glass array with the given dimensions
	 */
	ArrayList<ArrayList<Integer>> arr;
	int dim;

	public HourGlass(int dim) {
		arr = new ArrayList<>();
		this.dim = dim;
		PopulateList();
	}

	void PopulateList() {
		Random rand = new Random();

		for (int i = 0; i < dim; i++) {
			ArrayList<Integer> arrInner = new ArrayList<>();
			for (int j = 0; j < dim; j++) {
				arrInner.add(rand.nextInt(19) - 9);//-9<=x<=9
			}
			arr.add(arrInner);
		}
	}

	public int sumOfHourGlasses() {
		int sum = 0;
		for (int i = 1; i < dim - 1; i++) {
			for (int j = 1; j < dim - 1; j++) {
				sum += sumOfHourGlass(i, j);
			}
		}
		return sum;
	}

	private int sumOfHourGlass(int rCentre, int cCentre) {
		int sum = sumUpperHorizontal(rCentre, cCentre) + centreVal(rCentre, cCentre)
		+ sumLowerHorizontal(rCentre, cCentre);
		return sum;
		
	}

	private int sumUpperHorizontal(int rCentre, int cCentre) {
		int sum = 0;
		ArrayList<Integer> row = arr.get(rCentre - 1);
		for (int i = cCentre - 1; i <= cCentre + 1; i++) {
			sum += row.get(i);
		}
		return sum;
	}

	 private int sumLowerHorizontal(int rCentre, int cCentre) {
		int sum = 0;
		ArrayList<Integer> row = arr.get(rCentre + 1);
		for (int i = cCentre - 1; i <= cCentre + 1; i++) {
			sum += row.get(i);
		}
		return sum;
	}

	 private int centreVal(int rCentre, int cCentre) {
		ArrayList<Integer> row;
		row = arr.get(rCentre);
		return row.get(cCentre);
	}

	public void print() {
		for (int i = 0; i < arr.size(); i++) {
			for (int j : arr.get(i)) {
				if (j >= 0) {
					System.out.print(" ");
				}
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
