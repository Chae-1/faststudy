package chbo.chbo.ch3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfoPrinter {
    private MemberDao memberDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);

    }
}
