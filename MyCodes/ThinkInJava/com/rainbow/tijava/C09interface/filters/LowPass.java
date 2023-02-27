package com.rainbow.tijava.C09interface.filters;
/*
 * Filter 的子类, 也即变化的策略
 */
public class LowPass extends Filter{
    private double cutoff;
    public LowPass(double cut){
        this.cutoff = cut;
    }
    @Override
    public Waveforms process(Waveforms input) {
        return input;   // Dummy process
    }
}
