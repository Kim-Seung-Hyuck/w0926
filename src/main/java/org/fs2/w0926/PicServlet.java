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
        // 이미지 타입으로 값을 받는다.
        response.setContentType("image/jpg");

        // 크기가 가로 500, 세로 100인 image를 만들어준다.
        BufferedImage image =
                new BufferedImage(500, 100, BufferedImage.TYPE_INT_RGB);

        //붓
        Graphics graphics = image.getGraphics();
        //물감
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, 500, 100);

        graphics.setColor(Color.black);

        // 각각 랜덤으로 받을 값들을 넣어줄 배열을 만들어준다.
        int[] value = new int[6];

        // for문을 이용해 [0] ~ [5] 까지 랜덤한 숫자를 넣어준다
        for (int i = 0; i < 6; i++) {
            value[i] = (int) ((Math.random() * 45) + 1);

            // 앞에 들어간 랜덤한 숫자와 현재 들어온 랜덤한 숫자들을 비교하여
            for (int j = 0; j < i; j++){
                // 만약 값이 같다면 i--를 해줘서 다시 랜덤한 값을 넣어주도록 한다.
                if(value[i] == value[j]){
                    i--;
                    break;
                }
            }

            // 랜덤 숫자의 폰트와 크기를 설정
            Font plainFont = new Font("Serif", Font.BOLD, 20);
            graphics.setFont(plainFont);

            // 랜덤한 값들이 겹쳐지지 않게 x축 값을 다르게 주어{(i*50)+30} 겹치지 않게 만들어준다.
            graphics.drawString("" + value[i], (i*50)+30, 50);

        }

        OutputStream os = response.getOutputStream();

        // image를 gif형식으로 출력한다.
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