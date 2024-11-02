package ballroom.studio.service;


import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ballroom.studio.controller.model.BallroomStudioData;
import ballroom.studio.controller.model.BallroomStudioInstructors;
import ballroom.studio.dao.amenityDao;
import ballroom.studio.dao.ballroomStudioDao;
import ballroom.studio.dao.instructorsDao;
import ballroom.studio.dao.latinStyleDancingDao;
import ballroom.studio.dao.standardStyleDancingDao;
import ballroom.studio.dao.studentsDao;
import ballroom.studio.entity.Amenity;
import ballroom.studio.entity.BallroomStudio;
import ballroom.studio.entity.Instructors;
import ballroom.studio.entity.LatinStyleDancing;
import ballroom.studio.entity.StandardStyleDancing;
import ballroom.studio.entity.Students;



public class ballroomStudioService {
	@Autowired
	private static amenityDao amenityDao;
	@Autowired
	private static ballroomStudioDao ballroomStudioDao;

	@Autowired
	private static instructorsDao instructorsDao;
	
	@Autowired
	private static latinStyleDancingDao latinStyleDancingDao;
	
	@Autowired
	private static standardStyleDancingDao standardStyleDancingDao;
	
	@Autowired
	private static studentsDao studentsDao;
	

@Transactional(readOnly=false)	
public static  BallroomStudioData saveBallroomStudio(BallroomStudioData ballroomStudioData) {
		try {
			BallroomStudio ballroomstudio = findBallroomStudio(ballroomStudioData);
			if(ballroomstudio == null) {
			  ballroomstudio =  BallroomStudioData.toBallroomStudio();
			  ballroomstudio=  BallroomStudioData.save(ballroomstudio);
			  
			}else{
				ballroomStudioData=(BallroomStudioData)mergeData(ballroomstudio, ballroomStudioData);
				ballroomstudio =ballroomStudioDao.save(ballroomStudioData.toBallroomStudio());
				ballroomStudioData=new BallroomStudioData(ballroomstudio);
			}
			}catch (Exception e) {
				throw new NoSuchElementException("Error proceeding save/update location",e);
				
			}
			return  ballroomStudioData;
		}
	



private static BallroomStudio findBallroomStudio(BallroomStudioData ballroomStudioData) {
	// TODO Auto-generated method stub
	return null;
}




public static Object mergeData(Object src,Object target) throws Exception {
	if (src instanceof BallroomStudio) {
	if (src instanceof Amenity) {
	if (src instanceof Instructors) {
	if (src instanceof Students) {
			
			Class<?> clazz = src.getClass();
			for (Field srcField:clazz.getDeclaredFields()) {
				targetField.setAccessible(true);
				String localName = srcField.getName();
				String remoreName=targetField.getName();
			
				
				if(localNamme != null && remoteName != null) {
					if(localName.equalsIgnoreCase(remoreName)) {
						Object srcValue = srcField.get(src);
						Object targetValue = targetField.get(target);
						
				if(targetField.get(target)== null) {
					targetField.set(target,srcValue);
					
					Object targetValue = targetField.get(target);
					if (targetValue instanceof String) {
						String targetStr = (String) targetValue;
						String srcStr = (String) srcValue;
						if (!srcStr.contains(targetStr)) {
							targetField.set(target, srcValue);
						
						
					} else if (targetValue instanceof Long) {
						Long targetLong = (Long) targetValue;
						Long srcLong = (Long) srcValue;
						if (srcLong.longValue() != targetLong.longValue()) {
							targetField.set(target, srcValue);
						}
					}
				}
			}
		}
	}
}
}
return target;

	}





@Transactional(readOnly = true)
public static  BallroomStudioData retrieveballroomStudioById(Long ballroomStudioId) {
		BallroomStudio ballroomStudio =findBallroomStudioById(ballroomStudioId);
		return BallroomStudioData(ballroomStudio);

	}
private BallroomStudio findBallroomStudioById(Long ballroomStudioId) {
		return ballroomStudioDao.findById(ballroomStudioId)
				.orElseThrow(() -> new NoSuchElementException(
						"BallroomStudio  with Id=" + ballroomStudioId + " was not found." ));
}


@Transactional(readOnly=false)
public static  BallroomStudioData saveAmenity(BallroomStudioData ballroomStudioData) {
	try {
		BallroomStudio amenity= findAmenity(ballroomStudioData);
		if(amenity == null) {
		  amenity =  BallroomStudioData.toAmenity();
		  amenity=  BallroomStudioData.save(amenity);
		  
		}else{
			ballroomStudioData=(BallroomStudioData)mergeData(amenity, ballroomStudioData);
			amenity =amenityDao.save(ballroomStudioData.toAmenity());
			ballroomStudioData=new BallroomStudioData(amenity);
		}
		}catch (Exception e) {
			throw new NoSuchElementException("Error proceeding save/update location",e);
			
		}
		return  ballroomStudioData;
	}
	
	




@Transactional(readOnly = true)
public static List<BallroomStudioData> retrieveAllAmenity() {
	List<Amenity> amenities= amenityDao.findAll();
	List<BallroomStudioData> response = new LinkedList<>();
	
  for(Amenity amenity : amenities)
		response.add(new BallroomStudioData(amenity));
 return response;
	}




@Transactional(readOnly = true)
public static  BallroomStudioData retrieveAmenityById(Long amenityId) {
		Amenity amenity =findAmenityById(amenityId);
		return BallroomStudioData(amenity);
		
	}
	
private static  Amenity findAmenityById(Long amenityId) {
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
public static  BallroomStudioData saveInstructors(BallroomStudioData ballroomStudioData) {
	try {
		BallroomStudio instructors= findInstructors(ballroomStudioData);
		if(instructors == null) {
		   instructors =  BallroomStudioData.toInstructors();
		   instructors=  BallroomStudioData.save(instructors);
		  
		}else{
			ballroomStudioData=(BallroomStudioData)mergeData(instructors, ballroomStudioData);
			instructors =instructorsDao.save(ballroomStudioData.toInstructors());
			ballroomStudioData=new BallroomStudioData(instructors);
		}
		}catch (Exception e) {
			throw new NoSuchElementException("Error proceeding save/update location",e);
			
		}
		return  ballroomStudioData;
	}
	



private static BallroomStudio findInstructors(BallroomStudioData ballroomStudioData) {
	// TODO Auto-generated method stub
	return null;
}




@Transactional(readOnly = true)
public static  List<BallroomStudioData> retrieveAllInstructors() {
		 return instructorsDao.findAll()
					.stream().map(BallroomStudioData::new)
					.toList();
	}




@Transactional(readOnly = true)
public static BallroomStudioData retrieveInstructorsById(Long instructorsId) {
		Instructors instructors =findInstructorsById(instructorsId);
		return BallroomStudioData(instructors);
		
	}








private static  Instructors findInstructorsById(Long instructorsId) {
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
public static  BallroomStudioInstructors saveStudents(Long instructorsId,
			BallroomStudioInstructors ballroomStudioInstructors) {

	try {
		BallroomStudioInstructors students= findStudents(ballroomStudioInstructors);
		if(students == null) {
			students =  BallroomStudioData.toStudents();
			students=  BallroomStudioData.save(students);
		  
		}else{
			 ballroomStudioInstructors=(BallroomStudioInstructors)mergeData(students,  ballroomStudioInstructors);
			 students =studentsDao.save(BallroomStudioInstructors.toStudents();
			 ballroomStudioInstructors=new BallroomStudioData(students);
		}
		}catch (Exception e) {
			throw new NoSuchElementException("Error proceeding save/update location",e);
			
		}
		return  ballroomStudioInstructors;
	}
	



private static BallroomStudioInstructors findStudents(BallroomStudioInstructors ballroomStudioInstructors) {
	// TODO Auto-generated method stub
	return null;
}




@Transactional(readOnly = true)
public static  List<BallroomStudioInstructors> retrieveAllStudents() {
		 return studentsDao.findAll()
					.stream().map(BallroomStudioInstructors::new)
					.toList();
	}




@Transactional(readOnly = true)
public static  BallroomStudioInstructors retrieveStudentsById(Long studentsId) {
		Students students =findStudentsById(studentsId);
		return BallroomStudioInstructors(students);
		
	}



private static  Students findStudentsById(Long studentsId) {
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
public static  List<BallroomStudioInstructors> retrieveAllLatinStyleDancing() {
		 return latinStyleDancingDao.findAll()
					.stream().map(BallroomStudioInstructors::new)
					.toList();
	}




@Transactional(readOnly = true)
	public static BallroomStudioInstructors retrieveLatinStyleDancingId(Long latinStyleDancingId) {
		LatinStyleDancing latinStyleDancing =findLatinStyleDancingById(latinStyleDancingId);
		return BallroomStudioInstructors(latinStyleDancing);
	}






private static LatinStyleDancing findLatinStyleDancingById(Long latinStyleDancingId) {
	return latinStyleDancingDao.findById(latinStyleDancingId)
			.orElseThrow(() -> new NoSuchElementException(
					"LatinStyleDancing with Id=" + latinStyleDancingId + " was not found." ));
}



@Transactional(readOnly = true)
public static  List<BallroomStudioInstructors> retrieveStandardStyleDancing() {
		 return standardStyleDancingDao.findAll()
					.stream().map(BallroomStudioInstructors::new)
					.toList();
	}




@Transactional(readOnly = true)
public static  BallroomStudioInstructors retrieveStandardStyleDancingId(Long standardStyleDancingId) {
		StandardStyleDancing standardStyleDancing =findStandardStyleDancingById(standardStyleDancingId);
		return BallroomStudioInstructors(standardStyleDancing);
	}







private static  StandardStyleDancing findStandardStyleDancingById(Long standardStyleDancingId) {
	return standardStyleDancingDao.findById(standardStyleDancingId)
			.orElseThrow(() -> new NoSuchElementException(
					"StandardStyleDancing with Id=" + standardStyleDancingId + " was not found." ));
}







	


}