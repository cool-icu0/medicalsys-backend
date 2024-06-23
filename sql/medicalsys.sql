/*
 Navicat Premium Data Transfer

 Source Server         : 远程医疗服务器
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 47.98.213.9:3306
 Source Schema         : medicalsys

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 23/06/2024 18:38:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment_registration
-- ----------------------------
DROP TABLE IF EXISTS `appointment_registration`;
CREATE TABLE `appointment_registration`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `hospital_department` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '医院科室',
  `doctor_id` int(11) NULL DEFAULT NULL COMMENT '医生ID',
  `appointment_date` datetime NULL DEFAULT NULL COMMENT '预约时间',
  `app_prices` int(11) NULL DEFAULT NULL COMMENT '价格（基本价+职称价）',
  `is_complete` int(10) NULL DEFAULT 0 COMMENT '是否完成预约（0：未完成，1：已完成，2：已取消）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of appointment_registration
-- ----------------------------
INSERT INTO `appointment_registration` VALUES (1, 1, '皮肤科', 1, NULL, 199, 1);
INSERT INTO `appointment_registration` VALUES (2, 1, '牙科', 2, '2024-05-11 23:17:27', 199, 1);
INSERT INTO `appointment_registration` VALUES (3, 2, '皮肤科', 1, '2024-05-11 23:18:11', 199, 0);
INSERT INTO `appointment_registration` VALUES (4, 3, '骨科', 3, NULL, 200, 0);
INSERT INTO `appointment_registration` VALUES (5, 1, '皮肤科', 1, '2024-05-12 00:00:00', 50, 2);
INSERT INTO `appointment_registration` VALUES (6, 1, '皮肤科', 1, '2024-05-27 00:00:00', 50, 2);
INSERT INTO `appointment_registration` VALUES (7, 1, '皮肤科', 1, '2024-05-27 00:00:00', 50, 2);
INSERT INTO `appointment_registration` VALUES (8, 1, '皮肤科', 1, '2024-05-27 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (9, 1, '皮肤科', 1, '2024-05-27 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (10, 1, '牙科', 6, '2024-05-27 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (11, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 2);
INSERT INTO `appointment_registration` VALUES (12, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (13, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (14, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (15, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (16, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (17, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (18, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (19, 1, '皮肤科', 1, '2024-05-29 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (20, 1, '牙科', 6, '2024-05-29 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (21, 5, '牙科', 6, '2024-06-01 00:00:00', 300, 0);
INSERT INTO `appointment_registration` VALUES (22, 5, '牙科', 6, '2024-06-01 00:00:00', 300, 0);
INSERT INTO `appointment_registration` VALUES (23, 5, '牙科', 6, '2024-06-01 00:00:00', 300, 0);
INSERT INTO `appointment_registration` VALUES (24, 5, '牙科', 6, '2024-06-02 00:00:00', 300, 0);
INSERT INTO `appointment_registration` VALUES (25, 5, '皮肤科', 1, '2024-06-08 00:00:00', 50, 0);
INSERT INTO `appointment_registration` VALUES (26, 1, '皮肤科', 1, '2024-06-13 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (27, 1, '皮肤科', 1, '2024-04-29 00:00:00', NULL, 199);
INSERT INTO `appointment_registration` VALUES (28, 1, '皮肤科', 1, '2024-04-29 00:00:00', 50, 199);
INSERT INTO `appointment_registration` VALUES (29, 1, '皮肤科', 1, '2024-04-29 00:00:00', 199, 0);
INSERT INTO `appointment_registration` VALUES (30, 1, '皮肤科', 1, '2024-04-29 00:00:00', 199, 0);
INSERT INTO `appointment_registration` VALUES (31, 7, '眼科', 2, '2024-05-01 00:00:00', 250, 0);
INSERT INTO `appointment_registration` VALUES (32, 15, '骨科', 6, '2024-05-10 00:00:00', 300, 0);
INSERT INTO `appointment_registration` VALUES (33, 4, '外科', 3, '2024-05-15 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (34, 5, '儿科', 7, '2024-05-20 00:00:00', 150, 0);
INSERT INTO `appointment_registration` VALUES (35, 6, '神经科', 5, '2024-05-25 00:00:00', 350, 0);
INSERT INTO `appointment_registration` VALUES (36, 7, '妇产科', 4, '2024-06-01 00:00:00', 400, 0);
INSERT INTO `appointment_registration` VALUES (37, 8, '耳鼻喉科', 10, '2024-06-05 00:00:00', 220, 0);
INSERT INTO `appointment_registration` VALUES (38, 9, '口腔科', 9, '2024-06-10 00:00:00', 180, 0);
INSERT INTO `appointment_registration` VALUES (39, 10, '急诊科', 12, '2024-06-15 00:00:00', 280, 0);
INSERT INTO `appointment_registration` VALUES (40, 1, '皮肤科', 1, '2024-06-13 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (41, 1, '皮肤科', 1, '2024-06-13 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (42, 1, '皮肤科', 1, '2024-06-13 00:00:00', 200, 1);
INSERT INTO `appointment_registration` VALUES (43, 1, '皮肤科', 1, '2024-06-13 00:00:00', 200, 1);
INSERT INTO `appointment_registration` VALUES (44, 1, '皮肤科', 1, '2024-06-13 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (45, 1, '皮肤科', 1, '2024-06-13 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (46, 4, '皮肤科', 1, '2024-06-14 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (47, 1, '皮肤科', 1, '2024-06-14 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (48, 4, '皮肤科', 1, '2024-06-14 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (49, 1, '皮肤科', 1, '2024-06-14 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (50, 1, '皮肤科', 1, '2024-06-14 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (51, 4, '皮肤科', 1, '2024-06-14 00:00:00', 200, 0);
INSERT INTO `appointment_registration` VALUES (52, 4, '皮肤科', 1, '2024-06-20 00:00:00', 200, 0);

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '聊天记录id',
  `fromId` bigint(20) NOT NULL COMMENT '发送消息id',
  `toId` bigint(20) NULL DEFAULT NULL COMMENT '接收消息id',
  `text` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `chatType` tinyint(4) NOT NULL COMMENT '聊天类型 1-私聊 2-群聊',
  `createTime` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `teamId` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '聊天消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES (3, 1, 2, '收到', 1, '2024-06-11 02:17:09', '2024-06-11 02:17:08', NULL);
INSERT INTO `chat` VALUES (4, 1, NULL, '这个病怎么治疗\n', 3, '2024-06-11 02:18:26', '2024-06-11 02:18:25', NULL);
INSERT INTO `chat` VALUES (5, 2, NULL, '多喝水\n', 3, '2024-06-11 02:18:39', '2024-06-11 02:18:39', NULL);
INSERT INTO `chat` VALUES (6, 4, 2, '你好\n', 1, '2024-06-12 20:18:21', '2024-06-12 20:18:20', NULL);
INSERT INTO `chat` VALUES (25, 4, 1, '🤭', 1, '2024-06-14 02:54:59', '2024-06-14 02:54:59', NULL);
INSERT INTO `chat` VALUES (26, 4, 1, '你好\n', 1, '2024-06-14 02:58:59', '2024-06-14 02:58:58', NULL);
INSERT INTO `chat` VALUES (27, 4, NULL, '1', 3, '2024-06-14 10:52:53', '2024-06-14 10:52:51', NULL);
INSERT INTO `chat` VALUES (28, 3, NULL, '我是病人3', 3, '2024-06-14 10:53:04', '2024-06-14 10:53:02', NULL);
INSERT INTO `chat` VALUES (29, 4, 7, '1\n', 1, '2024-06-14 10:53:52', '2024-06-14 10:53:50', NULL);
INSERT INTO `chat` VALUES (30, 7, 4, '我感冒了\n', 1, '2024-06-14 10:54:02', '2024-06-14 10:53:59', NULL);
INSERT INTO `chat` VALUES (31, 7, 4, '😇', 1, '2024-06-14 10:54:13', '2024-06-14 10:54:10', NULL);
INSERT INTO `chat` VALUES (32, 4, 1, '123\n', 1, '2024-06-14 13:12:45', '2024-06-14 13:12:44', NULL);
INSERT INTO `chat` VALUES (33, 4, 7, '明白了\n', 1, '2024-06-14 13:13:50', '2024-06-14 13:13:50', NULL);
INSERT INTO `chat` VALUES (34, 4, 1, '😇', 1, '2024-06-14 20:38:46', '2024-06-14 20:38:44', NULL);
INSERT INTO `chat` VALUES (35, 4, NULL, '测试111', 3, '2024-06-20 15:21:36', '2024-06-20 15:21:34', NULL);
INSERT INTO `chat` VALUES (36, 7, 4, '测试222', 1, '2024-06-20 15:21:56', '2024-06-20 15:21:54', NULL);

-- ----------------------------
-- Table structure for consultation_price
-- ----------------------------
DROP TABLE IF EXISTS `consultation_price`;
CREATE TABLE `consultation_price`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '价格ID',
  `position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '问诊类型（职称价格）',
  `price` int(11) NULL DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of consultation_price
-- ----------------------------
INSERT INTO `consultation_price` VALUES (1, '普通医生', 100);
INSERT INTO `consultation_price` VALUES (2, '主治医生', 200);
INSERT INTO `consultation_price` VALUES (3, '主任医生', 300);
INSERT INTO `consultation_price` VALUES (4, '副主任医生', 250);
INSERT INTO `consultation_price` VALUES (5, '药剂师', 75);
INSERT INTO `consultation_price` VALUES (6, '实习医生', 50);
INSERT INTO `consultation_price` VALUES (8, '实习药剂师', 50);
INSERT INTO `consultation_price` VALUES (9, '副药剂师', 60);

-- ----------------------------
-- Table structure for consultation_record
-- ----------------------------
DROP TABLE IF EXISTS `consultation_record`;
CREATE TABLE `consultation_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问诊记录ID',
  `evaluation_date` date NULL DEFAULT NULL COMMENT '诊断日期',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `doctor_id` int(11) NULL DEFAULT NULL COMMENT '医生ID',
  `satisfaction_rating` int(11) NULL DEFAULT NULL COMMENT '满意度评分',
  `advice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '满意度评价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of consultation_record
-- ----------------------------
INSERT INTO `consultation_record` VALUES (1, '2024-04-29', 1, 1, 5, '非常好');
INSERT INTO `consultation_record` VALUES (2, '2024-04-30', 2, 1, 5, '好');
INSERT INTO `consultation_record` VALUES (3, NULL, 3, 2, 5, '好');
INSERT INTO `consultation_record` VALUES (4, '2024-04-29', 2, 3, 5, NULL);
INSERT INTO `consultation_record` VALUES (5, '2024-05-01', 8, 2, 4, '满意');
INSERT INTO `consultation_record` VALUES (6, '2024-05-10', 15, 6, 5, '非常好');
INSERT INTO `consultation_record` VALUES (7, '2024-05-15', 4, 3, 3, '一般');
INSERT INTO `consultation_record` VALUES (8, '2024-05-20', 5, 7, 5, '超出预期');
INSERT INTO `consultation_record` VALUES (9, '2024-05-25', 6, 5, 5, '超出预期');
INSERT INTO `consultation_record` VALUES (10, '2024-06-01', 7, 4, 4, '服务态度好');
INSERT INTO `consultation_record` VALUES (11, '2024-06-05', 8, 10, 3, '有待提升');
INSERT INTO `consultation_record` VALUES (12, '2024-06-10', 9, 9, 5, '非常满意');
INSERT INTO `consultation_record` VALUES (13, '2024-06-15', 10, 12, 4, '很好');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '科室ID',
  `department_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '科室名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '科室描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '皮肤科', '治疗各种皮肤病');
INSERT INTO `department` VALUES (2, '内科', '治疗各种内伤');
INSERT INTO `department` VALUES (3, '骨科', '治疗骨头的科室');
INSERT INTO `department` VALUES (4, '儿童科', '治疗儿童疾病');
INSERT INTO `department` VALUES (5, '牙科', '治疗牙齿疾病');
INSERT INTO `department` VALUES (6, '药房', '审核医生开具的处方');
INSERT INTO `department` VALUES (7, '皮肤科', '诊断和治疗皮肤疾病');
INSERT INTO `department` VALUES (8, '心内科', '诊断和治疗心血管疾病');
INSERT INTO `department` VALUES (9, '外科', '进行各种手术和治疗');
INSERT INTO `department` VALUES (10, '妇产科', '专注于女性生殖健康和婴儿出生');
INSERT INTO `department` VALUES (11, '神经科', '诊断和治疗神经系统疾病');
INSERT INTO `department` VALUES (12, '呼吸科', '诊断和治疗呼吸系统疾病');
INSERT INTO `department` VALUES (13, '儿科', '诊断和治疗儿童疾病');
INSERT INTO `department` VALUES (14, '眼科', '诊断和治疗眼部疾病');
INSERT INTO `department` VALUES (15, '肿瘤科', '诊断和治疗肿瘤疾病');
INSERT INTO `department` VALUES (16, '耳鼻喉科', '诊断和治疗耳、鼻、喉相关疾病');
INSERT INTO `department` VALUES (17, '康复科', '帮助患者恢复身体功能和生活能力');
INSERT INTO `department` VALUES (18, '急诊科', '处理急性疾病和紧急情况');
INSERT INTO `department` VALUES (19, '精神科', '诊断和治疗心理和精神疾病');
INSERT INTO `department` VALUES (20, '内分泌科', '诊断和治疗内分泌相关疾病');
INSERT INTO `department` VALUES (21, '骨科', '治疗骨骼、关节、肌肉、肌腱、韧带、神经、血管等损伤与疾病');

-- ----------------------------
-- Table structure for doctor_info
-- ----------------------------
DROP TABLE IF EXISTS `doctor_info`;
CREATE TABLE `doctor_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '医生ID',
  `doctor_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '医生姓名',
  `specialty` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '擅长领域',
  `hospital_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '所属医院名称',
  `department` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '所属科室',
  `position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职称',
  `experience_years` int(11) NULL DEFAULT NULL COMMENT '从业年限',
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '医生简介',
  `role` int(11) NULL DEFAULT NULL COMMENT '角色（1：医生，2：药剂师）',
  `img_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '医生照片',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of doctor_info
-- ----------------------------
INSERT INTO `doctor_info` VALUES (1, '小高', '皮肤科', '厦门理工二院', '皮肤科', '主治医生', 9, '毕业于福州大学', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (2, '小希', '药房', '厦门理工二院', '药房', '实习药剂师', 1, '厦门理工实习药剂师', 2, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (3, '小李', '皮肤科', '厦门理工二院', '皮肤科', '实习医生', 1, '厦门理工实习医生', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (4, '老余', '药理', '厦门理工二院', '药房', '副主任医生', 5, '厦门理工主任医生', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (5, '夏历', '牙科方面', '厦门理工二院', '牙科', '主任医生', 15, '毕业于厦门大学', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-12/Snipaste_2024-06-12_20-49-53.png', 0);
INSERT INTO `doctor_info` VALUES (6, '小梁', '牙科方面', '厦门理工二院', '牙科', '主任医生', 7, '毕业于福州大学', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (22, '胖金连', '药房', '厦门理工二院', '药房', '药剂师', 6, '擅长给姓武的人士喂药，本身就是一名重度拖延症患者，谁说医者不能自医，今天，我舍长老祖就要逆了这医学界。天不生我胖金连，医道万古入长夜，键来！！！！', 2, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (23, '李浩', '皮肤科', '厦门理工二院', '1', '实习医生', 1, '厦门理工二院实习医生', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (24, '张伟', '心血管疾病', '厦门理工二院', '心内科', '副主任医师', 20, '多年临床经验', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (25, '李梅', '外科手术', '厦门理工二院', '外科', '主任医生', 25, '多次参与重大手术', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (26, '王涛', '妇产科疾病', '厦门理工二院', '妇产科', '副主任医师', 18, '擅长妇产科手术', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (27, '赵强', '神经疾病', '厦门理工二院', '神经科', '主任医师', 22, '神经科学专家', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (28, '陈红', '呼吸系统疾病', '厦门理工二院', '呼吸科', '主治医师', 12, '年轻有为的呼吸科医生', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (29, '刘军', '儿科疾病', '厦门理工二院', '儿科', '副主任医师', 17, '擅长儿童疾病的诊治', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (30, '黄敏', '眼科疾病', '厦门理工二院', '眼科', '主任医师', 23, '眼科领域的资深专家', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (31, '高阳', '皮肤科疾病', '厦门理工二院', '皮肤科', '主治医师', 10, '擅长皮肤病的诊断和治疗', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (32, '周丽', '中医针灸', '厦门理工二院', '中医科', '主任医师', 30, '中医针灸领域的专家', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (33, '林浩', '肿瘤疾病', '厦门理工二院', '肿瘤科', '副主任医师', 27, '擅长肿瘤的诊治', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (34, '郭峰', '急诊处理', '厦门理工二院', '急诊科', '主治医师', 8, '急诊科室的年轻医生', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (35, '韩雪', '康复医学', '厦门理工二院', '康复科', '主任医师', 28, '康复医学领域的专家', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (36, '马明', '药剂管理', '厦门理工二院', '药剂科', '药剂师', 14, '负责药剂管理和调配', 2, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);
INSERT INTO `doctor_info` VALUES (37, '吴华', '心理健康', '厦门理工二院', '精神科', '副主任医师', 19, '心理健康方面的专家', 1, 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/5.png', 0);

-- ----------------------------
-- Table structure for health_card
-- ----------------------------
DROP TABLE IF EXISTS `health_card`;
CREATE TABLE `health_card`  (
  `card_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '医保卡ID',
  `card_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '医保卡号（唯一）',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '持卡人ID',
  `holder_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '持卡人姓名',
  `expiration_date` date NULL DEFAULT NULL COMMENT '过期日期',
  `card_prices` double NULL DEFAULT NULL COMMENT '余额',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '是否逻辑删除',
  PRIMARY KEY (`card_id`) USING BTREE,
  UNIQUE INDEX `card_number`(`card_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of health_card
-- ----------------------------
INSERT INTO `health_card` VALUES (1, '1568735468', 1, '小高', '2024-04-16', 2639, 0);
INSERT INTO `health_card` VALUES (2, '8461354456', 2, '小余', '2024-05-31', 5000, 0);
INSERT INTO `health_card` VALUES (3, '1231232111', 4, '小金', '2025-04-16', 4000, 0);
INSERT INTO `health_card` VALUES (4, '1568735477', 3, '小李', '2025-05-30', 7000, 0);
INSERT INTO `health_card` VALUES (5, '4135123214', 6, '小梁', '2026-08-22', 5660, 0);
INSERT INTO `health_card` VALUES (6, '1111111111', 5, 'user', '2026-06-05', 5000, 0);
INSERT INTO `health_card` VALUES (12, '2345678901', 2, '小陈', '2025-02-15', 2500, 0);
INSERT INTO `health_card` VALUES (13, '3456789012', 3, '小钟', '2025-03-20', 4000, 0);
INSERT INTO `health_card` VALUES (14, '4567890123', 4, '小连', '2025-04-30', 1500, 0);
INSERT INTO `health_card` VALUES (15, '5678901234', 5, '小余', '2025-05-15', 2800, 0);
INSERT INTO `health_card` VALUES (16, '6789012345', 6, '小李', '2025-06-20', 3200, 0);
INSERT INTO `health_card` VALUES (17, '7890123456', 7, '吴九', '2025-07-30', 1800, 0);
INSERT INTO `health_card` VALUES (18, '8901234567', 8, '郑十', '2025-08-15', 2200, 0);
INSERT INTO `health_card` VALUES (19, '9012345678', 9, '陈十一', '2025-09-20', 3500, 0);
INSERT INTO `health_card` VALUES (20, '0123456789', 10, '卫十二', '2025-10-30', 2000, 0);
INSERT INTO `health_card` VALUES (21, '1122334455', 11, '蒋十三', '2025-11-15', 2600, 0);
INSERT INTO `health_card` VALUES (22, '2233445566', 12, '沈十四', '2025-12-20', 3800, 0);
INSERT INTO `health_card` VALUES (23, '3344556677', 13, '韩十五', '2026-01-30', 1700, 0);
INSERT INTO `health_card` VALUES (24, '4455667788', 14, '杨十六', '2026-02-15', 2400, 0);
INSERT INTO `health_card` VALUES (25, '5566778899', 15, '朱十七', '2026-03-20', 3100, 0);
INSERT INTO `health_card` VALUES (26, '6677889900', 16, '秦十八', '2026-04-30', 2900, 0);
INSERT INTO `health_card` VALUES (27, '7788990011', 17, '尤十九', '2026-05-15', 3300, 0);
INSERT INTO `health_card` VALUES (28, '8899001122', 18, '许二十', '2026-06-20', 1900, 0);
INSERT INTO `health_card` VALUES (29, '9900112233', 19, '何廿一', '2026-07-30', 2700, 0);

-- ----------------------------
-- Table structure for health_record
-- ----------------------------
DROP TABLE IF EXISTS `health_record`;
CREATE TABLE `health_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '健康档案ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `basic_info` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '基本信息/药物过敏史',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of health_record
-- ----------------------------
INSERT INTO `health_record` VALUES (1, 1, '青霉素');
INSERT INTO `health_record` VALUES (2, 2, '芒果');
INSERT INTO `health_record` VALUES (3, 4, '抗生素');
INSERT INTO `health_record` VALUES (4, 5, '葡萄糖');
INSERT INTO `health_record` VALUES (5, 6, '青霉素');
INSERT INTO `health_record` VALUES (6, 7, '磺胺类药物');
INSERT INTO `health_record` VALUES (7, 8, '链霉素');
INSERT INTO `health_record` VALUES (8, 9, '布洛芬');
INSERT INTO `health_record` VALUES (9, 10, '阿司匹林');
INSERT INTO `health_record` VALUES (10, 11, '头孢菌素');
INSERT INTO `health_record` VALUES (11, 12, '磺胺嘧啶');

-- ----------------------------
-- Table structure for medical_history
-- ----------------------------
DROP TABLE IF EXISTS `medical_history`;
CREATE TABLE `medical_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病史ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID，关联用户表',
  `medical_condition` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '疾病情况描述',
  `diagnosis_date` date NULL DEFAULT NULL COMMENT '诊断日期',
  `treatment` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '治疗情况描述',
  `doctor_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '主治医生姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medical_history
-- ----------------------------
INSERT INTO `medical_history` VALUES (1, 1, '感冒', '2024-04-26', '轻微感冒，注意休息', '小高');
INSERT INTO `medical_history` VALUES (2, 1, '发烧', '2024-04-25', '中度发烧，需要开退烧药和布洛芬', '小高');
INSERT INTO `medical_history` VALUES (3, 2, '失眠', '2024-04-26', '轻度失眠，由焦虑引起，多放松心情即可痊愈', '小高');
INSERT INTO `medical_history` VALUES (5, 2, '脚崴了', '2024-05-28', '中度，用跌打油早晚各一次涂抹在受伤处，平时注意休息', '小连');
INSERT INTO `medical_history` VALUES (6, 1, '手骨折', '2024-04-16', '打石膏，观察1个月', '小高');
INSERT INTO `medical_history` VALUES (7, 2, '流感', '2023-11-15', '口服抗病毒药物，休息', '陈医生');
INSERT INTO `medical_history` VALUES (8, 4, '皮肤感染', '2024-01-05', '口服抗生素，局部消毒', '高医生');
INSERT INTO `medical_history` VALUES (9, 5, '肾结石', '2024-02-10', '体外碎石，多喝水', '刘林医生');
INSERT INTO `medical_history` VALUES (10, 6, '腰椎间盘突出', '2024-03-15', '物理治疗，注意休息', '李医生');
INSERT INTO `medical_history` VALUES (11, 7, '糖尿病', '2024-04-20', '口服降糖药，控制饮食', '张医生');
INSERT INTO `medical_history` VALUES (12, 8, '过敏性鼻炎', '2024-05-10', '口服抗过敏药，避免接触过敏原', '陈医生');
INSERT INTO `medical_history` VALUES (13, 9, '轻度抑郁症', '2024-06-15', '心理治疗，口服药物', '吴医生');
INSERT INTO `medical_history` VALUES (14, 3, '口腔溃疡', '2024-11-10', '局部涂药，补充维生素', '夏医生');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `medicine_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药品ID',
  `medicine_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '药品名称',
  `manufacturer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '生产厂家',
  `img_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '药品图片地址',
  `unit_price` int(11) NULL DEFAULT NULL COMMENT '单价',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '数量',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '描述',
  PRIMARY KEY (`medicine_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES (1, '感冒灵', '999', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/gml.jpg', 20, 48, '治疗感冒');
INSERT INTO `medicine` VALUES (2, '强力枇杷膏', '999', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-02/qlppg.jpg', 30, 50, '治疗咳嗽');
INSERT INTO `medicine` VALUES (3, '板蓝根颗粒', '999', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-02/blgkl.jpg', 35, 70, '清热解毒');
INSERT INTO `medicine` VALUES (4, '健胃消食片', '江中牌11', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-02/jwxsp.jpg', 23, 90, '治疗胃胀');
INSERT INTO `medicine` VALUES (6, '皮炎平', '华润三九医药股份有限公司', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/2.jpg', 22, 48, '治疗皮肤疾病');
INSERT INTO `medicine` VALUES (7, '同仁堂阿胶', '北京同仁堂通科药业', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/1.jpg', 45, 22, '补血滋阴、润燥止血，适用于血虚萎黄、眩晕心悸、心烦不眠、肺燥咳嗽等症状');
INSERT INTO `medicine` VALUES (8, '脑白金', '无锡健特药业', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/3.jpg', 60, 0, '改善睡眠、润肠通便，适用于睡眠状况不佳或便秘的人群');
INSERT INTO `medicine` VALUES (9, '阿司匹林', '拜耳制药', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/4.jpg', 15, 100, '用于缓解疼痛和退烧');
INSERT INTO `medicine` VALUES (10, '布洛芬', '强生制药', '布洛芬', 20, 200, '非甾体抗炎药，用于减轻炎症');
INSERT INTO `medicine` VALUES (11, '维生素C', '善存制药', '维生素C', 10, 500, '增强免疫力，补充维生素C');
INSERT INTO `medicine` VALUES (12, '盐酸利多卡因胶浆', '邯郸康业制药有限公司', '盐酸利多卡因胶浆', 15, 100, '本品为局麻药。主要用于表面麻醉（包括在胸腔镜检查或腹腔手术时作粘膜麻醉用）');
INSERT INTO `medicine` VALUES (13, '地喹氯铵含片', '珠海同源药业有限公司', '地喹氯铵含片', 15, 100, '用于急、慢性咽喉炎，口腔黏膜溃疡、齿龈炎');
INSERT INTO `medicine` VALUES (14, '复方氯己定含漱液', '江苏知原药业股份有限公司', '复方氯己定含漱液', 15, 100, '用于牙龈炎、冠周炎、口腔粘膜炎等引致的牙龈出血、牙周脓肿、口腔粘膜溃疡等的辅助治疗');
INSERT INTO `medicine` VALUES (15, '奥美拉唑', '阿斯利康', '奥美拉唑', 28, 35, '治疗胃酸过多，缓解胃酸反流症状');
INSERT INTO `medicine` VALUES (16, '雷尼替丁', '葛兰素史克', '雷尼替丁', 20, 45, '抑制胃酸分泌，治疗胃溃疡');
INSERT INTO `medicine` VALUES (17, '法莫替丁', '山东鲁抗', '法莫替丁', 15, 60, '治疗胃酸过多引起的胃痛、胃灼热');
INSERT INTO `medicine` VALUES (18, '碳酸氢钠', '同仁堂', '碳酸氢钠', 10, 25, '中和胃酸，缓解胃酸过多引起的不适');
INSERT INTO `medicine` VALUES (19, '铝碳酸镁', '修正药业', '铝碳酸镁', 30, 40, '保护胃黏膜，缓解胃酸刺激');
INSERT INTO `medicine` VALUES (20, '罗通定', '葵花药业集团', '罗通定', 28, 55, '镇痛药，可用于治疗头痛、月经痛以及助眠等');
INSERT INTO `medicine` VALUES (21, '对乙酰氨基酚', '浙江康乐药业股份有限公司', '对乙酰氨基酚', 22, 45, '解热镇痛药，常用于缓解轻至中度的头疼、发热等症状');
INSERT INTO `medicine` VALUES (22, '舒马曲普坦', '北京中生瑞泰科技有限公司', '舒马曲普坦', 30, 60, '用于缓解成人偏头痛的急性发作');
INSERT INTO `medicine` VALUES (23, '乳果糖口服溶液', '苏威制药', '乳果糖口服溶液', 30, 60, '通过改变肠腔内的渗透压，促进水和电解质分泌，降低粪便硬度，增加粪便体积，促进肠道流动，适用于轻中度的便秘患者');
INSERT INTO `medicine` VALUES (24, '开塞露', '仁和', '开塞露', 25, 50, '通过润滑肠壁，软化大便，促进排便，主要成分为甘露醇、甘油等，适用于多种原因导致的便秘');
INSERT INTO `medicine` VALUES (25, '通便灵胶囊', '焦作福瑞堂制药有限公司', '通便灵胶囊', 22, 45, '由番泻叶、当归、肉苁蓉组成，可发挥促进肠运动、促进排便的作用');
INSERT INTO `medicine` VALUES (26, '枸橼酸莫沙必利片', '亚宝药业集团', '枸橼酸莫沙必利片', 35, 70, '增加胃肠动力，促进排便，适用于慢传输型便秘的患者');
INSERT INTO `medicine` VALUES (27, '奥司他韦', '上海罗氏制药', '奥司他韦', 30, 60, '抗病毒药物，对A型和B型流感病毒均有良好效果，能显著缩短病程并减轻症状');
INSERT INTO `medicine` VALUES (28, '连花清瘟胶囊', '以岭药业', '连花清瘟胶囊', 25, 50, '中成药，具有宣肺泄热、清瘟解毒等作用，对流行性感冒有一定的改善作用');
INSERT INTO `medicine` VALUES (29, '盐酸金刚烷胺片', '上海信谊万象药业', '盐酸金刚烷胺片', 28, 55, '具有抗病毒作用，对流行性感冒病毒感染引起的症状有缓解效果');
INSERT INTO `medicine` VALUES (30, '复方樟脑乳膏', '北京宝树堂科技药业有限公', '复方樟脑乳膏', 30, 60, '适用于虫咬皮炎、湿疹、神经性皮炎、过敏性皮炎、丘疹性荨麻疹等，也可用于肩胛酸痛、肌肉痛及烫伤后的皮肤疼痛');
INSERT INTO `medicine` VALUES (31, '氯雷他定', '江苏亚邦强生药业', '氯雷他定', 25, 50, '口服抗组胺药，适用于缓解过敏性鼻炎有关的症状，如喷嚏、流涕、鼻痒、鼻塞以及眼部痒及烧灼感，也适用于缓解慢性荨麻疹、瘙痒性皮肤病及其他过敏性皮肤病的症状及体征');
INSERT INTO `medicine` VALUES (32, '醋酸氟轻松乳膏', '河南凤凰制药', '醋酸氟轻松乳膏', 35, 70, '用于过敏性皮炎、异位性皮炎、接触性皮炎、脂溢性皮炎、湿疹、皮肤瘙痒、银屑病、神经性皮炎等');
INSERT INTO `medicine` VALUES (33, '炉甘石洗剂', '湖南尔康制药', '炉甘石洗剂', 28, 55, '用于急性瘙痒性皮肤病，如荨麻疹和痱子');
INSERT INTO `medicine` VALUES (34, '消风止痒颗粒', '陕西华西制药', '消风止痒颗粒', 22, 45, '中成药，具有消风清热，除湿止痒的功效，用于丘疹样荨麻疹，也用于湿疹、皮肤瘙痒症');
INSERT INTO `medicine` VALUES (35, '硫酸阿托品片', '仁和堂药业', '硫酸阿托品片', 30, 60, '适用于消化系统疾病引起的胃绞痛、肠绞痛等症状，通过解除平滑肌痉挛和抑制腺体组织分泌来缓解疼痛');
INSERT INTO `medicine` VALUES (36, '颠茄磺苄啶片', '新乡市常乐制药', '颠茄磺苄啶片', 25, 50, '适用于肠道感染性病症引起的肠道疼痛，具有抑制肠道平滑肌收缩、痉挛以及杀菌、抑菌的作用');
INSERT INTO `medicine` VALUES (37, '消食片', '江中药业', '健胃消食片', 28, 55, '适用于因饮食过量或胃肠功能失调引起的腹胀、肚子疼，可调节自身消化系统');
INSERT INTO `medicine` VALUES (38, '硝酸甘油片', '北京益民药业', '硝酸甘油片', 30, 60, '用于冠心病心绞痛的治疗及预防，也可用于降低血压或治疗充血性心力衰竭');
INSERT INTO `medicine` VALUES (39, '阿司匹林肠溶片', '沈阳奥吉娜药业', '阿司匹林肠溶片', 25, 50, '用于冠心病的治疗，通过抑制血小板聚集来防止血栓形成，从而减轻心脏负担');
INSERT INTO `medicine` VALUES (40, '阿托伐他汀钙片', '辉瑞制药', '阿托伐他汀钙片', 35, 70, '用于高胆固醇血症和冠心病的治疗，通过降低血脂来减少心血管疾病的风险');
INSERT INTO `medicine` VALUES (41, '单硝酸异山梨酯片', '齐鲁制药', '单硝酸异山梨酯片', 28, 55, '用于冠心病的长期治疗，预防心绞痛，以及心肌梗死后持续心绞痛的治疗');
INSERT INTO `medicine` VALUES (42, '酒石酸美托洛尔片', '石家庄以岭药业', '酒石酸美托洛尔片', 22, 45, '用于治疗高血压、心绞痛、心肌梗死、心律失常、甲亢、心衰等心血管疾病');
INSERT INTO `medicine` VALUES (43, '脑白金', '无锡健特药业', '脑白金', 30, 60, '改善睡眠、润肠通便，适用于睡眠状况不佳或便秘的人群');
INSERT INTO `medicine` VALUES (44, '汤臣倍健蛋白粉', '汤臣倍健', '汤臣倍健蛋白粉', 25, 50, '补充优质蛋白质，增强免疫力，适合需要增强体力或免疫力的人群');
INSERT INTO `medicine` VALUES (45, '善存多维元素片', '惠氏制药', '善存多维元素片', 35, 70, '补充多种维生素和矿物质，维持身体正常功能，适用于饮食不均衡或需要补充营养素的人群');
INSERT INTO `medicine` VALUES (46, '鱼油软胶囊', '汤臣倍健', '鱼油软胶囊', 28, 55, '富含Omega-3脂肪酸，有助于降低血脂、预防心脑血管疾病，适合中老年人和高血脂人群');
INSERT INTO `medicine` VALUES (47, '阿胶', '北京同仁堂通科药业', 'https://medicalsys-test.oss-cn-beijing.aliyuncs.com/2024-06-13/1.jpg', 22, 45, '补血滋阴、润燥止血，适用于血虚萎黄、眩晕心悸、心烦不眠、肺燥咳嗽等症状');

-- ----------------------------
-- Table structure for patient_tracking
-- ----------------------------
DROP TABLE IF EXISTS `patient_tracking`;
CREATE TABLE `patient_tracking`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '跟踪记录ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '病患ID',
  `tracking_date` date NULL DEFAULT NULL COMMENT '跟踪日期',
  `is_recovery` int(11) NULL DEFAULT NULL COMMENT '是否痊愈',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of patient_tracking
-- ----------------------------
INSERT INTO `patient_tracking` VALUES (1, 1, '2024-05-09', 1);
INSERT INTO `patient_tracking` VALUES (2, 1, '2024-05-01', 0);
INSERT INTO `patient_tracking` VALUES (3, 2, '2024-04-18', 1);
INSERT INTO `patient_tracking` VALUES (4, 3, '2024-05-09', 1);
INSERT INTO `patient_tracking` VALUES (5, 5, '2024-06-11', 0);
INSERT INTO `patient_tracking` VALUES (6, 2, '2023-11-20', 1);
INSERT INTO `patient_tracking` VALUES (7, 4, '2024-01-15', 1);
INSERT INTO `patient_tracking` VALUES (8, 6, '2024-03-01', 0);
INSERT INTO `patient_tracking` VALUES (9, 5, '2024-04-10', 1);
INSERT INTO `patient_tracking` VALUES (10, 6, '2024-06-13', 0);
INSERT INTO `patient_tracking` VALUES (11, 7, '2024-06-12', 1);
INSERT INTO `patient_tracking` VALUES (12, 8, '2024-05-25', 1);
INSERT INTO `patient_tracking` VALUES (13, 8, '2024-06-10', 1);
INSERT INTO `patient_tracking` VALUES (14, 9, '2024-07-01', 1);
INSERT INTO `patient_tracking` VALUES (15, 9, '2024-08-15', 1);
INSERT INTO `patient_tracking` VALUES (16, 3, '2024-11-15', 1);

-- ----------------------------
-- Table structure for physical_condition
-- ----------------------------
DROP TABLE IF EXISTS `physical_condition`;
CREATE TABLE `physical_condition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '身体情况ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `checkup_date` date NULL DEFAULT NULL COMMENT '检查日期',
  `height` decimal(5, 2) NULL DEFAULT NULL COMMENT '身高（单位：厘米）',
  `weight` decimal(5, 2) NULL DEFAULT NULL COMMENT '体重（单位：公斤）',
  `blood_pressure` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '血压',
  `heart_rate` int(11) NULL DEFAULT NULL COMMENT '心率（次/分钟）',
  `body_temperature` decimal(4, 1) NULL DEFAULT NULL COMMENT '体温（单位：摄氏度）',
  `symptoms` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '症状描述',
  `diagnosis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '诊断结果',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of physical_condition
-- ----------------------------
INSERT INTO `physical_condition` VALUES (1, 1, '2024-04-17', 180.00, 75.00, '130', 78, 36.1, '无', '良好');
INSERT INTO `physical_condition` VALUES (2, 2, '2024-05-01', 175.00, 70.00, '125', 75, 36.3, '无', '良好');
INSERT INTO `physical_condition` VALUES (3, 5, NULL, 169.00, 65.00, '125', 70, 36.2, '无', '良好');
INSERT INTO `physical_condition` VALUES (4, 2, '2024-04-18', 165.00, 55.00, '110/70', 68, 36.2, '轻度头痛', '注意休息');
INSERT INTO `physical_condition` VALUES (5, 3, '2024-04-19', 182.00, 80.00, '135/90', 80, 36.8, '偶尔胸闷', '建议进一步检查');
INSERT INTO `physical_condition` VALUES (6, 4, '2024-04-20', 158.00, 50.00, '105/65', 65, 36.0, '无', '健康');
INSERT INTO `physical_condition` VALUES (7, 5, '2024-04-21', 178.00, 72.00, '125/85', 75, 36.3, '背部疼痛', '可能是久坐导致');
INSERT INTO `physical_condition` VALUES (8, 6, '2024-04-22', 160.00, 60.00, '115/75', 70, 36.7, '轻微咳嗽', '可能是感冒');
INSERT INTO `physical_condition` VALUES (9, 7, '2024-04-23', 185.00, 85.00, '140/95', 85, 37.0, '高血压', '需要药物治疗');
INSERT INTO `physical_condition` VALUES (10, 8, '2024-04-24', 170.00, 65.00, '122/82', 78, 36.4, '无', '健康');
INSERT INTO `physical_condition` VALUES (11, 9, '2024-04-25', 162.00, 52.00, '108/68', 62, 36.1, '眼睛疲劳', '建议多休息');
INSERT INTO `physical_condition` VALUES (12, 10, '2024-04-26', 188.00, 90.00, '150/100', 90, 37.2, '高血压', '需要紧急处理');
INSERT INTO `physical_condition` VALUES (13, 11, '2024-04-27', 155.00, 48.00, '100/60', 60, 35.9, '无', '偏瘦');
INSERT INTO `physical_condition` VALUES (14, 12, '2024-04-28', 172.00, 70.00, '128/88', 76, 36.6, '偶尔头晕', '可能是低血压');
INSERT INTO `physical_condition` VALUES (15, 13, '2024-04-29', 167.00, 63.00, '118/78', 67, 36.9, '无', '健康');
INSERT INTO `physical_condition` VALUES (16, 14, '2024-04-30', 180.00, 82.00, '138/92', 82, 37.1, '高血糖', '需要控制饮食');

-- ----------------------------
-- Table structure for prescribePrice
-- ----------------------------
DROP TABLE IF EXISTS `prescribePrice`;
CREATE TABLE `prescribePrice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prescribe_id` int(11) NULL DEFAULT NULL,
  `prices` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prescribePrice
-- ----------------------------
INSERT INTO `prescribePrice` VALUES (1, 1, 20);
INSERT INTO `prescribePrice` VALUES (2, 2, 30);
INSERT INTO `prescribePrice` VALUES (3, 4, 60);
INSERT INTO `prescribePrice` VALUES (4, 9, 60);
INSERT INTO `prescribePrice` VALUES (5, 11, 60);
INSERT INTO `prescribePrice` VALUES (6, 12, 60);
INSERT INTO `prescribePrice` VALUES (7, 13, 340);
INSERT INTO `prescribePrice` VALUES (8, 14, 40);
INSERT INTO `prescribePrice` VALUES (9, 15, 20);
INSERT INTO `prescribePrice` VALUES (10, 16, 20);
INSERT INTO `prescribePrice` VALUES (11, 17, 0);
INSERT INTO `prescribePrice` VALUES (12, 18, 0);
INSERT INTO `prescribePrice` VALUES (13, 19, 0);
INSERT INTO `prescribePrice` VALUES (14, 20, 0);
INSERT INTO `prescribePrice` VALUES (15, 21, 0);
INSERT INTO `prescribePrice` VALUES (16, 22, 0);
INSERT INTO `prescribePrice` VALUES (17, 23, 0);
INSERT INTO `prescribePrice` VALUES (18, 24, 0);
INSERT INTO `prescribePrice` VALUES (19, 25, 20);
INSERT INTO `prescribePrice` VALUES (20, 26, 0);
INSERT INTO `prescribePrice` VALUES (21, 27, 0);
INSERT INTO `prescribePrice` VALUES (22, 28, 20);
INSERT INTO `prescribePrice` VALUES (23, 29, 0);
INSERT INTO `prescribePrice` VALUES (24, 30, 20);
INSERT INTO `prescribePrice` VALUES (25, 39, 0);
INSERT INTO `prescribePrice` VALUES (26, 40, 35);
INSERT INTO `prescribePrice` VALUES (27, 41, 30);
INSERT INTO `prescribePrice` VALUES (28, 42, 30);
INSERT INTO `prescribePrice` VALUES (29, 43, 35);
INSERT INTO `prescribePrice` VALUES (30, 44, 20);
INSERT INTO `prescribePrice` VALUES (31, 45, 20);
INSERT INTO `prescribePrice` VALUES (32, 46, 20);
INSERT INTO `prescribePrice` VALUES (33, 47, 35);
INSERT INTO `prescribePrice` VALUES (34, 48, 20);
INSERT INTO `prescribePrice` VALUES (35, 49, 30);
INSERT INTO `prescribePrice` VALUES (36, 50, 23);
INSERT INTO `prescribePrice` VALUES (37, 51, 30);
INSERT INTO `prescribePrice` VALUES (38, 52, 20);
INSERT INTO `prescribePrice` VALUES (39, 53, 20);
INSERT INTO `prescribePrice` VALUES (40, 54, 20);
INSERT INTO `prescribePrice` VALUES (41, 55, 20);
INSERT INTO `prescribePrice` VALUES (42, 56, 20);
INSERT INTO `prescribePrice` VALUES (43, 57, 23);
INSERT INTO `prescribePrice` VALUES (44, 58, 20);
INSERT INTO `prescribePrice` VALUES (45, 59, 20);
INSERT INTO `prescribePrice` VALUES (46, 60, 20);
INSERT INTO `prescribePrice` VALUES (47, 61, 0);

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '处方ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `medication_guide` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '处方详情',
  `create_time` date NULL DEFAULT NULL COMMENT '处方日期',
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '药剂师受理状态（未受理，已受理）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES (1, 1, '感冒灵x1', '2024-04-17', '已受理');
INSERT INTO `prescription` VALUES (2, 2, '消炎药x1', '2024-05-02', '未受理');
INSERT INTO `prescription` VALUES (3, 4, '安眠药x2', '2024-06-12', '未受理');
INSERT INTO `prescription` VALUES (4, 1, '999感冒灵x1；消炎药x1', '2024-05-10', '已拒绝');
INSERT INTO `prescription` VALUES (15, 1, '感冒灵x1', '2024-05-26', '已取消');
INSERT INTO `prescription` VALUES (16, 1, '感冒灵x1', '2024-05-26', '已取消');
INSERT INTO `prescription` VALUES (24, 5, '板蓝根颗粒×1；', '2024-06-01', '未受理');
INSERT INTO `prescription` VALUES (39, 1, '强力枇杷膏×1；', '2024-06-13', '已受理');
INSERT INTO `prescription` VALUES (40, 1, '板蓝根颗粒x1；', '2024-06-13', '已付款');
INSERT INTO `prescription` VALUES (46, 1, '感冒灵x1', '2024-06-13', '已付款');
INSERT INTO `prescription` VALUES (47, 1, '板蓝根颗粒x1；', '2024-06-13', '已付款');
INSERT INTO `prescription` VALUES (48, 1, '感冒灵x1；', '2024-06-13', '已付款');
INSERT INTO `prescription` VALUES (49, 1, '强力枇杷膏x1；', '2024-06-13', '已付款');
INSERT INTO `prescription` VALUES (50, 1, '健胃消食片x1；', '2024-06-14', '已受理');
INSERT INTO `prescription` VALUES (51, 1, '强力枇杷膏x1；', '2024-06-14', '已付款');
INSERT INTO `prescription` VALUES (54, 1, '感冒灵x1；', '2024-06-14', '已受理');
INSERT INTO `prescription` VALUES (55, 1, '感冒灵x1', '2024-06-14', '已受理');
INSERT INTO `prescription` VALUES (56, 1, '感冒灵x1', '2024-06-14', '已受理');
INSERT INTO `prescription` VALUES (57, 1, '健胃消食片x1', '2024-06-14', '已受理');
INSERT INTO `prescription` VALUES (58, 1, '感冒灵x1', '2024-06-14', '已受理');
INSERT INTO `prescription` VALUES (59, 1, '感冒灵x1；', '2024-06-14', '已付款');
INSERT INTO `prescription` VALUES (60, 1, '感冒灵x1', '2024-06-14', '已受理');
INSERT INTO `prescription` VALUES (61, 7, '早中晚饭后一包', '2024-06-14', '已受理');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复ID',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '关联的主题ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '回复用户的ID',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '回复内容',
  `reply_date` datetime NULL DEFAULT NULL COMMENT '回复日期',
  PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, 1, 1, '多喝热水', '2024-04-25 23:59:18');
INSERT INTO `reply` VALUES (2, 1, 2, '喝感冒灵', '2024-04-25 23:59:42');
INSERT INTO `reply` VALUES (3, 2, 1, '睡觉', '2024-04-26 00:00:04');
INSERT INTO `reply` VALUES (4, 1, 2, '注意保暖', NULL);
INSERT INTO `reply` VALUES (5, 1, 1, '太棒了', '2024-04-17 00:00:00');
INSERT INTO `reply` VALUES (6, 8, 1, '我支持你', '2024-05-20 00:00:00');
INSERT INTO `reply` VALUES (7, 8, 1, '十点半了', '2024-06-11 08:00:00');
INSERT INTO `reply` VALUES (8, 8, 1, '今天520哦', '2024-06-12 08:00:00');
INSERT INTO `reply` VALUES (9, 1, 1, '舍长在干嘛', '2024-05-28 00:00:00');
INSERT INTO `reply` VALUES (10, 5, 1, '余总说让你喝水', '2024-05-28 00:00:00');
INSERT INTO `reply` VALUES (11, 1, 1, '111', '2024-05-30 00:00:00');
INSERT INTO `reply` VALUES (12, 15, 1, '早点睡呀好兄弟', '2024-06-11 00:00:00');
INSERT INTO `reply` VALUES (13, 6, 1, '我的头发呢？', '2024-06-11 00:00:00');
INSERT INTO `reply` VALUES (14, 20, 20, '这篇指南非常实用，对我帮助很大。', '2024-04-18 00:00:00');
INSERT INTO `reply` VALUES (15, 2, 2, '很全面的文章，对高血压的成因有了更深的了解。', '2024-04-19 00:00:00');
INSERT INTO `reply` VALUES (16, 3, 3, '心理健康同样重要，不能忽视。', '2024-04-20 00:00:00');
INSERT INTO `reply` VALUES (17, 4, 4, '中医养生理念很独特，值得一试。', '2024-04-21 00:00:00');
INSERT INTO `reply` VALUES (18, 5, 5, '疫苗接种利大于弊，每个人都应该接种。', '2024-04-22 00:00:00');
INSERT INTO `reply` VALUES (19, 6, 6, '失眠真的很痛苦，这些方法很有效。', '2024-04-23 00:00:00');
INSERT INTO `reply` VALUES (20, 7, 7, '对于心脏病患者来说，日常护理非常重要。', '2024-04-24 00:00:00');
INSERT INTO `reply` VALUES (21, 8, 8, '每天运动一下，身体倍儿棒！', '2024-04-25 00:00:00');
INSERT INTO `reply` VALUES (22, 9, 9, '营养均衡的饮食是身体健康的基础。', '2024-04-26 00:00:00');
INSERT INTO `reply` VALUES (23, 10, 10, '勤洗手，戴口罩，预防流感从我做起。', '2024-04-27 00:00:00');
INSERT INTO `reply` VALUES (24, 11, 11, '骨质疏松不容忽视，要早预防早治疗。', '2024-04-28 00:00:00');
INSERT INTO `reply` VALUES (25, 12, 12, '癌症早期筛查是拯救生命的关键。', '2024-04-29 00:00:00');
INSERT INTO `reply` VALUES (26, 13, 13, '孕妇的营养和保健关系到宝宝的健康。', '2024-04-30 00:00:00');
INSERT INTO `reply` VALUES (27, 14, 14, '学会管理压力，保持心理健康。', '2024-05-01 00:00:00');
INSERT INTO `reply` VALUES (28, 15, 15, '关爱老年人，从健康管理开始。', '2024-05-02 00:00:00');
INSERT INTO `reply` VALUES (29, 16, 16, '青少年肥胖问题日益严重，需要引起重视。', '2024-05-03 00:00:00');
INSERT INTO `reply` VALUES (30, 17, 17, '中医与西医结合，治疗效果更佳。', '2024-05-04 00:00:00');
INSERT INTO `reply` VALUES (31, 18, 18, '儿童疫苗接种是保护孩子健康的重要措施。', '2024-05-05 00:00:00');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主题ID',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主题标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '主题内容',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '创建主题的用户ID',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (1, '如何治疗感冒', '一般治疗：感冒期间保持饮食清淡，避免进食辛辣刺激食物；保持健康的生活方式，避免熬夜；多饮水，多休息。\n物理治疗：多穿衣物、多盖被褥促使身体发汗，有助于将人体湿气排出体外；出现发热症状时，腋窝温度低于38.5℃可以采取物理降温方法，如温水擦浴、头部冷敷和贴退热贴等。\n药物治疗：发热时，若腋窝温度超过38.5℃，可遵医嘱服用对乙酰氨基酚片、布洛芬缓释胶囊等药物进行治疗；出现咳嗽症状，可服用氢溴酸右美沙芬片、盐酸氨溴索片等药物；若症状严重或伴有其他不良症状，需到医院就诊，遵医嘱进行治疗。', 1, '2024-06-11 08:00:00');
INSERT INTO `topic` VALUES (2, '如何快速缓解头疼', '热敷：对于寒冷刺激导致的头疼，可以通过热敷加快头部血液循环来缓解。\n按摩：使用食指和大拇指对头部疼痛区域进行按摩，放松肌肉，提高血液循环速度。\n服用药物：头疼症状严重时可适量服用非甾体类抗炎药，如布洛芬，但需注意药物可能带来的不良反应。', 1, '2024-06-11 08:00:00');
INSERT INTO `topic` VALUES (3, '如何快速缓解牙痛', '花椒、白酒：含一粒花椒或口含白酒可暂时缓解牙痛。\n盐水漱口：用淡盐水漱口，能够抑制细菌滋生，减少炎症反应。\n冰敷：对于肿胀明显的牙痛，冰敷有较好效果。\n大蒜：将大蒜捣碎后取汁含在口中约10分钟，可在一定程度上止痛。\n青柠汁：青柠汁中的柑橘酸可以杀死细菌，用滴管滴在牙齿上作为止痛药。', 1, '2024-06-11 08:00:00');
INSERT INTO `topic` VALUES (4, '如何治疗失眠', '建立良好的睡眠习惯：保持规律的睡眠时间表，营造舒适的睡眠环境。\n放松技巧：应用深呼吸、渐进性肌肉松弛、冥想、瑜伽等放松技巧帮助入睡。\n药物治疗：在失眠严重的情况下，医生可能会考虑使用处方药物，如艾司唑仑片、安神补心丸等，但需在医生监督和指导下使用。\n其他方法：适量锻炼、睡前避免摄入刺激物、认知行为疗法等也可帮助缓解失眠。', 1, '2024-06-11 08:00:00');
INSERT INTO `topic` VALUES (5, '如何治疗焦虑', '适量运动：运动可以分泌消除焦虑的化学物质，使精神得到放松。\n做感兴趣的事情：将注意力转移到自己喜欢的事情上，有助于缓解紧张情绪。\n情感宣泄：将紧张、不安的情绪告诉朋友、亲人或找一个安静的地方宣泄出来。\n及时就医：若焦虑症状严重影响到日常生活，应求助于专业医生进行心理治疗或药物治疗。', 1, '2024-06-11 08:00:00');
INSERT INTO `topic` VALUES (6, '如何治疗脱发', '药物疗法：使用米诺地尔酊等外用药物擦拭头皮，并服用非那雄胺片等药物治疗；同时可服用养血生发胶囊等中药制剂。\n头皮毛发种植术：若脱发严重，可考虑通过植发进行治疗。\n饮食和生活习惯调整：加强饮食调理，避免烫染头发，经常按摩头皮等也有助于改善脱发。', 1, '2024-06-11 08:00:00');
INSERT INTO `topic` VALUES (15, '如何缓解眼干', '热敷：选择热毛巾湿敷或一次性热敷眼罩，温度控制在40℃～43℃左右，每次10分钟～15分钟即可。热敷有助于促进眼部血液循环，缓解眼部疲劳和干涩。\n眼部按摩：用食指和中指轻拉眼角，分别由上往下、由下往上进行按摩，力度以不压迫眼球为准。眼部按摩可以帮助放松眼部肌肉，促进眼部血液循环，缓解眼干症状。\n佩戴湿房镜：湿房镜本身可以防紫外线、防辐射、防蓝光，其侧面有小孔可以打开往里面加入纯净水或遵医加入眼药水。湿房镜能够增加眼表周围的湿度，有助于缓解眼干症状。\n眼球操：主要是眨眼运动，可以右左右左轮流眨眼，右右左左各眨眼10次，双眼每秒1次、2次、3次进行练习。有意识的眨眼可以让身体记住眨眼频率，从而自然定期眨眼，保持眼睛湿润。\n健康饮食：增加维生素C含量较高的食物，如柠檬泡水、猕猴桃、西兰花等；以及富含维生素A的食物，如胡萝卜、绿茶、动物肝脏等。这些食物有助于改善眼部健康，缓解眼干症状。富含W-3的食物如秋刀鱼、核桃、瓜子、牡蛎等也对干眼病有一定的辅助治疗作用。\n注意眼部卫生：尽量避免烟尘环境，少接触空调等干燥环境。保持眼部清洁，避免用手揉眼。\n避免长时间使用电子产品：长时间对着电脑屏幕、手机等电子产品容易导致眼睛疲劳和干涩。建议每隔一段时间休息一下眼睛，看看远处或绿色植物。\n使用眼药水：如果眼睛特别干涩，可以选用不含防腐剂的人工泪液来快速补充水分，缓解眼睛干涩。但请注意，眼药水只能暂时缓解症状，不能从根本上解决问题。', 1, '2024-06-11 00:00:00');
INSERT INTO `topic` VALUES (16, '如何解决拖延症', '设定明确的目标：为自己设定清晰、具体的目标，确保你知道自己要做什么，以及何时完成。这有助于你保持专注，避免被其他事情分散注意力。\n制定详细的计划：为实现目标制定详细的步骤和时间表。将任务分解成小步骤，并为每个步骤设定截止日期。这样做可以帮助你更好地管理时间和资源，确保你按计划进行。\n采用时间管理技巧：学习时间管理技巧，如番茄工作法、时间分块等，以提高工作效率。这些技巧可以帮助你更好地分配时间，避免拖延。\n设定优先级：识别出最重要的任务，并优先处理它们。这可以确保你在有限的时间内完成最重要的工作，从而减少拖延的可能性。\n克服恐惧和焦虑：有时，拖延症可能是由于对任务或结果的恐惧和焦虑引起的。尝试识别这些情绪，并采取措施来克服它们，如进行深呼吸、冥想或寻求支持。\n建立奖惩机制：为自己设定奖励和惩罚措施，以激励自己按时完成任务。例如，完成一个任务后可以给自己一些小奖励，而未完成任务则可以给自己一些小惩罚。', 1, '2024-06-12 00:00:00');
INSERT INTO `topic` VALUES (17, '摔伤了怎么办', '初步评估：首先，需要评估摔伤的严重程度。如果只是轻微的擦伤或淤血，通常可以自行处理。但如果有明显的出血、骨折、关节脱位或头部受伤，应立即寻求医疗帮助。\n止血：如果有出血，应立即采取措施止血。可以用干净的纱布或布条直接压迫伤口，以控制出血。如果出血严重，可能需要使用止血带，但应注意每隔一段时间松开一次，以避免组织坏死。\n清洁伤口：对于开放的伤口，需要用清水或生理盐水冲洗干净，以去除伤口内的异物和污垢。然后，可以用碘伏或酒精消毒伤口周围的皮肤。\n冷敷与热敷：对于软组织损伤，如肿胀、疼痛等，可以在伤后48小时内进行冷敷，以减轻疼痛和肿胀。48小时后，可以改为热敷，以促进血液循环和淤血吸收。\n抬高患肢：如果摔伤的部位是四肢，应抬高患肢，以减少肿胀和疼痛。\n固定与制动：如果有骨折或关节脱位的情况，应避免移动受伤部位，并用夹板或绷带进行固定，以减少进一步的损伤。\n药物治疗：如果疼痛严重，可以遵医嘱口服非甾体类抗炎止痛药，如双氯芬酸钠缓释片等。对于开放性伤口，可能还需要使用抗生素来预防感染。\n就医检查：对于严重的摔伤，如头部受伤、骨折等，应尽快就医检查。医生可能会根据情况进行X光、CT等检查，以明确诊断并制定治疗方案。\n注意休息与饮食：摔伤后需要注意休息，避免剧烈运动和负重。同时，饮食上应注意清淡易消化，避免辛辣、刺激性食物，以免影响伤口愈合。', 1, '2024-06-12 00:00:00');
INSERT INTO `topic` VALUES (18, '糖尿病饮食指南', '关于糖尿病患者应如何合理控制饮食的讨论', 20, '2024-04-17 00:00:00');
INSERT INTO `topic` VALUES (19, '高血压的预防与治疗', '探讨高血压的成因、预防方法和治疗手段', 2, '2024-04-18 00:00:00');
INSERT INTO `topic` VALUES (20, '心理健康的重要性', '讨论心理健康对整体健康的影响和重要性', 3, '2024-04-19 00:00:00');
INSERT INTO `topic` VALUES (21, '中医养生之道', '分享中医的养生理念和健康保健方法', 4, '2024-04-20 00:00:00');
INSERT INTO `topic` VALUES (22, '疫苗接种的利与弊', '讨论疫苗接种的益处、风险以及个人选择', 5, '2024-04-21 00:00:00');
INSERT INTO `topic` VALUES (23, '失眠的治疗方法', '探讨失眠的成因和各种有效的治疗方法', 6, '2024-04-22 00:00:00');
INSERT INTO `topic` VALUES (24, '心脏病患者日常护理', '为心脏病患者提供日常护理的建议和指导', 7, '2024-04-23 00:00:00');
INSERT INTO `topic` VALUES (25, '运动对健康的益处', '讨论运动对身体健康的各种益处和重要性', 8, '2024-04-24 00:00:00');
INSERT INTO `topic` VALUES (26, '营养饮食的重要性', '强调营养饮食对身体健康的重要性', 9, '2024-04-25 00:00:00');
INSERT INTO `topic` VALUES (27, '如何预防流感', '分享预防流感的措施和注意事项', 10, '2024-04-26 00:00:00');
INSERT INTO `topic` VALUES (28, '骨质疏松的预防与治疗', '探讨骨质疏松的预防和治疗方法', 11, '2024-04-27 00:00:00');
INSERT INTO `topic` VALUES (29, '癌症的早期筛查', '讨论癌症早期筛查的重要性和方法', 12, '2024-04-28 00:00:00');
INSERT INTO `topic` VALUES (30, '孕期营养与保健', '为孕妇提供营养和保健方面的建议', 13, '2024-04-29 00:00:00');
INSERT INTO `topic` VALUES (31, '心理健康与压力管理', '讨论心理健康与压力管理的关系和方法', 14, '2024-04-30 00:00:00');
INSERT INTO `topic` VALUES (32, '老年人的健康管理', '分享老年人健康管理的策略和技巧', 15, '2024-05-01 00:00:00');
INSERT INTO `topic` VALUES (33, '青少年肥胖问题', '讨论青少年肥胖的成因、影响和解决方案', 16, '2024-05-02 00:00:00');
INSERT INTO `topic` VALUES (34, '中医与西医的结合治疗', '探讨中医与西医结合治疗的优势和实例', 17, '2024-05-03 00:00:00');
INSERT INTO `topic` VALUES (35, '儿童疫苗接种计划', '分享儿童疫苗接种的计划和注意事项', 18, '2024-05-04 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `full_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `user_avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像路径',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `signature` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '个性签名',
  `gender` int(11) NULL DEFAULT NULL COMMENT '性别（0：未知，1：男，2：女）',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `role` int(11) NULL DEFAULT NULL COMMENT '角色（0.用户，1.医生，2.药剂师，3.管理员）',
  `is_delete` int(11) NULL DEFAULT NULL COMMENT '是否逻辑删除',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '12345678', 'admin', '713', 'https://img.zcool.cn/community/01fec958158d43a84a0d304fc3c541.png@1280w_1l_2o_100sh.png', '123789456', 'xxx@qq.com', '上海关心你', 1, '2024-04-01', 11, 3, 0);
INSERT INTO `user` VALUES (2, 'xiaogao', '12345678', '小高', NULL, 'https://img.zcool.cn/community/01fec958158d43a84a0d304fc3c541.png@1280w_1l_2o_100sh.png', '12233333', 'xxx@qq.com', NULL, 0, '2002-02-01', 1, 1, 0);
INSERT INTO `user` VALUES (3, 'admin1', '12345678', '测试', '测试员', 'https://img.zcool.cn/community/01fec958158d43a84a0d304fc3c541.png@1280w_1l_2o_100sh.png', '13434413243', 'xxx@qq.com', '测试员的目标是提升用户体验感', 1, '2002-05-01', 25, 0, 0);
INSERT INTO `user` VALUES (4, 'cool', '12345678', 'eson陈', '连宇宙', 'https://foruda.gitee.com/avatar/1676566705652498709/9913536_xiao-chenago_1676566705.png!avatar200', '11012011911', 'xxx@qq.com', '没有问题解决不了我', 1, '2024-04-29', 35, 1, 0);
INSERT INTO `user` VALUES (5, 'user', '12345678', '用户1', NULL, 'https://img.zcool.cn/community/01fec958158d43a84a0d304fc3c541.png@1280w_1l_2o_100sh.png', NULL, 'xxx@qq.com', NULL, 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES (6, 'doctor', '12345678', '小梁', NULL, 'https://img.zcool.cn/community/01fec958158d43a84a0d304fc3c541.png@1280w_1l_2o_100sh.png', '985211', 'xxx@qq.com', '我不疯谁疯', 0, '2002-02-03', 18, 1, 0);
INSERT INTO `user` VALUES (7, 'lian', '12345678', '连大药剂师', NULL, 'https://img.zcool.cn/community/01fec958158d43a84a0d304fc3c541.png@1280w_1l_2o_100sh.png', NULL, 'xxx@qq.com', '原神启动', 0, NULL, 38, 2, 0);

-- ----------------------------
-- Table structure for user_doctor
-- ----------------------------
DROP TABLE IF EXISTS `user_doctor`;
CREATE TABLE `user_doctor`  (
  `user_id` int(15) NOT NULL,
  `doc_id` int(15) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_doctor
-- ----------------------------
INSERT INTO `user_doctor` VALUES (2, 1);
INSERT INTO `user_doctor` VALUES (4, 2);
INSERT INTO `user_doctor` VALUES (6, 6);
INSERT INTO `user_doctor` VALUES (7, 22);

SET FOREIGN_KEY_CHECKS = 1;
