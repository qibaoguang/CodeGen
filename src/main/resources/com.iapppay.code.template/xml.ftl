<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC 
	"-//mybatis.org//DTD Mapper 3.0//EN" 
	" http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${nameSpace}">

	<resultMap type="${clazz}"
		id="${clazzName}Map">
		<#list columns as col>
		<result column="${col.outName}" property="${col.primitiveName}" />
		</#list>
	</resultMap>

	<sql id="template">
		<#list columns as col>
		${col.outName}<#if col_has_next>,</#if>
		</#list>
	</sql>
	
	<#assign out = "#" mid="{" close = "}">
	 
	<update id="save" parameterType="${clazz}">
		insert into `${tableName}`(
			<include refid="template" />
		)values(
		<#list columns as col>
		${out}${mid}${col.primitiveName}${close}<#if col_has_next>,</#if>
		</#list>
		)
	</update>

	<select id="load" resultMap="${clazzName}Map">
		select
		<include refid="template" />
		from `${tableName}`
	</select>
	
</mapper>
