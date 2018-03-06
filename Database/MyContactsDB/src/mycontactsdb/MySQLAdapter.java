package mycontactsdb;
import java.sql.*; //ทำงานกับ database บน java ต้อง import คลาสjava เข้ามา

public class MySQLAdapter {
    //สร้าง obj สำหรับเป็นตัวเชื่อมต่อกับฐานข้อมูล
    Connection conn=null;
    //สร้าง obj สำหรับรันคำสั่ง sql เพื่อจัดการกับข้อมูลในฐานข้อมูล
    Statement stmt;
    //สร้างตัวแปรสำหรับเก็บคำสั่ง sql เพื่อสั่งไปรับกับฐานข้อมูล
    String sql;
    //สร้าง obj สำหรับรับค่าที่ฐานข้อมูลคืนมาให้เป็น recordset
    ResultSet rset; //กลุ่มของผลลัพธ์ ที่คืนกลับมาของ record หรือ แถว 
     //ประกาศตัวแปรอาร์เรย์สำหรับคืนค่ากลับ
        String[] result;
        
    //สร้างเมธอดสำหรับเชื่อมกับฐานข้อมูลก่อน
    public Connection getConnection(){
        try{
            //สร้างการเชื่อมต่อไปยั MySQL
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts?useSSl=flase", 
                    "root",""); 
            //local คือเครื่องที่ใช้อยู่ เครื่องอื่นคือใช้ ip เครื่องนั้น ,3306 คือ พอตของserver นั้น , ไม่มีการเข้ารหัสด้วย SSl useSSl=flase
            //root คือ username , "" คือไม่มีpassword 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public int inserData(String val1, String val2, String val3){  //จำนวนrecord ที่ insert ได้
        //ประกาศตัวแปรสำหรับเก็บจำนวนเรคคอร์ดที่เพิ่มลงไปได้
        int i=0;
        try{
            //สร้างคำสั่ง sql ในการเพิ่มข้อมูลเรคคอร์ดใหม่ลงไปในตารางข้อมูง
            sql="insert into mycontacts values('"+val1+"','"+val2+"','"+val3+"')"; 
            //ถ้ากรณีใส่ข้อมูลลงไปเป็นstring  ให้ใช้ ฟันเดียว '' ครอบ
            System.out.println(sql);
            //รันคำลั่ง sql ที่สร้างไว้
            stmt=conn.createStatement(); //ส่งคำสั่งไปประมวลที่ stmt
            i=stmt.executeUpdate(sql); //ประมวลผลเพื่อนอัพเดทข้อมูล เพิ่งข้อมูลใหม่
            //คำลั่ง executeUpdate จะคืนค่ากลับเป็นจำนวนรคคอร์ดที่ทำสำเร็จ
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return i; //เพื่อแสดงว่ารีเทิร์นได้กี่เรคคอร์ด
    }
    
    //สร่างเมธอดอ่านข้อมูลทุกเรคคอร์ดจากตารางข้อมูล 
    public ResultSet selectAll(){
        try{
            //สร้างคำสั่ง sql สำหรับอ่านข้อมูลจากตารางข้อมูล
            sql="select * from mycontacts"; //อ่านข้อมูลใช้คำสั่ง select 
            //ใช้ * เพื่อเรียกทุกคำสั่ง
            //เลือก(select) ฟิวไหน(*) จากต่างอะไร(from mycontacts)
            //รันคำลั่ง sql ที่สร้างไว้
            stmt=conn.createStatement(); //จะเรียกที่ก็ใช้ statement ที
            rset=stmt.executeQuery(sql); //ถ้าเป็น insert จะใช้ executeQuery
            //คำลั่ง select จะคืนค่ากลับเป็นกลุ่มของผลลัพธ์ (set of result)
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return rset;
    }
    
    //สร้างเมธอดสำหรับการค้นหาข้อมูลตามเงื่อนไขที่กำหนด
    public String[] searchData(String val){
       
        try{
            //สร้างคำสั่ง sql สำหรับอ่านข้อมูลแบบมีเงื่อนไข
            sql="select * from mycontacts where contactname='"+val+"'";
            stmt=conn.createStatement();
            rset =stmt.executeQuery(sql);
            //อ่านข้อมูลจาก ResultSet แล้วเก็บลงอาร์เรย์
            while(rset.next()){ //วนอ่านข้อมูล
                
            
                String x=rset.getString("contactname")+";"+
                        rset.getString("mobile")+";"+
                        rset.getString("email");
                result=x.split(";",3); //แปลง string ลงอาร์เรย์ //split คือโยนค่าเข้าออาร์เรย์
            }
        }
            catch(SQLException e){
                    e.printStackTrace();
                    }
            return result;
        }
    }

