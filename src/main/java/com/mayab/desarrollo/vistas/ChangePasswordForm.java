package com.mayab.desarrollo.vistas;

import com.mayab.desarrollo.persistencia.DAOUsers;
import com.mayab.desarrollo.services.UServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordForm  extends  JFrame implements ActionListener{

    //initialize button, panel, label, and text field
    JButton b1, b2;
    JPanel newPanel;
    JLabel userLabel, oldPassLabel, newPassLabel;
    final JTextField  textField1, textField2, textField3;

    public ChangePasswordForm() throws HeadlessException {
        //public
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Password");
        setSize(300,100);

        //create label for username
        userLabel = new JLabel();
        userLabel.setText("Username");      //set label value for textField1

        //create text field to get username from the user
        textField1 = new JTextField(15);    //set length of the text

        //create label for old password
        oldPassLabel = new JLabel();
        oldPassLabel.setText("Old Password");      //set label value for textField2

        //create text field to get password from the user
        textField2 = new JPasswordField(15);    //set length for the password

        //create label for new password
        newPassLabel = new JLabel();
        newPassLabel.setText("New Password");      //set label value for textField2

        //create text field to get password from the user
        textField3 = new JPasswordField(15);    //set length for the password


        //create submit button
        b1 = new JButton("SUBMIT"); //set label to button

        //create change password button
        b2 = new JButton("CANCEL");

        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);    //set username label to panel
        newPanel.add(textField1);   //set text field to panel
        newPanel.add(oldPassLabel);    //set old password label to panel
        newPanel.add(textField2);   //set text field to panel
        newPanel.add(newPassLabel);    //set new password label to panel
        newPanel.add(textField3);   //set text field to panel

        newPanel.add(b1);           //set submit button to panel
        newPanel.add(b2);           //set cancel button to panel

        //set border to panel
        add(newPanel, BorderLayout.CENTER);

        //perform action on button click
        b1.addActionListener(this);     //add action listener to button
        b2.addActionListener(e -> cancelChanges());
        setTitle("CHANGE PASSWORD FORM");         //set title to the login form
    }


    public void cancelChanges(){
        this.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String userValue = textField1.getText();        //get user entered username from the textField1
        String oldPassValue = textField2.getText();        //get user old entered pasword from the textField2
        String newPassValue = textField3.getText();        //get user new password

        DAOUsers dao = new DAOUsers();
        UServices service = new UServices(dao);


        //check whether the credentials are authentic or not
        if (service.changePassword(userValue, oldPassValue, newPassValue)) {  //if authentic, navigate user to a new page

            //create instance of the NewPage
            NewPage page = new NewPage();

            //make page visible to the user
            page.setVisible(true);

            //create a welcome label and set it to the new page
            JLabel wel_label = new JLabel("Your password change has been successful: "+userValue);
            page.getContentPane().add(wel_label);
        }
        else{
            //show error message
            System.out.println("Please enter valid username and password");
        }
    }
}

