import java.util.Random;

public class ArrayHourGlass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dim = 10;
		HourGlass hg = new HourGlass(dim);

		hg.print();

		System.out.println(hg.sumOfHourGlasses());
		
	}

}
