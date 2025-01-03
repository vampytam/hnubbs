/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80400 (8.4.0)
 Source Host           : localhost:3306
 Source Schema         : hnubbs

 Target Server Type    : MySQL
 Target Server Version : 80400 (8.4.0)
 File Encoding         : 65001

 Date: 11/12/2024 20:50:01
*/
-- ----------------------------
-- Records of bbs_billboard
-- ----------------------------
INSERT INTO `bbs_billboard` VALUES (2, 'R1.0 开始已实现护眼模式 ,妈妈再也不用担心我的眼睛了。', '2024-12-01 16:09:31', 0);
INSERT INTO `bbs_billboard` VALUES (4, '系统已更新至最新版1.0.1', NULL, 1);

-- ----------------------------
-- Records of bbs_follow
-- ----------------------------
INSERT INTO `bbs_follow` VALUES (65, '1329723594994229250', '1317498859501797378');
INSERT INTO `bbs_follow` VALUES (85, '1332912847614083073', '1332636310897664002');
INSERT INTO `bbs_follow` VALUES (129, '1349290158897311745', '1349618748226658305');

-- ----------------------------
-- Records of bbs_post
-- ----------------------------
INSERT INTO `bbs_post` VALUES ('1333447953558765569', '1', '12\n2\n\n', '1349290158897311745', 0, 0, 77, b'0', b'0', 0, '2024-12-01 00:29:01', '2024-12-03 23:56:51');
INSERT INTO `bbs_post` VALUES ('1349362401438392322', '2024 健康，快乐', '2024的`FLAG`\n\n1. 技能进步\n2. 没有烦恼\n3. 发财 :smile:\n\n', '1349290158897311745', 0, 0, 21, b'0', b'0', 0, '2024-12-13 22:27:21', '2024-12-14 17:30:13');
INSERT INTO `bbs_post` VALUES ('1334481725322297346', 'hello，spring-security', ':hibiscus: spring-security\n\n', '1349290158897311745', 0, 0, 46, b'0', b'0', 0, '2024-12-03 20:56:51', NULL);
INSERT INTO `bbs_post` VALUES ('1332650453142827009', '哈哈哈，helloworld', '这是第一篇哦\n\n> hi :handshake: 你好\n\n`hello world`\n\n:+1: 很好\n', '1349290158897311745', 0, 0, 29, b'0', b'0', 1, '2024-11-28 19:40:02', '2024-11-28 19:46:39');
INSERT INTO `bbs_post` VALUES ('1333432347031646209', '哈哈哈，换了个dark主题', '主题更换为Dark\n\n', '1349290158897311745', 0, 0, 6, b'0', b'0', 0, '2024-11-30 23:27:00', NULL);
INSERT INTO `bbs_post` VALUES ('1333668258587750401', '嘿嘿，测试一下啊', '大家好\n`Hello everyone!`\n\n\n\n', '1349290158897311745', 0, 0, 7, b'0', b'0', 0, '2024-12-01 15:04:26', '2024-12-01 16:49:14');
INSERT INTO `bbs_post` VALUES ('1332682473151635458', '我要发财', '2024 冲冲冲！！！\n\n', '1349290158897311745', 0, 0, 94, b'0', b'0', 2, '2024-11-28 21:47:16', '2024-11-30 19:40:22');
INSERT INTO `bbs_post` VALUES ('1333695976536748034', '最新版本介绍，同步更新！', '<p align=center>一款基于SpringBoot构建的智慧社区系统</p>\n\n<p align=center>\n<a href=\"https://github.com/1020317774/rhapsody-admin/stargazers\"><img alt=\"GitHub release\" src=\"https://img.shields.io/github/release/1020317774/rhapsody-admin?style=flat-square\"></a>\n<a href=\"https://github.com/1020317774/rhapsody-admin/blob/main/LICENSE\"><img alt=\"GitHub license\" src=\"https://img.shields.io/github/license/1020317774/rhapsody-admin\"></a>\n</p>\n\n### Hi there :wave:\n\n<!--\n**1020317774/1020317774** is a :sparkles: _special_ :sparkles: repository because its `README.md` (this file) appears on your GitHub profile.\n\nHere are some ideas to get you started:\n\n- :telescope: I’m currently working on ...\n- :seedling: I’m currently learning ...\n- :dancers: I’m looking to collaborate on ...\n- :thinking: I’m looking for help with ...\n- :speech_balloon: Ask me about ...\n- :mailbox: How to reach me: ...\n- :smile: Pronouns: ...\n- :zap: Fun fact: ...\n-->\n\n[![1020317774\'s github stats](https://github-readme-stats.vercel.app/api?username=1020317774&show_icons=true&count_private=true)](https://github.com/1020317774)\n\n[![Top Langs](https://github-readme-stats.vercel.app/api/top-langs/?username=1020317774&layout=compact)](https://github.com/1020317774)\n---------\n\n> 作者：王一晨\n> github：[https://github.com/1020317774](https://github.com/1020317774)\n\n## 技术栈\n\n- [x] SpringBoot 2.X\n- [x] Mysql 8.X\n- [x] Mybatis\n- [x] MybatisPlus\n- [x] Redis\n- [x] Jwt\n- [x] FastJson\n- [x] Hutool\n- [x] Lombok\n- [ ] ElasticSearch\n\n……\n\n## 安装指导\n\n- 克隆\n\n```java\ngit clone https://github.com/1020317774/rhapsody-admin.git\n```\n\n- 修改`application.properties`选择环境\n- 修改多环境配置中的redis参数和数据库\n- 启动`BootApplication`\n- 访问[`http://127.0.0.1:10000`](http://127.0.0.1:10000)\n\n', '1349290158897311745', 0, 0, 45, b'1', b'1', 0, '2024-12-01 16:54:34', '2024-12-01 17:05:00');
INSERT INTO `bbs_post` VALUES ('1349631541260595202', '权限部分 OK', '1. 创建 ok\n2. 修改 ok\n3. 删除 ok\n\n', '1349290158897311745', 0, 0, 21, b'0', b'0', 0, '2024-12-14 16:16:49', '2024-12-14 16:18:53');
INSERT INTO `bbs_post` VALUES ('1333676096156528641', '测试', '测试\n\n', '1349290158897311745', 0, 0, 38, b'0', b'0', 0, '2024-12-01 15:35:34', NULL);
INSERT INTO `bbs_post` VALUES ('1332681213400817665', '聚合查询并统计', '* [x] SQL：\n\n```sql\nSELECT s.*,\nCOUNT(t.id) AS topics\nFROM section s\nLEFT JOIN topic t\nON s.id = t.section_id\nGROUP BY s.title\n```\n\n', '1349290158897311745', 0, 0, 55, b'0', b'0', 1, '2024-11-28 21:42:16', '2024-11-29 15:00:42');
INSERT INTO `bbs_post` VALUES ('1335149981733449729', '视频嵌入', ':+1:\n\n[https://www.bilibili.com/video/BV1w64y1f7w3](https://www.bilibili.com/video/BV1w64y1f7w3)\n\n[1](https://www.bilibili.com/video/BV1tp4y1x72w)\n\n```\n.vditor-reset pre > code\n```\n\n```\npublic class HelloWorld {\n\npublic static void main(String[] args) {\n    System.out.println(\"Hello World!\");\n}\n}\n```\n\n', '1349290158897311745', 0, 0, 41, b'0', b'0', 0, '2024-12-05 17:12:16', '2024-12-14 13:06:16');

-- ----------------------------
-- Records of bbs_post_tag
-- ----------------------------
INSERT INTO `bbs_post_tag` VALUES (36, '1332650453377708034', '1332650453142827009');
INSERT INTO `bbs_post_tag` VALUES (37, '1332681213568589825', '1332681213400817665');
INSERT INTO `bbs_post_tag` VALUES (38, '1332681213631504385', '1332681213400817665');
INSERT INTO `bbs_post_tag` VALUES (39, '1332682473218744321', '1332682473151635458');
INSERT INTO `bbs_post_tag` VALUES (40, '1332913064463794178', '1332913064396685314');
INSERT INTO `bbs_post_tag` VALUES (41, '1332913064530903041', '1332913064396685314');
INSERT INTO `bbs_post_tag` VALUES (42, '1333432347107143681', '1333432347031646209');
INSERT INTO `bbs_post_tag` VALUES (43, '1333432347107143682', '1333432347031646209');
INSERT INTO `bbs_post_tag` VALUES (44, '1333447953697177602', '1333447953558765569');
INSERT INTO `bbs_post_tag` VALUES (45, '1332913064463794178', '1333668258587750401');
INSERT INTO `bbs_post_tag` VALUES (46, '1333676096320106498', '1333676096156528641');
INSERT INTO `bbs_post_tag` VALUES (47, '1333695976742268930', '1333695976536748034');
INSERT INTO `bbs_post_tag` VALUES (48, '1334481725519429634', '1334481725322297346');
INSERT INTO `bbs_post_tag` VALUES (49, '1333447953697177602', '1335149981733449729');
INSERT INTO `bbs_post_tag` VALUES (50, '1349362401597775874', '1349362401438392322');
INSERT INTO `bbs_post_tag` VALUES (51, '1349631541306732545', '1349631541260595202');

-- ----------------------------
-- Records of bbs_promotion
-- ----------------------------
INSERT INTO `bbs_promotion` VALUES (1, '开发者头条', 'https://juejin.cn/', '开发者头条');
INSERT INTO `bbs_promotion` VALUES (2, '并发编程网', 'https://juejin.cn/', '并发编程网');
INSERT INTO `bbs_promotion` VALUES (3, '掘金', 'https://juejin.cn/', '掘金');

-- ----------------------------
-- Records of bbs_tag
-- ----------------------------
INSERT INTO `bbs_tag` VALUES ('1332650453377708034', 'java', 1);
INSERT INTO `bbs_tag` VALUES ('1332681213568589825', 'css', 1);
INSERT INTO `bbs_tag` VALUES ('1332681213631504385', 'mongodb', 1);
INSERT INTO `bbs_tag` VALUES ('1332682473218744321', 'python', 1);
INSERT INTO `bbs_tag` VALUES ('1332913064463794178', 'vue', 2);
INSERT INTO `bbs_tag` VALUES ('1332913064530903041', 'react', 1);
INSERT INTO `bbs_tag` VALUES ('1333432347107143681', 'node', 1);
INSERT INTO `bbs_tag` VALUES ('1333432347107143682', 'mysql', 1);
INSERT INTO `bbs_tag` VALUES ('1333447953697177602', 'flask', 2);
INSERT INTO `bbs_tag` VALUES ('1333676096320106498', 'spring', 1);
INSERT INTO `bbs_tag` VALUES ('1333695976742268930', 'django', 1);
INSERT INTO `bbs_tag` VALUES ('1334481725519429634', 'security', 1);
INSERT INTO `bbs_tag` VALUES ('1349362401597775874', 'tensorflow', 1);
INSERT INTO `bbs_tag` VALUES ('1349631541306732545', 'pytorch', 1);

-- ----------------------------
-- Records of bbs_tip
-- ----------------------------
INSERT INTO `bbs_tip` VALUES (1, '多锉出快锯，多做长知识。', '佚名', 1);
INSERT INTO `bbs_tip` VALUES (2, '未来总留着什么给对它抱有信心的人。', '佚名', 1);
INSERT INTO `bbs_tip` VALUES (3, '一个人的智慧不够用，两个人的智慧用不完。', '谚语', 1);
INSERT INTO `bbs_tip` VALUES (4, '十个指头按不住十个跳蚤', '傣族', 1);
INSERT INTO `bbs_tip` VALUES (5, '言不信者，行不果。', '墨子', 1);
INSERT INTO `bbs_tip` VALUES (6, '攀援而登，箕踞而遨，则几数州之土壤，皆在衽席之下。', '柳宗元', 1);
INSERT INTO `bbs_tip` VALUES (7, '美德大都包含在良好的习惯之内。', '帕利克', 1);
INSERT INTO `bbs_tip` VALUES (8, '人有不及，可以情恕。', '《晋书》', 1);
INSERT INTO `bbs_tip` VALUES (9, '明·吴惟顺', '法不传六耳', 1);
INSERT INTO `bbs_tip` VALUES (10, '真正的朋友应该说真话，不管那话多么尖锐。', '奥斯特洛夫斯基', 1);
INSERT INTO `bbs_tip` VALUES (11, '时间是一切财富中最宝贵的财富。', '德奥弗拉斯多', 1);
INSERT INTO `bbs_tip` VALUES (12, '看人下菜碟', '民谚', 1);
INSERT INTO `bbs_tip` VALUES (13, '如果不是怕别人反感，女人决不会保持完整的严肃。', '拉罗什福科', 1);
INSERT INTO `bbs_tip` VALUES (14, '爱是春暖花开时对你满满的笑意', '佚名', 1);
INSERT INTO `bbs_tip` VALUES (15, '希望是坚韧的拐杖，忍耐是旅行袋，携带它们，人可以登上永恒之旅。', '罗素', 1);
INSERT INTO `bbs_tip` VALUES (18, '天国般的幸福，存在于对真爱的希望。', '佚名', 1);
INSERT INTO `bbs_tip` VALUES (19, '我们现在必须完全保持党的纪律，否则一切都会陷入污泥中。', '马克思', 1);
INSERT INTO `bbs_tip` VALUES (20, '在科学上没有平坦的大道，只有不畏劳苦沿着陡峭山路攀登的人，才有希望达到光辉的顶点。', '马克思', 1);
INSERT INTO `bbs_tip` VALUES (21, '懒惰的马嫌路远', '蒙古', 1);
INSERT INTO `bbs_tip` VALUES (22, '别忘记热水是由冷水烧成的', '非洲', 1);

-- ----------------------------
-- Records of bbs_user
-- ----------------------------
INSERT INTO `bbs_user` VALUES ('1349290158897311745', 'admin', 'admin', '$2a$10$8qx711TBg/2hxfL7N.sxf.0ROMhR/iuPhQx33IFqGd7PLgt5nGJTO', 'https://s3.ax1x.com/2024/12/01/DfHNo4.jpg', '23456@qq.com', NULL, 2, '', '自由职业者', b'1', b'1', NULL, '2024-12-13 17:40:17', NULL);
INSERT INTO `bbs_user` VALUES ('1349618748226658305', 'zhangsan', 'zhangsan', '$2a$10$7K3yYv8sMV5Xsc2facXTcuyDo8JQ4FJHvjZ7qtWYcJdei3Q6Fvqdm', 'https://s3.ax1x.com/2024/12/01/DfHNo4.jpg', '23456@qq.com', NULL, 0, '', '自由职业者', b'1', b'1', NULL, '2024-12-14 15:25:59', NULL);
INSERT INTO `bbs_user` VALUES ('1866826591419006977', 'hhhh', 'hhhh', '9b112425b7118575f612ffd8110e87a8', 'https://s3.ax1x.com/2024/12/01/DfHNo4.jpg', 'seikwan@sina.com', NULL, 0, '', '这个人很懒，什么都没有留下', b'1', b'1', NULL, '2024-12-11 20:45:18', NULL);