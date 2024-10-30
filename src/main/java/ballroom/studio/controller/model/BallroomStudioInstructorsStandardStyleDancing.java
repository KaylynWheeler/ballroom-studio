package ballroom.studio.controller.model;


import ballroom.studio.entity.StandardStyleDancing;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BallroomStudioInstructorsStandardStyleDancing {
	private Long standardStyleDancingId;
	private String standardStyleName;
	
	public BallroomStudioInstructorsStandardStyleDancing(StandardStyleDancing standardStyleDancing) {
		standardStyleDancingId =standardStyleDancing.getStandardStyleDancingId();
		standardStyleName =standardStyleDancing.getStandardStyleName();
    
}
}


