package com.codeup.playground.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

//    GET	/posts	posts index page
//    GET	/posts/{id}	view an individual post
//    GET	/posts/create	view the form for creating a post
//    POST	/posts/create	create a new post
    @GetMapping("posts")
    public String posts(){
        return "Posts";
    }

    @GetMapping("postId")///{id}
    public String post(){
        return "SinglePost";
    }

    @GetMapping("posts/create")
    public String createPost(){
        return "CreatePost";
    }

    @PostMapping("posts/create")
    public String posted(){
        return "Post is Created!";
    }

    @GetMapping("search")
    public String search(){
        return "Search";
    }
}
