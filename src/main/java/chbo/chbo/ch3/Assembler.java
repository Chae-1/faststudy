package chbo.chbo.ch3;

import lombok.Data;
@Data
public class Assembler {
    private MemberDao memberDao;
    private ChangePasswordService changePasswordService;
    private MemberResisterService memberResisterService;

    public Assembler() {
        this.memberDao = new MemberDao();
        this.memberResisterService = new MemberResisterService(memberDao);
        ChangePasswordService change = new ChangePasswordService();
        change.setMemberDao(memberDao);
        this.changePasswordService = change;
    }

}
