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

 Date: 20/11/2023 15:14:52
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
INSERT INTO `account_bind` VALUES ('DEFAULT_CODE', '2000300704');
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
  PRIMARY KEY (`bill_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of recharge_record
-- ----------------------------
INSERT INTO `recharge_record` VALUES ('12', '2023-11-16 21:13:54', '456', '11#111', '1233');
INSERT INTO `recharge_record` VALUES ('12222', '2023-11-16 21:13:54', '12', '11#111', '1233');
INSERT INTO `recharge_record` VALUES ('12322', '2023-11-15 16:28:50', '2', '18#226', '1233');

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
  `home_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '宿舍号'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student_account
-- ----------------------------
INSERT INTO `student_account` VALUES (2000300704, '沈', b'1', '软件工程', '桂电', '三院', '18#226');

-- ----------------------------
-- Table structure for student_card
-- ----------------------------
DROP TABLE IF EXISTS `student_card`;
CREATE TABLE `student_card`  (
  `student_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '需要输入，不能修改',
  `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '绑定时候不需要输入',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '需要输入，不可修改',
  `card_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student_card
-- ----------------------------
INSERT INTO `student_card` VALUES ('2000300704', '沈', '123456', '1233');

SET FOREIGN_KEY_CHECKS = 1;
