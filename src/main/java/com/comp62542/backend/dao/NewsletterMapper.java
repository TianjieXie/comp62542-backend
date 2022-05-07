package com.comp62542.backend.dao;

import com.comp62542.backend.entity.Newsletter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsletterMapper {

    @Select({
            "select id, newsletterID, newsletterName, content from newsletter"
    })
    @ResultType(Newsletter.class)
    List<Newsletter> selectAllNewsletter();

    @Select({
            "select newsletter.id, newsletterName, newsletter.newsletterID, content " +
                    "from newsletter inner join subscription s on newsletter.newsletterID = s.newsletterID " +
                    "where s.newsletterID=#{newsletterId} and s.studentID=#{studentId}"
    })
    Newsletter selectNewsletterByStudentIdAndNewsletterId(String studentId, String newsletterId);

    @Insert({
            "insert into subscription (newsletterid, studentid) values(#{newsletterId}, #{studentId}) "
    })
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertNewsletter(@Param("studentId")String studentId, @Param("newsletterId")String newsletterId);
}
