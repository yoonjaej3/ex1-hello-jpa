package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();
        tx.begin();

        try{
            Member member =new Member();
           // member.setId(1L);
            member.setUsername("A");
            em.persist(member);
            System.out.println("================");
            System.out.println(member.getId());
            System.out.println("================");
           // member.setRoleType(RoleType.USER);


//            em.persist(member);
//            List<Member> result = em.createQuery("select m from Member as m",Member.class)
//                            .getResultList();
//
//            for (Member member : result){
//                System.out.println("member.name = "+ member.getName());
//            }

//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember= em.find(Member.class,101L);
//
//            System.out.println("findMember.id=" + findMember.getId());
//            System.out.println("findMember.id=" + findMember.getName());

//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("====================");

//              Member member= em.find(Member.class,150L);
//              member.setName("777777");
//
//            System.out.println("====================");
            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
