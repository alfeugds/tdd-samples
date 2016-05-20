/**
 * Created by alfeu on 18/05/16.
 */
public class Calculator {
    public int calculate(String expression){
        int result = 0;
        ExpressionNumber number1 = new ExpressionNumber();
        ExpressionNumber number2 = new ExpressionNumber();
        char operation = ' ';

        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                int number = Character.getNumericValue(c);
                //set number1. if already set, set number 2
                //if number2 is set, resolve the expression and set result to number1
                if (!number1.isSet()){
                    number1.setSet(true);
                    number1.setValue(number);
                }else if(!number2.isSet()) {
                    number2.setSet(true);
                    number2.setValue(number);

                    //calculate
                    switch(operation){
                        case '+':
                            result += number1.getValue() + number2.getValue();
                            break;
                        case '-':
                            result += number1.getValue() - number2.getValue();
                            break;
                        case '*':
                            result += number1.getValue() * number2.getValue();
                            break;
                    }
                    //reset values
                    number2.reset();
                    number1.setValue(result);

                }

            }else{
                switch(c){
                    case '+':
                    case '-':
                    case '*':
                        operation = c;
                        break;
                }
            }
        }

        return result;
    }

    class ExpressionNumber{

        boolean isSet;
        int value;

        public void reset(){
            this.isSet = false;
            this.value = 0;
        }

        public boolean isSet() {
            return isSet;
        }

        public void setSet(boolean set) {
            isSet = set;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }


    }
}
