public class SpringHelper {
    public String truncateAInFirst2Position(String str){
        if(str.length() <= 2) return str.replace("A","");
        String s1 = str.substring(0,2);
        String s2 = str.substring(2);
        return s1.replace("A","") + s2 ;
    }

    public boolean areFirst2CharSameAsLast2(String str){
        if(str.length() <=1){
            return false;
        }
        if(str.length() ==2){
            return true;
        }
        String str1 = str.substring(0,2);
        String str2 = str.substring(str.length()-2);
        return str1.equals(str2);
    }
}
