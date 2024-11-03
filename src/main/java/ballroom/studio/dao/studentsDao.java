package ballroom.studio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ballroom.studio.entity.Students;

public interface StudentsDao extends JpaRepository<Students, Long> {

}
