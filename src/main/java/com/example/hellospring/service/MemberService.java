package com.example.hellospring.service;

import com.example.hellospring.domain.Member;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    // 의존성 주입
    private final MemberRepository memberRepository;


    // 오토와이어드 어노테이션이 스프링 컨테이너에서 memberRepository Bean 을 찾아서 넣어준다.
    // DI : 의존성 주입, 스프링이 알아서 넣어준다.
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *  회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 회원 등록  X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }


    // 중복체크하는 메소드 따로 생성
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->
                {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     *  전체회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
