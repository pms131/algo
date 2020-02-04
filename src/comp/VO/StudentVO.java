package comp.VO;

import java.util.Comparator;

public class StudentVO {

	private String name;
	private int height;
	private double vision;

	public StudentVO() {
		name = "";
		height = 0;
		vision = 0;
	} 
	
	public StudentVO(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	public static final Comparator<StudentVO> HEIGHT_ORDER = new HeightOrderComp();
	
	private static class HeightOrderComp implements Comparator<StudentVO> {
		@Override
		public int compare(StudentVO s1, StudentVO s2) {
			if(s1.height > s2.height) {
				return 1;
			} else if (s1.height < s2.height) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getVision() {
		return vision;
	}

	public void setVision(double vision) {
		this.vision = vision;
	}

	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", height=" + height + ", vision=" + vision + "]";
	}
	
	
	
}
