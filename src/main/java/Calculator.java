import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alfeu on 18/05/16.
 */
public class Calculator {
	public int calculate(String expression){
		int result = 0;
		
		expression = expression.replaceAll(" ", "");
		
		//check if there is a parenthesis expression, then resolve, transform expression and check again
		Pattern innerParenthesisRegex = Pattern.compile("\\((?=[^\\(]*$)([^\\)]+)\\)");
		Matcher matcher = innerParenthesisRegex.matcher(expression);
		boolean hasParenthesis = false;
		if(matcher.find()){
			hasParenthesis = true;
			do{
				//eval matched expression
				String simpleExpression = matcher.group(1);
				result = evaluateExpressionWithoutParenthesis(simpleExpression);
				
				//transform the actual expression into a smaller one
				expression = matcher.replaceAll(Integer.toString(result));
				matcher = innerParenthesisRegex.matcher(expression);
				hasParenthesis = matcher.find();
				//do this until there is no parenthesis left
			}while(hasParenthesis);
		}
		
		//after removing all parenthesis, resolve expression		
		result = evaluateExpressionWithoutParenthesis(expression);

		return result;
	}

	private int evaluateExpressionWithoutParenthesis(String expression){
		int result = 0;
		//resolve first the multiplications
		Pattern multiplicationOperationRegex = Pattern.compile("(\\d+)\\*(\\d+)");
		Matcher matcher = multiplicationOperationRegex.matcher(expression);
		boolean hasMultiplicationOperation = false;
		if(matcher.find()){
			hasMultiplicationOperation = true;
			do{
				//eval matched expression
				int number1 = Integer.parseInt(matcher.group(1));
				int number2 = Integer.parseInt(matcher.group(2));
				result = evaluateExpression(number1, number2, '*');
				
				//transform the actual expression into a smaller one
				expression = matcher.replaceFirst(Integer.toString(result));
				matcher = multiplicationOperationRegex.matcher(expression);
				hasMultiplicationOperation = matcher.find();
				
				//do this until there is no parenthesis left				
			}while(hasMultiplicationOperation);
		}
		
		//resolve the remaining operations
		Pattern operationRegex = Pattern.compile("(\\d+)([\\+\\-])(\\d+)");
		matcher = operationRegex.matcher(expression);
		boolean hasOperation = false;
		if(matcher.find()){
			hasOperation = true;
			do{
				//eval matched expression
				int number1 = Integer.parseInt(matcher.group(1));
				int number2 = Integer.parseInt(matcher.group(3));
				result = evaluateExpression(number1, number2, matcher.group(2).toCharArray()[0]);
				
				//transform the actual expression into a smaller one
				expression = matcher.replaceFirst(Integer.toString(result));
				matcher = operationRegex.matcher(expression);
				hasOperation = matcher.find();
				//to this until there is no parenthesis left
				
			}while(hasOperation);
		}

		return result;
	}
	private int evaluateExpression(int number1, int number2, char operation){
		//calculate
		int result = 0;
		switch(operation){
			case '+':
				result = number1 + number2;
				break;
			case '-':
				result = number1 - number2;
				break;
			case '*':
				result = number1 * number2;
				break;
			default:
				throw new UnsupportedOperationException("Operation not supported");
		}
		return result;
	}
}
