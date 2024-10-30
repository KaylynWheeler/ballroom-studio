package ballroom.studio.controller.model;

import ballroom.studio.entity.Amenity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BallroomStudioAmenity {
	private Long amenityId;
	private String amenityName;
	
	
	public BallroomStudioAmenity(Amenity amenity) {
		amenityId =amenity.getAmenityId();
		amenityName =amenity.getAmenityName();
    
}
}

