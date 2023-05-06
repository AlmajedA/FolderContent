package com.hw2;
import java.util.List;

public class File extends Directory{
    private String fileName;
    private double size;
    private String extension;

    public File(String fileName, long size, String extension){
        this.fileName = fileName;
        this.size = size;
        this.extension = extension;
    }

    public String getName(){
        return this.fileName + '.' + this.extension;
    }

    public double calculateSize(){
        return this.size/1024.0/1024.0;
    }

    public String getExtension(){
        return this.extension;
    }
    
    

    public void add(Directory element) {
		throw new UnsupportedOperationException("Invalid operation for file type.");
	}

	public void remove(Directory element) {
		throw new UnsupportedOperationException("Invalid operation for file type.");
	}

    public List<Directory> getChildren() {
		throw new UnsupportedOperationException("Invalid operation for file type.");
	}

}
