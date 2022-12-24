import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] arg){
        Equation();
    }

    public static int GetNumber()
    {
        Scanner numberS = new Scanner(System.in);
        int number;
        while(true)
        {
            try {
                System.out.print("Введите число: ");
                number = numberS.nextInt();
                break;
            } catch(Exception e) {
                System.out.print("Ошибка ввода");
            }

        }
        return number;
    }

    public static String GetString()
    {
        Scanner str = new Scanner(System.in);
        String equation;
        System.out.print("Введите формулу:  ");
        equation = str.nextLine();
        return equation;
    }

    public static void Equation()
    {
        Map<String,Integer> states = new HashMap<String,Integer>();
       states.put("p",0);
        Scanner str = new Scanner(System.in);
        //a+b+c+d+c
        String equation = GetString();
        equation =String.format(equation).replace(" ","");
        String[] st1= equation.split("\\+");
        //int [] numbers = new int [st1.length];
        int sum = 0;
        for (int i = 0; i < st1.length; i++)
        {
            for (Map.Entry<String,Integer> item : states.entrySet()) {

                if (item.getKey() != st1[i]) {
                    states.put(st1[i], GetNumber());
                    break;
                }
            }
        }
        for(Map.Entry<String,Integer> item : states.entrySet()){
            sum+=item.getValue();
        }
        System.out.printf("ответ: %d",sum);


        }
    }


