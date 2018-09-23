package dao;

import javaBean.Comment;

import java.sql.SQLException;

public class CommentDao {
    public static DatabaseDao databaseDao;

    static {
        try {
            databaseDao = new DatabaseDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer insertComment(Comment comment) throws SQLException {
        String sql = "insert into comment(commentId,newsId,userId,commentContent,commentDate,praise,stair,userName,headerIconUrl) values("+
                comment.getCommentId()+"','"+
                comment.getNewsId()+"','"+
                comment.getUserId()+"','"+
                comment.getCommentContent()+"','"+
                comment.getCommentDate()+"','"+
                comment.getPraise()+"','"+
                comment.getStair()+"','"+
                comment.getUserName()+"','"+
                comment.getHeaderIconUrl()+"')";
        return databaseDao.update(sql);
    }
}
