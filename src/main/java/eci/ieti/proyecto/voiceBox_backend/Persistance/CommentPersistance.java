package eci.ieti.proyecto.voiceBox_backend.Persistance;

import java.util.ArrayList;

import eci.ieti.proyecto.voiceBox_backend.model.Comment;

public interface CommentPersistance {
    /**
     * Method returns the id of the last comment of the comments document
     * @return
     */
    public Long getLastId();

    public Comment getComment(Long ID);


    public Boolean deleteComment(Long ID);

    public ArrayList<Comment> getCommentsFromAudioBook(Long audioBookID);  

    public Boolean persistComment(Comment comment);

    public Boolean deleteCommentsFromAudioBook(Long audioBookID);

    

}