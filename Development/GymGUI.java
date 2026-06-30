import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class GymGUI {
    // ArrayList to store GymMember objects
    ArrayList<GymMember> memberList = new ArrayList<GymMember>();
    ArrayList<Integer> idList = new ArrayList<Integer>();

    // Main method to display the GUI
    public void display() {
        // Create main frame
        JFrame jf = new JFrame("Gym Management System");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1200, 800);
        jf.setLayout(null);
        jf.getContentPane().setBackground(new Color(210, 186, 163));

        // Adding main heading
        JLabel heading = new JLabel("Gym Management System");
        heading.setBounds(370, 15, 700, 70);
        Font headingFont = new Font("Arial", Font.BOLD, 40);
        Color titleColor = new Color(23, 5, 81);
        heading.setForeground(titleColor);
        heading.setFont(headingFont);
        jf.add(heading);

        // Regular Member Button
        JButton regularBtn = new JButton("Regular Member");
        regularBtn.setBounds(270, 270, 300, 200);
        Font btnFont = new Font("Arial", Font.PLAIN, 25);
        regularBtn.setFont(btnFont);
        regularBtn.setForeground(new Color(26, 36, 33));
        regularBtn.setBackground(new Color(245, 245, 220));
        regularBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                regularMemberGUI();
            }
        });
        jf.add(regularBtn);

        // Premium Member Button
        JButton premiumBtn = new JButton("Premium Member");
        premiumBtn.setBounds(620, 270, 300, 200);
        premiumBtn.setFont(btnFont);
        premiumBtn.setForeground(new Color(26, 36, 33));
        premiumBtn.setBackground(new Color(245, 245, 220));
        premiumBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                premiumMemberGUI();
            }
        });
        jf.add(premiumBtn);

        jf.setVisible(true);
    }

    // Regular Member GUI
    public void regularMemberGUI() {
        JFrame regularFrame = new JFrame("Regular Member Management");
        regularFrame.setLayout(null);
        regularFrame.setSize(1200, 800);
        Color frameColor = new Color(210, 186, 163);
        regularFrame.getContentPane().setBackground(frameColor);

        // Heading
        JLabel heading = new JLabel("REGULAR MEMBER");
        heading.setBounds(400, 10, 500, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        regularFrame.add(heading);

        // Member Info Panel - Left
        JPanel memberInfoPanel = new JPanel();
        memberInfoPanel.setBounds(80, 80, 500, 300);
        memberInfoPanel.setLayout(null);
        memberInfoPanel.setBackground(new Color(245, 245, 220));

        // Labels and text fields for regular member
        addFormField(memberInfoPanel, "Member ID:", 30, 30, 150, 30);
        JTextField idField = new JTextField();
        idField.setBounds(190, 30, 230, 30);
        memberInfoPanel.add(idField);

        addFormField(memberInfoPanel, "Name:", 30, 70, 150, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(190, 70, 230, 30);
        memberInfoPanel.add(nameField);

        addFormField(memberInfoPanel, "Location:", 30, 110, 150, 30);
        JTextField locationField = new JTextField();
        locationField.setBounds(190, 110, 230, 30);
        memberInfoPanel.add(locationField);

        addFormField(memberInfoPanel, "Phone:", 30, 150, 150, 30);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(190, 150, 230, 30);
        memberInfoPanel.add(phoneField);

        addFormField(memberInfoPanel, "Email:", 30, 190, 150, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(190, 190, 230, 30);
        memberInfoPanel.add(emailField);

        addFormField(memberInfoPanel, "Referral Source:", 30, 230, 150, 30);
        JTextField referralField = new JTextField();
        referralField.setBounds(190, 230, 230, 30);
        memberInfoPanel.add(referralField);

        // Additional info panel - Right
        JPanel additionalInfoPanel = new JPanel();
        additionalInfoPanel.setBounds(620, 80, 500, 300);
        additionalInfoPanel.setLayout(null);
        additionalInfoPanel.setBackground(new Color(245, 245, 220));

        // Gender selection
        addFormField(additionalInfoPanel, "Gender:", 30, 30, 150, 30);
        JRadioButton maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(190, 30, 100, 30);
        maleRadio.setBackground(new Color(245, 245, 220));
        JRadioButton femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(300, 30, 100, 30);
        femaleRadio.setBackground(new Color(245, 245, 220));
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        maleRadio.setSelected(true);
        additionalInfoPanel.add(maleRadio);
        additionalInfoPanel.add(femaleRadio);

        // Date of Birth combo boxes
        addFormField(additionalInfoPanel, "Date of Birth:", 30, 70, 150, 30);
        // Day combo box
        JComboBox<String> dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }
        dayComboBox.setBounds(190, 70, 60, 30);
        additionalInfoPanel.add(dayComboBox);

        // Month combo box
        JComboBox<String> monthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                                                                      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        monthComboBox.setBounds(260, 70, 70, 30);
        additionalInfoPanel.add(monthComboBox);

        // Year combo box
        JComboBox<String> yearComboBox = new JComboBox<>();
        for (int i = 1995; i <= 2025; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
        yearComboBox.setBounds(340, 70, 80, 30);
        additionalInfoPanel.add(yearComboBox);

        // Start Date combo boxes
        addFormField(additionalInfoPanel, "Start Date:", 30, 110, 150, 30);
        // Day combo box
        JComboBox<String> startDayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            startDayComboBox.addItem(String.valueOf(i));
        }
        startDayComboBox.setBounds(190, 110, 60, 30);
        additionalInfoPanel.add(startDayComboBox);

        // Month combo box
        JComboBox<String> startMonthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                                                                           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        startMonthComboBox.setBounds(260, 110, 70, 30);
        additionalInfoPanel.add(startMonthComboBox);

        // Year combo box
        JComboBox<String> startYearComboBox = new JComboBox<>();
        for (int i = 1995; i <= 2025; i++) {
            startYearComboBox.addItem(String.valueOf(i));
        }
        startYearComboBox.setBounds(340, 110, 80, 30);
        additionalInfoPanel.add(startYearComboBox);

        addFormField(additionalInfoPanel, "Membership Plan:", 30, 150, 150, 30);
        String[] plans = {"Basic", "Standard", "Deluxe"};
        JComboBox<String> planComboBox = new JComboBox<>(plans);
        planComboBox.setBounds(190, 150, 230, 30);
        additionalInfoPanel.add(planComboBox);

        // Plan Price (non-editable)
        addFormField(additionalInfoPanel, "Plan Price:", 30, 190, 150, 30);
        JTextField priceField = new JTextField("6500");
        priceField.setBounds(190, 190, 230, 30);
        priceField.setEditable(false);
        additionalInfoPanel.add(priceField);

        // Update price when plan changes
        planComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPlan = (String) planComboBox.getSelectedItem();
                if (selectedPlan.equals("Basic")) {
                    priceField.setText("6500");
                } else if (selectedPlan.equals("Standard")) {
                    priceField.setText("12500");
                } else if (selectedPlan.equals("Deluxe")) {
                    priceField.setText("18500");
                }
            }
        });

        // Operations panel
        JPanel operationsPanel = new JPanel();
        operationsPanel.setBounds(80, 400, 1040, 120);
        operationsPanel.setLayout(null);
        operationsPanel.setBackground(new Color(245, 245, 220));

        // Add member button
        JButton addButton = new JButton("Add Regular Member");
        addButton.setBounds(20, 40, 200, 40);
        addButton.setBackground(new Color(210, 180, 140));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (idField.getText().isEmpty() || nameField.getText().isEmpty() || locationField.getText().isEmpty() || 
                    phoneField.getText().isEmpty() || emailField.getText().isEmpty() || referralField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(addButton, "Please fill all required fields");
                } else {
                    try {
                        int memberId = Integer.parseInt(idField.getText());
                        if (idList.contains(memberId)) {
                            JOptionPane.showMessageDialog(addButton, "Member ID already exists");
                            return;
                        }
                        
                        String name = nameField.getText();
                        String location = locationField.getText();
                        String phone = phoneField.getText();
                        String email = emailField.getText();
                        String gender = maleRadio.isSelected() ? "Male" : "Female";
                        // Construct date strings from combo boxes
                        String dob = dayComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + yearComboBox.getSelectedItem();
                        String startDate = startDayComboBox.getSelectedItem() + "-" + startMonthComboBox.getSelectedItem() + "-" + startYearComboBox.getSelectedItem();
                        String referralSource = referralField.getText();
                        String plan = (String) planComboBox.getSelectedItem();
                        double price = Double.parseDouble(priceField.getText());
                        
                        RegularMember member = new RegularMember(memberId, name, location, phone, email, gender, 
                                                                dob, startDate, referralSource, price);// Upcasting to GymMember
                        memberList.add(member);
                        idList.add(memberId);
                        
                        JOptionPane.showMessageDialog(addButton, "Regular Member Added Successfully");
                        
                        // Clear fields
                        clearFields(idField, nameField, locationField, phoneField, emailField, referralField);
                        planComboBox.setSelectedIndex(0);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                    }
                }
            }
        });
        operationsPanel.add(addButton);

        // Display button
        JButton displayButton = new JButton("Display");
        displayButton.setBounds(240, 40, 150, 40);
        displayButton.setBackground(new Color(210, 180, 140));
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean found = false;
                for (GymMember member : memberList) {
                    if (member instanceof RegularMember) {
                        member.display();
                        found = true;
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(null, "Regular member details displayed in console");
                } else {
                    JOptionPane.showMessageDialog(null, "No regular members found");
                }
            }
        });
        operationsPanel.add(displayButton);

        // Clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(410, 40, 150, 40);
        clearButton.setBackground(new Color(210, 180, 140));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                clearFields(idField, nameField, locationField, phoneField, emailField, referralField);
                planComboBox.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "All fields cleared");
            }
        });
        operationsPanel.add(clearButton);

        // Member operations panel
        JPanel memberOperationsPanel = new JPanel();
        memberOperationsPanel.setBounds(80, 540, 1040, 200);
        memberOperationsPanel.setLayout(null);
        memberOperationsPanel.setBackground(new Color(245, 245, 220));

        // Member ID for operations
        addFormField(memberOperationsPanel, "Member ID:", 20, 30, 100, 30);
        JTextField opIdField = new JTextField();
        opIdField.setBounds(130, 30, 150, 30);
        memberOperationsPanel.add(opIdField);

        // Activate membership button
        JButton activateButton = new JButton("Activate Membership");
        activateButton.setBounds(20, 80, 180, 40);
        activateButton.setBackground(new Color(210, 180, 140));
        activateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(activateButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(activateButton, "Member not found");
                        return;
                    }
                    
                    member.activateMembership();
                    JOptionPane.showMessageDialog(activateButton, "Membership activated successfully");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(activateButton);

        // Deactivate membership button
        JButton deactivateButton = new JButton("Deactivate Membership");
        deactivateButton.setBounds(210, 80, 180, 40);
        deactivateButton.setBackground(new Color(210, 180, 140));
        deactivateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(deactivateButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(deactivateButton, "Member not found");
                        return;
                    }
                    
                    member.deactivateMembership();
                    JOptionPane.showMessageDialog(deactivateButton, "Membership deactivated successfully");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(deactivateButton);

        // Mark attendance button
        JButton attendanceButton = new JButton("Mark Attendance");
        attendanceButton.setBounds(400, 80, 180, 40);
        attendanceButton.setBackground(new Color(210, 180, 140));
        attendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(attendanceButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(attendanceButton, "Member not found");
                        return;
                    }
                    
                    if (!member.isActiveStatus()) {
                        JOptionPane.showMessageDialog(attendanceButton, "Member is not active. Please activate first.");
                        return;
                    }
                    
                    member.markAttendance();
                    JOptionPane.showMessageDialog(attendanceButton, "Attendance marked successfully");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(attendanceButton);

        // Upgrade plan section
        addFormField(memberOperationsPanel, "New Plan:", 300, 30, 100, 30);
        JComboBox<String> upgradeComboBox = new JComboBox<>(plans);
        upgradeComboBox.setBounds(400, 30, 150, 30);
        memberOperationsPanel.add(upgradeComboBox);

        // Upgrade button
        JButton upgradeButton = new JButton("Upgrade Plan");
        upgradeButton.setBounds(590, 80, 180, 40);
        upgradeButton.setBackground(new Color(210, 180, 140));
        upgradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(upgradeButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(upgradeButton, "Member not found");
                        return;
                    }
                    
                    if (!(member instanceof RegularMember)) {
                        JOptionPane.showMessageDialog(upgradeButton, "Only Regular Members can upgrade plans");
                        return;
                    }
                    
                    RegularMember regMember = (RegularMember) member;//Downcasting GymMember to RegularMember
                    String newPlan = (String) upgradeComboBox.getSelectedItem();
                    String result = regMember.upgradePlan(newPlan);
                    JOptionPane.showMessageDialog(upgradeButton, result);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(upgradeButton);

        // Revert Member button
        JButton revertButton = new JButton("Revert Member");
        revertButton.setBounds(780, 80, 180, 40);
        revertButton.setBackground(new Color(210, 180, 140));
        revertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(revertButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(revertButton, "Member not found");
                        return;
                    }
                    
                    if (!(member instanceof RegularMember)) {
                        JOptionPane.showMessageDialog(revertButton, "Not a Regular Member");
                        return;
                    }
                    
                    RegularMember regMember = (RegularMember) member;
                    regMember.revertRegularMember("Member reverted via UI");
                    JOptionPane.showMessageDialog(revertButton, "Member reverted successfully");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(revertButton);

        // Back button to go to Premium Member GUI
        JButton premiumButton = new JButton("Switch to Premium Member");
        premiumButton.setBounds(800, 140, 220, 40);
        premiumButton.setBackground(new Color(210, 180, 140));
        premiumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regularFrame.dispose();
                premiumMemberGUI();
            }
        });
        memberOperationsPanel.add(premiumButton);

        // Add panels to frame
        regularFrame.add(heading);
        regularFrame.add(memberInfoPanel);
        regularFrame.add(additionalInfoPanel);
        regularFrame.add(operationsPanel);
        regularFrame.add(memberOperationsPanel);
        regularFrame.setVisible(true);
    }

    // Premium Member GUI
    public void premiumMemberGUI() {
        JFrame premiumFrame = new JFrame("Premium Member Management");
        premiumFrame.setLayout(null);
        premiumFrame.setSize(1200, 800);
        Color frameColor = new Color(210, 186, 163);
        premiumFrame.getContentPane().setBackground(frameColor);

        // Heading
        JLabel heading = new JLabel("PREMIUM MEMBER");
        heading.setBounds(400, 10, 500, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        premiumFrame.add(heading);

        // Member Info Panel - Left
        JPanel memberInfoPanel = new JPanel();
        memberInfoPanel.setBounds(80, 80, 500, 300);
        memberInfoPanel.setLayout(null);
        memberInfoPanel.setBackground(new Color(245, 245, 220));

        // Labels and text fields for premium member
        addFormField(memberInfoPanel, "Member ID:", 30, 30, 150, 30);
        JTextField idField = new JTextField();
        idField.setBounds(190, 30, 230, 30);
        memberInfoPanel.add(idField);

        addFormField(memberInfoPanel, "Name:", 30, 70, 150, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(190, 70, 230, 30);
        memberInfoPanel.add(nameField);

        addFormField(memberInfoPanel, "Location:", 30, 110, 150, 30);
        JTextField locationField = new JTextField();
        locationField.setBounds(190, 110, 230, 30);
        memberInfoPanel.add(locationField);

        addFormField(memberInfoPanel, "Phone:", 30, 150, 150, 30);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(190, 150, 230, 30);
        memberInfoPanel.add(phoneField);

        addFormField(memberInfoPanel, "Email:", 30, 190, 150, 30);
        JTextField emailField = new JTextField();
        emailField.setBounds(190, 190, 230, 30);
        memberInfoPanel.add(emailField);

        addFormField(memberInfoPanel, "Trainer:", 30, 230, 150, 30);
        JTextField trainerField = new JTextField();
        trainerField.setBounds(190, 230, 230, 30);
        memberInfoPanel.add(trainerField);

        // Additional info panel - Right
        JPanel additionalInfoPanel = new JPanel();
        additionalInfoPanel.setBounds(620, 80, 500, 300);
        additionalInfoPanel.setLayout(null);
        additionalInfoPanel.setBackground(new Color(245, 245, 220));

        // Gender selection
        addFormField(additionalInfoPanel, "Gender:", 30, 30, 150, 30);
        JRadioButton maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(190, 30, 100, 30);
        maleRadio.setBackground(new Color(245, 245, 220));
        JRadioButton femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(300, 30, 100, 30);
        femaleRadio.setBackground(new Color(245, 245, 220));
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        maleRadio.setSelected(true);
        additionalInfoPanel.add(maleRadio);
        additionalInfoPanel.add(femaleRadio);

        // Date of Birth combo boxes
        addFormField(additionalInfoPanel, "Date of Birth:", 30, 70, 150, 30);
        // Day combo box
        JComboBox<String> dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(String.valueOf(i));
        }
        dayComboBox.setBounds(190, 70, 60, 30);
        additionalInfoPanel.add(dayComboBox);

        // Month combo box
        JComboBox<String> monthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                                                                      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        monthComboBox.setBounds(260, 70, 70, 30);
        additionalInfoPanel.add(monthComboBox);

        // Year combo box
        JComboBox<String> yearComboBox = new JComboBox<>();
        for (int i = 1995; i <= 2025; i++) {
            yearComboBox.addItem(String.valueOf(i));
        }
        yearComboBox.setBounds(340, 70, 80, 30);
        additionalInfoPanel.add(yearComboBox);

        // Start Date combo boxes
        addFormField(additionalInfoPanel, "Start Date:", 30, 110, 150, 30);
        // Day combo box
        JComboBox<String> startDayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            startDayComboBox.addItem(String.valueOf(i));
        }
        startDayComboBox.setBounds(190, 110, 60, 30);
        additionalInfoPanel.add(startDayComboBox);

        // Month combo box
        JComboBox<String> startMonthComboBox = new JComboBox<>(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                                                                           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        startMonthComboBox.setBounds(260, 110, 70, 30);
        additionalInfoPanel.add(startMonthComboBox);

        // Year combo box
        JComboBox<String> startYearComboBox = new JComboBox<>();
        for (int i = 1995; i <= 2025; i++) {
            startYearComboBox.addItem(String.valueOf(i));
        }
        startYearComboBox.setBounds(340, 110, 80, 30);
        additionalInfoPanel.add(startYearComboBox);

        // Premium charge (non-editable)
        addFormField(additionalInfoPanel, "Premium Charge:", 30, 150, 150, 30);
        JTextField chargeField = new JTextField("50000");
        chargeField.setBounds(190, 150, 230, 30);
        chargeField.setEditable(false);
        additionalInfoPanel.add(chargeField);

        // Operations panel
        JPanel operationsPanel = new JPanel();
        operationsPanel.setBounds(80, 400, 1040, 120);
        operationsPanel.setLayout(null);
        operationsPanel.setBackground(new Color(245, 245, 220));

        // Add member button
        JButton addButton = new JButton("Add Premium Member");
        addButton.setBounds(20, 40, 200, 40);
        addButton.setBackground(new Color(210, 180, 140));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (idField.getText().isEmpty() || nameField.getText().isEmpty() || locationField.getText().isEmpty() || 
                    phoneField.getText().isEmpty() || emailField.getText().isEmpty() || trainerField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(addButton, "Please fill all required fields");
                } else {
                    try {
                        int memberId = Integer.parseInt(idField.getText());
                        if (idList.contains(memberId)) {
                            JOptionPane.showMessageDialog(addButton, "Member ID already exists");
                            return;
                        }
                        
                        String name = nameField.getText();
                        String location = locationField.getText();
                        String phone = phoneField.getText();
                        String email = emailField.getText();
                        String gender = maleRadio.isSelected() ? "Male" : "Female";
                        // Construct date strings from combo boxes
                        String dob = dayComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + yearComboBox.getSelectedItem();
                        String startDate = startDayComboBox.getSelectedItem() + "-" + startMonthComboBox.getSelectedItem() + "-" + startYearComboBox.getSelectedItem();
                        String trainer = trainerField.getText();
                        
                        PremiumMember member = new PremiumMember(memberId, name, location, phone, email, gender, 
                                                                dob, startDate, trainer);
                        memberList.add(member); // Upcasting (RegularMember/PremiumMember to GymMember)
                        idList.add(memberId);
                        
                        JOptionPane.showMessageDialog(addButton, "Premium Member Added Successfully");
                        
                        // Clear fields
                        clearFields(idField, nameField, locationField, phoneField, emailField, trainerField);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                    }
                }
            }
        });
        operationsPanel.add(addButton);

        // Display button
        JButton displayButton = new JButton("Display");
        displayButton.setBounds(240, 40, 150, 40);
        displayButton.setBackground(new Color(210, 180, 140));
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean found = false;
                for (GymMember member : memberList) {
                    if (member instanceof PremiumMember) {
                        member.display();
                        found = true;
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(null, "Premium member details displayed in console");
                } else {
                    JOptionPane.showMessageDialog(null, "No premium members found");
                }
            }
        });
        operationsPanel.add(displayButton);

        // Clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(410, 40, 150, 40);
        clearButton.setBackground(new Color(210, 180, 140));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                clearFields(idField, nameField, locationField, phoneField, emailField, trainerField);
                JOptionPane.showMessageDialog(null, "All fields cleared");
            }
        });
        operationsPanel.add(clearButton);

        // Member operations panel
        JPanel memberOperationsPanel = new JPanel();
        memberOperationsPanel.setBounds(80, 540, 1040, 200);
        memberOperationsPanel.setLayout(null);
        memberOperationsPanel.setBackground(new Color(245, 245, 220));

        // Member ID for operations
        addFormField(memberOperationsPanel, "Member ID:", 20, 30, 100, 30);
        JTextField opIdField = new JTextField();
        opIdField.setBounds(130, 30, 150, 30);
        memberOperationsPanel.add(opIdField);

        // Activate membership button
        JButton activateButton = new JButton("Activate Membership");
        activateButton.setBounds(20, 80, 180, 40);
        activateButton.setBackground(new Color(210, 180, 140));
        activateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(activateButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(activateButton, "Member not found");
                        return;
                    }
                    
                    member.activateMembership();
                    JOptionPane.showMessageDialog(activateButton, "Membership activated successfully");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(activateButton);

        // Deactivate membership button
        JButton deactivateButton = new JButton("Deactivate Membership");
        deactivateButton.setBounds(210, 80, 180, 40);
        deactivateButton.setBackground(new Color(210, 180, 140));
        deactivateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(deactivateButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(deactivateButton, "Member not found");
                        return;
                    }
                    
                    member.deactivateMembership();
                    JOptionPane.showMessageDialog(deactivateButton, "Membership deactivated successfully");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(deactivateButton);

        // Mark attendance button
        JButton attendanceButton = new JButton("Mark Attendance");
        attendanceButton.setBounds(400, 80, 180, 40);
        attendanceButton.setBackground(new Color(210, 180, 140));
        attendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(attendanceButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(attendanceButton, "Member not found");
                        return;
                    }
                    
                    if (!member.isActiveStatus()) {
                        JOptionPane.showMessageDialog(attendanceButton, "Member is not active. Please activate first.");
                        return;
                    }
                    
                    member.markAttendance();
                    JOptionPane.showMessageDialog(attendanceButton, "Attendance marked successfully");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        }   );
            memberOperationsPanel.add(attendanceButton);

            // Payment section
            addFormField(memberOperationsPanel, "Payment Amount:", 300, 30, 130, 30);
            JTextField paymentField = new JTextField();
            paymentField.setBounds(440, 30, 150, 30);
            memberOperationsPanel.add(paymentField);

            // Pay button
            JButton payButton = new JButton("Pay Amount");
            payButton.setBounds(590, 80, 180, 40);
            payButton.setBackground(new Color(210, 180, 140));
            payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty() || paymentField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(payButton, "Please enter Member ID and Payment Amount");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    double amount = Double.parseDouble(paymentField.getText());
                    
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(payButton, "Member not found");
                        return;
                    }
                    
                    if (!(member instanceof PremiumMember)) {
                        JOptionPane.showMessageDialog(payButton, "Not a Premium Member");
                        return;
                    }
                    
                    PremiumMember premMember = (PremiumMember) member;//Downcasting GymMember to PremiumMember
                    String result = premMember.payDueAmount(amount);
                    JOptionPane.showMessageDialog(payButton, result);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers");
                }
            }
        });
        memberOperationsPanel.add(payButton);

        // Calculate discount button
        JButton discountButton = new JButton("Calculate Discount");
        discountButton.setBounds(780, 80, 180, 40);
        discountButton.setBackground(new Color(210, 180, 140));
        discountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(discountButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(discountButton, "Member not found");
                        return;
                    }
                    
                    if (!(member instanceof PremiumMember)) {
                        JOptionPane.showMessageDialog(discountButton, "Not a Premium Member");
                        return;
                    }
                    
                    PremiumMember premMember = (PremiumMember) member;
                    premMember.calculateDiscount();
                    
                    if (premMember.getIsFullPayment()) {
                        JOptionPane.showMessageDialog(discountButton, "Discount of Rs. " + 
                                                    premMember.getDiscountAmount() + " applied");
                    } else {
                        JOptionPane.showMessageDialog(discountButton, 
                                                    "Discount not available. Full payment not completed.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(discountButton);

        // Revert Member button
        JButton revertButton = new JButton("Revert Member");
        revertButton.setBounds(20, 140, 180, 40);
        revertButton.setBackground(new Color(210, 180, 140));
        revertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (opIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(revertButton, "Please enter Member ID");
                    return;
                }
                
                try {
                    int memberId = Integer.parseInt(opIdField.getText());
                    GymMember member = findMemberById(memberId);
                    
                    if (member == null) {
                        JOptionPane.showMessageDialog(revertButton, "Member not found");
                        return;
                    }
                    
                    if (!(member instanceof PremiumMember)) {
                        JOptionPane.showMessageDialog(revertButton, "Not a Premium Member");
                        return;
                    }
                    
                    PremiumMember premMember = (PremiumMember) member;
                    premMember.revertPremiumMember();
                    JOptionPane.showMessageDialog(revertButton, "Member reverted successfully");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for Member ID");
                }
            }
        });
        memberOperationsPanel.add(revertButton);

        // Save to file button
        JButton saveButton = new JButton("Save to File");
        saveButton.setBounds(210, 140, 180, 40);
        saveButton.setBackground(new Color(210, 180, 140));
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                saveToFile();
            }
        });
        memberOperationsPanel.add(saveButton);

        // Read from file button
        JButton readButton = new JButton("Read from File");
        readButton.setBounds(400, 140, 180, 40);
        readButton.setBackground(new Color(210, 180, 140));
        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                readFromFile();
            }
        });
        memberOperationsPanel.add(readButton);

        // Back button to go to Regular Member GUI
        JButton regularButton = new JButton("Switch to Regular Member");
        regularButton.setBounds(590, 140, 220, 40);
        regularButton.setBackground(new Color(210, 180, 140));
        regularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                premiumFrame.dispose();
                regularMemberGUI();
            }
        });
        memberOperationsPanel.add(regularButton);

        // Add panels to frame
        premiumFrame.add(heading);
        premiumFrame.add(memberInfoPanel);
        premiumFrame.add(additionalInfoPanel);
        premiumFrame.add(operationsPanel);
        premiumFrame.add(memberOperationsPanel);
        premiumFrame.setVisible(true);
    }

    // Helper method to add form fields
    private void addFormField(JPanel panel, String labelText, int x, int y, int width, int height) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(label);
    }

    // Helper method to clear text fields
    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    // Helper method to find a member by ID
    private GymMember findMemberById(int id) {
        for (GymMember member : memberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Save member details to file
    private void saveToFile() {
        try {
            FileWriter writer = new FileWriter("MemberDetails.txt");
            
            // Write header
            writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n", 
                         "ID", "Name", "Location", "Phone", "Email", "Membership Start Date", "Plan", "Price", 
                         "Attendance", "Loyalty Points", "Active Status", "Full Payment", "Discount Amount", "Net Amount Paid"));
            
            // Write member details
            for (GymMember member : memberList) {
                if (member instanceof RegularMember) {
                    RegularMember regMember = (RegularMember) member;
                    writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15s %-15s\n", 
                                regMember.getId(), regMember.getName(), regMember.getLocation(), regMember.getPhone(), 
                                regMember.getEmail(), regMember.getMembershipStartDate(), regMember.getPlan(), 
                                regMember.getPrice(), regMember.getAttendance(), regMember.getLoyaltyPoints(), 
                                regMember.isActiveStatus() ? "true" : "false", "NA", "NA", "NA"));
                } else if (member instanceof PremiumMember) {
                    PremiumMember premMember = (PremiumMember) member;
                    writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15.2f %-15.2f\n", 
                                premMember.getId(), premMember.getName(), premMember.getLocation(), premMember.getPhone(), 
                                premMember.getEmail(), premMember.getMembershipStartDate(), "Premium", 
                                premMember.getPremiumCharge(), premMember.getAttendance(), premMember.getLoyaltyPoints(), 
                                premMember.isActiveStatus() ? "true" : "false", premMember.getIsFullPayment() ? "true" : "false", 
                                premMember.getDiscountAmount(), premMember.getPaidAmount()));
                }
            }
            
            writer.close();
            JOptionPane.showMessageDialog(null, "Member details saved to MemberDetails.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving to file: " + e.getMessage());
        }
    }

    // Read member details from file
    private void readFromFile() {
        try {
            FileReader reader = new FileReader("MemberDetails.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            // Create a frame to display file contents
            JFrame fileFrame = new JFrame("Member Details");
            fileFrame.setSize(1200, 600);
            fileFrame.setLayout(new BorderLayout());
            
            // Create a text area to display the file contents
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JScrollPane scrollPane = new JScrollPane(textArea);
            fileFrame.add(scrollPane, BorderLayout.CENTER);
            
            // Read and display file contents
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            
            textArea.setText(content.toString());
            
            bufferedReader.close();
            reader.close();
            fileFrame.setVisible(true);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found: MemberDetails.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        GymGUI gymGUI = new GymGUI();
        gymGUI.display();
    }
}