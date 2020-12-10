package za.ac.cput.entity.tertiaryInstitution;



import java.util.Objects;



public class Course {

    private String courseId;
    private String courseName;
    private String courseCode;
    private String courseFees;
    private int courseRequirement;

    protected Course(){}

    private Course(Builder builder) {
        this.courseId = builder.courseId;
        this.courseCode = builder.courseCode;
        this.courseName = builder.courseName;
        this.courseFees = builder.courseFees;
        this.courseRequirement = builder.courseRequirement;
    }

    public String getCourseId() { return courseId; }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseFees() {
        return courseFees;
    }

    public int getCourseRequirement() {
        return courseRequirement;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseFees='" + courseFees + '\'' +
                ", courseRequirement='" + courseRequirement + '\'' +
                '}';
    }

    public static class Builder{
        private String courseId;
        private String courseName;
        private String courseCode;
        private String courseFees;
        private int courseRequirement;

        public Builder setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setCourseName (String courseName){
            this.courseName =courseName;
            return this;
        }

        public Builder setCourseCode (String courseCode){
            this.courseCode =courseCode;
            return this;
        }

        public Builder setCourseFees (String courseFees){
            this.courseFees =courseFees;
            return this;
        }

        public Builder setCourseRequirement (int courseRequirement){
            this.courseRequirement =courseRequirement;
            return this;
        }

        public Builder copy (Course course){
            this.courseId = course.courseId;
            this.courseName = course.courseName;
            this.courseCode = course.courseCode;
            this.courseFees = course.courseFees;
            this.courseRequirement = course.courseRequirement;
            return this;
        }

        public Course build(){return new Course (this);}

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }
}
