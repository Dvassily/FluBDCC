package fluEpidemic;
/*
 *ColorAnsi manage color for toString method of entity
 *associate to a color his ANSI code.
 */
public enum ColorAnsi {
    GREEN("\u001B[32m"),
    RED("\u001B[31m"),
    RESET("\u001B[0m");
	
	private String codeColor;
	ColorAnsi(String color){
		this.codeColor = color;
	}
	public String getCodeColor() {
		return codeColor;
	}
    
}
