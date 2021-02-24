
package repositories;

import com.Jonas.AppWebOficina.domain.Pecas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonas, created 23/02/2021
 */
@Repository
public interface PecaRepository extends JpaRepository<Pecas, Integer>{

}
