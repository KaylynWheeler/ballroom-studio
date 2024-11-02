package ballroom.studio.controller.model;


import java.util.HashSet;
import java.util.Set;
import ballroom.studio.entity.Amenity;
import ballroom.studio.entity.BallroomStudio;
import ballroom.studio.entity.Instructors;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data@NoArgsConstructor
public class BallroomStudioData {
	private Long ballroomStudioId;
	private String ballroomStudioName;
	private String ballroomStudioAddress;
	private String ballroomStudioCity;
	private String ballroomStudioState;
	private String ballroomStudioZip;
	private String ballroomStudioPhone;
	private Set <BallroomStudioAmenity> amenities  = new HashSet<>();
	private Set <BallroomStudioInstructors> instructors  = new HashSet<>();
	
	public BallroomStudioData(BallroomStudio ballroomStudio) {
    	ballroomStudioId =ballroomStudio.getBallroomStudioId();
        ballroomStudioName =ballroomStudio.getBallroomStudioName();
    	ballroomStudioAddress = ballroomStudio.getBallroomStudioAddress();
    	ballroomStudioCity = ballroomStudio.getBallroomStudioCity();
    	ballroomStudioState=ballroomStudio.getBallroomStudioState();
    	ballroomStudioZip= ballroomStudio.getBallroomStudioZip();
    	ballroomStudioPhone = ballroomStudio.getBallroomStudioPhone();
    	
	

	

	for (Amenity amenity : ballroomStudio.getAmenities()) {
		amenities.add(new BallroomStudioAmenity(amenity));

	}


	for (Instructors instructor : ballroomStudio.getInstructors()) {
		instructors.add(new BallroomStudioInstructors(instructor));
		
	
	}
	
	}
	
}
	


	
