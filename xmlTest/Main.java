package xmlTest;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		// 파씽을 위한 준비
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		// xml파일을 처리 PC안에 있어서 전체경로를 지정, xml파싱처리 확시작
		Document doc = docBuilder.parse(new File("C:\\Users\\정해석\\교안\\자바심화\\testdata.xml"));
		
		Element root = doc.getDocumentElement(); // root 태그를 가지고 오기도 하지만 지금은 쓰이는 곳이 없음
		
		NodeList tag_name = doc.getElementsByTagName("name");
		NodeList tag_studentid = doc.getElementsByTagName("studentid");
		NodeList tag_kor = doc.getElementsByTagName("kor");
		NodeList tag_eng = doc.getElementsByTagName("eng");
		NodeList tag_mat = doc.getElementsByTagName("mat");
		
		System.out.printf("***************************************\n");
		for (int i = 0; i < tag_name.getLength(); i++) {
			System.out.printf("이름 : %s\n", tag_name.item(i).getFirstChild().getNodeValue());
			System.out.printf("학번 : %s\n", tag_studentid.item(i).getFirstChild().getNodeValue());
			System.out.printf("국어 : %s\n", tag_kor.item(i).getFirstChild().getNodeValue());
			System.out.printf("영어 : %s\n", tag_eng.item(i).getFirstChild().getNodeValue());
			System.out.printf("수학 : %s\n", tag_mat.item(i).getFirstChild().getNodeValue());
			System.out.printf("***************************************\n");
		}
		
	}

}
