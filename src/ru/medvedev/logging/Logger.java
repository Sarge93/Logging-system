package ru.medvedev.logging;

import sun.reflect.Reflection;

import java.util.ArrayList;

/**
 * Created by Сергей on 12.04.2016.
 */
public class Logger {
    private String name;
    private ArrayList<Handler> handlers = new ArrayList<Handler>();
    private Filter filter;
    private Logger parent;
    private Level defaulLevel;

    public Logger(String name, Level defaulLevel) {
        this.name = name;
        this.defaulLevel = defaulLevel;
    }

    public Logger(String name) {
        this(name, Level.info);
    }

    public Logger() {
        this(Reflection.getCallerClass().getName());
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public void log(Level level, String lodMsg) {
        if (level.ordinal() < defaulLevel.ordinal()) {
            return;
        }
        Record record = new Record(level, lodMsg);
    }
}
