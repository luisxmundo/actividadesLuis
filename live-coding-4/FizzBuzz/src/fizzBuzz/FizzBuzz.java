package fizzBuzz;

public class FizzBuzz {
    int numMax = 100;

    //Métodos propios
    public void FizzBuzz() {
        for (int i = 1; i <= numMax; i++){
            //System.out.println(i);
            if(i % 3 == 0 && i % 5 == 0 ) {
                System.out.println("FizzBuzz");
            }else if(i  % 3 == 0){
                System.out.println("Fizz");
            }else if(i % 5 == 0){
                System.out.println("Buzz");
            } else if(i % 3 !=0 || i % 5 !=0){
                System.out.println(i);
            }
        }
    }

}