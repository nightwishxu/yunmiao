package com.util.video;


import com.base.CoreConstants;

import java.io.*;

public class MyFFMPEGLocator extends FFMPEGLocator {
    private static final int myEXEversion = 1;
    private String path;

    public MyFFMPEGLocator() {
        String os = System.getProperty("os.name").toLowerCase();
        boolean isWindows;
        if (os.indexOf("windows") != -1) {
            isWindows = true;
        } else {
            isWindows = false;
        }



        String suffix = isWindows ? ".exe" : "";


        if (isWindows) {
            File temp = new File(System.getProperty("java.io.tmpdir"), "jave-1");
            if (!temp.exists()) {
                temp.mkdirs();
                temp.deleteOnExit();
            }
            File exe = new File(temp, "ffmpeg" + suffix);
            if (!exe.exists()) {
                this.copyFile(CoreConstants.getProperty("ffmpeg.path","")+"ffmpeg" + suffix, exe);
            }
//            File dll = new File(temp, "pthreadGC2.dll");
//            if (!dll.exists()) {
//                this.copyFile("pthreadGC2.dll", dll);
//            }
            this.path = exe.getAbsolutePath();
        }else{
            Runtime runtime = Runtime.getRuntime();
            File exe = new File(CoreConstants.getProperty("ffmpeg.path","")+"ffmpeg" + suffix);
            try {
                runtime.exec(new String[]{"/bin/chmod", "755", exe.getAbsolutePath()});
                this.path = exe.getAbsolutePath();
            } catch (IOException var8) {
                var8.printStackTrace();
            }
        }
    }

    @Override
    protected String getFFMPEGExecutablePath() {
        return this.path;
    }

    private void copyFile(String path, File dest) throws RuntimeException {
        InputStream input = null;
        FileOutputStream output = null;

        try {
//            input = this.getClass().getResourceAsStream(path);
            input = new FileInputStream(path);
            output = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];

            int l;
            while((l = input.read(buffer)) != -1) {
                output.write(buffer, 0, l);
            }
        } catch (IOException var18) {
            throw new RuntimeException("Cannot write file " + dest.getAbsolutePath());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (Throwable var17) {

                }
            }

            if (input != null) {
                try {
                    input.close();
                } catch (Throwable var16) {
                    ;
                }
            }

        }

    }
}
