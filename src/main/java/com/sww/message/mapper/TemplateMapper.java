package com.sww.message.mapper;

import com.sww.message.entity.Template;
import org.apache.ibatis.annotations.Insert;

public interface TemplateMapper {

    @Insert("insert into template(type, template_name, templateid, autograph, content)values(#{type}, #{template_name}," +
            " #{templateid}, #{autograph}, #{content})")
    int add(Template template);
}
