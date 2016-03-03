package com.kevin.javaawtlib;

import com.kevin.javaawtlib.awt.FileChooser;
import com.kevin.javaawtlib.callback.FilePathCallback;

public class TestMain {
	
	
	/**
	 * 壳dex文件路径
	 */
	public static String srcDexFilePath = "";
	/**
	 * 需加壳apk文件路径
	 */
	public static String srcApkFilePath = "";
	/**
	 * 加壳后的dex文件输出路径
	 */
	public static String outFileDir = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileChooser("选择文件", new FilePathCallback() {
			
			@Override
			public void onFileSelected(String filePath) {
				// TODO Auto-generated method stub
				System.out.println("输出文件路径:"+filePath );
				
				System.exit(0);
				
			}
		});

	}

}
