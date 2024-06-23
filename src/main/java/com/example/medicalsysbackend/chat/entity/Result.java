package com.example.medicalsysbackend.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 22603
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean flag;
    private String message;
}
