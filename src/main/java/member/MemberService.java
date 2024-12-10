package member;

import container.Container;

public class MemberService {
  private  MemberRepository memberRepository;

  public MemberService() {
    memberRepository = Container.memberRepository;
  }

  public void join(String loginId, String loginPW, String name) {
    memberRepository.join(loginId, loginPW, name);
  }

  public Member findByLoginId(String loginId) {
    return memberRepository.findByLoginId(loginId);
  }
}