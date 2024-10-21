package ballroom.studio.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ballroom_studio_id")
	private BallroomStudio ballroomStudio; 
	
	@OneToMany(mappedBy = "standardstyledancing", cascade = CascadeType.ALL)
	private Set <StandardStyleDancing> standardstyledances  = new HashSet<>();
	
	@OneToMany(mappedBy = "latinstyledancing", cascade = CascadeType.ALL)
	private Set <LatinStyleDancing> latinstyledances  = new HashSet<>();
}




