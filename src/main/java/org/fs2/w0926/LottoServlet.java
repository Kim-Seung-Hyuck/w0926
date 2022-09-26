package org.fs2.w0926;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

@WebServlet(name = "LottoServlet", value = {"/lotto", "/lotto2"})
public class LottoServlet extends HttpServlet {

    // Get방식 : 조회할때 사용(정보 확산을 위해 사용(URL))
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("LottoServlet...........Get");
        System.out.println(this);
        System.out.println(Thread.currentThread().getName());
        System.out.println("-----------------");

    }

    @Override
    protected void doPost(HttpServletRequest requestq, HttpServletResponse response) throws ServletException, IOException {

    }
}
