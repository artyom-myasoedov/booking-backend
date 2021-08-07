package booking.backend.db.repository;

import booking.backend.db.entity.RoomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Integer>, RoomCustomRepository {

  Optional<RoomEntity> findById(Integer roomId);

  Page<RoomEntity> findByLandlord_Id(Integer id, Pageable pageable);

  Page<RoomEntity> findAll(Pageable pageable);




}
