package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.service.PostService;
import com.kakadurf.cv4.domain.transport.dto.PostDto;
import com.kakadurf.cv4.domain.transport.dto.PostInfo;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class RestComments {
    @Autowired
    PostService postService;
    @PostMapping("/api/comments/{post_id}")
    public ResponseEntity<String> getComments(@PathVariable("post_id") long postId){
        return ResponseEntity.ok(postService.getComments(postId).stream()
                .map(PostDto::toJSON).collect(Collectors.joining(", ")));
    }
    @PostMapping("/api/add_post")
    public ResponseEntity<?> addPost(@RequestBody PostInfo postInfo,
                          @AuthenticationPrincipal UserDetailsImpl security){
        postService.addPost(postInfo, security.user);
        return ResponseEntity.ok().build();
    }
}
