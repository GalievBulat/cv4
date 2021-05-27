package com.kakadurf.cv4.framework.controller.servlet;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
@PreAuthorize("hasAuthority(SUPPORT)")
@Controller
public class SupportPage {
    public String getSupportPage(){
        return "support";
    }
}
