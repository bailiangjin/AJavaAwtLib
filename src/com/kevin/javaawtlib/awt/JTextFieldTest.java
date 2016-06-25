package com.kevin.javaawtlib.awt;

import com.kevin.javaawtlib.callback.FilePathCallback;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;import javax.swing.*;

public class JTextFieldTest extends JFrame {


    public static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 200, 600, 400);
        frame.setTitle("JTextField Test");
        frame.setLayout(new GridLayout(5, 2));
        JTextField textField_unsign = new JTextField("请选择输入文件路径", 1000);
        JTextField textField_signed = new JTextField("请选择输出文件路径", 1000);
        FileChooseBtn btn1 = new FileChooseBtn("选择初始文件", new FilePathCallback() {
            @Override
            public void onFileSelected(String filePath) {
                System.out.println("srcFilePath:" + filePath);
                textField_unsign.setText(filePath);
            }
        });
        FileChooseBtn btn2 = new FileChooseBtn("选择输出文件", new FilePathCallback() {
            @Override
            public void onFileSelected(String filePath) {
                System.out.println("srcFilePath:" + filePath);
                textField_signed.setText(filePath);
            }
        });

        JLabel label1 = new JLabel("Alias:", SwingConstants.RIGHT);
        JLabel label2 = new JLabel("password:", SwingConstants.RIGHT);
        JTextField userNameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField();

        JButton btn_cancel = new JButton("取消") ;
        JButton btn_sign = new JButton("签名") ;

        ActionListener actionListener= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn_cancel) {
                    System.exit(0);
                }
                if (e.getSource() == btn_sign) {
                    JDialog dialog = new JDialog(frame, "签名");
                    dialog.setBounds(600,600,200,100);
                    dialog.show();
                }
            }
        };

        btn_cancel.addActionListener(actionListener);
        btn_sign.addActionListener(actionListener);

        frame.add(textField_unsign);
        frame.add(btn1);
        frame.add(textField_signed);
        frame.add(btn2);
        frame.add(label1);
        frame.add(userNameField);
        frame.add(label2);
        frame.add(passwordField);
        frame.add(btn_cancel);
        frame.add(btn_sign);
//        frame.setSize(200, 70);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }

}
