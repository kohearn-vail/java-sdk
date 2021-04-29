package com.vailsys.freeclimb;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.vailsys.freeclimb.api.FreeClimbException;
import org.apache.commons.codec.binary.Hex;

public class Utils {
	/**
	 * Verify a request's signature
	 *
	 * @param requestBody         The request's body
	 * @param signatureHeader     The request's `freeclimb-signature` header
     * @param signingSecret       A signing secret from the FreeClimb account
     * @param tolerance           Acceptable duration threshold represented in 
     *                            milliseconds, defaulting to 5 minutes when not
     *                            provided
     * @throws FreeClimbException upon failed verification
	 */
	public static void verifyRequest(String requestBody, String signatureHeader, String signingSecret, int tolerance) throws FreeClimbException {
		String[] values = signatureHeader.split(",");

        long time = 0;
        List<String> v1 = new ArrayList<String>();
        for (String queryString : values) {
            try {
                final int idex =queryString.indexOf("=");
                String key = idex > 0
                    ? URLDecoder.decode(queryString.substring(0, idex), "UTF-8")
                    : queryString;
                String value = (idex > 0) && (queryString.length() > idex + 1)
                    ? queryString.substring(idex + 1)
                    : null;
                if (key.equals("t")) {
                    time = Long.parseLong(value);
                }
                if (key.equals("v1")) {
                    v1.add(value);
                }
            } catch (UnsupportedEncodingException e) {
                throw new FreeClimbException(e);
            }
        }

        long currentTime = new Date().getTime();
        long signatureAge = currentTime - (time*1000);
        if (tolerance < signatureAge) {
            throw new FreeClimbException(String.format("Request rejected - signature's timestamp failed against current tolerance of %2d milliseconds. Signature age: %2d milliseconds", tolerance, signatureAge));
        }

        String data = time + "." + requestBody;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(signingSecret.getBytes(), "HmacSHA256"));
            String hmac = Hex.encodeHexString(mac.doFinal(data.getBytes()));

            if (!v1.contains(hmac)) {
                throw new FreeClimbException(String.format("Unverified Request Signature - FreeClimb was unable to verify that this request originated from FreeClimb. If this request was unexpected, it may be from a bad actor. Please proceed with caution. If this request was expected, to fix this issue try checking for any typos or misspelling of your signing secret."));
            }
        } catch (Exception e) {
            throw new FreeClimbException("Failed to calculate hmac using ", e);
        }
	}

    /**
	 * Verify a request's signature
	 *
	 * @param requestBody         The request's body
	 * @param signatureHeader     The request's `freeclimb-signature` header
     * @param signingSecret       A signing secret from the FreeClimb account
     * @throws FreeClimbException upon failed verification
	 */
    public void verifyRequest(String requestBody, String signatureHeader, String signingSecret) throws FreeClimbException {
		this.verifyRequest(requestBody, signatureHeader, signingSecret, 5*60*1000);
	}
}
