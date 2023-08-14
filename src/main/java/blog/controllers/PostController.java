package blog.controllers;

import blog.PostNotFoundException;
import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PostController {
    private final PostService postService;

    private final NotificationService notifyService;
    public PostController (PostService postService, NotificationService notifyService) {
        this.postService = postService;
        this.notifyService = notifyService;
    }


    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
            Post post = postService.findById(id);
            if (post == null) {
                notifyService.addErrorMessage("Cannot find post #" + id);
                return "redirect:/";
            }
            model.addAttribute("post", post);
            return "posts/view";
    }
}
