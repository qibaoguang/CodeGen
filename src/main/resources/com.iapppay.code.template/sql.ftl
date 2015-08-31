-- ----------------------------
-- Table structure for `${tableName}`
-- ----------------------------
CREATE TABLE `${tableName}` (
  <#list columns as col>
  `${col.outName}` ${col.outType} NOT NULL COMMENT '',
  </#list>
  PRIMARY KEY (`_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='_CMT';