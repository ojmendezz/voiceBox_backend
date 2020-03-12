package eci.ieti.proyecto.voiceBox_backend.Persistance;

import java.util.ArrayList;

import eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl.CommentPersistanceImpl;
import eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl.SuscriptionPersistanceImpl;
import eci.ieti.proyecto.voiceBox_backend.model.Comment;

public class VoiceBoxPersistance{


    // deberia inyectarse
    private CommentPersistance commentPersistance;
    private SuscriptionPersistance suscriptionPersistance;

    public VoiceBoxPersistance(){
        // debe inyectarse
        commentPersistance = new CommentPersistanceImpl();
        suscriptionPersistance = new SuscriptionPersistanceImpl();

    }

    public Long getLastCommentId(){
        return commentPersistance.getLastId();

    }

    public boolean saveComment(Comment comment){
        return commentPersistance.persistComment(comment);
        
    }

    public Boolean deleteComment(Long id){
        return commentPersistance.deleteComment(id);
    }

    public ArrayList<Comment> getCommentsFromAudioBook(Long id){
        return commentPersistance.getCommentsFromAudioBook(id);
    }

    public Boolean deleteAllCommentsFromAudioBook(Long id){
        return commentPersistance.deleteCommentsFromAudioBook(id);
    }

    public Comment getComment(Long id){
        return commentPersistance.getComment(id);
    }

    // suscription
    
}