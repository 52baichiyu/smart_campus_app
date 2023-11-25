/*
 Navicat Premium Data Transfer

 Source Server         : 新服务器一号
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : 139.159.232.210:3310
 Source Schema         : magic

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 25/11/2023 05:57:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account_bind
-- ----------------------------
DROP TABLE IF EXISTS `account_bind`;
CREATE TABLE `account_bind`  (
  `user_code` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'DEFAULT_CODE' COMMENT 'DEFAULT_CODE',
  `student_number` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`student_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of account_bind
-- ----------------------------
INSERT INTO `account_bind` VALUES ('oB5SN6OSPHPcg0EeQOeeXx62i90U', '2000300704');
INSERT INTO `account_bind` VALUES ('DEFAULT_CODE', '2000301312');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程号',
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程名',
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '老师',
  `semester` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学期',
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '周次',
  `a_b` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '星期几，第几大节,两个字符用逗号隔开存储',
  `week` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '上课周数，从第几周开始，到第几周结束，两个字符使用逗号隔开',
  `place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '上课教室',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '系统备注',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课程性质',
  `assess_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '考核方式',
  `credits` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学分',
  PRIMARY KEY (`course_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document`  (
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文档标题，要求无后缀',
  `publish_people` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发布人',
  `date` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '跳转的地址\n',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `document_id_uindex`(`id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES ('【榜样】李华：做自己热爱的事、追求内心的宁静', 'ctfliar', '2023-11-11 21:16:30', 1, 'https://www.guet.edu.cn/2023/1110/c6356a111895/page.htm');
INSERT INTO `document` VALUES ('【科技前沿】第38期：我校硕士研究生在管理科学与工程领域主流期刊发表多篇高水平论文（图）', 'ctfliar', '2023-11-10 21:17:21', 2, 'https://www.guet.edu.cn/2023/1110/c6356a111894/page.htm');

-- ----------------------------
-- Table structure for payment_record
-- ----------------------------
DROP TABLE IF EXISTS `payment_record`;
CREATE TABLE `payment_record`  (
  `bill_no` int NOT NULL COMMENT '消费记录的消费单号',
  `date` datetime NULL DEFAULT NULL COMMENT '消费时间',
  `payament` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消费金额',
  `home_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '宿舍号',
  `card_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '校园卡号',
  PRIMARY KEY (`bill_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of payment_record
-- ----------------------------
INSERT INTO `payment_record` VALUES (12333, '2023-11-16 21:12:49', '12', '11#111', '1233');
INSERT INTO `payment_record` VALUES (12433, '2023-11-17 16:28:08', '20', '18#226', '1233');
INSERT INTO `payment_record` VALUES (24333, '2023-11-18 21:12:49', '23', '11#111', '1233');

-- ----------------------------
-- Table structure for recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `recharge_record`;
CREATE TABLE `recharge_record`  (
  `bill_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '充值单号',
  `date` datetime NULL DEFAULT NULL COMMENT '充值时间',
  `recharge_amount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '充值记录的充值金额',
  `home_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '宿舍号',
  `card_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '校园卡号',
  `student_card_recharge` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'false' COMMENT '通过这个参数判断是不是校园卡充值的记录',
  PRIMARY KEY (`bill_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of recharge_record
-- ----------------------------
INSERT INTO `recharge_record` VALUES ('06de684e60054ffb81e60ed35f9391e8', '2023-11-23 15:22:18', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('098e60e9-916b-4ff0-ba95-7f010f511433', '2023-11-22 08:18:43', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('09c87833-94fe-4430-ae43-96a2642fc03d', '2023-11-22 08:09:55', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('0b31e2b026ab42a98ac5d9852c14a197', '2023-11-23 15:24:07', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('12', '2023-11-16 21:13:54', '456', '11#111', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('12222', '2023-11-16 21:13:54', '12', '11#111', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('12322', '2023-11-15 16:28:50', '2', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('1feebdd2d6484729aa52d9aff39102dd', '2023-11-22 08:28:23', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('20c9f642c5f446eeb8051fdf102c069d', '2023-11-22 08:29:52', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('2d6cbc8fe8f34474a312f91075bcdd5b', '2023-11-23 14:59:31', '1', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('31ee19f3a08d4a439830fba1fb341b89', '2023-11-22 08:26:45', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('337fa5a811f74e77b26db99db4bcb0c4', '2023-11-23 19:01:42', '1', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('465c881aef3c4a8eba590387282f7e94', '2023-11-23 08:41:50', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('6b900c5b81be4268a1dd901ec5acfd5a', '2023-11-22 08:26:02', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('86bd3360aeb243c496d117ac9644811c', '2023-11-22 21:15:36', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('9711cd46af8d477eb09eeff0f4c36d69', '2023-11-23 15:23:08', '9', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('9f5798ced7094f16a4264260fed72d66', '2023-11-23 15:31:36', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('a5aa1aa3f7974e088753d2c58438f605', '2023-11-23 15:00:46', '20', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('b17d9b5e1fa7474086002ba0cddb129c', '2023-11-23 19:25:41', '20', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('bfa3649d9eab4f4dad969d123e8f82b5', '2023-11-23 19:25:41', '20', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('c44fcd60-ff22-40b6-9647-f17dba623168', '2023-11-22 08:16:34', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('d91ede2641e946b68fd3262e24cdcab7', '2023-11-23 19:20:14', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('efb38ba0bd274823ab03c4023d4077a2', '2023-11-23 15:29:05', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('f041c5210ca74763a401c22087b55e12', '2023-11-23 19:20:14', '10', '18#226', '1233', 'false');
INSERT INTO `recharge_record` VALUES ('fcb8454b8c594dfb92d83377e9c38d09', '2023-11-23 15:01:51', '20', '18#226', '1233', 'true');
INSERT INTO `recharge_record` VALUES ('ff9b259e6d0844358fbadcc700b30517', '2023-11-23 19:01:43', '1', '18#226', '1233', 'true');

-- ----------------------------
-- Table structure for student_account
-- ----------------------------
DROP TABLE IF EXISTS `student_account`;
CREATE TABLE `student_account`  (
  `stundent_number` int NULL DEFAULT NULL COMMENT '学号',
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `sex` bit(1) NULL DEFAULT NULL COMMENT '0表示男的，1表示女的',
  `specialized` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '专业',
  `school_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学校名称',
  `academy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学院',
  `home_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '宿舍号',
  `home_money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '30' COMMENT '宿舍剩余电费'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student_account
-- ----------------------------
INSERT INTO `student_account` VALUES (2000300704, '沈', b'1', '软件工程', '桂电', '三院', '18#226', '212');

-- ----------------------------
-- Table structure for student_card
-- ----------------------------
DROP TABLE IF EXISTS `student_card`;
CREATE TABLE `student_card`  (
  `student_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '需要输入，不能修改',
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '绑定时候不需要输入',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '需要输入，不可修改',
  `card_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `card_money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '30' COMMENT '校园卡余额'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student_card
-- ----------------------------
INSERT INTO `student_card` VALUES ('2000300704', '沈', '123456', '1233', '30');
INSERT INTO `student_card` VALUES ('2000301312', 'yu', 'asd213', '123144', '30');

SET FOREIGN_KEY_CHECKS = 1;
