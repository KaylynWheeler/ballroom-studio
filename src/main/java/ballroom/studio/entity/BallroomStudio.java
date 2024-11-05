package ballroom.studio.entity;



import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private String ballroomStudioEmail;

@OneToMany(mappedBy = "ballroomStudio", cascade = CascadeType.ALL)
	private Set <Amenity> amenities  = new HashSet<>();
@OneToMany(mappedBy = "ballroomStudio", cascade = CascadeType.ALL)
	private Set <Instructors> instructors  = new HashSet<>();
	
	
}
