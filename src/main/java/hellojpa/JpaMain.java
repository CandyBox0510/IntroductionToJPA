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


            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            entityManager.persist( member1 );
            entityManager.persist( member2 );*/

            /*Member member = entityManager.find( Member.class, 150L );
            member.setName( "ZZZZZ" );*/

            /*Member member3 = new Member(170L, "B");
            entityManager.persist( member3 );
            entityManager.flush();*/

            Member member = entityManager.find( Member.class, 150L );
            member.setName( "AAAAAA" );

//            entityManager.detach( member );
//            entityManager.clear();
//            entityManager.close();

            Member member2 = entityManager.find( Member.class, 150L );

            System.out.println("==========================");

            tx.commit();
        } catch ( Exception e ){
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
