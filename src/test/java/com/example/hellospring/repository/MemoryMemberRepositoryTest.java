package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    // 각 테이스 끝날 때 마다 clear
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//      Assertions.assertEquals(result, member);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("spring1");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        repository.save(member1);

        Member result = repository.findByName("spring2").get();

        Assertions.assertThat(member).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("spring1");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        repository.save(member1);
    }


}
