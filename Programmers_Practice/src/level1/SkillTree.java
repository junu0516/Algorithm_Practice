package level1;

public class SkillTree {
	
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0;i<skill_trees.length;i++){
            String curr = skill_trees[i];
            StringBuilder check = new StringBuilder();
            
            for(int j=0;j<curr.length();j++){
                String temp = curr.substring(j,j+1);
                
                if(skill.indexOf(temp) != -1){
                    check.append(temp);
                }
            }
            
            if(skill.indexOf(check.toString())==0){
                answer++;
            }       
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = new String[] {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill,skill_trees));
	}

}
