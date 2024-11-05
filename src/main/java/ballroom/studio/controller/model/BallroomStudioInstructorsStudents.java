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
	private String studentsAddress;
	private String studentsCity;
	private String studentsState;
	private String studentsZip;
	private String studentsPhone;
	private String studentsEmail;
	private Set<BallroomStudioInstructors> instructors = new HashSet<>();

public BallroomStudioInstructorsStudents  (Students students) {
	studentsId =students.getStudentsId();
	 studentsFirstName = students.getStudentsFirstName();
	 studentsLastName =  students.getStudentsLastName();
	 studentsAddress = students.getStudentsAddress();
	 studentsCity = students.getStudentsCity();
	 studentsState=students.getStudentsState();
	 studentsZip= students.getStudentsZip();
	studentsPhone =  students.getStudentsPhone();
	studentsEmail = students.getStudentsEmail();
    
	 for (Instructors instructor : students.getInstructors()) {
			instructors.add(new BallroomStudioInstructors(instructor));
          }

     }

}