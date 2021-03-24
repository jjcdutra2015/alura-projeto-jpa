package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoContaLeonardo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta contaDoLeonardo = em.find(Conta.class, 1L);

        em.getTransaction().begin();

        contaDoLeonardo.setSaldo(20.0);

        em.getTransaction().commit();
    }
}
