package sfims.sv1.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Member findOne(Long id) {
        return entityManager.find(Member.class, id);
    }

    @Override
    public void delete(Member member) {
        entityManager.remove(member);
    }

    @Override
    public Integer deleteAll() {
        String jpql = "delete from Member m";
        return entityManager.createQuery(jpql)
                .executeUpdate();
    }
}
