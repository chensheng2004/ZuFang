package com.hose.pojo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//公共方法
public class PublicMethod {

    public static  String PATH;

    public static void picturestorage(HttpSession session, House house) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String path = servletContext.getRealPath("temporaryfiles");

        if(PATH==(null))
        {
            PATH=path;
        }

        File file = new File(path +File.separator + house.getHouseImageName());

        if(!file.exists())
        {
            file.createNewFile();
        }else {
            return;
        }

        OutputStream in=null;

        try {
            in= new FileOutputStream(file);

            in.write(house.getHouseImage());

        }catch (Exception ex)
        {

        }
        finally {
            in.close();
        }
    }
}
