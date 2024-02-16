package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {// memberRepository의존
        this.memberRepository = memberRepository;
    }

    //가입 하고 찾는데 인터페이스 memberRepository가 필요
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //test용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
