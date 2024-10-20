package ballroom.studio.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BallroomStudio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ballroomStudioId;
	private String ballroomStudioName;
	private String ballroomStudioAddress;
	private String ballroomStudioCity;
	private String ballroomStudioState;
	private String ballroomStudioZip;
	private String ballroomStudioPhone;
	
}
