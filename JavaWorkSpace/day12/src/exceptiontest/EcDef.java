package exceptiontest;

public class EcDef extends Exception {
	static final long serialVersionUID = -338751124229948L;
	
	public EcDef() {
		
	}
	public EcDef(String msg) {
		super(msg);
	}
}
