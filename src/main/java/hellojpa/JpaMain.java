package hellojpa;

import hellojpa.domain.Book;
import hellojpa.domain.Member;
import hellojpa.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static <Members> void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();
        tx.begin();

        try{

            Team team1= new Team();
            team1.setName("teamA");
            em.persist(team1);


            Team team2= new Team();
            team2.setName("teamB");
            em.persist(team2);


            Member member1 =new Member();
            member1.setUsername("member1");
            member1.setTeam(team1);
            em.persist(member1);

            Member member2 =new Member();
            member2.setUsername("member2");
            member2.setTeam(team2);
            em.persist(member2);

            em.flush();
            em.clear();

            //Member refMember=em.getReference(Member.class,member1.getId());

            //Member m=em.find(Member.class,member1.getId());
            List<Member> members=em.createQuery("select m from Member m",Member.class).getResultList();
            System.out.println("@@@@@@@@@@@@@@@");
            System.out.println(members.get(0).getUsername());
            System.out.println("@@@@@@@@@@@@@@@");
            tx.commit();
        } catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally{
            em.close();
        }
        emf.close();
    }
}
