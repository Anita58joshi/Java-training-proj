package com.anita.factory;

public class SubCommand extends MathCommand{
    @Override
    public Double calculate(Double x, Double y) {
        return x-y;
    }
}
