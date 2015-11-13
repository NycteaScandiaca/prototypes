package org.nycteascandiaca.prototypes.web.repository;

import org.nycteascandiaca.prototypes.web.domain.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParameterRepository extends JpaRepository<Parameter, Long>
{

}
