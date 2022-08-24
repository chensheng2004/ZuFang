package com.hose.Listener;


import com.hose.pojo.PublicMethod;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.File;
import java.io.IOException;

//最后删除临时图片监听器
@WebListener
public class ImageDeletionListener implements ServletContextListener {

    private static void deleteFile(File file) throws IOException {

        File[] files = file.listFiles();
        if (files!=null){//如果包含文件进行删除操作
            for (int i = 0; i <files.length ; i++) {
                if (files[i].isFile()){
                    //删除子文件
                    files[i].delete();
                }else if (files[i].isDirectory()){
                    //通过递归的方法找到子目录的文件
                    deleteFile(files[i]);
                }
                files[i].delete();//删除子目录
            }
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if(PublicMethod.PATH==null)return;

        File rootFile = new File(PublicMethod.PATH);

        try {
            deleteFile(rootFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServletContextListener.super.contextDestroyed(sce);
    }
}
