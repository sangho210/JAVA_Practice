package com.omok;
import java.io.Serializable;

//서버, 클라이언트 공용
public class PointMsg implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int code;
	private int x, y;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
