package Trans;

import java.util.Random;

public class Trans_2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int detail = 5;
        int final_deatail = 0;
        double cost = 0;
        double fixed_costs = 0.5;
        double other_costs = 0.5;
        int making_detail = 1;
        int detail_cost = 1;
        int price_detail = 10;
        int  i = 1;
         while (i < 366) {
             cost+=fixed_costs;
             cost+=other_costs;
            if (i % 7 == 0){
                detail += 6;
                cost += detail_cost * 6;
            }
            int work = rand.nextInt(100);
            if (work < 90 ){
                if (detail > 0) {
                    final_deatail++;
                    detail--;
                    cost += making_detail;
                }
                else {
                    System.out.println("Нехватает заготовок");

                }
            }
            else {
                System.out.println("День "+i+" Станок сломан");
                System.out.println("День "+(i+1)+" Станок сломан");
                System.out.println("День "+(i+2)+" Станок сломан");
                System.out.println("День "+(i+3)+" Станок сломан");
                i+=4;
                continue;
            }

            System.out.println("День "+ i +" Деталь произведена, сейчас деталей "+ final_deatail);
            i++;
        }
         int revenue = final_deatail*price_detail;
         double profit = revenue - cost;
         System.out.println("Остаток заготовок "+ detail+" Всего деталей произведено "+final_deatail);
         System.out.println("Выручка"+revenue+"Затраты"+cost+"Прибыль"+profit);
    }
}
