package ballroom.studio.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



@Entity
@Data
public class Instructors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long instructorsId;
	private String instructorsFirstName;
	private String instructorsLastName;
	private String instructorsPhone;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade =jakarta.persistence.CascadeType.PERSIST)
	@JoinTable(
	   name="instructors_students",
	   joinColumns = @JoinColumn(name =" instructors_id"),
	   inverseJoinColumns = @JoinColumn( name = "students_id"))
	   private Set<Students> students = new HashSet<>();

	   
	
	
}


