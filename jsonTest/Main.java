package jsonTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("C:\\Users\\정해석\\교안\\자바심화\\testdata2.json"));
		
//		JSONObject jsonObject = (JSONObject) obj;
		
		JSONArray array = (JSONArray)obj; //키가 없는 array
		
		System.out.println("*********************************************");
		for (int i = 0; i < array.size(); i++) { // array만큼 반복
			JSONObject result = (JSONObject) array.get(i); // array에서 하나 가져오기
			System.out.println("이름 : " + result.get("name")); // 이름가져오기
			System.out.println("학법 : " + result.get("studentid")); // 학번가져오기
			
			
			JSONArray score = (JSONArray) result.get("score"); //성적을 배열로 가져오기
			long kor = (long)score.get(0); // 배열중 0번째 국어
			long eng = (long)score.get(1); // 배열중 1번째 영어
			long mat = (long)score.get(2); // 배열중 2번째 수학, 배열이 잘못만들어져 3개가 아니라면 오류
			
			System.out.println("국어 : " + kor);
			System.out.println("영어 : " + eng);
			System.out.println("수학 : " + mat);
			System.out.println("총점 : " + (kor + eng + mat));
			System.out.println("평균 : " + ((kor + eng + mat) / 3.0));
			System.out.println("*********************************************");
		}
	}

}
