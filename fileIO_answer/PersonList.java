import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonList {
    private ArrayList<Person> list = new ArrayList<Person>();   // List of people

    public PersonList() {
        // Initialize the list from "known" data. We could also call load here to load an existing file.
        Person p = new Person("Richard", "Gere", 345678);
        list.add(p);
        p = new Person("Mel", "Gibson", 456789);
        list.add(p);
        p = new Person("Meryl", "Streep", 567890);
        list.add(p);
    }

    // Write all person objects in the array list to a text file, one line per object
    public void saveData() {
        PrintWriter writer = null;
        try {
            File fileDescriptor = new File("address-book.txt");
            writer = new PrintWriter(fileDescriptor);

            for (int i = 0; i < list.size(); i++) {
                Person p = list.get(i);
                writer.println(p.getFirstName() + "," +
                               p.getLastName() + "," +
                               p.getID());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not create the file, please try again");
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    // Read the entire file and add all person records into the array list.
    public void loadData() {
        Scanner reader = null;
        try {
            File fileDescriptor = new File("address-book.txt");
            reader = new Scanner(fileDescriptor);

            list.clear();              // Ensure the array list starts out empty
            while (reader.hasNext()) {
                String record = reader.nextLine();
                // Now split the string into separate fields...
                String[] fields = record.split(",");
                Person p = new Person(fields[0],   // First name
                                      fields[1],   // Last name
                                      Integer.parseInt(fields[2])); // ID
                list.add(p);
            }
            System.out.println(list);
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not open the file, please try again");
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }

    }

    public static void main(String[] args) {

        PersonList self = new PersonList();
        self.saveData();
        self.loadData();
    }
}
