package ImageHoster.controller;

import ImageHoster.model.Comments;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentsService;

    @Autowired
    private ImageService imageService;

    @RequestMapping("/image/{id}/{title}/comments")
    public String writeComment(@PathVariable("id") int id, @PathVariable("title") String title, @RequestParam("comment") String comment, Model model, HttpSession session) {
        System.out.println(comment);
        Comments newComment = new Comments();
        newComment.setCreatedDate(new Date());
        newComment.setImage(imageService.getImage(id));
        User sessionUser = (User)session.getAttribute("loggeduser");
        newComment.setUser(sessionUser);
        newComment.setText(comment);
        commentsService.writeComment(newComment);
        return "redirect:/images/"+id +"/"+ title;
    }
}
