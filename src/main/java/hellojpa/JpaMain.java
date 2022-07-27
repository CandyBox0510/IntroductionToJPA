package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "hello" );

        EntityManager entityManager =  entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try{

            Member member = new Member();
            member.setUsername( "CCC" );

            System.out.println("==========================");

            entityManager.persist( member );
            tx.commit();
        } catch ( Exception e ){
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
