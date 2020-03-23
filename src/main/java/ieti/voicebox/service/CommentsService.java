package ieti.voicebox.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ieti.voicebox.model.AudioBook;
import ieti.voicebox.model.Comment;
import ieti.voicebox.persistence.AudioBookRepository;


@Configuration
public class CommentsService{
    @Autowired
    private AudioBookRepository audioBookRepository;
    
    public Comment createComment(Comment comment) {
        AudioBook book=audioBookRepository.findById(comment.getAudioBook()).get();
        ArrayList<Comment> comments = book.getCommentaries();
        try{
            comment.setId(comments.get(comments.size()-1).getId()+1);
        }
        catch (NullPointerException np){
            comment.setId(1);
        }
        updateComments(comments,book);
        return comment;
    }

    public ArrayList<Comment> getCommentsFromAudioBook(String audioBookID) {
        return audioBookRepository.findById(audioBookID).get().getCommentaries();
    }

    public ArrayList<Comment> deleteCommentsFromAudioBook(String audioBookID) {
        AudioBook book=audioBookRepository.findById(audioBookID).get();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        updateComments(comments,book);
        return comments; 


    }

    public ArrayList<Comment> deleteComment(Long commentID, String audioBookID) {
        AudioBook book=audioBookRepository.findById(audioBookID).get();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        for (int i =0;i<comments.size();i++){
            if(comments.get(i).getId()==(commentID)){
                comments.remove(i);
                break;
            }
        }
        updateComments(comments,book);
        return comments;



    }


    private void updateComments(ArrayList<Comment> comments, AudioBook book){
        book.setCommentaries(comments);
        audioBookRepository.save(book);
    }

}