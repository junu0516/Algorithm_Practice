package level2;
import java.util.*;
public class Chatting {
	public static String[] solution(String[] record) {
		HashMap<String,String> map = new HashMap<>(); //아이디, 닉네임
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
                converted = map.get(id)+"님이 들어왔습니다.";
            }else if(order=='L'){
                converted = map.get(id)+"님이 나갔습니다.";
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
