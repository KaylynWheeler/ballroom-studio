package ballroom.studio.controller.model;

import ballroom.studio.entity.LatinStyleDancing;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BallroomStudioInstructorsLatinStyleDancing {
	private Long latinStyleDancingId;
	private String latinStyleName;
	
	
	public BallroomStudioInstructorsLatinStyleDancing(LatinStyleDancing latinStyleDancing) {
		latinStyleDancingId=latinStyleDancing.getLatinStyleDancingId();
		latinStyleName =latinStyleDancing.getLatinStyleName();
    
}
}


