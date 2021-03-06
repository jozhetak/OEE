<#include "Configs.java">
<#include "Macros.java">
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.aleph5.${app_name}.mapper.${object}Mapper">

    <delete id="deleteAllById">
        DELETE FROM ${toUnderScore(object)}
        WHERE id IN
        <foreach item="item" index="index" collection="list" open="(" separator="," close=")">
            ${sc}{item}
        </foreach>
    </delete>

</mapper>
