package com.hw2;
import java.util.ArrayList;
import java.util.List;


public class Folder extends Directory{
    private String folderName;
    private List<Directory> children;
    
    public Folder(String name){
        this.folderName = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
		return this.folderName;
    }

    public void add(Directory element) {
		children.add(element);
	}

	public void remove(Directory element) {
		children.remove(element);
	}

    public List<Directory> getChildren() {
		return children;
	}

    public double calculateSize() {
		double size = 0;
		for (Directory ele : children) {
			size += ele.calculateSize();
		}
		
		return size;
	}

}