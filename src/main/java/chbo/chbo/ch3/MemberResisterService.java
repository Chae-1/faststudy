package chbo.chbo.ch3;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberResisterService {
    private final MemberDao memberDao;

    public Long resist(RegisterRequest request) {
        Member findMember = memberDao.selectByEmail(request.getEmail());
        if(findMember != null) {
            throw new DuplicateMemberException("dup email");
        }
        Member member = new Member(request.getEmail(),
                request.getPassword(),
                request.getName(), LocalDateTime.now());
        memberDao.insert(member);
        return member.getId();
    }
}
