package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "hello" );

        EntityManager entityManager =  entityManagerFactory.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try{
//            Member member = new Member();
//            member.setId( 2L );
//            member.setName( "HelloB" );

//            Member findMember = entityManager.find( Member.class, 1L );
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());
//            findMember.setName( "HelloJPA" );

            List< Member > select_m_from_member = entityManager.createQuery( "select m from Member as m", Member.class )
                    .setFirstResult( 1 ).setMaxResults( 10 ).getResultList();

            for ( Member member : select_m_from_member ) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        } catch ( Exception e ){
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
