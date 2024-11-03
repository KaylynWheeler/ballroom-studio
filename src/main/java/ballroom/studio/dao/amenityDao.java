package ballroom.studio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ballroom.studio.entity.Amenity;

public interface AmenityDao extends JpaRepository<Amenity, Long> {

}
