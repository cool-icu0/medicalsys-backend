package com.example.medicalsysbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionController {
    @GetMapping("/getSessionId")
    public String getSessionId(HttpServletRequest request) {
        // 获取 HttpSession 对象
        HttpSession session = request.getSession();

        // 获取 HttpSession ID
        String sessionId = session.getId();

        return "Session ID: " + sessionId;
    }
}
