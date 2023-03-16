package chbo.chbo.ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AssemblerMain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("명령어 입력 ㄱㄱ");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit"))
                break;

            if(command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
            } else if(command.startsWith("change ")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static Assembler assembler = new Assembler();

    private static void printHelp() {
        System.out.println();
        System.out.println("명령어 사용법");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 암호 암호확인");
    }

    private static void processNewCommand(String[] s) {
        if(s.length != 5) {
            printHelp();
            return ;
        }
        MemberResisterService registerService = assembler.getMemberResisterService();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(s[1]);
        registerRequest.setName(s[2]);
        registerRequest.setPassword(s[3]);
        registerRequest.setConfirmPassword(s[4]);
        if(!registerRequest.isPasswordEqualToConfirmPassword()) {
            System.out.println("password 가 일치 하지 않음");
            return;
        }
        try {
            registerService.resist(registerRequest);
            System.out.println("등록");
        } catch (DuplicateMemberException e) {
            System.out.println("존재 하지 않는 이메일");
        }
    }

    private static void processChangeCommand(String[] s) {
        if(s.length != 4) {
            printHelp();
            return ;
        }
        ChangePasswordService changePasswordService = assembler.getChangePasswordService();
        try {
            changePasswordService.changePassword(s[1], s[2], s[3]);
        } catch (WrongIdPasswordException e) {
            System.out.println("암호가 일치 하지 않습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("회원정보가 없습니다.");
        }
    }
}
