package io.github.filipeacht.clients.model.repository;

import io.github.filipeacht.clients.model.entity.ServiceProvided;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {

    @Query(" select s " +
            " from ServiceProvided  s " +
            " join s.client c " +
            " where upper( c.name ) like upper( :name )" +
            " and MONTH(s.date) = :month ")
    List<ServiceProvided> findByClientNameAndMonth(
            @Param("name") String name,
            @Param("month") Integer month);
}
