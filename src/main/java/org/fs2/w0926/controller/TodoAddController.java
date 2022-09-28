package org.fs2.w0926.controller;

import org.fs2.w0926.dao.TodoDAO;
import org.fs2.w0926.dto.TodoDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "TodoAddController", value = "/todo/add")
public class TodoAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/todo/add.jsp")
                .forward(request, response);
    }

    // DAO로 등록 처리
    // 마지막에 목록(list.jsp)으로 Redirecte
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("title"));
        System.out.println(request.getParameter("memo"));
        System.out.println(request.getParameter("dueDate"));

        TodoDTO dto = TodoDTO.builder()
                .title(request.getParameter("title"))
                .memo(request.getParameter("memo"))
                .dueDate((LocalDate.parse(request.getParameter("dueDate"))))
                .build();

        try {
            TodoDAO.INSTANCE.insert(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/todo/list");

    }
}
