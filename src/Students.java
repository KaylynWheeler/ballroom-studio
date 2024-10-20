package ballroom.studio.entity;

import java.util.HashSet;
import java.util.Set;


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
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "students")
	private Set<Instructor> instructors = new HashSet<> ();
}


