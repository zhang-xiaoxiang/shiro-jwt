/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : lvyou

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 14/07/2019 09:55:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户主键ID',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `user_password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户登录密码',
  `user_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `user_email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱地址',
  `user_autonym` int(3) NULL DEFAULT NULL COMMENT '用户身份认证 (0未认证,1已认证)',
  `user_site` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户地址',
  `user_sex` int(1) NULL DEFAULT NULL COMMENT '用户性别( 0女,1男)',
  `user_date_birth` datetime(0) NULL DEFAULT NULL COMMENT '用户出生日期',
  `user_signature` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户个性签名',
  `user_guide` int(3) NULL DEFAULT 0 COMMENT '是否导游',
  `user_vip` int(3) NULL DEFAULT NULL COMMENT '用户是否会员 ( 0否1是)',
  `user_integral` int(32) NULL DEFAULT NULL COMMENT '用户积分',
  `c_id` varchar(64) CHARACTER SET tis620 COLLATE tis620_thai_ci NULL DEFAULT NULL COMMENT '移动设备唯一cid',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '用户注册时间',
  `wx_openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信openID',
  `wx_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信头像',
  `qq_openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQopenID',
  `qq_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ头像',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '客户端用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1560160331180405455', '长草颜团子(张晓祥)', '18883173476', 'e265048be258b4c63e2e0ac78a19ec1e', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-06-24/b89287a4f70043ab95a72c0d46a9abab-ytz.jpg', '1090510535@qq.com', 0, '重庆市-江北区-江北城 南方上格林', 1, '1992-06-12 08:00:00', '遥知不是雪,牙巴都笑缺!', 0, 0, 2, '3', '2019-06-10 17:52:11', 'Please fill in the wxopenid', 'Please fill in the  wxIcon', 'Please fill in the qqOpenid', 'Please fill in the  qqIcon');
INSERT INTO `user` VALUES ('1560160331180408888', '张大仙', '18888888888', '123456', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-06-24/b89287a4f70043ab95a72c0d46a9abab-ytz.jpg', '1090510535@qq.com', 0, '重庆市-江北区-江北城 南方上格林', 1, '1992-06-12 08:00:00', '遥知不是雪,牙巴都笑缺!', 0, 0, 2, '3', '2019-06-10 17:52:11', 'Please fill in the wxopenid', 'Please fill in the  wxIcon', 'Please fill in the qqOpenid', 'Please fill in the  qqIcon');
INSERT INTO `user` VALUES ('1560396402586773424', '那撸多(程航)', '18723373086', 'db50eb75559387c06aac7fcae4210046', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2019-06-13 11:26:43', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('1562550499621821132', '老板娘', '17302314959', '74178cb9cade30fd0f4ecc00a1259852', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-07-08/8d804f9c700f498ea28037bc95c2f667-user_default.png', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2019-07-08 09:48:20', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('1562810641854947231', NULL, '18323495263', 'c55a2c0e5b63faa62ce5a58e3f96931b', 'https://xinzuolvyou.oss-cn-beijing.aliyuncs.com/images/2019-07-08/8d804f9c700f498ea28037bc95c2f667-user_default.png', NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, '2019-07-11 10:04:02', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
