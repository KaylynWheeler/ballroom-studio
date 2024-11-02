package ballroom.studio.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ballroom.studio.controller.model.BallroomStudioData;
import ballroom.studio.controller.model.BallroomStudioInstructors;
import ballroom.studio.service.ballroomStudioService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/ballroom_studio")
@Slf4j
public class BallroomStudioController {
	
@PutMapping("/ballroomstudio/{ballroomStudioId}")
	public BallroomStudioData updateBallroomStudio(@PathVariable Long ballroomStudioId, 
			@RequestBody BallroomStudioData ballroomStudioData ) {
		ballroomStudioData.setBallroomStudioId(ballroomStudioId);
		log.info("Updating Ballroom Studio {}", ballroomStudioData);
		return ballroomStudioService.saveBallroomStudio(ballroomStudioData);
	}

@GetMapping("/{ballroomStudioId}")
public BallroomStudioData retrieveBallroomStudioById(@PathVariable Long ballroomStudioId) {
		log.info("Retrieving Ballroom Studio with ID= {}", ballroomStudioId);
return ballroomStudioService.retrieveballroomStudioById(ballroomStudioId);
}
@PutMapping("/ballroomstudio/{amenityId}")
public BallroomStudioData updateAmenity(@PathVariable Long amenityId,
		@RequestBody BallroomStudioData ballroomStudioData ) {
	log.info("Updating amenities {}", ballroomStudioData);
	return ballroomStudioService.saveAmenity(ballroomStudioData);
}

@GetMapping("/amenity")
public List<BallroomStudioData>retrieveAllAmenity() {
		log.info("Retrieving all  amenity called. ");
return ballroomStudioService.retrieveAllAmenity();

}
@GetMapping("/amenity/{amenityId}")
public BallroomStudioData retrieveAmenityById(@PathVariable Long amenityId) {
		log.info("Retrieving amenity with ID= {}", amenityId);
return ballroomStudioService.retrieveAmenityById(amenityId);

}

@DeleteMapping("/amenity")
public void deleteAllAmenity() {
log.info("Attempting to delete all instructors");
throw new UnsupportedOperationException(
"Deleting all amenties is not allowed.");

}
@DeleteMapping("/ballroom_studio/{amenityId}")
public Map< String ,String>deleteAmenityById(
		@PathVariable Long amenityId) {
	log.info("Deleting amenties with ID= {}",amenityId);
	ballroomStudioService ballroomStudioService = new ballroomStudioService();
	ballroomStudioService.deleteAmenityById(amenityId);
	 
	 return Map.of("message", "Delete amenities with ID=" + amenityId +
			 " was successful.");
}

@PutMapping("/ballroom_studio/{instructorsId}")
public BallroomStudioData updateInstructors(@PathVariable Long instructorsId, 
		@RequestBody BallroomStudioData ballroomStudioData ) {
	log.info("Updating instructors {}" , ballroomStudioData);
	return ballroomStudioService.saveInstructors(ballroomStudioData);
}
@GetMapping("/instructors")
public List<BallroomStudioData>retrieveAllInstructors() {
		log.info("Retrieving all  instructors called. ");
return ballroomStudioService.retrieveAllInstructors();

}
@GetMapping("/instructors/{instructorsId}")
public BallroomStudioData retrieveInstructorsById(@PathVariable Long instructorsId) {
		log.info("Retrieving instructors with ID= {}", instructorsId);
return ballroomStudioService.retrieveInstructorsById(instructorsId);
}

@DeleteMapping("/instructors")
public void deleteAllIstructors() {
log.info("Attempting to delete all instructors");
throw new UnsupportedOperationException(
"Deleting all instructors is not allowed.");
}
@DeleteMapping("ballroom_studio/{instructorsId}")
public Map< String ,String>deleteInstructorsById(
		@PathVariable Long instructorsId) {
	log.info("Deleting instructors with ID= {}",instructorsId);
	ballroomStudioService ballroomStudioService = new ballroomStudioService();
	ballroomStudioService.deleteInstructorsById(instructorsId);
	 
	 return Map.of("message", "Delete instructors with ID=" + instructorsId +
			 " was successful.");
}

@PostMapping("/{instructorsId}/students")
@ResponseStatus(code= HttpStatus.CREATED)
public BallroomStudioInstructors addStudentsToBallRoomStudioInstuctors(@PathVariable Long instructorsId, 
		@RequestBody BallroomStudioInstructors ballroomStudioInstructors ) {
	log.info("Adding stundents {} to ballroom studio Instructors with ID{}", ballroomStudioInstructors);
	return ballroomStudioService.saveStudents(instructorsId,ballroomStudioInstructors);
	
}
@GetMapping("/students")
public List<BallroomStudioInstructors> retrieveAllStudents(){
	log.info("Retrieve all students called.");
	return ballroomStudioService.retrieveAllStudents();
}
@GetMapping("/students/{studentsId}")
public BallroomStudioInstructors retrieveStudentsById(@PathVariable Long studentsId) {
	log.info("Retrieve all students with ID= {}",studentsId);
	return ballroomStudioService.retrieveStudentsById(studentsId);
	
}
@DeleteMapping("/students")
public void deleteAllStudents() {
log.info("Attempting to delete all students");
throw new UnsupportedOperationException(
"Deleting all students is not allowed.");
}
@DeleteMapping("/students/{studentsId}")
public Map< String ,String>deleteStudentsById(
		@PathVariable Long studentsId) {
	log.info("Deleting students with ID= {}",studentsId);
	ballroomStudioService ballroomStudioService = new ballroomStudioService();
	ballroomStudioService.deleteStudentsById(studentsId);
	 
	 return Map.of("message", "Delete students with ID=" + studentsId +
			 " was successful.");

}

@GetMapping("/latin_style_dancing")
public List<BallroomStudioInstructors>latinStyleDancing(){
	log.info("Retrieve all Latin Style Dances called.");
	return ballroomStudioService.retrieveAllLatinStyleDancing();
}
@GetMapping("/latin_style_dancing/{latinStyleDancingId}")
public BallroomStudioInstructors retrieveLatinStyleDancingId(@PathVariable Long latinStyleDancingId) {
	log.info("Retrieve all Latin Style Dance with ID= {}",latinStyleDancingId);
	return ballroomStudioService.retrieveLatinStyleDancingId(latinStyleDancingId);
}
@GetMapping("/standard_style_dancing")
public List<BallroomStudioInstructors>standardStyleDancing(){
	log.info("Retrieve all Standard Style Dances called.");
	return ballroomStudioService.retrieveStandardStyleDancing();
}
@GetMapping("/standard_style_dancing/{standardStyleDancingId}")
public BallroomStudioInstructors retrieveStandardStyleDancingId(@PathVariable Long standardStyleDancingId) {
	log.info("Retrieve all Standard Style Dance with ID= {}",standardStyleDancingId);
	return ballroomStudioService.retrieveStandardStyleDancingId(standardStyleDancingId);
    }
}
