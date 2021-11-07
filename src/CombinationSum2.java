import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class CombinationSum2 {
    public static void main(String[] args){
        try{
            CombinationSum2 obj = new CombinationSum2();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        returnAllCombos(candidates,target,currentList,finalList,0);
        return finalList;
    }
    public void returnAllCombos(int[] candidates,int target,List<Integer> currentList,List<List<Integer>> finalList,int previousNum){
        if(target ==0){
            List<Integer> tempList = new ArrayList<>();
            for(int y=0;y<currentList.size();y++){
                tempList.add(currentList.get(y));
            }
            finalList.add(tempList);
        }else{
            HashSet<Integer> usedIntegers = new HashSet<>();
            for(int x=0;x<candidates.length;x++){
                if(candidates[x] <= target && candidates[x] >= previousNum && candidates[x] != -1 && !(usedIntegers.contains(candidates[x]))){
                    int currentNum = candidates[x];
                    target-=currentNum;
                    candidates[x] = -1;
                    usedIntegers.add(currentNum);
                    currentList.add(currentNum);
                    returnAllCombos(candidates,target,currentList,finalList,currentNum);
                    target+= currentNum;
                    candidates[x] = currentNum;
                    currentList.remove(Integer.valueOf(currentNum));
                }
            }
        }
    }
}