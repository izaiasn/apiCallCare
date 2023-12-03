package call.care.api.domain.unidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    Page<Unidade> findAllByAtivoTrue(Pageable paginacao);

}
