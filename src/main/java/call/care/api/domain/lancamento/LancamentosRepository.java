package call.care.api.domain.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentosRepository extends JpaRepository <Lancamentos , Long> {
    Page<Lancamentos> findAllByAtivoTrue(Pageable paginacao);
}
