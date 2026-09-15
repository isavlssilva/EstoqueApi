package dev.isa.EstoqueApiAplication.domain.repository;

import dev.isa.EstoqueApiAplication.domain.dto.TotalCategoriaDTO;
import dev.isa.EstoqueApiAplication.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
                       
    @Query("SELECT new dev.isa.EstoqueApiAplication.domain.dto.TotalCategoriaDTO("
            + "c.categoria, "
            + "SUM(p.saldo), "
            + "SUM(p.saldo * p.valor_unitario)) "
            + "FROM Categoria c JOIN Produto p ON p.categoria = c "
            + "GROUP BY c.id, c.categoria "
            + "ORDER BY c.categoria")
    List<TotalCategoriaDTO> findTotalCategoriaViaJPQL();
    
    
}
