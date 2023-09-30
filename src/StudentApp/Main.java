package StudentApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Student Management App");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("Press 1 to ADD a student");
            System.out.println("Press 2 to DELETE a student");
            System.out.println("Press 3 to DISPLAY students");
            System.out.println("Press 4 to UPDATE student");
            System.out.println("Press 5 to EXIT");
            System.out.println();

            int choice = Integer.parseInt(br.readLine());

            if(choice == 1){
                //add student
                System.out.print("Enter the Name: ");
                String name = br.readLine();

                System.out.print("Enter the Age: ");
                int age = Integer.parseInt(br.readLine());

                System.out.print("Enter the Phone Number: ");
                String phone = br.readLine();

                System.out.print("Enter the City: ");
                String city = br.readLine();

                //make Student obj to store student
                Student stu = new Student(name,age,phone,city);
                boolean ans = StudentDao.insertStudentToDb(stu);
                if(ans){
                    System.out.println("Student added successfully :)");
                }else{
                    System.out.println("Oops! Something went wrong :(");
                }
                System.out.println(stu);
            }
            else if(choice == 2){
                //delete student
                System.out.print("Enter the Student id: ");
                int userId = Integer.parseInt(br.readLine());
                boolean flag = StudentDao.deleteStudent(userId);
                if(flag){
                    System.out.println("Student deleted successfully :)");
                }else{
                    System.out.println("Oops! Something went wrong :(");
                }
            }
            else if(choice == 3){
                //display students
                    StudentDao.displayStudents();
            }
            else if(choice == 4){
                //update
                System.out.print("Enter the Student id: ");
                int userId = Integer.parseInt(br.readLine());

                System.out.print("Enter the Name: ");
                String name = br.readLine();

                System.out.print("Enter the Age: ");
                int age = Integer.parseInt(br.readLine());

                System.out.print("Enter the Phone Number: ");
                String phone = br.readLine();

                System.out.print("Enter the City: ");
                String city = br.readLine();
                Student stu = new Student(name,age,phone,city);

                boolean ans = StudentDao.updateStudent(stu, userId);

                if(ans){
                    System.out.println("Student updated successfully :)");
                }else{
                    System.out.println("Oops! Something went wrong :(");
                }
                System.out.println(stu);
            }
            else if(choice == 5){
                //exit
                break;
            }
            else{
                System.out.println("Invalid Input !");
            }
        }
        System.out.println("ThankYou for using :)");
    }
}