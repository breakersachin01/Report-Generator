package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MainLoginWindow extends JFrame {

    private JPanel loginPanel;
    private JPanel dropDownPanel;
    private JPanel blankPanel;
    private JPanel updateStudentPanel;
    private JPanel addStudentPanel;
    private JPanel deleteRecordPanel;
    private JPanel feedMarksPanel;
    private JPanel viewMarksPanel;
    private String courseCode;

    public MainLoginWindow() {
        initComponents();
    }

    private void switchToAddStudentPanel() {
        // Handle "Add Student" action here
        // this panel will open when add student button is clicked
        if (updateStudentPanel != null) // to check if update panel is open or not
            blankPanel.remove(updateStudentPanel); // if open then remove it
        if (deleteRecordPanel != null) // to check if delete panel is open or not
            blankPanel.remove(deleteRecordPanel); // if open then remove it
        if (feedMarksPanel != null) // to check if feed marks panel is open or not
            blankPanel.remove(feedMarksPanel); // if open then remove it
        if (viewMarksPanel != null) // to check if view marks panel is open or not
            blankPanel.remove(viewMarksPanel); // if open then remove it

        // Create or show the add student panel
        if (addStudentPanel == null) { // if add student panel is not open then create it
            addStudentPanel = new JPanel();
            addStudentPanel.setLayout(null);
        } else {
            blankPanel.remove(addStudentPanel); // if add student panel is open then remove all the components from it
            addStudentPanel = new JPanel();
            addStudentPanel.setLayout(null);
        }

        Font headingFont = new Font("Arial", Font.BOLD, 25); // setting the font for heading
        JLabel studentInfoLabel = new JLabel("Enter Student Information"); // creating a label for heading
        studentInfoLabel.setFont(headingFont); // setting the font for heading label
        studentInfoLabel.setBounds(220, 60, 325, 30); // setting the position of heading label
        addStudentPanel.add(studentInfoLabel); // adding the heading label to the panel

        // Creating the Labels for the text fields and setting their position on the
        // addStudentPanel
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(40, 90, 325, 30);
        addStudentPanel.add(nameLabel);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(415, 90, 325, 30);
        addStudentPanel.add(departmentLabel);

        JLabel regNumberLabel = new JLabel("Reg Number:");
        regNumberLabel.setBounds(40, 190, 325, 30);
        addStudentPanel.add(regNumberLabel);

        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberLabel.setBounds(415, 190, 325, 30);
        addStudentPanel.add(rollNumberLabel);

        JLabel fatherNameLabel = new JLabel("Father's Name:");
        fatherNameLabel.setBounds(40, 290, 325, 30);
        addStudentPanel.add(fatherNameLabel);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(415, 290, 325, 30);
        addStudentPanel.add(addressLabel);

        JLabel mobileNumberLabel = new JLabel("Mobile Number:");
        mobileNumberLabel.setBounds(40, 390, 325, 30);
        addStudentPanel.add(mobileNumberLabel);

        JLabel sectionLabel = new JLabel("Section:");
        sectionLabel.setBounds(415, 390, 325, 30);
        addStudentPanel.add(sectionLabel);

        // Creating the text fields and setting their position on the addStudentPanel
        JTextField nameField = new JTextField();
        nameField.setBounds(40, 120, 325, 30);
        addStudentPanel.add(nameField);

        JTextField departmentField = new JTextField();
        departmentField.setBounds(415, 120, 325, 30);
        addStudentPanel.add(departmentField);

        JTextField regNumberField = new JTextField();
        regNumberField.setBounds(40, 220, 325, 30);
        addStudentPanel.add(regNumberField);

        JTextField rollNumberField = new JTextField();
        rollNumberField.setBounds(415, 220, 325, 30);
        addStudentPanel.add(rollNumberField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(40, 320, 325, 30);
        addStudentPanel.add(fatherNameField);

        JTextField addressField = new JTextField();
        addressField.setBounds(415, 320, 325, 30);
        addStudentPanel.add(addressField);

        JTextField mobileNumberField = new JTextField();
        mobileNumberField.setBounds(40, 420, 325, 30);
        addStudentPanel.add(mobileNumberField);

        JTextField sectionField = new JTextField();
        sectionField.setBounds(415, 420, 325, 30);
        addStudentPanel.add(sectionField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(360, 490, 70, 30);
        // Handle the addButton click event here
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String name = nameField.getText();
                String department = departmentField.getText();
                String regNumber = regNumberField.getText();
                String rollNumber = rollNumberField.getText();
                String fatherName = fatherNameField.getText();
                String address = addressField.getText();
                String mobileNumber = mobileNumberField.getText();
                String section = sectionField.getText();

                // Insert the data into the database
                Database db = new Database();
                db.InsertStudentData(name, department, regNumber, rollNumber, section, fatherName, address,
                        mobileNumber);
                // Clear the text fields
                nameField.setText("");
                departmentField.setText("");
                regNumberField.setText("");
                rollNumberField.setText("");
                fatherNameField.setText("");
                addressField.setText("");
                mobileNumberField.setText("");
                sectionField.setText("");
            }
        });
        addStudentPanel.add(addButton);

        addStudentPanel.setBounds(0, 0, 800, 550); // setting the position of addStudentPanel
        blankPanel.add(addStudentPanel); // adding the addStudentPanel to the blank panel
        getContentPane().add(blankPanel); // adding the blank panel to the frame
        validate(); // Revalidate the frame to update the UI
        repaint(); // Repaint the frame
    }

    private void switchToUpdatePanel() {

        // Handle "Update Student" action here
        // this panel will open when update student button is clicked

        if (addStudentPanel != null) // to check if add student panel is open or not
            blankPanel.remove(addStudentPanel); // if open then remove it
        if (deleteRecordPanel != null) // to check if delete panel is open or not
            blankPanel.remove(deleteRecordPanel); // if open then remove it
        if (feedMarksPanel != null) // to check if feed marks panel is open or not
            blankPanel.remove(feedMarksPanel); // if open then remove it
        if (viewMarksPanel != null) // to check if view marks panel is open or not
            blankPanel.remove(viewMarksPanel); // if open then remove it

        // Create or show the update student panel
        if (updateStudentPanel == null) {
            updateStudentPanel = new JPanel();
            updateStudentPanel.setLayout(null);
        } else {
            blankPanel.remove(updateStudentPanel);
            updateStudentPanel = new JPanel();
            updateStudentPanel.setLayout(null);
        }

        // Heading Label
        Font headingFont = new Font("Arial", Font.BOLD, 25);
        JLabel studentInfoLabel = new JLabel("Update Student Information");
        studentInfoLabel.setFont(headingFont);
        studentInfoLabel.setBounds(220, 60, 325, 30);
        updateStudentPanel.add(studentInfoLabel);

        // Input Registration Number to find the student
        JLabel regNumberLabel = new JLabel("Reg Number:"); // Registration Number
        regNumberLabel.setBounds(70, 100, 200, 30);
        updateStudentPanel.add(regNumberLabel);

        JTextField regNumberField = new JTextField();
        regNumberField.setBounds(330, 100, 200, 30);
        updateStudentPanel.add(regNumberField);

        JButton findButton = new JButton("Find");
        findButton.setBounds(590, 100, 100, 30);
        updateStudentPanel.add(findButton);

        // Adding the labels and text fields to the updateStudentPanel
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(40, 150, 325, 30);
        updateStudentPanel.add(nameLabel);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(415, 150, 325, 30);
        updateStudentPanel.add(departmentLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(40, 180, 325, 30);
        updateStudentPanel.add(nameField);

        JTextField departmentField = new JTextField();
        departmentField.setBounds(415, 180, 325, 30);
        updateStudentPanel.add(departmentField);

        // Roll Number and Father's Name Label
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberLabel.setBounds(415, 240, 325, 30);
        updateStudentPanel.add(rollNumberLabel);

        JLabel fatherNameLabel = new JLabel("Father's Name:");
        fatherNameLabel.setBounds(40, 240, 325, 30);
        updateStudentPanel.add(fatherNameLabel);

        JTextField rollNumberField = new JTextField();
        rollNumberField.setBounds(415, 270, 325, 30);
        updateStudentPanel.add(rollNumberField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(40, 270, 325, 30);
        updateStudentPanel.add(fatherNameField);

        // Address and Mobile Number Label
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(40, 330, 325, 30);
        updateStudentPanel.add(addressLabel);

        JLabel mobileNumberLabel = new JLabel("Mobile Number:");
        mobileNumberLabel.setBounds(415, 330, 325, 30);
        updateStudentPanel.add(mobileNumberLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(40, 360, 325, 30);
        updateStudentPanel.add(addressField);

        JTextField mobileNumberField = new JTextField();
        mobileNumberField.setBounds(415, 360, 325, 30);
        updateStudentPanel.add(mobileNumberField);

        // Section Label
        JLabel sectionLabel = new JLabel("Section:");
        sectionLabel.setBounds(40, 420, 325, 30);
        updateStudentPanel.add(sectionLabel);

        JTextField sectionField = new JTextField();
        sectionField.setBounds(40, 450, 325, 30);
        updateStudentPanel.add(sectionField);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(415, 450, 120, 30);
        updateStudentPanel.add(updateButton);

        // set all the fields non editable
        nameField.setEditable(false);
        departmentField.setEditable(false);
        rollNumberField.setEditable(false);
        fatherNameField.setEditable(false);
        addressField.setEditable(false);
        mobileNumberField.setEditable(false);
        sectionField.setEditable(false);

        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Database db = new Database();
                String regNumberValue = regNumberField.getText();
                ResultSet rs = db.RetrieveRecord(regNumberValue, 0);
                String name = "";
                String dept = "";
                String roll_no = "";
                String section = "";
                String fathers = "";
                String mobile = "";
                String address = "";

                try {
                    regNumberField.setEditable(false);
                    name = rs.getString("name");
                    dept = rs.getString("department");
                    fathers = rs.getString("fathers_name");
                    roll_no = rs.getString("roll_no");
                    section = rs.getString("section");
                    mobile = rs.getString("mobile");
                    address = rs.getString("address");
                    System.out.println(name + " " + dept + " " + roll_no + " " + section);
                    nameField.setEditable(true);
                    departmentField.setEditable(true);
                    rollNumberField.setEditable(true);
                    fatherNameField.setEditable(true);
                    addressField.setEditable(true);
                    mobileNumberField.setEditable(true);
                    sectionField.setEditable(true);

                    nameField.setText(name);
                    departmentField.setText(dept);
                    rollNumberField.setText(roll_no);
                    fatherNameField.setText(fathers);
                    addressField.setText(address);
                    mobileNumberField.setText(mobile);
                    sectionField.setText(section);
                } catch (Exception exception) {
                    regNumberField.setEditable(true);
                    JOptionPane.showMessageDialog(null, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String dept = departmentField.getText();
                String regNumberValue = regNumberField.getText();
                String roll_no = rollNumberField.getText();
                String fathers = fatherNameField.getText();
                String address = addressField.getText();
                String mobile = mobileNumberField.getText();
                String section = sectionField.getText();
                System.out.println(roll_no);
                Database db = new Database();
                if (db.UpdateStudentData(regNumberValue, name, dept, roll_no, section, fathers, address, mobile) > 0) {
                    JOptionPane.showMessageDialog(null, "Student Record Updated Successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    departmentField.setText("");
                    regNumberField.setText("");
                    rollNumberField.setText("");
                    fatherNameField.setText("");
                    addressField.setText("");
                    mobileNumberField.setText("");
                    sectionField.setText("");
                    regNumberField.setEditable(true);
                }
            }
        });
        updateStudentPanel.setBounds(0, 0, 800, 550);
        blankPanel.add(updateStudentPanel);
        getContentPane().add(blankPanel);
        validate(); // Revalidate the frame to update the UI
        repaint(); // Repaint the frame
    }

    private void switchToRemovePanel() {

        if (addStudentPanel != null)
            blankPanel.remove(addStudentPanel);
        if (updateStudentPanel != null)
            blankPanel.remove(updateStudentPanel);
        if (feedMarksPanel != null)
            blankPanel.remove(feedMarksPanel);
        if (viewMarksPanel != null)
            blankPanel.remove(viewMarksPanel);
        if (deleteRecordPanel == null) {
            deleteRecordPanel = new JPanel();
            deleteRecordPanel.setLayout(null);
        } else {
            blankPanel.remove(deleteRecordPanel);
            deleteRecordPanel = new JPanel();
            deleteRecordPanel.setLayout(null);
        }

        Font headingFont = new Font("Arial", Font.BOLD, 25);
        JLabel studentInfoLabel = new JLabel("Delete Student Record");
        studentInfoLabel.setFont(headingFont);
        studentInfoLabel.setBounds(220, 60, 325, 30);
        deleteRecordPanel.add(studentInfoLabel);

        // Registration Number
        JLabel regNumberLabel = new JLabel("Reg Number:");
        regNumberLabel.setBounds(70, 100, 200, 30);
        deleteRecordPanel.add(regNumberLabel);

        JTextField regNumberField = new JTextField();
        regNumberField.setBounds(330, 100, 200, 30);
        deleteRecordPanel.add(regNumberField);

        JButton findButton = new JButton("Find");
        findButton.setBounds(590, 100, 100, 30);
        deleteRecordPanel.add(findButton);

        // Name and Department Label
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(40, 150, 325, 30);
        deleteRecordPanel.add(nameLabel);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(415, 150, 325, 30);
        deleteRecordPanel.add(departmentLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(40, 180, 325, 30);
        deleteRecordPanel.add(nameField);

        JTextField departmentField = new JTextField();
        departmentField.setBounds(415, 180, 325, 30);
        deleteRecordPanel.add(departmentField);

        // Roll Number and Father's Name Label
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberLabel.setBounds(415, 240, 325, 30);
        deleteRecordPanel.add(rollNumberLabel);

        JLabel fatherNameLabel = new JLabel("Father's Name:");
        fatherNameLabel.setBounds(40, 240, 325, 30);
        deleteRecordPanel.add(fatherNameLabel);

        JTextField rollNumberField = new JTextField();
        rollNumberField.setBounds(415, 270, 325, 30);
        deleteRecordPanel.add(rollNumberField);

        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(40, 270, 325, 30);
        deleteRecordPanel.add(fatherNameField);

        // Address and Mobile Number Label
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(40, 330, 325, 30);
        deleteRecordPanel.add(addressLabel);

        JLabel mobileNumberLabel = new JLabel("Mobile Number:");
        mobileNumberLabel.setBounds(415, 330, 325, 30);
        deleteRecordPanel.add(mobileNumberLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(40, 360, 325, 30);
        deleteRecordPanel.add(addressField);

        JTextField mobileNumberField = new JTextField();
        mobileNumberField.setBounds(415, 360, 325, 30);
        deleteRecordPanel.add(mobileNumberField);

        // Section Label
        JLabel sectionLabel = new JLabel("Section:");
        sectionLabel.setBounds(40, 420, 325, 30);
        deleteRecordPanel.add(sectionLabel);

        JTextField sectionField = new JTextField();
        sectionField.setBounds(40, 450, 325, 30);
        deleteRecordPanel.add(sectionField);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(415, 450, 120, 30);
        deleteRecordPanel.add(removeButton);

        // set all the fields non editable
        nameField.setEditable(false);
        departmentField.setEditable(false);
        rollNumberField.setEditable(false);
        fatherNameField.setEditable(false);
        addressField.setEditable(false);
        mobileNumberField.setEditable(false);
        sectionField.setEditable(false);

        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Database db = new Database();
                String regNumberValue = regNumberField.getText();
                ResultSet rs = db.RetrieveRecord(regNumberValue, 0);
                String name = "";
                String dept = "";
                String roll_no = "";
                String section = "";
                String fathers = "";
                String mobile = "";
                String address = "";

                try {
                    regNumberField.setEditable(false);
                    name = rs.getString("name");
                    dept = rs.getString("department");
                    fathers = rs.getString("fathers_name");
                    roll_no = rs.getString("roll_no");
                    section = rs.getString("section");
                    mobile = rs.getString("mobile");
                    address = rs.getString("address");
                    System.out.println(name + " " + dept + " " + roll_no + " " + section);

                    nameField.setText(name);
                    departmentField.setText(dept);
                    rollNumberField.setText(roll_no);
                    fatherNameField.setText(fathers);
                    addressField.setText(address);
                    mobileNumberField.setText(mobile);
                    sectionField.setText(section);
                } catch (Exception exception) {
                    regNumberField.setEditable(true);
                    JOptionPane.showMessageDialog(null, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String regNumberValue = regNumberField.getText();
                Database db = new Database();
                if (db.DeleteStudentRecord(regNumberValue) > 0) {
                    JOptionPane.showMessageDialog(null, "Student Record Deleted Successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    departmentField.setText("");
                    regNumberField.setText("");
                    rollNumberField.setText("");
                    fatherNameField.setText("");
                    addressField.setText("");
                    mobileNumberField.setText("");
                    sectionField.setText("");
                    regNumberField.setEditable(true);
                }
            }
        });

        deleteRecordPanel.setBounds(0, 0, 800, 550);
        blankPanel.add(deleteRecordPanel);
        getContentPane().add(blankPanel);
        validate(); // Revalidate the frame to update the UI
        repaint(); // Repaint the frame
    }

    private void switchToFeedMarksPanel() {
        if (addStudentPanel != null)
            blankPanel.remove(addStudentPanel);
        if (updateStudentPanel != null)
            blankPanel.remove(updateStudentPanel);
        if (deleteRecordPanel != null)
            blankPanel.remove(deleteRecordPanel);
        if (viewMarksPanel != null)
            blankPanel.remove(viewMarksPanel);

        if (feedMarksPanel == null)
            feedMarksPanel = new JPanel(null);
        else {
            blankPanel.remove(feedMarksPanel);
            feedMarksPanel = new JPanel(null);
        }

        JPanel headPanel = new JPanel(null);
        JPanel detailsPanel = new JPanel(null);
        JPanel marksPanel = new JPanel(null);
        JPanel coursePanel = new JPanel(null);

        Font headingFont = new Font("Arial", Font.BOLD, 25);
        JLabel studentInfoLabel = new JLabel("Feed Student Marks");
        studentInfoLabel.setFont(headingFont);
        studentInfoLabel.setBounds(260, 60, 325, 30);
        headPanel.add(studentInfoLabel);

        // Registration Number
        JLabel regNumberLabel = new JLabel("Registration Number:");
        regNumberLabel.setBounds(100, 100, 250, 30);
        headPanel.add(regNumberLabel);

        JTextField regNumberField = new JTextField();
        regNumberField.setBounds(240, 100, 200, 30);
        headPanel.add(regNumberField);

        JButton findButton = new JButton("Find");
        findButton.setBounds(470, 100, 100, 30);
        headPanel.add(findButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(590, 100, 100, 30);
        headPanel.add(resetButton);

        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String regNumberValue = regNumberField.getText();
                Database db = new Database();
                ResultSet rs = db.RetrieveRecord(regNumberValue, 0);
                String name = "";
                String dept = "";
                String roll_no = "";
                String section = "";

                try {
                    regNumberField.setEditable(false);
                    name = rs.getString("name");
                    dept = rs.getString("department");
                    roll_no = rs.getString("roll_no");
                    section = rs.getString("section");
                    System.out.print(name + " " + dept + " " + roll_no + " " + section);
                } catch (Exception exception) {
                    regNumberField.setEditable(true);
                    JOptionPane.showMessageDialog(null, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (name != "") {
                    coursePanel.setBounds(600, 150, 200, 450);
                    coursePanel.setBackground(new Color(192, 192, 192));
                    feedMarksPanel.add(coursePanel);

                    // Add the details panel
                    detailsPanel.setBackground(new Color(211, 211, 211));
                    detailsPanel.setBounds(0, 150, 600, 100);
                    feedMarksPanel.add(detailsPanel);

                    Font detailFont = new Font("Helvetica", Font.PLAIN, 16);
                    JLabel nameLabel = new JLabel("Name: " + name);
                    nameLabel.setFont(detailFont);
                    nameLabel.setBounds(50, 20, 225, 30);
                    detailsPanel.add(nameLabel);
                    JLabel departmentLabel = new JLabel("Department: " + dept);
                    departmentLabel.setFont(detailFont);
                    departmentLabel.setBounds(275, 20, 225, 30);
                    detailsPanel.add(departmentLabel);
                    JLabel rollNumberLabel = new JLabel("Roll Number: " + roll_no);
                    rollNumberLabel.setFont(detailFont);
                    rollNumberLabel.setBounds(50, 60, 200, 30);
                    detailsPanel.add(rollNumberLabel);
                    JLabel sectionLabel = new JLabel("Section: " + section);
                    sectionLabel.setFont(detailFont);
                    sectionLabel.setBounds(275, 60, 225, 30);
                    detailsPanel.add(sectionLabel);

                    marksPanel.setBackground(new Color(105, 105, 105));
                    marksPanel.setBounds(0, 100, 600, 450);
                    feedMarksPanel.add(marksPanel);

                    JLabel CA1 = new JLabel("CA-1");
                    CA1.setFont(detailFont);
                    CA1.setBounds(100, 200, 100, 30);
                    marksPanel.add(CA1);
                    JTextField ca1Field = new JTextField();
                    ca1Field.setBounds(90, 240, 60, 25);
                    marksPanel.add(ca1Field);

                    JLabel CA2 = new JLabel("CA-2");
                    CA2.setFont(detailFont);
                    CA2.setBounds(250, 200, 100, 30);
                    marksPanel.add(CA2);
                    JTextField ca2Field = new JTextField();
                    ca2Field.setBounds(240, 240, 60, 25);
                    marksPanel.add(ca2Field);

                    JLabel CA3 = new JLabel("CA-3");
                    CA3.setFont(detailFont);
                    CA3.setBounds(400, 200, 100, 30);
                    marksPanel.add(CA3);
                    JTextField ca3Field = new JTextField();
                    ca3Field.setBounds(390, 240, 60, 25);
                    marksPanel.add(ca3Field);

                    JLabel MTE = new JLabel("MTE");
                    MTE.setFont(detailFont);
                    MTE.setBounds(100, 300, 225, 30);
                    marksPanel.add(MTE);
                    JTextField mteField = new JTextField();
                    mteField.setBounds(90, 340, 60, 25);
                    marksPanel.add(mteField);

                    JLabel ETE = new JLabel("ETE");
                    ETE.setFont(detailFont);
                    ETE.setBounds(250, 300, 100, 30);
                    marksPanel.add(ETE);
                    JTextField eteField = new JTextField();
                    eteField.setBounds(240, 340, 60, 25);
                    marksPanel.add(eteField);

                    JButton saveButton = new JButton("Save");
                    saveButton.setFont(detailFont);
                    saveButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String ca1 = ca1Field.getText();
                            String ca2 = ca2Field.getText();
                            String ca3 = ca3Field.getText();
                            String mte = mteField.getText();
                            String ete = eteField.getText();
                            Database db = new Database();
                            // System.out.println(courseCode);
                            if (db.feedMarks(regNumberValue, courseCode, ca1, ca2, ca3, mte, ete) > 1)
                                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Error Occured Please Try Again");
                        }
                    });
                    saveButton.setBounds(380, 335, 80, 30);
                    marksPanel.add(saveButton);
                }

                ResultSet rs1 = db.RetrieveRecord(regNumberValue, dept);
                int i = 50;
                try {
                    do {
                        String course_code = rs1.getString("course_code");
                        String course_name = rs1.getString("course_name");
                        // feedMarksPanel.add(new JLabel(course_code));
                        System.out.println(course_code);
                        System.out.println(course_name);
                        courseCode = course_code;
                        JButton courseButton = new JButton(course_code);
                        courseButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Handle the button click event for this course
                                // You can use e.getSource() to identify which button was clicked
                                // Perform actions specific to this course
                                System.out.println("Button Clicked" + e.getActionCommand());
                                courseCode = e.getActionCommand();

                            }
                        });

                        courseButton.setBounds(50, i, 100, 30); // Adjust the X position as needed
                        i += 50;
                        coursePanel.add(courseButton); // Add buttons to coursePanel
                    } while (rs1.next());
                } catch (Exception error) {
                    System.out.println(error);
                }
                System.out.println("Find Button Clicked");
                validate(); // Revalidate the frame to update the UI
                repaint(); // Repaint the frame
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regNumberField.setEditable(true);
                System.out.println("Reset Button Clicked");
            }
        });
        // set headpanel color to gray
        headPanel.setBackground(new Color(169, 169, 169));
        headPanel.setBounds(0, 0, 800, 150);
        feedMarksPanel.add(headPanel);
        feedMarksPanel.setBounds(0, 0, 800, 550);

        blankPanel.add(feedMarksPanel);
        getContentPane().add(blankPanel);
        validate(); // Revalidate the frame to update the UI
        repaint(); // Repaint the frame
    }

    private void switchToViewMarksPanel() {

        if (addStudentPanel != null)
            blankPanel.remove(addStudentPanel);
        if (updateStudentPanel != null)
            blankPanel.remove(updateStudentPanel);
        if (deleteRecordPanel != null)
            blankPanel.remove(deleteRecordPanel);
        if (feedMarksPanel != null)
            blankPanel.remove(feedMarksPanel);

        if (viewMarksPanel == null)
            viewMarksPanel = new JPanel(null);
        else {
            blankPanel.remove(viewMarksPanel);
            viewMarksPanel = new JPanel(null);
        }

        JPanel headPanel = new JPanel(null);
        headPanel.setBounds(0, 0, 800, 150);

        Font headingFont = new Font("Arial", Font.BOLD, 25);
        JLabel studentInfoLabel = new JLabel("View Student Marks");
        studentInfoLabel.setFont(headingFont);
        studentInfoLabel.setBounds(260, 60, 325, 30);
        headPanel.add(studentInfoLabel);

        // Registration Number
        JLabel regNumberLabel = new JLabel("Registration Number:");
        regNumberLabel.setBounds(100, 100, 250, 30);
        headPanel.add(regNumberLabel);

        JTextField regNumberField = new JTextField();
        regNumberField.setBounds(240, 100, 200, 30);
        headPanel.add(regNumberField);

        JButton findButton = new JButton("Find");
        findButton.setBounds(470, 100, 100, 30);
        headPanel.add(findButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(590, 100, 100, 30);
        headPanel.add(resetButton);

        JPanel viewMarksSubPanel = new JPanel(null);
        viewMarksSubPanel.setBounds(0, 150, 800, 450);
        viewMarksPanel.add(viewMarksSubPanel);

        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String regNumberValue = regNumberField.getText();
                Database db = new Database();
                ResultSet rs = db.RetrieveRecord(regNumberValue, 2);
                String name = "";
                String dept = "";
                String roll_no = "";
                String section = "";
                String fathers = "";
                String mobile = "";
                String address = "";

                try {
                    regNumberField.setEditable(false);
                    name = rs.getString("name");
                    dept = rs.getString("department");
                    fathers = rs.getString("fathers_name");
                    roll_no = rs.getString("roll_no");
                    section = rs.getString("section");
                    mobile = rs.getString("mobile");
                    address = rs.getString("address");
                    System.out.println(name + " " + dept + " " + roll_no + " " + section);
                } catch (Exception exception) {
                    regNumberField.setEditable(true);
                    JOptionPane.showMessageDialog(null, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

                Font detailFont = new Font("Helvetica", Font.PLAIN, 16);
                if (name != "") {

                    JLabel nameLabel = new JLabel("Name: ");
                    nameLabel.setBounds(50, 20, 200, 20);
                    viewMarksSubPanel.add(nameLabel);
                    JLabel nameValueLabel = new JLabel(name);
                    nameValueLabel.setFont(detailFont);
                    nameValueLabel.setBounds(50, 40, 200, 30);
                    viewMarksSubPanel.add(nameValueLabel);

                    JLabel fathersLabel = new JLabel("Father's Name");
                    fathersLabel.setBounds(300, 20, 200, 20);
                    viewMarksSubPanel.add(fathersLabel);
                    JLabel fathersValueLabel = new JLabel(fathers);
                    fathersValueLabel.setFont(detailFont);
                    fathersValueLabel.setBounds(300, 40, 200, 30);
                    viewMarksSubPanel.add(fathersValueLabel);

                    JLabel deptLabel = new JLabel("Department");
                    deptLabel.setBounds(550, 20, 200, 20);
                    viewMarksSubPanel.add(deptLabel);
                    JLabel deptValueLabel = new JLabel(dept);
                    deptValueLabel.setFont(detailFont);
                    deptValueLabel.setBounds(550, 40, 200, 30);
                    viewMarksSubPanel.add(deptValueLabel);

                    JLabel regNumberLabel = new JLabel("Reg Number");
                    regNumberLabel.setBounds(50, 80, 200, 20);
                    viewMarksSubPanel.add(regNumberLabel);
                    JLabel regNumberValueLabel = new JLabel(regNumberValue);
                    regNumberValueLabel.setFont(detailFont);
                    regNumberValueLabel.setBounds(50, 100, 200, 30);
                    viewMarksSubPanel.add(regNumberValueLabel);

                    JLabel rollLabel = new JLabel("Roll No");
                    rollLabel.setBounds(300, 80, 200, 20);
                    viewMarksSubPanel.add(rollLabel);
                    JLabel rollValueLabel = new JLabel(roll_no);
                    rollValueLabel.setFont(detailFont);
                    rollValueLabel.setBounds(300, 100, 200, 30);
                    viewMarksSubPanel.add(rollValueLabel);

                    JLabel mobileLabel = new JLabel("Mobile");
                    mobileLabel.setBounds(550, 80, 200, 20);
                    viewMarksSubPanel.add(mobileLabel);
                    JLabel mobileValueLabel = new JLabel(mobile);
                    mobileValueLabel.setFont(detailFont);
                    mobileValueLabel.setBounds(550, 100, 200, 30);
                    viewMarksSubPanel.add(mobileValueLabel);

                    JLabel sectionLabel = new JLabel("Section");
                    sectionLabel.setBounds(50, 140, 200, 20);
                    viewMarksSubPanel.add(sectionLabel);
                    JLabel sectionValueLabel = new JLabel(section);
                    sectionValueLabel.setFont(detailFont);
                    sectionValueLabel.setBounds(50, 160, 200, 30);
                    viewMarksSubPanel.add(sectionValueLabel);

                    JLabel addressLabel = new JLabel("Address");
                    addressLabel.setBounds(300, 140, 200, 20);
                    viewMarksSubPanel.add(addressLabel);
                    JLabel addressValueLabel = new JLabel(address);
                    addressValueLabel.setFont(detailFont);
                    addressValueLabel.setBounds(300, 160, 200, 30);
                    viewMarksSubPanel.add(addressValueLabel);

                    JButton downloaButton = new JButton("Donwload", null);
                    downloaButton.setBounds(550, 160, 100, 30);
                    viewMarksSubPanel.add(downloaButton);

                    downloaButton.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            GenerateReportPDF report = new GenerateReportPDF(regNumberValue);
                        }

                    });

                    JLabel course_code = new JLabel("Course Code");
                    course_code.setBounds(20, 200, 80, 30);
                    viewMarksSubPanel.add(course_code);

                    JLabel course_name = new JLabel("Course Name");
                    course_name.setBounds(125, 200, 260, 30);
                    viewMarksSubPanel.add(course_name);

                    JLabel ca1 = new JLabel("CA-1");
                    ca1.setBounds(350, 200, 50, 30);
                    viewMarksSubPanel.add(ca1);

                    JLabel ca2 = new JLabel("CA-2");
                    ca2.setBounds(424, 200, 50, 30);
                    viewMarksSubPanel.add(ca2);

                    JLabel ca3 = new JLabel("CA-3");
                    ca3.setBounds(498, 200, 50, 30);
                    viewMarksSubPanel.add(ca3);

                    JLabel mte = new JLabel("MTE");
                    mte.setBounds(572, 200, 50, 30);
                    viewMarksSubPanel.add(mte);

                    JLabel ete = new JLabel("ETE");
                    ete.setBounds(646, 200, 50, 30);
                    viewMarksSubPanel.add(ete);

                    JLabel grade = new JLabel("Grade");
                    grade.setBounds(720, 200, 50, 30);
                    viewMarksSubPanel.add(grade);

                    JPanel contentPanel = new JPanel(null);
                    contentPanel.setBounds(20, 230, 745, 220);

                    GenerateGrade gradeObj = new GenerateGrade();

                    try {
                        int i = 0;
                        do {
                            String course_code_value = rs.getString("Course_code");
                            String course_name_value = rs.getString("course_name");
                            int ca1marks = rs.getInt("CA1");
                            int ca2marks = rs.getInt("CA2");
                            int ca3marks = rs.getInt("CA3");
                            int mtemarks = rs.getInt("MTE");
                            int etemarks = rs.getInt("ETE");

                            JLabel courseCodeLabel = new JLabel(course_code_value);
                            courseCodeLabel.setBounds(0, i * 30, 80, 30);
                            contentPanel.add(courseCodeLabel);

                            JLabel courseNameLabel = new JLabel(course_name_value);
                            courseNameLabel.setBounds(105, i * 30, 260, 30);
                            contentPanel.add(courseNameLabel);

                            JLabel ca1Label = new JLabel(String.valueOf(ca1marks));
                            ca1Label.setBounds(330, i * 30, 50, 30);
                            contentPanel.add(ca1Label);

                            JLabel ca2Label = new JLabel(String.valueOf(ca2marks));
                            ca2Label.setBounds(404, i * 30, 50, 30);
                            contentPanel.add(ca2Label);

                            JLabel ca3Label = new JLabel(String.valueOf(ca3marks));
                            ca3Label.setBounds(478, i * 30, 50, 30);
                            contentPanel.add(ca3Label);

                            JLabel mteLabel = new JLabel(String.valueOf(mtemarks));
                            mteLabel.setBounds(552, i * 30, 50, 30);
                            contentPanel.add(mteLabel);

                            JLabel eteLabel = new JLabel(String.valueOf(etemarks));
                            eteLabel.setBounds(626, i * 30, 50, 30);
                            contentPanel.add(eteLabel);

                            JLabel gradeLabel = new JLabel(
                                    gradeObj.grade(ca1marks, ca2marks, ca3marks, mtemarks, etemarks));
                            gradeLabel.setBounds(700, i * 30, 50, 30);
                            contentPanel.add(gradeLabel);
                            i++;

                            System.out.printf(
                                    "Course_code: %s, Course_name: %s, CA1: %d, CA2: %d, CA3: %d, MTE: %d, ETE: %d\n",
                                    course_code_value, course_name_value, ca1marks, ca2marks, ca3marks, mtemarks,
                                    etemarks);
                        } while (rs.next());
                    } catch (Exception exception) {
                        regNumberField.setEditable(true);
                        JOptionPane.showMessageDialog(null, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    viewMarksSubPanel.add(contentPanel);

                }

                System.out.println("Find Button Clicked");
                validate(); // Revalidate the frame to update the UI
                repaint(); // Repaint the frame
            }
        });

        viewMarksSubPanel.setBackground(new Color(211, 211, 211));

        viewMarksPanel.add(headPanel);
        viewMarksPanel.setBackground(new Color(169, 169, 169));
        viewMarksPanel.setBounds(0, 0, 800, 550);

        blankPanel.add(viewMarksPanel);
        getContentPane().add(blankPanel);
        validate(); // Revalidate the frame to update the UI
        repaint(); // Repaint the frame

    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Window");
        setSize(800, 600);

        // Create the login panel
        loginPanel = new JPanel();
        loginPanel.setLayout(null);

        // Create the login panel components
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(200, 150, 80, 25);
        loginPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(300, 150, 200, 25);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(200, 200, 80, 25);
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(300, 200, 200, 25);
        loginPanel.add(passwordField);

        // Create the login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 250, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText(); // Fetching the username entered by the user
                char[] enteredPasswordChars = passwordField.getPassword(); // Fetching the password entered by the user
                String password = new String(enteredPasswordChars); // Converting the password to String
                if (username.equals("admin") && password.equals("root")) // Checking if the username and password are
                                                                         // correct
                    switchToBlankPanel();
                else // Displaying an error message if the username or password is incorrect
                    JOptionPane.showMessageDialog(null, "Incorrect password. Try again.", "Login Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        });
        loginPanel.add(loginButton);

        // Create the drop down panel for the buttons to be displayed after login
        dropDownPanel = new JPanel();
        dropDownPanel.setLayout(null);
        dropDownPanel.setBackground(Color.GRAY);
        dropDownPanel.setBounds(0, 0, 800, 50);

        // Create the blank panel
        blankPanel = new JPanel();
        blankPanel.setLayout(null);
        blankPanel.setBackground(Color.WHITE);
        blankPanel.setBounds(0, 50, 800, 550);

        // Add the login panel to the frame initially
        getContentPane().add(loginPanel);
    }

    private void switchToBlankPanel() {
        if (loginPanel != null)
            getContentPane().remove(loginPanel);

        // Create buttons for Administration and Examination
        JButton adminButton = new JButton("Administration");
        JButton examButton = new JButton("Examination");
        JButton logoutButton = new JButton("Logout");

        adminButton.setBounds(100, 10, 150, 30);
        examButton.setBounds(300, 10, 150, 30);
        logoutButton.setBounds(500, 10, 150, 30);

        JPopupMenu adminMenu = new JPopupMenu();
        JMenuItem addStudentItem = new JMenuItem("Add Student");
        JMenuItem updateStudentItem = new JMenuItem("Update Student");
        JMenuItem deleteStudentItem = new JMenuItem("Delete Student");

        JPopupMenu examMenu = new JPopupMenu();
        JMenuItem feedMarksItem = new JMenuItem("Feed Marks");
        JMenuItem viewMarksItem = new JMenuItem("View Marks");
        JMenuItem downloadResultsItem = new JMenuItem("Download Results");

        adminMenu.add(addStudentItem);
        adminMenu.add(updateStudentItem);
        adminMenu.add(deleteStudentItem);

        examMenu.add(feedMarksItem);
        examMenu.add(viewMarksItem);
        examMenu.add(downloadResultsItem);

        // Add action listeners for the menu items
        addStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchToAddStudentPanel();
            }
        });

        updateStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle "Update Student" action here
                switchToUpdatePanel();
            }
        });

        deleteStudentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchToRemovePanel();
            }
        });

        feedMarksItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle "Feed Marks" action here
                switchToFeedMarksPanel();
            }
        });

        viewMarksItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle "View Marks" action here
                switchToViewMarksPanel();
            }
        });

        downloadResultsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle "Download Results" action here
                JOptionPane.showMessageDialog(null, "Download Results clicked");
            }
        });

        // Add action listeners to the Administration and Examination buttons
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Administration button click here
                adminMenu.show(adminButton, 0, adminButton.getHeight());
            }
        });

        examButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle Examination button click here
                examMenu.show(examButton, 0, examButton.getHeight());
            }
        });

        // Add the buttons to the blank panel
        dropDownPanel.add(adminButton);
        dropDownPanel.add(examButton);
        dropDownPanel.add(logoutButton);

        getContentPane().add(dropDownPanel);
        getContentPane().add(blankPanel);
        validate();
        repaint();
    }

    // public static void main(String args[]) {
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // new MainLoginWindow().setVisible(true);
    // }
    // });
    // }
}
