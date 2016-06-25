package com.kevin.javaawtlib.awt.signapk;

import com.kevin.javaawtlib.awt.FileChooseBtn;
import com.kevin.javaawtlib.awt.DefaultValueJTextField;
import com.kevin.javaawtlib.callback.FilePathCallback;
import com.kevin.javabaselib.utils.StringUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SignApkMain extends JFrame {


    public static void constructGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 200, 450, 200);
        frame.setTitle("Android Apk签名工具——by bailiangjin");
        frame.setLayout(new GridLayout(6, 2));

        List<DefaultValueJTextField> list =new ArrayList<>();

        DefaultValueJTextField textField_unSignApk = new DefaultValueJTextField("未签名Apk文件路径", 1000);
        DefaultValueJTextField textField_keyStore = new DefaultValueJTextField("签名key路径", 1000);
        DefaultValueJTextField textField_signed = new DefaultValueJTextField("签名后Apk输出路径", 1000);
        FileChooseBtn btn1 = new FileChooseBtn("点击选择未签名Apk文件", new FilePathCallback() {
            @Override
            public void onFileSelected(String filePath) {
                System.out.println("未签名Apk文件:" + filePath);
                textField_unSignApk.setText(filePath);
            }
        });
        FileChooseBtn btn2 = new FileChooseBtn("点击选择签名文件", new FilePathCallback() {
            @Override
            public void onFileSelected(String filePath) {
                System.out.println("签名文件:" + filePath);
                textField_keyStore.setText(filePath);
            }
        });
        FileChooseBtn btn3 = new FileChooseBtn("点击选择签名后Apk输出路径", new FilePathCallback() {
            @Override
            public void onFileSelected(String filePath) {
                System.out.println("签名后Apk输出路径:" + filePath);
                textField_signed.setText(filePath);
            }
        });

        JLabel label1 = new JLabel("Alias:", SwingConstants.CENTER);
        JLabel label2 = new JLabel("password:", SwingConstants.CENTER);
        DefaultValueJTextField userNameField = new DefaultValueJTextField("请输入Alias",1000);
        JPasswordField passwordField = new JPasswordField();

        JButton btn_cancel = new JButton("取消") ;
        JButton btn_sign = new JButton("执行签名") ;

        ActionListener actionListener= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btn_cancel) {
                    System.exit(0);
                }
                if (e.getSource() == btn_sign) {

                    boolean isComplete=true;
                    StringBuffer sb =new StringBuffer();
                    sb.append("<html><body>");
                    for (DefaultValueJTextField field:list) {
                        if(field.isDefaultValue()){
                            String line = field.getDefaultValue()+":未设置值"+"<br>";
                            sb.append(line);
                            isComplete=false;
                        }
                    }

                    if (StringUtils.isEmpty(passwordField.getText())){
                        sb.append("密码:未设置");
                        isComplete=false;
                    }

                    sb.append("</body></html>");

                    if (!isComplete){
                        JDialog dialog = new JDialog(frame, "提示");
                        dialog.setBounds(100,100,200,200);
                        JLabel labelContent = new JLabel("Alias:", SwingConstants.CENTER);
                        labelContent.setText(sb.toString());
                        dialog.add(labelContent);
                        JButton jbtn= new JButton("确定");
                        jbtn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dialog.hide();
                            }
                        });

                        JPanel pan=new JPanel();
                        pan.setLayout(new FlowLayout());

                        pan.add(labelContent);
                        pan.add(jbtn);
                        dialog.add(pan);
                        dialog.show();
                    }else {
                        //TODO:执行签名

                    }

                }
            }
        };
        list.add(textField_unSignApk);
        list.add(textField_keyStore);
        list.add(textField_signed);
        list.add(userNameField);

        btn_cancel.addActionListener(actionListener);
        btn_sign.addActionListener(actionListener);

        frame.add(textField_unSignApk);
        frame.add(btn1);
        frame.add(textField_keyStore);
        frame.add(btn2);
        frame.add(textField_signed);
        frame.add(btn3);
        frame.add(label1);
        frame.add(userNameField);
        frame.add(label2);
        frame.add(passwordField);
        frame.add(btn_cancel);
        frame.add(btn_sign);
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
