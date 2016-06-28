package com.bailiangjin.javaawtlib;

import com.bailiangjin.javaawtlib.callback.FilePathCallback;
import com.bailiangjin.javaawtlib.swing.FileChooser;

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
