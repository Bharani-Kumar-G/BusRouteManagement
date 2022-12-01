
public class BaseController {
	public boolean isNumeric(float number) {
		String strNum = Float.toString(number);
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        float d = Float.parseFloat(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
