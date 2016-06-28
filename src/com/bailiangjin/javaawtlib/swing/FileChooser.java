package com.bailiangjin.javaawtlib.swing;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.bailiangjin.javaawtlib.callback.FilePathCallback;

/**
 *  文件选择窗口控件
 * @author bailiangjin
 *
 */
public class FileChooser extends JFrame implements ActionListener {
	private JButton open = null;
	private FilePathCallback filePathCallback;
	private String btnName="";

	public FileChooser(String btnName, FilePathCallback filePathCallback) {
		this.btnName=btnName;
		open = new JButton(btnName);
		this.add(open);
		this.setBounds(400, 200, 300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		open.addActionListener(this);
		this.filePathCallback=filePathCallback;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnValue = jfc.showDialog(new JLabel(), this.btnName);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
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

}
