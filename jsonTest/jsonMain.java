package jsonTest;

import java.io.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class jsonMain {
	
	public static JSONObject oneRec(String name, int studentid, int kor, int eng, int mat) {
		JSONObject dataObject = new JSONObject();
		dataObject.put("name", name);
		dataObject.put("studentid", studentid);
		
		//json array 생성
		JSONArray score = new JSONArray();
		score.add(kor); score.add(eng); score.add(mat);
		dataObject.put("score", score);
		
		return dataObject;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 최종 전체 JSONobject 선언
		JSONObject jsonObject = new JSONObject();
		// 한명 성적의 JSON 정보를 담을 Array 선언
		JSONArray dataArray = new JSONArray();
		
		// 한명 정보가 들어갈 JSONObject 선언
		JSONObject dataObject = new JSONObject();
		dataObject.put("name", "나연");
		dataObject.put("studentid", 209901);
		
		// json array 생성
		JSONArray score = new JSONArray();
		score.add(90); score.add(100); score.add(95);
		dataObject.put("score", score);
		dataArray.add(dataObject);
		
		// 깔끔하게 함수 처리
		dataArray.add(oneRec("정연", 209902, 100, 85, 75));
		dataArray.add(oneRec("모모", 209903, 90, 75, 85));
		dataArray.add(oneRec("사나", 209904, 90, 85, 75));
		dataArray.add(oneRec("지효", 209905, 80, 75, 85));
		dataArray.add(oneRec("미나", 209906, 90, 85, 55));
		dataArray.add(oneRec("다연", 209907, 70, 75, 65));
		dataArray.add(oneRec("채영", 209908, 100, 75, 95));
		dataArray.add(oneRec("쯔위", 209909, 80, 65, 95));
		
		try {
			FileWriter file = new FileWriter("C:\\Users\\정해석\\교안\\자바심화\\testdata2.json");
			file.write(dataArray.toJSONString());
			file.flush();
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("JSON 만듦 : " + dataArray);
	}

}
