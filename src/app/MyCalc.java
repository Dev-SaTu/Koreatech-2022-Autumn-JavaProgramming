package app;

import lib.Calculator;

public class MyCalc extends Calculator {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mult(int a, int b) {
		return a * b;
	}

	@Override
	public double div(int a, int b) {
		return (double) a / b;
	}

	@Override
	public int abs_value(int x) {
		return Math.abs(x);
	}

	@Override
	public int power(int x, int n) {
		return (int) Math.pow((double) x, (double) n);
	}

	@Override
	public double avg(int[] a) {
		double avg = 0.0;
		for (int i : a) {
			avg += i;
		}
		avg /= a.length;
		return avg;
	}

}
