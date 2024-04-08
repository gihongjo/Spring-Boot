package kr.excel.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelExampleWrite {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Member> memberList = new ArrayList<>();

        while(true){
            System.out.println("이름을 입력하세요 (끝내기: quit 입력): ");
            String name = scan.nextLine();

            if(name.equals("quit")){
                break;
            }

            System.out.println("나이를 입력하세요: ");
            int age = scan.nextInt();
            scan.nextLine();

            System.out.println("생년월일을 입력하세요 : ");
            String birthDay = scan.nextLine();
            System.out.println("전화번호를 입력하세요: ");
            String phNumber = scan.nextLine();
            System.out.println("주소를 입력하세요: ");
            String address = scan.nextLine();

            System.out.println("결혼 여부를 입력하세요 (true/false): ");
            boolean isMarried = scan.nextBoolean();
            scan.nextLine();

            Member memberVO = new Member(name, birthDay, phNumber, address, age, isMarried);

            memberList.add(memberVO);
        }
        scan.close();

        try {
            // 엑셀 파일을 생성하기 위한 XSSFWorkbook 객체 생성
            XSSFWorkbook workbook = new XSSFWorkbook();

            // 시트 생성, 이름은 "회원정보"
            Sheet sheet = workbook.createSheet("회원정보");

            // 열 이름을 담을 행 생성
            Row headerRow = sheet.createRow(0);

            // 각 열에 열 이름 셋팅
            headerRow.createCell(0).setCellValue("이름");
            headerRow.createCell(1).setCellValue("나이");
            headerRow.createCell(2).setCellValue("생년월일");
            headerRow.createCell(3).setCellValue("전화번호");
            headerRow.createCell(4).setCellValue("주소");
            headerRow.createCell(5).setCellValue("결혼여부");

            // 회원 목록(memberList)를 반복하여 엑셀 파일에 데이터를 채움
            for( int i=0; i<memberList.size(); i++){
                Member member = memberList.get(i);

                // 회원마다 행 생성
                Row row = sheet.createRow(i+1);

                // 각 열에 회원 정보 셋팅
                row.createCell(0).setCellValue(member.getName());        // 이름
                row.createCell(1).setCellValue(member.getAge());         // 나이
                row.createCell(2).setCellValue(member.getBirthdate());   // 생년월일
                row.createCell(3).setCellValue(member.getPhone());       // 전화번호
                row.createCell(4).setCellValue(member.getAdress());      // 주소

                // 결혼 여부를 나타내는 셀 생성 후 셋팅
                Cell marriedCell = row.createCell(5);
                marriedCell.setCellValue(member.isMarried());
            }

            // 생성한 엑셀 파일을 저장할 파일명 지정
            String fileName="members.xls";

            // FileOutputStream을 사용하여 파일에 엑셀 데이터를 씀
            FileOutputStream outputStream = new FileOutputStream(new File(fileName));

            // 엑셀 파일 쓰기
            workbook.write(outputStream);

            // 스트림과 workbook 닫기
            workbook.close();

            // 저장 완료 메시지 출력
            System.out.println("저장 완료");

        } catch (Exception e) {
            // 예외가 발생한 경우 해당 예외를 출력
            e.printStackTrace();
        }


    }
}

