package org.nycteascandiaca.prototypes.web.repository;

import org.nycteascandiaca.prototypes.web.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long>
{
	
}
