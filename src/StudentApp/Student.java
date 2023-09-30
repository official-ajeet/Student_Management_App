package StudentApp;
public class Student {//data transfer object (dto)
    private int id;
    private String name;
    private int age;
    private String phone;
    private String city;


//GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    //constructor when we doesn't have ID:- id will be 0 initialize with rest of the values
    public Student(String name, int age, String phone, String city) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.city = city;
    }


//TOSTRING METHOD TO DISPLAY

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

