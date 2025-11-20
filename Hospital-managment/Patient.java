public class Patient {
    public int id;
    public String name;
    public int age;
    public String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public String toString() {
        return "Patient ID: " + id + " | Name: " + name + 
               " | Age: " + age + " | Disease: " + disease;
    }
}
