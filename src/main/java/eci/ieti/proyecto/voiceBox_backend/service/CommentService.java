package eci.ieti.proyecto.voiceBox_backend.service;

import java.util.ArrayList;

import eci.ieti.proyecto.voiceBox_backend.model.Comment;

public interface CommentService {
    public Boolean createComment(String description, Long user, Long audioBook);

    public Boolean persistComment(Comment comment);

    public ArrayList<Comment> getCommentsFromAudioBook(Long audioBookID);

    public Boolean deleteCommentsFromAudiBook(Long audioBookID);

    public Boolean deleteComment(Long commentID);

    






    
}