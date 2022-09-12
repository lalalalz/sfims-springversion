package sfims.sv1.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository {

    Member save(Member member);

    Member findOne(Long id);

    void delete(Member member);

    Integer deleteAll();
}
