public class Case1 {
    public static void main(String[] args){
        System.out.println("Welcome to Gradle........");
        SpringHelper helper = new SpringHelper();
        System.out.println(
                helper.truncateAInFirst2Position("AACD") +" , "  +
                        helper.truncateAInFirst2Position("AA") +" , "  +
                        helper.truncateAInFirst2Position("ACD") +" , "  +
                        helper.truncateAInFirst2Position("BCDE") +" , "
        );

    }
}
