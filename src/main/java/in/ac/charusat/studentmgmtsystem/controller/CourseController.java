package in.ac.charusat.studentmgmtsystem.controller;


import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
//    List<Course> Courses = new ArrayList<>(
//            Arrays.asList(
//                    new Course(1, "Tom", "US"),
//                    new Course(2, "Harry", "Canada"),
//                    new Course(3, "Nick", "UK")
//            )
//    );

    // Mappings - URL endpoints
    // Get the list of all Course
    @GetMapping("/listCourses")
    public List<Course> getCourse_id() {
        return courseRepository.findAll();
    }

    // Get the Course information
    @GetMapping("/Course/{id}")
    public Course getCourse(@PathVariable Integer id) {
        return courseRepository.findById(id).get();
    }

    // Delete the Course
    @DeleteMapping("/Course/{id}")
    public List<Course> deleteCourse(@PathVariable Integer id) {
        courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }

    // Add new Course
    @PostMapping("/Course")
    public List<Course> addCourse(@RequestBody Course Course) {
        courseRepository.save(Course);
        return courseRepository.findAll();
    }

    // Update the Course information
    @PutMapping("/Course/{id}")
    public List<Course> updateCourse(@RequestBody Course Course, @PathVariable Integer id) {
        Course CourseObj = courseRepository.findById(id).get();
        CourseObj.setCourse_name(Course.getCourse_name());
        courseRepository.save(CourseObj);
        return courseRepository.findAll();
    }

}
