public class Primes {
    /*% java Primes 30
        Prime numbers up to 30:
        2
        3
        5
        7
        11
        13
        17
        19
        23
        29
        There are 10 primes between 2 and 30 (33% are primes)
     */
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        boolean[] arr = new boolean[number + 1];
        //int halfLen = number / 2;
        // if (number % 2 == 0){
        //     halfLen = number / 2;
        // } else {
        //     halfLen = (number / 2) + 1;
        // }

        for(int i = 0; i < arr.length; i ++){
            arr[i] = true;
        }

        for (int i = 2; i < number; i ++){
            for(int j = i + 1; j < number; j ++){
                if(j % i == 0){
                    arr[j] = false;
                }
            }
        }

        System.out.println("Prime numbers up to " + number + ":");
        int counterPrime = 0;
        for(int i = 2; i < arr.length; i ++){
            if(arr[i]){
                System.out.println(i);
                counterPrime ++;
            }
        }
        //There are 10 primes between 2 and 30 (33% are primes)
        int present = (int)(100 * (counterPrime / (double)number));
        System.out.println("There are " + counterPrime + " primes between 2 and " + 
                            number + " (" + present + "% are primes)");
    }
}