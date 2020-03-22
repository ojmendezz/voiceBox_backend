package ieti.voicebox.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ieti.voicebox.model.Comment;
import ieti.voicebox.service.CommentsService;

@Controller
@RequestMapping("comments")
public class CommentController {

    @Autowired
    CommentsService commentServices;

    @GetMapping("/{audioId}")
    public ResponseEntity<List<Comment>> getCommentsFromAudioBook(@PathVariable String audioId) {
        List<Comment> comments = commentServices.getCommentsFromAudioBook(audioId);
        return new ResponseEntity<>(comments, HttpStatus.ACCEPTED);
    }

    /* depende de si no pone problema al crear comment con el constuctor alterno */
    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment ){
        Comment newComment = commentServices.createComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/all/{bookId}/{commentId}")
    public ResponseEntity<List<Comment>> deleteCommentFromAudioBook(@PathVariable("bookId") String bookId,@PathVariable("commentId") long commentId){
        List<Comment> updatedComments = commentServices.deleteComment(commentId,bookId);
        return new ResponseEntity<>(updatedComments,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<List<Comment>> deleteCommentsFromAudioBook(@PathVariable("bookId") String bookId){
        List<Comment> updatedComments = commentServices.deleteCommentsFromAudioBook(bookId);
        return new ResponseEntity<>(updatedComments,HttpStatus.ACCEPTED);
    }

}