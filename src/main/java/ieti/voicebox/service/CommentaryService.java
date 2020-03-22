package ieti.voicebox.service;

import java.util.ArrayList;

import ieti.voicebox.model.Commentary;

public class CommentaryService{
    public Boolean createComment(String description, Long user, Long audioBook) {
        return true;
    }

    public Boolean persistComment(Commentary comment) {
        return true;

    }

    public ArrayList<Commentary> getCommentsFromAudioBook(Long audioBookID) {
        ArrayList<Commentary> comments = new ArrayList<Commentary>();
        return comments;
    }

    public Boolean deleteCommentsFromAudiBook(Long audioBookID) {
        return true;

    }

    public Boolean deleteComment(Long commentID) {
        return true;

    }

}