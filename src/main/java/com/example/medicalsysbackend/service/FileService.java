package com.example.medicalsysbackend.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Cool
 */
public interface FileService {
    /**
     * 上传头像到OSS
     *
     * @param file
     * @return
     */
    String uploadFileAvatar(MultipartFile file);
}
