package com.mayab.desarrollo.main;

import com.mayab.desarrollo.vistas.*;
import javax.swing.*;

public class TestView {
    public static void main(String[] args) {
        try{

            LoginForm form = new LoginForm();
            form.setSize(300,100);
            form.setVisible(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
}
