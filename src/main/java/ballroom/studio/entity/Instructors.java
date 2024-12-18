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
	private String instructorsAddress;
	private String instructorsCity;
	private String instructorsState;
	private String instructorsZip;
	private String instructorsPhone;
	private String instructorsEmail;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany( cascade =CascadeType.ALL)
	@JoinTable(
			   name="instructors_students",
			   joinColumns = @JoinColumn(name ="instructors_id"),
			   inverseJoinColumns = @JoinColumn( name = "students_id"))
	   private Set<Students> students = new HashSet<>();

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ballroom_studio_id")
	private BallroomStudio ballroomStudio; 
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "instructors", cascade = CascadeType.PERSIST)
	private Set <StandardStyleDancing> standardstyledances  = new HashSet<>();
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "instructors", cascade = CascadeType.PERSIST)
	private Set <LatinStyleDancing> latinstyledances  = new HashSet<>();

}




