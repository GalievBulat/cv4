package com.kakadurf.cv4.framework.controller.servlet;

import com.kakadurf.cv4.domain.datasource.SubscribeSource;
import com.kakadurf.cv4.domain.datasource.UserSource;
import com.kakadurf.cv4.domain.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Users {
    @Autowired
    UserSource userSource;
    @Autowired
    SubscribeSource subscribeSource;

    @GetMapping("/search")
    public String getSearchPage(Model model,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10" ) int size){
        /*UserEntity user1 = userSource.findById(4L).get();
        UserEntity user2 = userSource.findById(5L).get();
        HashSet<UserEntity> hs1 = new HashSet<>();
        HashSet<UserEntity> hs2 = new HashSet<>();
        hs1.add(user1);
        hs2.add(user2);
        user1.setSubscribes(hs2);
        user2.setSubscribes(hs1);
        userSource.save(user1);
        userSource.save(user2);
        user1 = userSource.findById(4L).get();
        System.out.println(user1.getSubscribes().toString());*/
        /*userSource.findById(4L).ifPresent(userEntity -> {
                    System.out.println(userEntity.getSubscribes().stream().map(userEntity1 ->
                    userEntity.getEmail()).collect(Collectors.joining()));
                });*/
        UserEntity userEntity = userSource.findById(4L).get();
        System.out.println(subscribeSource.findBySubscriber(userEntity));
        return "help";
    }
}
