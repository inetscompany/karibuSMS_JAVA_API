package karibusms;

/**
 * -----------------------------------------
 *
 * ******* Address**************** 
 * INETS COMPANY LIMITED
 * P.O BOX 32258, DAR ES
 * SALAAM TANZANIA
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

/*
 |--------------------------------------------------------------------------
 | Application package for sending SMS
 |--------------------------------------------------------------------------
 |
 | This Class is the core file that connect your application written in JAVE 
 | with karibusms. Please remember to obtain your API KEY and API SECRET in
 | http://karibusms.com/api after being login.

 For any request, please mail us to info@karibusms.com
 |
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Ephraim Swilla <ephraim@inetstz.com>
 * @version 2.1.0
 *
 */
public class Karibusms {

    /**
     * --------------------------------------------------------------------------
     *
     * @var final Integer karibusmspro
     * --------------------------------------------------------------------------
     * This define if you want to send SMS via INTERNET based or you want your
     * mobile phone to send SMS.
     *
     * N:B; karibuSMS MUST be installed in your android phone to enable SMS to
     * be sent from android phone
     *
     * karibusmspro = 1 , Internet SMS, karibusmspro = 0, Phone SMS
     */
    final Integer karibusmspro = 1;

    /**
     * --------------------------------------------------------------------------
     *
     * @var String API_KEY
     * --------------------------------------------------------------------------
     *
     * Obtained directly from http://karibusms.com/api after creating your APP
     * name
     *
     */
    final String API_KEY = "74478661445646499";
    /**
     * --------------------------------------------------------------------------
     *
     * @var String API_SECRET
     * --------------------------------------------------------------------------
     *
     * Obtained directly from http://karibusms.com/api after creating your APP
     * name
     *
     */
    final String API_SECRET = "5ed1c4c170a811ac24b52c7b444c8bed928e5967";

    /**
     * -------------------------------------------------------------------------
     *
     * @var String name;
     * -------------------------------------------------------------------------
     *
     * A name that will appear in text SMS when user receives SMS. This will
     * only be valid if you set variable karibusmspro=1
     *
     */
    final String name = "KARIBU";

    /**
     * @param phone_number
     * @param message
     * @return JSON Object
     * @throws java.lang.Exception
     */
    public String send_sms(String phone_number, String message) throws Exception {
	return this.curl(this.writeBufferSms(phone_number, message));
    }

    private String curl(String param) throws Exception {
	String returns = null;
	URL url = new URL("http://karibusms.com/api");
	URLConnection conn = url.openConnection();
	conn.setDoOutput(true);
	BufferedReader reader;
	try (OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream())) {
	    writer.write(param);
	    writer.flush();
	    String line;
	    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    while ((line = reader.readLine()) != null) {
		returns = line;
	    }
	}
	reader.close();
	return returns;
    }

    /**
     *
     * @return JSON Object
     * @throws Exception
     */
    public String get_statistics() throws Exception {
	return this.curl(this.writeBufferStatistic());
    }

    /**
     *
     * @param phone_number
     * @param message
     * @return String
     */
    private String writeBufferSms(String phone_number, String message) {
	return "api_key=" + API_KEY + "&karibusmspro=" + karibusmspro + "&message=" + message + "&phone_number=" + phone_number + "&name=" + name + "&api_secret=" + API_SECRET;
    }

    /**
     *
     * @return String
     */
    private String writeBufferStatistic() {
	return "api_key=" + API_KEY + "&tag=get_statistics&api_secret=" + API_SECRET;
    }
}
