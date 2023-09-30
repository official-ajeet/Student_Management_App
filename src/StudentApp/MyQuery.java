package StudentApp;
public class MyQuery {
    static String insert(){
        return "insert into students(id,name,age,phone,city) values(?,?,?,?,?)";
    }
    static String delete(){
        return "delete from students where id = ?";
    }
    static String display(){
        return "select * from students";
    }
    static String update(){
        return "update students set name = ?, age = ?, phone = ?, city = ? where id = ?";
    }
}
