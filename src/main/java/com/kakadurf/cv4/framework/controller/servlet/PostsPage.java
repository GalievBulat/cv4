package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.datasource.PostSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.service.JwtTokenizer;
import com.kakadurf.cv4.domain.service.PostService;
import com.kakadurf.cv4.domain.transport.dto.PostInfo;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@PreAuthorize("isAuthenticated()")
public class PostsPage {
    @Autowired
    PostService postService;
    @Autowired
    JwtTokenizer jwtTokenizer;
    @GetMapping("/posts")
    public String getPostsPage(Model model,
                               @AuthenticationPrincipal UserDetailsImpl security,
                               @PageableDefault Pageable pageable){
        model.addAttribute("posts",postService.getAllPosts(pageable));
        model.addAttribute("token", jwtTokenizer.getToken(security.user.getId(),security.user.getName()));
        return "posts";
    }
    @PostMapping("/add_post")
    public String addPost(@RequestBody PostInfo postInfo,
                        @AuthenticationPrincipal UserDetailsImpl security){
        postService.addPost(postInfo, security.user);
        return "redirect:/posts";
    }
}
