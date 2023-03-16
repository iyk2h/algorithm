class Solution {
    public String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();

        int leftHand = 10;  
        int rightHand = 12; 

        for(int number : numbers) {

            if(number == 0) number = 11; 

            switch(number % 3) {
                case 0 :  
                    rightHand = number;
                    sb.append("R");
                    break;

                case 1 :  
                    leftHand = number;
                    sb.append("L");
                    break;

                case 2 :  

                    int calL = leftHand - number;  
                    if(calL < 0) calL = calL * -1; 

                    int calR = rightHand - number; 
                    if(calR < 0) calR = calR * -1; 

                    int distanceL = (calL % 3) + (calL / 3); 
                    int distanceR = (calR % 3) + (calR / 3); 

                    if(distanceL < distanceR) { 
                        leftHand = number;
                        sb.append("L");

                    }else if(distanceL > distanceR) { 
                        rightHand = number;
                        sb.append("R");

                    }else {
                        if("left".equals(hand)){
                            leftHand = number;
                            sb.append("L");
                        }else {
                            rightHand = number;
                            sb.append("R");
                        }
                    }
                    break;
            }
        }
        return sb.toString();
    }

}