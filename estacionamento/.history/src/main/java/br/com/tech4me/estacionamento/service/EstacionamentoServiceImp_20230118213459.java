package br.com.tech4me.estacionamento.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.estacionamento.httpClient.CarroClient;
import br.com.tech4me.estacionamento.model.Estacionamento;
import br.com.tech4me.estacionamento.repository.EstacionamentoRepository;
import br.com.tech4me.estacionamento.shared.EstacionamentoCompletoDto;
import br.com.tech4me.estacionamento.shared.EstacionamentoDto;

@Service
public class EstacionamentoServiceImp implements EstacionamentoService{


    @Autowired
    private EstacionamentoRepository repository;
    
    @Autowired
    private CarroClient CarroriaClient;

    @Override
    public List<EstacionamentoCompletoDto> obterEstacionados() {
        List<Estacionamento> estacionados = repository.findAll();
        List<EstacionamentoCompletoDto> dto = estacionados.stream().map(e -> new ModelMapper().map(e, EstacionamentoCompletoDto.class)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public Optional<EstacionamentoDto> obterestacionadoPorId(String id) {
        
        Optional<Estacionamento> estacionado = repository.findById(id);
        if(estacionado.isPresent()){
            EstacionamentoDto estacionadoComCarro = new ModelMapper().map(estacionado, EstacionamentoDto.class);
            estacionadoComCarro.setDadosCarro(CarroriaClient.obterCarro(estacionadoComCarro.getIdCarro()));
            return Optional.of(estacionadoComCarro);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void removerCarro(String id) {
        repository.deleteById(id);
    }

    @Override
    public EstacionamentoCompletoDto CadastrarPedido(EstacionamentoCompletoDto dto) {
        Estacionamento pedido = new ModelMapper().map(dto, Estacionamento.class);
removerCarro
        repository.save(pedido);
        return new ModelMapper().map(pedido,EstacionamentoCompletoDto.class);
    }

    @Override
    public Optional<EstacionamentoDto> atualizarPedidoPorId(String id, EstacionamentoDto dto) {
        Optional<Estacionamento> retorno = repository.findById(id);

        if(retorno.isPresent()){
            Estacionamento pedidoRetorno = new ModelMapper().map(dto, Estacionamento.class);
            pedidoRetorno.setId(id);
            repository.save(pedidoRetorno);
            return Optional.of(new ModelMapper().map(pedidoRetorno, EstacionamentoDto.class));
        }else{
            return Optional.empty();
        }
    }   
}
