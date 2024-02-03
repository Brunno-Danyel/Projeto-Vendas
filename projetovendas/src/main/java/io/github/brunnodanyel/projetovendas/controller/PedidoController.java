package io.github.brunnodanyel.projetovendas.controller;

import io.github.brunnodanyel.projetovendas.model.dtoRequest.PedidoRequestDTO;
import io.github.brunnodanyel.projetovendas.model.dtoResponse.PedidoBuscaResponseDTO;
import io.github.brunnodanyel.projetovendas.model.dtoResponse.PedidoResponseDTO;
import io.github.brunnodanyel.projetovendas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/realizarPedido")
    @ResponseStatus(CREATED)
    public PedidoResponseDTO realizarPedido(@RequestBody @Valid PedidoRequestDTO pedidoRequestDTO){
        return pedidoService.realizarPedido(pedidoRequestDTO);
    }

    @GetMapping("buscar/pedido/cpf")
    public List<PedidoBuscaResponseDTO> buscarPedidoCpf(){
        return pedidoService.buscarPedidoCpf();
    }

    @PutMapping("/cancela/{idPedido}")
    @ResponseStatus(NO_CONTENT)
    public void cancelaPedido(Long idPedido) {
        pedidoService.cancelaPedido(idPedido);
    }
}
