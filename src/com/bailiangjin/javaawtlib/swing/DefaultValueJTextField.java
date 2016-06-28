package com.bailiangjin.javaawtlib.swing;


import com.bailiangjin.javabaselib.utils.StringUtils;

import javax.swing.*;

/**
 * 有默认值的 JTextField 初始化时传入默认值
 * Created by bailiangjin on 16/6/25.
 */
public class DefaultValueJTextField extends JTextField {

    private String defaultValue;


    public DefaultValueJTextField(String text, int columns) {
        super(text, columns);
        this.defaultValue = text;
    }

    public boolean isDefaultValue() {
        if (StringUtils.isEmpty(defaultValue)) {
            return StringUtils.isEmpty(getText());
        }
        return defaultValue.equals(getText());
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
