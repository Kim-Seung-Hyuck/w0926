package org.zerock.dao;

import com.sun.tools.javac.comp.Todo;
import org.fs2.w0926.dao.TodoDAO;
import org.fs2.w0926.dto.TodoDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class TodoDAOTests {



    @Test
    public void testList() throws Exception {

        for (TodoDTO dto : TodoDAO.INSTANCE.list(2,10)){
            System.out.println(dto);
        }
    }

    @Test
    public void testInserts() {
        IntStream.rangeClosed(1, 1).forEach(i -> {
            TodoDTO dto = TodoDTO.builder()
                    .title("KSH.test" + i)
                    .memo("Test...")
                    .dueDate(LocalDate.now())
                    .build();

            try {
                System.out.println(TodoDAO.INSTANCE.insert(dto));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    public void testUpdate(){

        IntStream.rangeClosed(1, 1).forEach(i -> {
            TodoDTO dto = TodoDTO.builder()
                    .tno(i)
                    .title("win.test" + i)
                    .memo("Test win")
                    .dueDate(LocalDate.now())
                    .build();
            try {
                System.out.println(TodoDAO.INSTANCE.update(dto));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Test
    public void testDelete() throws Exception {

        TodoDTO dto = TodoDTO.builder()
                .tno(1)
                .build();

                System.out.println(TodoDAO.INSTANCE.delete(dto));

        };

    }
