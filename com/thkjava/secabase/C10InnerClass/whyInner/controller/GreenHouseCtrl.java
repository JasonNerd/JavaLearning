package com.thkjava.secabase.C10InnerClass.whyInner.controller;
// This produces a specific application of thecontrol system, 
// all in a single class. Innerclasses allow you to encapsulate
// differentfunctionality for each type of event

public class GreenHouseCtrl extends Controller{
    // 灯光
    private boolean light = false;
    public class LightOn extends Event{
        public LightOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            light = true;   // 实际以硬件程序替代
        }
        @Override
        public String toString() {
            return "Light is on.";
        }
    }
    public class LightOff extends Event{
        public LightOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            light = false;   // 实际以硬件程序替代
        }
        public String toString() {
            return "Light is off.";
        }
    }
    // 水分
    private boolean water = false;
    public class WaterOn extends Event{
        public WaterOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            water = true;   // 实际以硬件程序替代
        }
        @Override
        public String toString() {
            return "Water is on.";
        }
    }
    public class WaterOff extends Event{
        public WaterOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            water = false;   // 实际以硬件程序替代
        }
        public String toString() {
            return "Water is off.";
        }
    }
    // 昼夜
    private String thermostat = "Day";
    public class ThermostatNight extends Event{
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            thermostat = "Night";   // 实际以硬件程序替代
        }
        @Override
        public String toString() {
            return "Thermostat on night setting.";
        }
    }
    public class ThermostatDay extends Event{
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            thermostat = "Day";   // 实际以硬件程序替代
        }
        public String toString() {
            return "Thermostat on day setting.";
        }
    }
    // 警铃
    public class Bell extends Event{
        public Bell(long delayTime) {
            super(delayTime);
        }
        public void action() {
            addEvent(new Bell(delayTime));
        }
        public String toString() {
            return "Bing!";
        }
    }
    // 重启
    public class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime, Event[] events){
            super(delayTime);
            eventList = events;
            for(Event e: eventList)
                addEvent(e);
        }
        public void action() {
            for (Event e: eventList){
                e.start();
                addEvent(e);
            }
            start();        // Rerun this event
            addEvent(this);
        }
        @Override
        public String toString() {
            return "Restarting System.";
        }
    }
    // 关机
    public static class Terminate extends Event{
        public Terminate(long delayTime) { super(delayTime); }
        public void action(){ System.exit(0); }
        @Override
        public String toString() {
            return "Terminating";
        }
    }

    public static void main(String[] args) {
        GreenHouseCtrl gCtrl = new GreenHouseCtrl();
        gCtrl.addEvent(gCtrl.new Bell(5000));
        Event[] events = {
            gCtrl.new ThermostatNight(0), 
            gCtrl.new WaterOn(300), 
            gCtrl.new WaterOff(600), 
            gCtrl.new LightOff(900), 
            gCtrl.new ThermostatDay(1500), 
            gCtrl.new LightOn(1800), 
            gCtrl.new WaterOn(2100), 
            gCtrl.new LightOff(2400), 
            gCtrl.new WaterOff(2700), 
        };
        gCtrl.addEvent(gCtrl.new Restart(3200, events));
        if (args.length == 1)
            gCtrl.addEvent(new GreenHouseCtrl.Terminate(new Integer(args[0])));
        gCtrl.run();
    }
}
