package chbo.chbo.ch3;

public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter printer;

    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
        this.memberDao = memberDao;
        this.printer = printer;
    }

    public void printAll() {
        memberDao.selectAll()
                .stream()
                .forEach((member) -> printer.print(member));
    }
}
