package level4;

import java.util.HashMap;

public class HotelBooking {   
    
    public static long[] solution(long k, long[] room_number) {
        HashMap<Long,Long> room_status = new HashMap<>(); //방번호, 가능한 다음 방번호
        long[] booked = new long[room_number.length]; //i번 게스트가 배정된 방 번호
        
        for(int i=0;i<room_number.length;i++){//i가 게스트 번호
            int guest = i;
            long wanted = room_number[guest]; //게스트가 원하는 방번호
            booked[i] = assign(room_status, wanted); //방 할당(현재 예약 가능한 방번호 리턴)
        }
        
        return booked;
    }
    
    public static long assign(HashMap<Long,Long> room_status, long wanted){
        if(!room_status.containsKey(wanted)) { //해시맵 키가 존재하지 않는다는 것은, 아직 wanted 방이 배정되지 않은 상태라는 것
        	room_status.put(wanted, wanted+1); //바로 방 배정
        	return wanted; //배정한 방번호 리턴
        }
    	//해시맵 키가 존재, 즉 wanted 방이 이미 배정된 상태일 경우
    	long next = assign(room_status,room_status.get(wanted)); //재귀적으로 다시 assign 함수를 호출(가능한 다음 방번호를 wanted 매개변수로 줘서 해당 wanted에 대해서 가능한 방을 다시 탐색)
    	room_status.put(wanted, next); //리턴된 값은 현재 할당 가능한 방번호가 되며 이를 기존의 wanted에 대해 가능한 다음 방번호로 둠
    	
    	//여기까지는 올 일이 없지만 그냥 적어줌
        return next;
    }
    
    public static void main(String[] args) {
    	long k = 10;
    	long[] room_number = new long[] {1,3,4,1,3,1};
    	long[] result = solution(k,room_number);
    	for(int i=0;i<result.length;i++) {
    		System.out.print(result[i]+" ");
    	}
    }
}
