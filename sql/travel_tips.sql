/*新增游记表单travel_tips` 
DROP TABLE  `travel_tips`;*/

CREATE TABLE `travel_tips` (
  `tipId` VARCHAR(32) COLLATE utf8_bin NOT NULL,	#编号
  `shareTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,	#分享时间
  `address` VARCHAR(32) COLLATE utf8_bin NOT NULL,	#目标地点
  `author` VARCHAR(32) COLLATE utf8_bin NOT NULL,	#作者
  `introduction` VARCHAR(500) COLLATE utf8_bin NOT NULL,	#简介
  `url` VARCHAR(100) COLLATE utf8_bin DEFAULT NULL, #攻略网站
  `readCount` INT(11) DEFAULT NULL, #阅读次数
  PRIMARY KEY (`tipId`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `travel_tips` */

INSERT  INTO `travel_tips`(`tipId`,`shareTime`,`address`,`author`,`introduction`,`url`, `readCount`) 
VALUES 
('10001','2023-02-03 12:00:00','黄山', 'sail', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10002','2022-09-03 12:00:00','巢湖', 'Bking', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10003','2023-04-03 12:00:00','重庆', 'settle', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10004','2022-12-03 12:00:00','泰山', '阿斯达', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10005','2022-06-03 12:00:00','恒山', '云云', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10006','2023-03-03 12:00:00','九寨沟', 'sail', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10007','2022-10-03 12:00:00','庐山', '卡达', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10008','2023-01-03 12:00:00','放马滩', '伊尔弎丝雾', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10009','2022-11-03 12:00:00','逍遥津森林公园', '小林', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10010','2022-09-03 12:00:00','灵隐寺', '东方', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10011','2021-12-03 12:00:00','千岛湖', '阿萨德', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0),
('10012','2022-04-03 12:00:00','重庆大渡口', '大东', '暂无', 'https://m.mafengwo.cn/mmobile/wanfaguide/?gid=405132&aggregate_id=1110000010117530305&source=default', 0);


