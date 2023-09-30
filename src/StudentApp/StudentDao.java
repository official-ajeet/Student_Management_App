package StudentApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
//FUNCTION TO INSERT A STUDENT

    public static boolean insertStudentToDb(Student stu){//its static , can be used without making an object
        boolean flag = false;
        try{
            //jdbc code
            Connection con = ConnectionProvider.createConnection();
            String query = MyQuery.insert();

            //using prepared statement , bcoz working dynamically
            PreparedStatement pstm = con.prepareStatement(query);
            //set the values to the parameter
            pstm.setInt(1,stu.getId());
            pstm.setString(2,stu.getName());
            pstm.setInt(3,stu.getAge());
            pstm.setString(4, stu.getPhone());
            pstm.setString(5, stu.getCity());

            //execute
            pstm.executeUpdate();

            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;//if everything will be okay , return true else false
    }

//FUNCTION TO DELETE A STUDENT
    public static boolean deleteStudent(int userId) {
        boolean flag = false;
        try{
            Connection con = ConnectionProvider.createConnection();
            String query = MyQuery.delete();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,userId);
            pstm.execute();

            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

//FUNCTION TO DISPLAY ALL STUDENTS
    public static void displayStudents() {
        try{
            Connection con = ConnectionProvider.createConnection();
            String query = MyQuery.display();

            Statement stm = con.createStatement();//stmnt can be used
            ResultSet res = stm.executeQuery(query);// we need some values so using excquery

            //print data
            while(res.next()){
                int id = res.getInt(1);
                String name = res.getString(2);
                int age = res.getInt(3);
                String phone = res.getString(4);
                String city = res.getString(5);

                System.out.println("Id : "+id);
                System.out.println("Name : "+name);
                System.out.println("Age : "+age);
                System.out.println("Phone : "+phone);
                System.out.println("City : "+city);
                System.out.println("-------------------------------");
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }

//FUNCTION TO UPDATE A STUDENT
    public static boolean updateStudent(Student stu, int userId) {
        boolean flag = false;
        try{
            Connection con = ConnectionProvider.createConnection();
            String query = MyQuery.update();
            PreparedStatement pstm = con.prepareStatement(query);

            //set values to the parameter
            pstm.setString(1,stu.getName());
            pstm.setInt(2,stu.getAge());
            pstm.setString(3,stu.getPhone());
            pstm.setString(4,stu.getCity());
            pstm.setInt(5,userId);

            pstm.executeUpdate();

            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
