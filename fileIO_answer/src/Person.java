
public class Person {
    private String firstName;  // The person's first name
    private String lastName;   // The person's last name
    private int ID;            // The ID number

    // Constructor & getters/setters
    public Person(String name1, String name2, int id) {
        firstName = name1;
        lastName = name2;
        ID = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    // For displaying a person's info in the form
    // John Doe - 123456
    public String toString() {
        return firstName + " " + lastName + " - " + ID;
    }

}
