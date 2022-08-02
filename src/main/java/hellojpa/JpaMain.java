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
            //저장
            Team team = new Team();
            team.setName("TeamA");
//            team.getMembers().add( member );
            entityManager.persist( team );


            Member member = new Member();
            member.setUsername( "member1" );
            entityManager.persist( member );

            team.addMember(member);


            entityManager.flush();
            entityManager.clear();

            System.out.println("==========BEFORE COMMIT======");
            tx.commit();
            System.out.println("==========AFTER COMMIT======");
        } catch ( Exception e ){
            tx.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
