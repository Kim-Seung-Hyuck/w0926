package org.zerock.dao;

import lombok.Cleanup;
import org.fs2.w0926.dao.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectTests {

    @Test
    public void testConnects100() throws Exception {

        //드라이버 로딩
        Class.forName("org.mariadb.jdbc.Driver");

        long strat = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {

            //커넥션
            @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();


            String query = "select now()";
            //쿼리
            @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(query);

            @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next(); // 메타 데이터 건너뛰기

            String str = resultSet.getString(1);

            System.out.println(str);

            //close()
        }


        long end = System.currentTimeMillis();

        long gap = end - strat;

        System.out.println("Time : " + gap);


    }

    public void testConnectsDS() throws Exception {

        Connection connection = ConnectionUtil.INSTANCE.getConnection();

        String query = "select now()";
        //쿼리
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next(); // 메타 데이터 건너뛰기

        String str = resultSet.getString(1);

        System.out.println(str);

        //close();
    }

}
