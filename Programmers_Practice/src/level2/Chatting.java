package level2;
import java.util.*;
public class Chatting {
	public static String[] solution(String[] record) {
		HashMap<String,String> map = new HashMap<>(); //���̵�, �г���
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0;i<record.length;i++){
        	String message = record[i];
            String[] elements = message.split(" ");
            char order = elements[0].charAt(0);
            if(order=='L') {
            	continue;
            }
            String id = elements[1];
            String name = elements[2];
            
            if(order=='E' || order=='C'){
                map.put(id,name);
            }
        }
        
        for(int i=0;i<record.length;i++){
            String message = record[i];
            String[] elements = message.split(" ");
            char order = elements[0].charAt(0);
            String id = elements[1];
            
            String converted;
            if(order=='E'){
                converted = map.get(id)+"���� ���Խ��ϴ�.";
            }else if(order=='L'){
                converted = map.get(id)+"���� �������ϴ�.";
            }else{
                continue;
            }
            list.add(converted);
        }
        
        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }        
        return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] records = new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		records = solution(records);
		for(int i=0;i<records.length;i++) {
			System.out.println(records[i]);
		}
		
	}

}
