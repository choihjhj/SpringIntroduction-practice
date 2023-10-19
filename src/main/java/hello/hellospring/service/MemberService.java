package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class MemberService {
    private final MemberRepository memberRepository=new MemoryMemberRepository();
    /**
     * 회원가입
     */
    public Long join(Member member){
        vaildateDuplicateMember(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();

    }
    private void vaildateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체회원조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}