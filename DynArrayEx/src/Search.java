import java.util.*;

public class Search {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();    // The array of numbers

		// Fill with random numbers from 1 to 100
		Random rnd = new Random();

		list.add(new Student("Hao",123));
		list.add(new Student("Man",456));
		list.add(new Student("AADASD",789));

		Scanner inp = new Scanner(System.in);
		System.out.print("Please enter the number to search for: ");
		int num = inp.nextInt();

		// Sort the array then do binary search (note this is less efficient than a linear search!)
		System.out.println("The array: " + list);

		// Do our own linear search
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (num == list.get(i).getId()) {
				index = i;
				break;
			}
		}

		// Check result
		if (index < 0) {
			System.out.println("The number " + num + " was not found.");
		}
		else {
			System.out.println("The number " + num + " was found at array index " + index + " in the array.");
		}
	}
}
