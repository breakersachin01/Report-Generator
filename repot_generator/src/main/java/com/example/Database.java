package com.example;

import java.sql.*;

// import javax.lang.model.util.ElementScanner;
import javax.swing.JOptionPane;

public class Database {
    static final String DB_URL = "jdbc:mysql://localhost:3306/University";
    static final String USER = "root";
    static final String PASS = "";

    int InsertStudentData(String Name, String Department, String Reg_no, String Roll_no, String Section,
            String Fathers_name, String Address, String Mobile) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "Insert Into Student (Name, Department, Reg_no, Roll_no, Section, Fathers_name, Address, Mobile) VALUES ( '"
                    + Name + "', '" + Department + "', '" + Reg_no + "', '" + Roll_no + "', '" + Section + "', '"
                    + Fathers_name + "', '" + Address + "', '" + Mobile + "')";
            ResultSet rs = new Database().RetrieveRecord(Reg_no, Department);
            if (rs.getString("course_name") == null) {
                NullPointerException nullPointer = new NullPointerException();
                throw nullPointer;
            }
            i = stmt.executeUpdate(sql);
            do {
                String course_code = rs.getString("course_code");
                String course_name = rs.getString("course_name");
                String sql1 = "Insert Into marks (Reg_no, Course, Course_code, CA1, CA2, CA3, MTE, ETE) values ( '"
                        + Reg_no + "', '"
                        + course_name + "', '" + course_code + "', 0, 0, 0, 0, 0)";
                i = stmt.executeUpdate(sql1);
            } while (rs.next());
            System.out.println("Inserted Student Details in given databaase...");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Incorrect password. Try again.", "Login Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return i;
    }

    ResultSet RetrieveRecord(String Reg_no, int q) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "";
            if (q == 0)
                query = "SELECT * FROM Student WHERE Reg_no = '" + Reg_no + "'";
            else if (q == 1)
                query = "SELECT * FROM marks WHERE REG_no = '" + Reg_no + "'";
            else if (q == 2)
                query = "SELECT s.Name, s.Department, s.Reg_no, s.Roll_no, s.Section, s.Fathers_name, s.Address, s.Mobile, "
                        +
                        "m.Course_code, cd.course_name, m.CA1, m.CA2, m.CA3, m.MTE, m.ETE " +
                        "FROM student s " +
                        "JOIN marks m ON s.Reg_no = m.Reg_no " +
                        "JOIN course_details cd ON m.Course_code = cd.course_code " +
                        "WHERE s.Reg_no ='" + Reg_no + "'";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return resultSet;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    int CountCourse(String Dept) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT COUNT(*) FROM course_details WHERE department = '" + Dept + "'";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                i++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    ResultSet RetrieveRecord(String Reg_no, String dept) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM course_details WHERE department = '" + dept + "'";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return resultSet;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    int UpdateStudentData(String Reg_no, String Name, String Department, String Roll_no, String Section,
            String Fathers_name, String Address, String Mobile) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "UPDATE Student SET Name = '" + Name + "', Department = '" + Department
                    + "', Roll_no = '" + Roll_no + "', Section = '" + Section + "', Fathers_name = '" + Fathers_name
                    + "', Address = '" + Address + "', Mobile = '" + Mobile + "' WHERE Reg_no = '" + Reg_no + "'";

            i = stmt.executeUpdate(sql);

            System.out.println("Updated the details in the table..." + "name: " + Name + " dept: " + Department
                    + " roll: " + Roll_no + " section: " + Section + " fathers name: " + Fathers_name + " address: "
                    + Address + " mobile: " + Mobile);
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    int DeleteStudentRecord(String Reg_no) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String query = "DELETE FROM marks WHERE Reg_no = '" + Reg_no + "'";
            String sql = "DELETE FROM Student WHERE Reg_no = '" + Reg_no + "' ";

            i = stmt.executeUpdate(query);
            i = stmt.executeUpdate(sql);
            if (i > 0)
                System.out.println("Deleted Record in from databaase...");
        } catch (Exception e) {
            System.out.println(e);
        }

        return i;
    }

    int feedMarks(String Reg_no, String courseCode, String CA1, String CA2, String CA3, String MTE, String ETE) {

        int ca1 = Integer.parseInt(CA1);
        int ca2 = Integer.parseInt(CA2);
        int ca3 = Integer.parseInt(CA3);
        int mte = Integer.parseInt(MTE);
        int ete = Integer.parseInt(ETE);

        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO marks (Reg_no, Course_code, CA1, CA2, CA3, MTE, ETE) VALUES ('" + Reg_no + "', '"
                    + courseCode + "', '" + ca1 + "', '" + ca2 + "', '" + ca3 + "', '" + mte + "', '" + ete + "') "
                    + "ON DUPLICATE KEY UPDATE CA1 = '" + ca1 + "', CA2 = '" + ca2 + "', CA3 = '" + ca3 + "', MTE = '"
                    + mte + "', ETE = '" + ete + "'";

            String sql2 = "UPDATE marks SET CA1 = '" + ca1 + "', CA2 = '" + ca2 + "', CA3= '" + ca3 + "', MTE = '" + mte
                    + "', ETE = '" + ete + "' WHERE Reg_no = '" + Reg_no + "' AND Course_code ='" + courseCode + "'";

            // String sql = "INSERT INTO marks (Reg_no, Course_code, CA1, CA2, CA3, MTE,
            // ETE) VALUES (?, ?, ?, ?, ?, ?, ?) "
            // +
            // "ON DUPLICATE KEY UPDATE CA1 = ?, CA2 = ?, CA3 = ?, MTE = ?, ETE = ?";

            i = stmt.executeUpdate(sql);

            System.out.println("Inserted Student marks in given databaase...");
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    public static void main(String str[]) throws SQLException, NullPointerException {
        Database db = new Database();
        ResultSet rs = db.RetrieveRecord("CE202101", 0);
        if (rs != null)
            System.out.println(rs.getString("Name"));
        else
            System.out.println("No record found");

        // System.out.println(rs.getString("Name"));

        // db.UpdateStudentData("12108088", "Aftab", "MEC", "20", "RJ", "Razzak Ali",
        // "Pratappur", "9984526525");

        // db.DeleteStudentRecord("12105585");
        // db.feedMarks("12108086", "CSE205", "19", "25", "20", "15", "40");

        // ResultSet rs = db.RetrieveRecord("12108086", "Computer Science");
        // do {
        // System.out.println(rs.getString("course_code"));
        // } while (rs.next());

    }
}
