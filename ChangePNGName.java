package com.file;

import java.io.File;

/**
 * <p>Description:  批量修改本地文件名 </p>
 * Created by slack on 2016/8/24 17:06 .
 */
public class ChangePNGName {
    public static void main(String[] args) {
        scanFile("png","D:\\android\\wu_ta_app\\prebuilt_core\\icon\\lvjing\\");
    }

    private static void scanFile(String type, String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (!f.isDirectory()) {
                    if (isType(type, f.getName())) {
                        // do something...     style_0.png
                        f.renameTo(new File(path+
                                f.getName().substring(0,f.getName().indexOf("."))+"_20160816.png"));
//                        System.out.println(f.getAbsolutePath()+ ":"+ f.getName()
//                                + "," + f.getAbsolutePath().substring(0,f.getAbsolutePath().lastIndexOf("."))
//                        + "," + f.getName().substring(0,f.getName().indexOf(".")) );
                    }
                } else {
                    scanFile(type, path + File.separator + f.getName());
                }
            }
        }
    }

    private static boolean isType(String type, String name) {
        if (type == null || name == null) {
            return false;
        }
        if (name.length() > (type.length() + 1)) {
            if (type.equals(name.substring(name.lastIndexOf(".") + 1))) {
                return true;
            }
        }
        return false;
    }
}
