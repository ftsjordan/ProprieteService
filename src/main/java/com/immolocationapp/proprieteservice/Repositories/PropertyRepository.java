package com.immolocationapp.proprieteservice.Repositories;

import com.immolocationapp.proprieteservice.entities.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    Page<Property> findByLessorId(Long id, Pageable pageable);
    @Query("select p from Property p where p.IsAvailable=true")
    Page<Property> findByAvailableIsTrue(Pageable pageable);

}
