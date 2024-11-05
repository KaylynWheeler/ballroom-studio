package ballroom.studio.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
@Entity
@Data
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentsId;
	private String studentsFirstName;
	private String studentsLastName;
	private String studentsAddress;
	private String studentsCity;
	private String studentsState;
	private String studentsZip;
	private String studentsPhone;
	private String studentsEmail;
	
	@ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
	 private Set<Instructors> instructors = new HashSet<>();
}
