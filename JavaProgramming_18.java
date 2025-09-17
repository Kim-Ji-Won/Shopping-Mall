import java.util.Scanner;
import java.util.InputMismatchException; //InputMismatchException는 java.util아래에 있으므로 import 해줘야 함

public class JavaProgramming_18 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("10명 학생의 학번과 점수 입력");

        int grade [] = new int [10];
        int score [] = new int [10]; //크기 10인 학점 배열 생성


        for(int i=0; i<grade.length; i++) {
            System.out.print((i+1) + ">>");
            grade[i] = scanner.nextInt(); //학번 배열 입력 받음 
            score[i] = scanner.nextInt(); //학점 배열 입력 받음 
        }
        
        while(true) {  //(프로그램 종료)을 입력할 때까지 실행 반
        	System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
        
        	int search = scanner.nextInt(); //1, 2, 3중에 하나를 입력 받음 
        
        	if(search == 1) { //학번 검색(1)
        		System.out.print("학번>>");
        		//정수가 아닐 경우 InputMismatchException 예외 발생 
        		try {
        			int searchGrade = scanner.nextInt(); //찾으려는 학번 입력받음 
        			boolean found = false; //found 변수 false로 초기화 
        			for (int i=0; i<10; i++) {
        				if (grade[i] == searchGrade) { //배열에 저장된 학번과 입력받은 학번이 일치했을 때
        					System.out.println(score[i] + "점");
        					found = true; //일치한 경우를 찾음 
        					break; //반복 종료
        				}
        			}
        			if(!found) { //찾지 못한 경우 
        				System.out.println(searchGrade + "의 학생은 없습니다.");
        			}
        		}
        		catch(InputMismatchException e) { //try 에서 발생한 예외 처리 
        			System.out.println("경고!! 정수를 입력하세요.");
        			scanner.nextLine(); //남아있는 엔터 제거함 
        		}
        	}
        		
        	else if(search == 2) { //점수 검색(2를 눌렸을 때의 경우)
        		System.out.print("점수>>");
        		//정수가 아닐 경우 InputMismatchException 예외 발생  
        		try{
        			int searchScore = scanner.nextInt(); //찾으려는 점수 입력받음
        			boolean found = false; //found 변수 false로 초기화 
        			//문자열 student 변수를 생성한 이유는 점수가 같은 학생이 여러명일 수 있기 때문
        			String student = ""; //문자열 student 변수 공백으로 초기화 
        	
        			for (int i=0; i<10; i++) {
        				if (score[i] == searchScore ) { //배열에 저장된 학점과 입력받은 학점이 있치했을 때 
        					student += (i+1) + " "; //문자열 student 변수에 student + (i+1) 저장함 
        					found = true; //일치한 경우를 찾음 
        				}
        			}
            
        			if(found) { //일치했을 때
        				System.out.println("점수가 " + searchScore + "인 학생은 " + student + "입니다.");
        			}
        			else { //일치하지 않았을 떄
        				System.out.println("점수가 " + searchScore + "인 학생은 없습니다.");
        			}
        		}
        		catch(InputMismatchException e) { //try 에서 발생한 예외 처리 
        			System.out.println("경고!! 정수를 입력하세요.");
        			scanner.nextLine(); //남아있는 엔터 제거함 
        		}
        	}
        	else { //3을 입력했을 때의 경우(프로그램 종료)
        		System.out.print("프로그램을 종료합니다.");
        		break; //while 탈출 
        	}
        }
    }
}
