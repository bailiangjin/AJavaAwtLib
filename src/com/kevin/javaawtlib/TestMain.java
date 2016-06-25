package com.kevin.javaawtlib;

import com.kevin.javaawtlib.swing.FileChooser;
import com.kevin.javaawtlib.callback.FilePathCallback;

public class TestMain {
	


	public static void main(String[] args) {
		new FileChooser("选择文件", new FilePathCallback() {
			
			@Override
			public void onFileSelected(String filePath) {
				System.out.println("文件路径:"+filePath );
				System.exit(0);
				
			}
		});

	}

}
