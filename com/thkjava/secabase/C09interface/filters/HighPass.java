package com.thkjava.secabase.C09interface.filters;
/*
 * Filter 的子类, 也即变化的策略
 */
public class HighPass extends Filter{
    private double cutoff;
    public HighPass(double cut){
        this.cutoff = cut;
    }
    @Override
    public Waveforms process(Waveforms input) {
        return input;   // Dummy process
    }
}
