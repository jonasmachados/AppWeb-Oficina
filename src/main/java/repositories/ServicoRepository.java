
package repositories;

import com.Jonas.AppWebOficina.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonas, created 22/02/2021
 */
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer>{

    

}
