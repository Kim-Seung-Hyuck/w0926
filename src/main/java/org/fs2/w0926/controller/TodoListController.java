package org.fs2.w0926.controller;

import org.fs2.w0926.dao.TodoDAO;
import org.fs2.w0926.dto.TodoDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List< TodoDTO> data = TodoDAO.INSTANCE.list(1, 100);
            request.setAttribute("list", data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp")
            .forward(request, response);



    }
}
