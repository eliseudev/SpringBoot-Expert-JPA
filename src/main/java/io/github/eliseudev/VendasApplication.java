package io.github.eliseudev;

import io.github.eliseudev.domain.repositorio.ClientesRepo;
import io.github.eliseudev.doman.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepo clientes){
        return args -> {
          System.out.println("Salvando Clientes");
          clientes.salvar(new Cliente("Eliseu Oliveira"));
          clientes.salvar(new Cliente("Elias Ataides"));
          clientes.salvar(new Cliente("Allana Ataides"));

          System.out.println("Listando Cliente Salvos");
          List<Cliente> todosClientes = clientes.obterTodos();
          todosClientes.forEach(System.out::println);

          System.out.println("Cliente Deletado");
          clientes.deletarCliente(3);

          System.out.println("Listando Cliente");
          todosClientes = clientes.obterTodos();
          todosClientes.forEach(System.out::println);

          System.out.println("Buscando cliente por nome");
          Cliente buscarClienteNome = new Cliente("Eliseu");
          System.out.println(clientes.obterClienteNome(buscarClienteNome.getNome()));

          System.out.println("Atualizando Cliente");
          Cliente atualizarCliente = new Cliente(2, "Elias Ataides Oliveira"){};
          clientes.atualizar(atualizarCliente);

          System.out.println("Listando Clientes Atualizado");
          todosClientes = clientes.obterTodos();
          todosClientes.forEach(System.out::println);

        };
    }
    public static void main(String[] args){
        SpringApplication.run(VendasApplication.class, args);
    }
}
