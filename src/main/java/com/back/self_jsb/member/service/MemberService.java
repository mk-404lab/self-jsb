package com.back.self_jsb.member.service;

import com.back.self_jsb.member.entity.Member;
import com.back.self_jsb.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(String username, String password, String nickname){
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        member.setNickname(nickname);

        return memberRepository.save(member);
    }
}
