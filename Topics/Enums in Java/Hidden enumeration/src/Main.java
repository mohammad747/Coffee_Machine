public class Main {

    public static void main(String[] args) {
    // write your program here
        Secret[] secrets = Secret.values();
        int counter = 0;
        for (Secret s : secrets) {
            if (s.toString().substring(0, 4).equalsIgnoreCase("star")) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}


//   enum Secret {
//    STAR, CRASH, START, // ...
//}
