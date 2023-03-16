package com.thkjava.secabase.C09interface.filters;
/*
 * Filter 的子类, 也即变化的策略
 */
public class BandPass extends Filter{
    private double lowCutoff, highCutoff;
    public BandPass(double low, double high){
        this.lowCutoff = low;
        this.highCutoff = high;
    }
    @Override
    public Waveforms process(Waveforms input) {
        return input;   // Dummy process
    }
}
