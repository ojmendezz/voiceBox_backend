package eci.ieti.proyecto.voiceBox_backend.Persistance;

import eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl.CommentPersistanceImpl;
import eci.ieti.proyecto.voiceBox_backend.model.Comment;

public class VoiceBoxPersistance{


    // deberia inyectarse
    private CommentPersistance commentPersistance;

    public VoiceBoxPersistance(){
        // debe inyectarse
        commentPersistance = new CommentPersistanceImpl();

    }

    public Long getLastCommentId(){
        return commentPersistance.getLastId();

    }

    public boolean saveComment(Comment comment){
        return commentPersistance.persistComment(comment);
        
    }

    
}