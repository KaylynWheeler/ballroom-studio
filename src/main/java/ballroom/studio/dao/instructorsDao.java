package ballroom.studio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ballroom.studio.entity.Instructors;

public interface instructorsDao extends JpaRepository<Instructors, Long> {

}