package com.example.medicalsysbackend.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultMessage {
    private boolean isSystem;
    private String fromName;
    private String nowTime;
    private Object message;
}