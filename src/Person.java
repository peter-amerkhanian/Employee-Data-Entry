/**
 * Abstract class representing a person
 */
public abstract class Person {
    private String name;
    private int age;

    /**
     * Getter method for age
     *
     * @return age of person
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for age
     *
     * @param age the new age for the person
     */
    public void setAge(int age) throws negativeNumberException {
        if (age < 0) {
            throw new negativeNumberException(age);
        }
        this.age = age;
    }

    /**
     * Getter method for name
     *
     * @return name of person
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name
     *
     * @param newName the new name for the person
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Parameterized Constructor
     *
     * @param name name of person
     * @param age  age of person
     */
    public Person(String name, int age) throws negativeNumberException {
        this.setName(name);
        this.setAge(age);
    }

    /**
     * Default Constructor
     */
    public Person() throws negativeNumberException {
        this("N/A", 0);
    }

    /**
     * ToString method
     *
     * @return a string representation of a person
     */
    @Override
    public String toString() {
        return "{name=" + this.getName() +
                ", age=" + this.getAge() +
                "}";
    }

    /**
     * equals method
     *
     * @param o the object to be compared to
     * @return true if equal, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return this.getAge() == person.getAge() &&
                this.getName().equals(person.getName());
    }
}
