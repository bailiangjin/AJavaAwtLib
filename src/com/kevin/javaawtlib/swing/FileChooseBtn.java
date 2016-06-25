package com.kevin.javaawtlib.swing;
/**
 * @author 白良锦 bailiangjin@gmail.com
 * @version
 */

import com.kevin.javaawtlib.callback.FilePathCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 文件选择文件按钮
 *
 * @author bailiangjin
 */
public class FileChooseBtn extends JButton implements ActionListener {

    /**
     * 默认值
     */
    public static final String UN_CHOSE_DEFAULT_VALUE = "未选择文件或路径 请重新选择";

    private FilePathCallback filePathCallback;
    private String filePath;


    public FileChooseBtn(String btnName, FilePathCallback filePathCallback) {
        super(btnName);
        this.setSize(300, 200);
        this.setVisible(true);
        this.addActionListener(this);
        this.filePathCallback = filePathCallback;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnValue = fileChooser.showDialog(new JLabel(), this.getName());
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null && !file.exists()) {
                System.out.println("未选择");
                filePathCallback.onFileSelected(UN_CHOSE_DEFAULT_VALUE);
                return;
            }
            if (file.isDirectory()) {
                System.out.println("文件夹:" + file.getAbsolutePath());
                filePathCallback.onFileSelected(file.getAbsolutePath());
            } else if (file.isFile()) {
                System.out.println("文件:" + file.getAbsolutePath());
                filePathCallback.onFileSelected(file.getAbsolutePath());
            }
        }else{
            filePathCallback.onFileSelected(UN_CHOSE_DEFAULT_VALUE);
        }

    }

    public boolean isDefaultValue() {
        return UN_CHOSE_DEFAULT_VALUE.equals(filePath);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
