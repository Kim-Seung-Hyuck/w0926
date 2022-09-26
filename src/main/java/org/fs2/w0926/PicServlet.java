package org.fs2.w0926;

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;

@WebServlet(name = "PicServlet", value = "/pic1")
public class PicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpg");

        BufferedImage image =
                new BufferedImage(500, 100, BufferedImage.TYPE_INT_RGB);

        //붓
        Graphics graphics = image.getGraphics();
        //물감
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, 500, 100);

        graphics.setColor(Color.black);

        int[] value = new int[6];

        int temp = 0;

        for (int i = 0; i < 6; i++) {
            value[i] = (int) ((Math.random() * 45) + 1);
            for (int j = 0; j < i; j++){
                if(value[i] == value[j]){
                    i--;
                    break;
                }
            }

            Font plainFont = new Font("Serif", Font.BOLD, 20);
            graphics.setFont(plainFont);

            graphics.drawString("" + value[i], (i*50)+30, 50);

        }

        OutputStream os = response.getOutputStream();

        ImageIO.write(image,"gif",os);
    }

}


//        OutputStream out = response.getOutputStream();
//
//        FileInputStream fin = new FileInputStream("C:\\zzz\\winter.jpg");

//        response.setContentType("image/jpg");

//        byte[] arr = new byte[1024*8];
//
//        while (true){
//            int count = fin.read(arr);
//            if(count == -1){break;}
//            out.write(arr,0,count);
//        } //end while