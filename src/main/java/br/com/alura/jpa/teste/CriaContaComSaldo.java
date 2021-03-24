package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Márcia");
        conta.setNumero(12345);
        conta.setAgencia(54321);
        conta.setSaldo(100.0);

        em.getTransaction().begin();

        em.persist(conta);

        conta.setSaldo(1000.0);

        em.getTransaction().commit();
        em.close();

        EntityManager em2 = emf.createEntityManager();
        System.out.println("Id conta Maricia: " + conta.getId());
        conta.setSaldo(500.0);

        em2.getTransaction().begin();

        em2.merge(conta);

        em2.getTransaction().commit();
    }
}
