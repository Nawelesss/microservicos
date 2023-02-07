package br.com.tech4me.estacionamento.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.estacionamento.shared.EstacionamentoCompletoDto;
import br.com.tech4me.estacionamento.shared.EstacionamentoDto;

public interface EstacionamentoService {
    
    List<EstacionamentoCompletoDto> obterEstacionados();
    Optional<EstacionamentoDto> obterEstacionadoPorId(String id);
    void excluirEstacionado(String id);
    EstacionamentoCompletoDto CadastrarEstacionado(EstacionamentoCompletoDto Estacionado);
    Optional<EstacionamentoDto> atualizarCarroPorId(String id, EstacionamentoDto dto);

}
