package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    public void writeComment(Comments comment){
        commentsRepository.writecomment(comment);
    }

    public List<Comments> getComment(Image image){
       return  commentsRepository.getComment(image);
    }

    public void deleteComments(Image image) {
        List<Comments> comments = commentsRepository.getComment(image);
        commentsRepository.deleteComments(comments);
    }
}
