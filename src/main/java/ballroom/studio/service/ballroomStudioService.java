package ballroom.studio.service;



import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ballroom.studio.controller.model.BallroomStudioAmenity;
import ballroom.studio.controller.model.BallroomStudioData;
import ballroom.studio.controller.model.BallroomStudioInstructors;
import ballroom.studio.controller.model.BallroomStudioInstructorsLatinStyleDancing;
import ballroom.studio.controller.model.BallroomStudioInstructorsStandardStyleDancing;
import ballroom.studio.controller.model.BallroomStudioInstructorsStudents;
import ballroom.studio.dao.AmenityDao;
import ballroom.studio.dao.BallroomStudioDao;
import ballroom.studio.dao.InstructorsDao;
import ballroom.studio.dao.LatinStyleDancingDao;
import ballroom.studio.dao.StandardStyleDancingDao;
import ballroom.studio.dao.StudentsDao;
import ballroom.studio.entity.Amenity;
import ballroom.studio.entity.BallroomStudio;
import ballroom.studio.entity.Instructors;
import ballroom.studio.entity.LatinStyleDancing;
import ballroom.studio.entity.StandardStyleDancing;
import ballroom.studio.entity.Students;




public class BallroomStudioService {
	@Autowired
	private static AmenityDao amenityDao;
	@Autowired
	private static BallroomStudioDao ballroomStudioDao;

	@Autowired
	private static InstructorsDao instructorsDao;
	
	@Autowired
	private static LatinStyleDancingDao latinStyleDancingDao;
	
	@Autowired
	private static StandardStyleDancingDao standardStyleDancingDao;
	
	@Autowired
	private static StudentsDao studentsDao;
	

@Transactional(readOnly=false)	
public  BallroomStudioData updateBallroomStudio(BallroomStudioData ballroomStudioData) {
	Long ballroomStudioId = ballroomStudioData.getBallroomStudioId();
	BallroomStudio ballroomStudio =findOrCreateBallroomStudio(ballroomStudioId);
			
	
	setFieldsInBallroomStudio(ballroomStudio,ballroomStudioData);
	
	return new BallroomStudioData(ballroomStudioDao.save(ballroomStudio));
	
}
	
private void setFieldsInBallroomStudio(BallroomStudio ballroomStudio, BallroomStudioData ballroomStudioData) {
	ballroomStudio.setBallroomStudioId(ballroomStudioData.getBallroomStudioId());
	ballroomStudio.setBallroomStudioName(ballroomStudioData.getBallroomStudioName());
	ballroomStudio.setBallroomStudioAddress(ballroomStudioData.getBallroomStudioAddress());;
	ballroomStudio.setBallroomStudioCity(ballroomStudioData.getBallroomStudioCity());
	ballroomStudio.setBallroomStudioState(ballroomStudioData.getBallroomStudioState());
	ballroomStudio.setBallroomStudioZip(ballroomStudioData.getBallroomStudioZip());
	ballroomStudio.setBallroomStudioPhone(ballroomStudioData.getBallroomStudioPhone());
	
}

private BallroomStudio findOrCreateBallroomStudio(Long ballroomStudioId) {
	BallroomStudio ballroomStudio;
	if(Objects.isNull(ballroomStudioId)) {
		 ballroomStudio = new BallroomStudio();
		
	}else {
		 ballroomStudio = findBallroomStudioId(ballroomStudioId);
	}

	return ballroomStudio;
	}


private BallroomStudio findBallroomStudioId(Long ballroomStudioId) {
	return ballroomStudioDao.findById(ballroomStudioId)
			.orElseThrow(() -> new NoSuchElementException(
			"Ballroom Studio with ID=" + ballroomStudioId + " was not found." ));
}

@Transactional(readOnly = true)
public  BallroomStudioData retrieveballroomStudioById(Long ballroomStudioId) {
		BallroomStudio ballroomStudio =findBallroomStudioById(ballroomStudioId);
		return new BallroomStudioData(ballroomStudio);

	}
private BallroomStudio findBallroomStudioById(Long ballroomStudioId) {
		return ballroomStudioDao.findById(ballroomStudioId)
				.orElseThrow(() -> new NoSuchElementException(
						"BallroomStudio  with Id=" + ballroomStudioId + " was not found." ));
}


@Transactional(readOnly=false)
public BallroomStudioAmenity updateAmenity(BallroomStudioAmenity ballroomStudioAmenity) {
	Long amenityId = ballroomStudioAmenity.getAmenityId();
	Amenity amenity =findOrCreateAmenity(amenityId);
			
	
	setFieldsInAmenity(amenity,ballroomStudioAmenity);
	
	return new BallroomStudioAmenity(amenityDao.save(amenity));
	
}




private void setFieldsInAmenity(Amenity amenity, BallroomStudioAmenity ballroomStudioAmenity) {
	amenity.setAmenityId(ballroomStudioAmenity.getAmenityId());
	amenity.setAmenityName(ballroomStudioAmenity.getAmenityName());
	
}


private Amenity findOrCreateAmenity(Long amenityId) {
	if(Objects.isNull(amenityId)) {
		return new Amenity();
	}
	
	return findAmenityById(amenityId);
}

@Transactional(readOnly = true)
public List<BallroomStudioAmenity> retrieveAllAmenity() {
	List<Amenity> amenities= amenityDao.findAll();
	List<BallroomStudioAmenity> response = new LinkedList<>();
	
  for(Amenity amenity : amenities)
		response.add(new BallroomStudioAmenity(amenity));
 return response;
	}




@Transactional(readOnly = true)
public  BallroomStudioAmenity retrieveAmenityById(Long amenityId) {
		Amenity amenity =findAmenityById(amenityId);
		return new BallroomStudioAmenity(amenity);
		
	}
	
private   Amenity findAmenityById(Long amenityId) {
	return amenityDao.findById(amenityId)
			.orElseThrow(() -> new NoSuchElementException(
					"Amenity with Id=" + amenityId + " was not found." ));
}




@Transactional(readOnly = false)
public void deleteAmenityById(Long amenityId) {
		Amenity amenity = findAmenityById(amenityId);
		amenityDao.delete(amenity);
		
	}




@Transactional(readOnly=false)
public BallroomStudioInstructors updateInstructors(BallroomStudioInstructors ballroomStudioInstructors) { {
	Long instructorsId =ballroomStudioInstructors.getInstructorsId();
	Instructors instructors =findOrCreateInstructors(instructorsId);
			
	
	setFieldsIninstructors(instructors,ballroomStudioInstructors);
	
	return new  BallroomStudioInstructors(instructorsDao.save(instructors));
	
}

	

}

private void setFieldsIninstructors(Instructors instructors, BallroomStudioInstructors ballroomStudioInstructors) {
	instructors.setInstructorsId(ballroomStudioInstructors.getInstructorsId());
	instructors.setInstructorsFirstName(ballroomStudioInstructors.getInstructorsFirstName());;
	instructors.setInstructorsLastName(ballroomStudioInstructors.getInstructorsLastName());
	instructors.setInstructorsPhone(ballroomStudioInstructors.getInstructorsPhone());
	
}

private Instructors findOrCreateInstructors(Long instructorsId) {
	if(Objects.isNull(instructorsId)) {
		return new Instructors();
	}
	
	return findInstructorsById(instructorsId);
}


@Transactional(readOnly = true)
public  List<BallroomStudioInstructors> retrieveAllInstructors() {
		 return instructorsDao.findAll()
					.stream().map(BallroomStudioInstructors::new)
					.toList();
	}




@Transactional(readOnly = true)
public  BallroomStudioInstructors retrieveInstructorsById(Long instructorsId) {
		Instructors instructors =findInstructorsById(instructorsId);
		return new BallroomStudioInstructors(instructors);
		
	}

private  Instructors findInstructorsById(Long instructorsId) {
	return instructorsDao.findById(instructorsId)
			.orElseThrow(() -> new NoSuchElementException(
					"Instructors with Id=" +instructorsId + " was not found." ));
}



@Transactional(readOnly = false)
	public void deleteInstructorsById(Long instructorsId) {
		Instructors instructors = findInstructorsById(instructorsId);
		instructorsDao.delete(instructors);
		
	}
		
	
@Transactional(readOnly=false)
public  BallroomStudioInstructorsStudents saveStudents(Long instructorsId,BallroomStudioInstructorsStudents ballroomStudioInstructorsStudents) {
		Instructors instructors = findInstructorsById(instructorsId);
Long studentsId =ballroomStudioInstructorsStudents.getStudentsId();
Students students = findOrCreateStudents(instructorsId, studentsId);

copyStudentsFields(students, ballroomStudioInstructorsStudents);


students.getInstructors().add(instructors);
instructors .getStudents().add(students);

Students dbStudents = studentsDao.save(students);

return new BallroomStudioInstructorsStudents(dbStudents);
}

private void copyStudentsFields(Students students, BallroomStudioInstructorsStudents ballroomStudioInstructorsStudents) {
students.setStudentsId(ballroomStudioInstructorsStudents.getStudentsId());
students.setStudentsFirstName(ballroomStudioInstructorsStudents.getStudentsFirstName());;
students.setStudentsLastName(ballroomStudioInstructorsStudents.getStudentsLastName());
students.setStudentsPhone(ballroomStudioInstructorsStudents.getStudentsPhone());
}

private Students findOrCreateStudents(Long instructorsId, Long studentsId) {
if(Objects.isNull(studentsId)) {
	return new Students();
}

return findStudentsById(instructorsId, studentsId);
}

private Students findStudentsById(Long instructorsId, Long studentsId) {
	Students students = studentsDao.findById(studentsId)
		 .orElseThrow(()-> new NoSuchElementException("Students with Id=" + studentsId + " was not found."	));	
		boolean found = false;
		
		for(Instructors instructors : students.getInstructors()) {
			if (instructors.getInstructorsId()== instructorsId) {
				found = true;
				break;
			}
		}
		if(!found) {
			throw new IllegalArgumentException("The customer with ID=" + studentsId + 
					"is not emplyee by the pet store with ID=" + instructorsId + ".");
		}
			return students;

		}


@Transactional(readOnly = true)
public List<BallroomStudioInstructorsStudents> retrieveAllStudents() {
		 return studentsDao.findAll()
					.stream().map(BallroomStudioInstructorsStudents::new)
					.toList();
	}




@Transactional(readOnly = true)
public   BallroomStudioInstructorsStudents retrieveStudentsById(Long studentsId) {
		Students students =findStudentsById(studentsId);
		return  new BallroomStudioInstructorsStudents(students);
		
	}



private  Students findStudentsById(Long studentsId) {
	return studentsDao.findById(studentsId)
			.orElseThrow(() -> new NoSuchElementException(
					"Students with Id=" + studentsId + " was not found." ));
}



@Transactional(readOnly = false)
public void deleteStudentsById(Long studentsId) {
		Students students = findStudentsById(studentsId);
		studentsDao.delete(students);
		
		
	}



@Transactional(readOnly = true)
public List<BallroomStudioInstructorsLatinStyleDancing> retrieveAllLatinStyleDancing() {
		 return latinStyleDancingDao.findAll()
					.stream().map(BallroomStudioInstructorsLatinStyleDancing::new)
					.toList();
	}




@Transactional(readOnly = true)
	public  BallroomStudioInstructorsLatinStyleDancing retrieveLatinStyleDancingId(Long latinStyleDancingId) {
		LatinStyleDancing latinStyleDancing =findLatinStyleDancingById(latinStyleDancingId);
		return new BallroomStudioInstructorsLatinStyleDancing(latinStyleDancing);
	}






private  LatinStyleDancing findLatinStyleDancingById(Long latinStyleDancingId) {
	return latinStyleDancingDao.findById(latinStyleDancingId)
			.orElseThrow(() -> new NoSuchElementException(
					"LatinStyleDancing with Id=" + latinStyleDancingId + " was not found." ));
}



@Transactional(readOnly = true)
public List<BallroomStudioInstructorsStandardStyleDancing> retrieveStandardStyleDancing() {
		 return standardStyleDancingDao.findAll()
					.stream().map(BallroomStudioInstructorsStandardStyleDancing::new)
					.toList();
	}




@Transactional(readOnly = true)
public  BallroomStudioInstructorsStandardStyleDancing retrieveStandardStyleDancingId(Long standardStyleDancingId) {
		StandardStyleDancing standardStyleDancing =findStandardStyleDancingById(standardStyleDancingId);
		return  new BallroomStudioInstructorsStandardStyleDancing(standardStyleDancing);
	}







private static  StandardStyleDancing findStandardStyleDancingById(Long standardStyleDancingId) {
	return standardStyleDancingDao.findById(standardStyleDancingId)
			.orElseThrow(() -> new NoSuchElementException(
					"Standard Style Dancing with Id=" + standardStyleDancingId + " was not found." ));
}









	


}