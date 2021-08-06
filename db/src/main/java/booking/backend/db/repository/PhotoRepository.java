package booking.backend.db.repository;

import booking.backend.db.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Integer> {

  List<PhotoEntity> findByRoomId(Integer roomId);


}
