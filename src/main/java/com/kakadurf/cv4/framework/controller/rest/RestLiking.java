package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.service.PostService;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestLiking {
    @Autowired
    PostService postService;
    @PostMapping("/api/like/{post_id}")
    public ResponseEntity<?> likePost(@PathVariable("post_id") long postId,
                                      @AuthenticationPrincipal UserDetailsImpl security){
        postService.likePost(security.user, postId);
        return ResponseEntity.ok().build();
    }
}
