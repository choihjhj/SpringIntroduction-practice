package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //뉴맴버받아서저장
    Optional<Member> findById(Long id); //id에 해당하는맴버찾기
    Optional<Member> findByName(String name); //name에 해당하는 맴버찾기
    List<Member> findAll(); //전체맴버조회
    void clearStore();
}
