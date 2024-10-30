package ballroom.studio.controller.model;

import java.util.HashSet;
import java.util.Set;

import ballroom.studio.entity.Instructors;
import ballroom.studio.entity.LatinStyleDancing;
import ballroom.studio.entity.StandardStyleDancing;
import ballroom.studio.entity.Students;
import ballroom.studio.instructors.controller.model.BallroomStudioInstructorsStudents;
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
	private Set <BallroomStudioInstructorsStandardStyleDancing> standardstyledance  = new HashSet<>();
	private Set <BallroomStudioInstructorsLatinStyleDancing> latinstyledance  = new HashSet<>();


	 
	 public BallroomStudioInstructors (Instructors instructors) {
		    instructorsId =instructors.getInstructorsId();
		    instructorsFirstName =instructors.getInstructorsFirstName();
		    instructorsLastName = instructors.getInstructorsLastName();
		    instructorsPhone = instructors.getInstructorsPhone();
		    
		   
			
	 
	 for (Students students: instructors.getStudents()) {
		 students.add(new BallroomStudioInstructorsStudents(students));
	 
	 }
	 
	 for (StandardStyleDancing standardStyleDancing: instructors.getStandardstyledances()) {
		 standardStyleDancing.add(new BallroomStudioInstructorsStandardStyleDancing(standardStyleDancing));
		 
	 }
	 
	 
	 for (LatinStyleDancing latinStyleDancing: instructors.getLatinstyledances()) {
		 latinStyleDancing.add( new BallroomStudioInstructorsLatinStyleDancing(latinStyleDancing));

	     	
}
	 }
}

