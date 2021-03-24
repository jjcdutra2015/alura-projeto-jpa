package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJPQLMovimentacaoDeUmaCategoria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria and m.valor > 300" +
                "and m.tipoMovimentacao = :pTipoMovimentacao";

        Categoria categoria = new Categoria();
        categoria.setId(3L);

        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);
        query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);

        List<Movimentacao> resultList = query.getResultList();
        for (Movimentacao movimentacao : resultList ) {
            System.out.println("Categorias: " + movimentacao.getCategorias());
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Valor: " + movimentacao.getValor());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }
    }
}
