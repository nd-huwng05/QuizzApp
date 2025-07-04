package com.huwng05.services;

import com.huwng05.pojo.Question;
import com.huwng05.utils.JdbcConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionServices {
    public void addQuestion(Question q) throws SQLException {
        Connection cnn = JdbcConnector.getInstance().connect();
        cnn.setAutoCommit(false);
        String sql = "insert into question (content, hint, image, category_id, level_id) values (?, ?, ?, ?, ?)";
        PreparedStatement stm = cnn.prepareCall(sql);
        stm.setString(1, q.getContent());
        stm.setString(2, q.getHint());
        stm.setString(3, q.getImage());
        stm.setInt(4, q.getCategory().getId());
        stm.setInt(5, q.getLevel().getId());
        if( stm.executeUpdate() > 0) {
            int qId= -1;
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                qId = rs.getInt(1);
            }
            sql = "insert into choice (content, is_correct, question_id) values (?, ?, ?) ";
            for (var choice : q.getChoices()) {
                stm = cnn.prepareStatement(sql);
                stm.setString(1, choice.getContent());
                stm.setBoolean(2, choice.isCorrect());
                stm.setInt(3, qId);
                stm.executeUpdate();
            }
            cnn.commit();
        } else  {
            cnn.rollback();
        }
    }
}
