package call.care.api.unidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    Page<Unidade> findAllByAtivoTrue(Pageable paginacao);

}
