package sfims.sv1.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Transactional
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        Member member = new Member("lalalalz", "1234", "19930425",
                "최진수", "01077133697", "lalalalz@naver.com");

        memberRepository.save(member);
    }

    @AfterEach
    void afterEach() {
        Integer removedCount = memberRepository.deleteAll();
        log.info("afterEach deleteAll : {}", removedCount);
    }

    @Test
    void 회원_저장() {
        // given
        Member member = new Member("lalalalz1", "1234", "19930425",
                "최진수", "01077133697", "lalalalz@naver.com");

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember).isEqualTo(member);
    }

    @Test
    void 회원_검색() {
        // given
        Member member = new Member("lalalalz1", "1234", "19930425",
                "최진수", "01077133697", "lalalalz@naver.com");
        memberRepository.save(member);

        // when
        Long memberId = member.getId();
        Member findMember = memberRepository.findOne(memberId);

        // then
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void 회원_삭제() {
        // given
        Member member = new Member("lalalalz1", "1234", "19930425",
                "최진수", "01077133697", "lalalalz@naver.com");
        memberRepository.save(member);

        // when
        memberRepository.delete(member);
        Member findMember = memberRepository.findOne(member.getId());

        // then
        assertThat(findMember).isNull();
    }

    @Test
    void 모든_회원_삭제() {
        // given
        Member member1 = new Member("lalalalz1", "1234", "19930425",
                "최진수", "01077133697", "lalalalz@naver.com");
        Member member2 = new Member("lalalalz2", "1234", "19930425",
                "최진수", "01077133697", "lalalalz@naver.com");
        Member member3 = new Member("lalalalz3", "1234", "19930425",
                "최진수", "01077133697", "lalalalz@naver.com");
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // when
        Integer removedCount = memberRepository.deleteAll();

        // then
        assertThat(removedCount.intValue()).isEqualTo(4);
    }
}