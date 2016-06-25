package com.kevin.javaawtlib.awt;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 
 *
 */

import com.kevin.javaawtlib.callback.FilePathCallback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 *  文件选择窗口控件
 * @author bailiangjin
 *
 */
public class FileChooseBtn extends JButton implements ActionListener {
	private FilePathCallback  filePathCallback;

	public FileChooseBtn(String btnName, FilePathCallback filePathCallback) {
		super(btnName);
		this.setBounds(400, 200, 300, 200);
		this.setVisible(true);
		this.addActionListener(this);
		this.filePathCallback=filePathCallback;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfc.showDialog(new JLabel(), this.getName());
		File file = jfc.getSelectedFile();
		if (file.isDirectory()) {
			System.out.println("文件夹:" + file.getAbsolutePath());
			filePathCallback.onFileSelected(file.getAbsolutePath());
		} else if (file.isFile()) {
			System.out.println("文件:" + file.getAbsolutePath());
			filePathCallback.onFileSelected(file.getAbsolutePath());
		}
		System.out.println(jfc.getSelectedFile().getName());

	}

}
