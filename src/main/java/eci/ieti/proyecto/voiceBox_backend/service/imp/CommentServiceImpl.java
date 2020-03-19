package eci.ieti.proyecto.voiceBox_backend.service.imp;

import java.util.ArrayList;
import eci.ieti.proyecto.voiceBox_backend.model.Comment;
import eci.ieti.proyecto.voiceBox_backend.service.CommentService;

public class CommentServiceImpl implements CommentService {
    @Override
    public Boolean createComment(String description, Long user, Long audioBook) {
        //Comment com = new Comment(description, audioBook, user, vbp.getLastCommentId()+1);
        return true;
    }

    @Override
    public Boolean persistComment(Comment comment) {
        return true;

    }

    @Override
    public ArrayList<Comment> getCommentsFromAudioBook(Long audioBookID) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        return comments;
    }

    @Override
    public Boolean deleteCommentsFromAudiBook(Long audioBookID) {
        return true;

    }

    @Override
    public Boolean deleteComment(Long commentID) {
        return true;

    }

}