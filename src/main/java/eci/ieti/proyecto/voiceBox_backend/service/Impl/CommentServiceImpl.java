package eci.ieti.proyecto.voiceBox_backend.service.Impl;

import java.util.ArrayList;

import eci.ieti.proyecto.voiceBox_backend.model.Comment;
import eci.ieti.proyecto.voiceBox_backend.service.CommentService;

public class CommentServiceImpl implements CommentService {

    @Override
    public Boolean createComment(String description, Long user, Long audioBook) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Boolean persistComment(Comment comment) {
        return true;

    }

    @Override
    public ArrayList<Comment> getCommentsFromAudioBook(Long audioBookID) {
        ArrayList comments = new ArrayList<Comment>();
        return comments;
    }

    @Override
    public Boolean deleteCommentsFromAudiBook(Long audioBookID) {
        // TODO Auto-generated method stub
        return true;

    }

    @Override
    public Boolean deleteComment(Long commentID) {
        // TODO Auto-generated method stub
        return true;

    }

}