package com.kakadurf.cv4.framework.controller.rest;

import com.kakadurf.cv4.domain.service.interfaces.UserManagingService;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSubscribe {
    @Autowired
    UserManagingService userManagingService;
    @GetMapping("/api/subscribe/{id}")
    @Operation(summary = "Subscribes to a given user", tags = "user")
    public ResponseEntity<?> subscribe(@RequestParam("id") long id,
                                            @AuthenticationPrincipal UserDetailsImpl security) {
        userManagingService.subscribeToUser(security.user.getId(), id);
        return ResponseEntity.ok().build();
    }
}
