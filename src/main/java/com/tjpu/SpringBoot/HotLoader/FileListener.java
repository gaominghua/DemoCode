package com.tjpu.SpringBoot.HotLoader;

import com.tjpu.SpringBoot.HotLoader.classloader.MyClassLoader;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

public class FileListener  extends FileAlterationListenerAdaptor{

    @Override
    public void onFileChange(File file) {
        if (file.getName().contains(".class")){

            try {
                MyClassLoader myClassLoader = new MyClassLoader(Application.rootPath,Application.rootPath+"/com");
                   Application.stop();
                   Application.start0(myClassLoader);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
