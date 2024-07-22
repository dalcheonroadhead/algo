import java.io.*;
import java.util.*;

class Solution {
        public int solution(int[] picks, String[] minerals) {
            int cost =  0;
            int share = minerals.length/5;
            int remainder = minerals.length%5;
            int cost_length = remainder==0? share : share+1;

            Cost [] allCost = new Cost [cost_length];

            for(int i = 0; i < cost_length; i++) {
                int d_cost = 0;
                int i_cost = 0;
                int s_cost = 0;
                int loop_length = (i == cost_length-1)? remainder : 5;

                for(int j = 0; j < loop_length; j++) {
                    switch(minerals[i*5+j]){
                        case "diamond": {
                            d_cost+=1;
                            i_cost+=5;
                            s_cost+=25;
                            break;
                        }
                        case "iron": {
                            d_cost+=1;
                            i_cost+=1;
                            s_cost+=5;
                            break;
                        }
                        case "stone": {
                            d_cost+=1;
                            i_cost+=1;
                            s_cost+=1;
                            break;
                        }
                    }
                }
                allCost[i] = new Cost(d_cost,i_cost,s_cost);

            }



            Arrays.sort(allCost, new Comparator<Cost>() {
                @Override
                public int compare(Cost o1, Cost o2){
                    return o2.s_cost - o1.s_cost;
                }
            });
            int iter = 0;
            while((picks[0] > 0|| picks[1] > 0 || picks[2] > 0) && iter < allCost.length){
                if(picks[0]-- > 0) cost        += allCost[iter++].d_cost;
                else if(picks[1]-- > 0) cost   += allCost[iter++].i_cost;
                else if(picks[2]-- > 0) cost   += allCost[iter++].s_cost;
            }

            return cost;
        }
}

    class Cost {
        int d_cost;
        int i_cost;
        int s_cost;

        public Cost(int d_cost, int i_cost, int s_cost) {
            this.d_cost = d_cost;
            this.i_cost = i_cost;
            this.s_cost = s_cost;
        }
    }

