package com.comp62542.backend;

import com.comp62542.backend.dao.ActivityMapper;
import com.comp62542.backend.dao.CourseMapper;
import com.comp62542.backend.entity.Activity;
import com.comp62542.backend.util.CommonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = BackendApplication.class)
public class MapperTest {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void testSelectActivityByStudentId() {
        List<Activity> activity = activityMapper.selectByStudentId("10872364");
        System.out.println(activity.get(0));
    }

    @Test
    public void testSelectActivityById() {
        Activity activity = activityMapper.selectById(1);
        System.out.println(activity);
    }

    @Test
    public void testSelectActivityByActivityId() {
        Activity activity = activityMapper.selectByActivityId("100");
        System.out.println(activity);
    }

    @Test
    public void testSelectActivityByName() {
        Activity activity = activityMapper.selectByActivityName("Meeting with supervisor");
        System.out.println(activity);
    }

    @Test
    public void testInsertActivity() {
        Activity activity = new Activity();
        activity.setActivityId(CommonUtils.generateUUID());
        activity.setActivityName("test");
        activity.setType("tutorial");
        activity.setTime("3-1300-1400");
        activity.setStudentId("10872364");
        System.out.println(activityMapper.insertActivity(activity));

    }

    @Test
    public void testSelectAllCourse() {
        System.out.println(courseMapper.selectAllCourse());
    }

    @Test
    public void testInsertCourse() {
        System.out.println(courseMapper.insertCourse("COMP62542", "10872364"));
    }

    @Test
    public void testSelectCoursesByStudentId() {
        System.out.println(courseMapper.selectCoursesByStudentId("10872364"));
    }

}
