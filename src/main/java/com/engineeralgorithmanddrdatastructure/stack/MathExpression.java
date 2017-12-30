package com.engineeralgorithmanddrdatastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MathExpression {
	public static double solveExpression(String expression) {
		List<Item> items = buildItems(expression);
		Stack<Operator> operatorStack = new Stack<>();
		Stack<Operand> operandStack = new Stack<>();
		for (Item item : items) {
			reduceExpression(operatorStack, operandStack, item);
		}
		while (!operatorStack.isEmpty()) {
			double newValue = solveTopExpression(operatorStack, operandStack);
			operandStack.push(new Operand(newValue));
		}
		return operandStack.pop().getValue();
	}

	private static double solveTopExpression(Stack<Operator> operatorStack, Stack<Operand> operandStack) {
		Operator current = operatorStack.pop();
		Operand second = operandStack.pop();
		Operand first = operandStack.pop();
		double newValue = execute(first.getValue(), current.getOperatorType(), second.getValue());
		return newValue;
	}

	private static void reduceExpression(Stack<Operator> operatorStack, Stack<Operand> operandStack, Item item) {
		if (!item.isOperator()) {
			operandStack.add((Operand) item);
		} else {
			if (!operatorStack.isEmpty()) {
				collapseTerms(operatorStack, operandStack, item);
			} else {
				operatorStack.add((Operator) item);
			}
		}
	}

	private static void collapseTerms(Stack<Operator> operatorStack, Stack<Operand> operandStack, Item item) {
		Operator topOperator = operatorStack.peek();
		Operator current = (Operator) item;
		if (current.getPrecedence() <= topOperator.getPrecedence()) {
			double newValue = solveTopExpression(operatorStack, operandStack);
			operandStack.push(new Operand(newValue));
			operatorStack.push(current);
		} else {
			operatorStack.add((Operator) item);
		}

	}

	private static double execute(double left, OperatorType operatorType, double right) {
		switch (operatorType) {
		case DIVISION:
			return left / right;
		case MULTIPLICATION:
			return left * right;
		case SUBSTRACTION:
			return left - right;
		case ADDITION:
			return left + right;
		}
		return 0;
	}

	private static List<Item> buildItems(String expression) {
		List<Item> terms = new ArrayList<>();
		StringBuffer operand = new StringBuffer();
		for (int index = 0; index < expression.length(); index++) {
			if (isOperator(expression.charAt(index))) {
				OperatorType operatorType = getOperatorType(expression.charAt(index));
				double number = Double.parseDouble(operand.toString());
				terms.add(new Operand(number));
				terms.add(new Operator(operatorType));
				operand = new StringBuffer();
			} else {
				operand.append(expression.charAt(index));
			}
		}
		if (operand.length() > 0) {
			double number = Double.parseDouble(operand.toString());
			terms.add(new Operand(number));
		}
		return terms;
	}

	private static OperatorType getOperatorType(char operator) {
		switch (operator) {
		case '-':
			return OperatorType.SUBSTRACTION;
		case '+':
			return OperatorType.ADDITION;
		case '/':
			return OperatorType.DIVISION;
		case '*':
			return OperatorType.MULTIPLICATION;
		}
		return null;
	}

	private static boolean isOperator(char operator) {
		return operator == '-' || operator == '+' || operator == '/' || operator == '*';
	}

}

abstract class Item {
	public boolean isOperator() {
		return false;
	}
}

enum OperatorType {
	ADDITION(1), MULTIPLICATION(2), DIVISION(2), SUBSTRACTION(1);
	private final int precedence;

	OperatorType(int precedence) {
		this.precedence = precedence;
	}

	public int getPrecedence() {
		return precedence;
	}

}

class Operator extends Item {
	private final OperatorType operatorType;

	public Operator(OperatorType operatorType) {
		super();
		this.operatorType = operatorType;
	}

	public OperatorType getOperatorType() {
		return operatorType;
	}

	public int getPrecedence() {
		return this.operatorType.getPrecedence();
	}

	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public String toString() {
		return operatorType.toString();
	}

}

class Operand extends Item {
	private double value;

	public Operand(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
