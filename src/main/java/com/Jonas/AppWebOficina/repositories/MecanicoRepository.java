
package com.Jonas.AppWebOficina.repositories;

import com.Jonas.AppWebOficina.domain.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonas, created 21/02/2021
 */
@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, Integer>{

    

}
