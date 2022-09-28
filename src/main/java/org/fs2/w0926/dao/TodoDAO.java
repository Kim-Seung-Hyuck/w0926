package org.fs2.w0926.dao;

// 리턴값을 무엇으로 할것이냐?
// 결과를 받아야하는 데이터가 존재하면 반환값을 명시


import com.sun.tools.javac.comp.Todo;
import lombok.Cleanup;
import org.fs2.w0926.dto.TodoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public enum TodoDAO {
    INSTANCE;
    private final String INSERT = "INSERT INTO tbl_todo (title,memo,dueDate) VALUES (?,?,?)";
    private final String Last = "select last_insert_id()";


    public List<TodoDTO> list(int page, int size)throws  Exception{
        StringBuffer buffer =
                new StringBuffer("select * from tbl_todo where tno>0 order by tno desc limit ?,?");

        int skip = ( page < 0 ? 1 : page-1 ) * size;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(buffer.toString());
        preparedStatement.setInt(1,skip);
        preparedStatement.setInt(2,size);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        List<TodoDTO> list = new ArrayList<>();
        while(resultSet.next()){
            TodoDTO dto = TodoDTO.builder()
                    .tno(resultSet.getInt("tno"))
                    .title(resultSet.getString("title"))
                    .memo(resultSet.getString("memo"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .complete(resultSet.getBoolean("complete"))
                    .regDate(resultSet.getTimestamp("regDate").toLocalDateTime())
                    .modDate(resultSet.getTimestamp("modDate").toLocalDateTime())
                    .build();
            list.add(dto);
        }
        return list;
    }

    public Integer insert(TodoDTO todoDTO) throws Exception{
        Integer result = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();

        @Cleanup PreparedStatement preparedStatement
                = connection.prepareStatement(INSERT);

        preparedStatement.setString(1, todoDTO.getTitle());
        preparedStatement.setString(2,todoDTO.getMemo());
        preparedStatement.setDate(3, Date.valueOf(todoDTO.getDueDate()));

        //insert/update/delete -> int
        int count = preparedStatement.executeUpdate();
        if(count !=1 ){
            throw new Exception("insert error");
        } //end if
        preparedStatement.close();
//        preparedStatement = connection.prepareStatement(Last);

//        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

//        resultSet.next();
//
//        result = resultSet.getInt(1);

        return result;

    }

    public TodoDTO read(TodoDTO todoDTO) throws Exception{

        StringBuffer buffer =
                new StringBuffer("select * from tbl_todo where tno>0 order by tno desc limit ?,?");

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(buffer.toString());


        String sql = "Select * From tbl_todo where tno = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, todoDTO.getTno());
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
            TodoDTO dto = TodoDTO.builder()
                    .tno(resultSet.getInt("tno"))
                    .title(resultSet.getString("title"))
                    .memo(resultSet.getString("memo"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .complete(resultSet.getBoolean("complete"))
                    .regDate(resultSet.getTimestamp("regDate").toLocalDateTime())
                    .modDate(resultSet.getTimestamp("modDate").toLocalDateTime())
                    .build();

        return dto;

    }

    public Integer update(TodoDTO todoDTO) throws Exception{

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();

        @Cleanup PreparedStatement preparedStatement = null;

        String sql = "UPDATE tbl_todo SET title = ?, memo = ?,  duedate = ? where tno = ?";

        int result = 0;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, todoDTO.getTitle());
            preparedStatement.setString(2, todoDTO.getMemo());
            preparedStatement.setDate(3, Date.valueOf(todoDTO.getDueDate()));
            preparedStatement.setInt(4, todoDTO.getTno());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public Integer delete(TodoDTO todoDTO) throws Exception{
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();

        @Cleanup PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM tbl_todo where tno = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, todoDTO.getTno());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Integer result = preparedStatement.executeUpdate();
        return result;

    }

}

