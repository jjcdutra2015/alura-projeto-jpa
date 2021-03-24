package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TestaRelacionamentoMovimentacaoCategoria {

    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setId(2L);

        Categoria categoria = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal(300.0));
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Viagem à SP");
        movimentacao.setConta(conta);
        movimentacao.setCategorias(Arrays.asList(categoria, categoria2));

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal(300.0));
        movimentacao2.setData(LocalDateTime.now());
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setConta(conta);
        movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(categoria);
        em.persist(categoria2);
        em.persist(movimentacao);
        em.persist(movimentacao2);

        em.getTransaction().commit();
        em.close();
    }
}
