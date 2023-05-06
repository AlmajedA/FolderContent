package com.hw2;
import java.util.List;

public abstract class Directory {

    public abstract String getName();

    public abstract void add(Directory element);
    
	public abstract void remove(Directory element);

    public abstract List<Directory> getChildren();

    public abstract double calculateSize();
}
 