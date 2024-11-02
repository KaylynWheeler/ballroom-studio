package ballroom.studio.controller.model;

import java.util.HashSet;
import java.util.Set;

import ballroom.studio.entity.Instructors;
import ballroom.studio.entity.LatinStyleDancing;
import ballroom.studio.entity.StandardStyleDancing;
import ballroom.studio.entity.Students;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BallroomStudioInstructors {
	private Long instructorsId;
	private String instructorsFirstName;
	private String instructorsLastName;
	private String instructorsPhone;
	private Set<BallroomStudioInstructorsStudents> students = new HashSet<>();
	private Set <BallroomStudioInstructorsStandardStyleDancing> standardstyledancing  = new HashSet<>();
	private Set <BallroomStudioInstructorsLatinStyleDancing> latinstyledancing  = new HashSet<>();


	 
	 public BallroomStudioInstructors (Instructors instructors) {
		    instructorsId =instructors.getInstructorsId();
		    instructorsFirstName =instructors.getInstructorsFirstName();
		    instructorsLastName = instructors.getInstructorsLastName();
		    instructorsPhone = instructors.getInstructorsPhone();
		    
		   
		 for (Students student : instructors.getStudents()) {
		 students.add(new BallroomStudioInstructorsStudents(student));
	 
	 }
	 
	 for (StandardStyleDancing standardStyleDance: instructors.getStandardstyledances()) {
		 standardstyledancing.add(new BallroomStudioInstructorsStandardStyleDancing(standardStyleDance));
		 
	 }
	 
	 
	 for (LatinStyleDancing latinStyleDance: instructors.getLatinstyledances()) {
		 latinstyledancing.add(new BallroomStudioInstructorsLatinStyleDancing(latinStyleDance));

	     }
	     	

	 }
	 
	 
}

