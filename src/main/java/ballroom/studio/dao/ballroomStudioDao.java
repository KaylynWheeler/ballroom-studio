package ballroom.studio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ballroom.studio.entity.BallroomStudio;

public interface ballroomStudioDao extends JpaRepository<BallroomStudio, Long> {

}
