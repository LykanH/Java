package service;
/**
 * 
 * @Description  表示三种成员的状态
 * @author muchen
 * @version
 * @date 2022年8月8日下午2:39:05
 *
 */
public class Status {
	private final String NAME;

	public Status(String name) {
		this.NAME = name;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");

	public String getNAME() {
		return NAME;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return NAME;
		}

}
