package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Result {

    @Id
    private Integer course_id;
    private String course_name;

    public Result(Integer id, String name) {
        this.course_id = id;
        this.course_name = name;

    }

    public Result() {

    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer id) {
        this.course_id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String name) {
        this.course_name = name;
    }

}
