package ImageHoster.service;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//This annotation tells that this is a service class
@Service
public class CommentService {

    @Autowired
    private CommentsRepository commentsRepository;

    //This method calls the repository method to persist the comment into db
    public void writeComment(Comments comment) {
        commentsRepository.writecomment(comment);
    }

    //This method gets all the comments for an image
    public List<Comments> getComment(Image image) {
        return commentsRepository.getComment(image);
    }

    //This method delete the comments for an image.
    public void deleteComments(Image image) {
        List<Comments> comments = commentsRepository.getComment(image);
        commentsRepository.deleteComments(comments);
    }
}
