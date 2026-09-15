package dev.isa.EstoqueApiAplication.domain.service;

import dev.isa.EstoqueApiAplication.domain.dto.TotalCategoriaDTO;
import dev.isa.EstoqueApiAplication.domain.model.Categoria;
import dev.isa.EstoqueApiAplication.domain.repository.CategoriaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<TotalCategoriaDTO> buscarValorTotalPorCategoria() {
        return categoriaRepository.findTotalCategoriaViaJPQL();
    }
}
