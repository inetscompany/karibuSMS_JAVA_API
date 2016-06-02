package karibusms;
/**
 * -----------------------------------------
 * 
 * ******* Address****************
 * INETS COMPANY LIMITED
 * P.O BOX 32258, DAR ES SALAAM
 * TANZANIA
 * 
 * 
 * *******Office Location *********
 * 11th block, Bima Road, Mikocheni B, Kinondoni, Dar es salaam
 * 
 * 
 * ********Contacts***************
 * Email: <info@inetstz.com>
 * Website: <www.inetstz.com>
 * Mobile: <+255 655 406 004>
 * Tel:    <+255 22 278 0228>
 * -----------------------------------------
 */

/**
 *
 * @author Ephraim Swilla <ephraim@inetstz.com>
 */
public class Example {

    static Karibusms sms;

    public static void main(String[] args) throws Exception {
	sms = new Karibusms();
	String x = sms.send_sms("0655406004", "Testing from java api");
	System.out.print(x);
    }

}
