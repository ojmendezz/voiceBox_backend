package eci.ieti.proyecto.voiceBox_backend.Persistance.PersistanceImpl;

import java.util.ArrayList;

import eci.ieti.proyecto.voiceBox_backend.Persistance.CommentPersistance;
import eci.ieti.proyecto.voiceBox_backend.model.Comment;

public class CommentPersistanceImpl implements CommentPersistance {

    @Override
    public Long getLastId() {
        return (long) Math.random();
    }

    @Override
    public Boolean deleteComment(Long ID) {
        
        return true;
    }

    @Override
    public ArrayList<Comment> getCommentsFromAudioBook(Long audioBookID) {
        ArrayList<Comment> comments =  new ArrayList<Comment>();
        return comments;
    }

    @Override
    public Boolean persistComment(Comment comment) {
        
        return true;
    }

    @Override
    public Boolean deleteCommentsFromAudioBook(Long audioBookID) {
        
        return true;
    }

    @Override
    public Comment getComment(Long ID) {
        Comment ans = new Comment("comentario dummie", 1, 1, 1);
        return ans;
    }
    
}