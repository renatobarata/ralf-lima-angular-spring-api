package br.com.projeto.api.controle;

import br.com.projeto.api.modelo.Cliente;
import br.com.projeto.api.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class Controle {

    @Autowired
    private Repositorio acao;

    @PostMapping("/")
    public Cliente cadastrar(@RequestBody Cliente c) {
        return acao.save(c);
    }

    @GetMapping("/")
    public Iterable<Cliente> selecionar() {
        return acao.findAll();
    }

    @PutMapping("/")
    public Cliente editar(@RequestBody Cliente c) {
        return acao.save(c);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable Long codigo) {

        // Obtêm um objeto completo do tipo Optional<?>
        Optional<Cliente> objOptional = acao.findById(codigo);

        // Converte o objeto Optional<?> em um objeto do tipo cliente
        Cliente cliente = objOptional.get();

        // Efetua a remoção
        acao.delete(cliente);
    }
}
