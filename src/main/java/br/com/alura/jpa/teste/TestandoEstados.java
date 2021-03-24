package br.com.alura.jpa.teste;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoEstados {
    public static void main(String[] args) {
//        Transient
        Conta conta = new Conta();
        conta.setTitular("Almiro");
        conta.setAgencia(12323);
        conta.setNumero(56565645);
        conta.setSaldo(900.0);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        Transient -> Managed
        em.persist(conta);

//        Managed -> Removed
        em.remove(conta);

        em.getTransaction().commit();
    }
}
