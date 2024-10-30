package ballroom.studio.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ballroom.studio.controller.model.BallroomStudioData;
import ballroom.studio.service.ballroomStudioService;
import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("/ballroom_studio")
@Slf4j
public class BallroomStudioController {
	
@PutMapping("/ballroomstudio/{ballroomStudioId}")
	public BallroomStudioData updateballroomstudio(@PathVariable Long ballroomStudioId, 
			@RequestBody BallroomStudioData ballroomStudioData ) {
		ballroomStudioData.setBallroomStudioId(ballroomStudioId);
		log.info("Updating ballroomstudio {}", ballroomStudioData);
		return ballroomStudioService.saveBallroomStudio(ballroomStudioData);
	}

@GetMapping("/{ballroomStudioId}")
public BallroomStudioData retrieveballroomStudioById(@PathVariable Long ballroomStudioId) {
		log.info("Retrieving Ballroom Studio with ID= {}", ballroomStudioId);
return ballroomStudioService.retrieveballroomStudioById(ballroomStudioId);

}
@GetMapping("/{amenityId}")
public BallroomStudioData retrieveamenityById(@PathVariable Long amenityId) {
		log.info("Retrieving amenity with ID= {}", amenityId);
return ballroomStudioService.retrieveamenityById(amenityId);
}
@PutMapping("/ballroom_studio/{instructorsId}")
public BallroomStudioData updateInstructors(@PathVariable Long instructorsId, 
		@RequestBody BallroomStudioData ballroomStudioData ) {
	log.info("Updating instructors {}" , ballroomStudioData);
	return ballroomStudioService.saveInstructors(ballroomStudioData);
}
@GetMapping("/{instructorsId}")
public BallroomStudioData retrieveInstructorsById(@PathVariable Long instructorsId) {
		log.info("Retrieving instructors with ID= {}", instructorsId);
return ballroomStudioService.retrieveInstructorsById(instructorsId);
}
@DeleteMapping("ballroom_studio/{instructorsId}")
public Map< String ,String>deleteInstructorsById(
		@PathVariable Long instructorsId) {
	log.info("Deleting instrctors with ID= {}",instructorsId);
	ballroomStudioService.deleteInstructorsById(instructorsId);
	 
	 return Map.of("message", "Delete instructors with ID=" + instructorsId +
			 " was successful.");
}

}