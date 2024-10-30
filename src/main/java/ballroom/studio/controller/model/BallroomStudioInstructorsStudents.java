package ballroom.studio.controller.model;

import java.util.HashSet;
import java.util.Set;

import ballroom.studio.entity.Instructors;
import ballroom.studio.entity.Students;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BallroomStudioInstructorsStudents {
	private Long studentsId;
	private String studentsFirstName;
	private String studentsLastName;
	private String studentsPhone;
	private Set<BallroomStudioInstructors> instructors = new HashSet<>();

public BallroomStudioInstructorsStudents  (Students students) {
	studentsId =students.getStudentsId();
	 studentsFirstName = students.getStudentsFirstName();
	 studentsLastName =  students.getStudentsLastName();
	 studentsPhone =  students.getStudentsPhone();
    
	 for (Instructors instructors : students.getInstructors()) {
			instructors.add(new BallroomStudioInstructors(instructors));
}

}

}