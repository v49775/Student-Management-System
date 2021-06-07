package com.company;

import java.util.Scanner;
import java.sql.*;
public class student_management_system {
    public static void main(String[] args){
        System.out.println("welcome to the Student Management System");
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("Press 1 to insert data in the system");
            System.out.println("Press 2 to delete data in the system");
            System.out.println("Press 3 to show data in the system");
            System.out.println("Press 4 to exit into the system");
            int userinput = sc.nextInt();

            //database connection


               String url="jdbc:mysql://localhost:3306/student_management?autoReconnect=true&useSSL=false";
               String uname="root";
               String pass="v49775";

            if (userinput == 1) {

                //insert data code

                System.out.println("enter the student rollno: ");
                int rollno=sc.nextInt();
                System.out.println("enter the student name: ");
                String name=sc.next();
                System.out.println("enter phone no: ");
                String phone=sc.next();
                System.out.println("enter your city name: ");
                String city=sc.next();

                String query="insert into student(rollno,stname,phone,city) values(?,?,?,?)";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,uname,pass);
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setInt(1,rollno);
                    ps.setString(2,name);
                    ps.setString(3,phone);
                    ps.setString(4,city);
//                    int exqry=ps.executeUpdate();
                    if(true){
                        ps.executeUpdate();
                        System.out.println("successfully inserted the data");
                    }
                    else {
                        System.out.println("something went wrong");
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }


    
            } else if (userinput == 2) {
                //delete data code
                System.out.println("enter the student roll no do you want to delete : ");
                int rollno=sc.nextInt();


                String query="delete from student where rollno=?";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,uname,pass);
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setInt(1,rollno);

                    if(true){
                        ps.executeUpdate();
                        System.out.println("successfully deleted the data of "+rollno+" roll number");
                    }
                    else {
                        System.out.println("something went wrong");
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            } else if (userinput == 3) {
                //show data code3
                String query="select * from student";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection(url,uname,pass);
                    Statement ps = con.createStatement();
                    ResultSet rs=ps.executeQuery(query);
                    while(rs.next()){
                        String alldata=rs.getInt(1)+"    :    "+ rs.getString("stname")+"    :    " +rs.getString("phone")+"    :    " +rs.getString("city");
                        System.out.println(alldata);
                    }

                }
                catch(Exception e){
                    e.printStackTrace();
                }
            } else if (userinput == 4) {
                //exit into the system code
                break;
            } else {

            }
        }
    }
}


