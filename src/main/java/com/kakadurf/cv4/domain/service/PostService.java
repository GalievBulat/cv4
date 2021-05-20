package com.kakadurf.cv4.domain.service;

import com.kakadurf.cv4.domain.datasource.MusicSource;
import com.kakadurf.cv4.domain.datasource.PostSource;
import com.kakadurf.cv4.domain.entities.PostEntity;
import com.kakadurf.cv4.domain.entities.UserEntity;
import com.kakadurf.cv4.domain.transport.PostMapper;
import com.kakadurf.cv4.domain.transport.dto.PostDto;
import com.kakadurf.cv4.domain.transport.dto.PostInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class PostService {
    @Autowired
    PostSource postSource;

    @Autowired
    MusicSource musicSource;
    public List<PostDto> getAllPosts(int page, int size){
        return postSource.findAllByParentIsNull(PageRequest.of(page, size))
                .map(PostMapper.INSTANCE::postToDto).toList();
    }
    public List<PostDto> getAllPosts(Pageable pageable){
        return postSource.findAllByParentIsNull(pageable)
                .map(PostMapper.INSTANCE::postToDto).toList();
    }
    @Transactional
    public void likePost(UserEntity user, long postId){
        PostEntity post = postSource.findAllById(postId);
        Set<UserEntity> set = post.getLiked();
        set.add(user);
        postSource.save(post);
    }
    public List<PostDto> getComments(long postId){
        PostEntity postEntity = postSource.findAllById(postId);
        return postSource.findByParent(postEntity, Pageable.unpaged())
                .map(PostMapper.INSTANCE::postToDto).toList();
    }
    public void addPost(PostInfo postInfo, UserEntity owner){
        postSource.save(PostEntity.builder()
                .music(musicSource.findById(postInfo.getMusicId()))
                .parent(postSource.findAllById(postInfo.getParentId()))
                .owner(owner)
                .text(postInfo.getText())
                .build());
    }
}
