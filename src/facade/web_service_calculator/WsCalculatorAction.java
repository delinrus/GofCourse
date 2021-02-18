package facade.web_service_calculator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class WsCalculatorAction {

    private final String URL_PATTERN = "http://www.dneonline.com/calculator.asmx?op=%s";

    private final String RESPONSE_BODY_PATTERN = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "  <soap:Body>\n" +
            "    <%s xmlns=\"http://tempuri.org/\">\n" +
            "      <intA>%d</intA>\n" +
            "      <intB>%d</intB>\n" +
            "    </%s>\n" +
            "  </soap:Body>\n" +
            "</soap:Envelope>";

    private final String RESULT_MATCHING_PATTERN = "<%sResult>(.*)</%sResult>";

    protected abstract String getOperation();

    public int doOperation(int x1, int x2) throws Exception {
        HttpURLConnection connection = setConnection();
        sendQuery(connection, x1, x2);
        checkResponse(connection);
        String response = getResponse(connection);
        return matchResult(response);
    }

    private HttpURLConnection setConnection() throws Exception {
        URL obj = new URL(String.format(URL_PATTERN, getOperation()));
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.setDoOutput(true);
        return connection;
    }

    private void sendQuery(HttpURLConnection connection, int x1, int x2) throws IOException {
        try (DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
            String xml = String.format(RESPONSE_BODY_PATTERN, getOperation(), x1, x2, getOperation());
            out.writeBytes(xml);
            out.flush();
        }
    }

    private void checkResponse(HttpURLConnection connection) throws Exception {
        String responseStatus = connection.getResponseMessage();
        if (!"OK".equals(responseStatus)) {
            throw new Exception();
        }
    }

    private int matchResult(String response) throws Exception {
        String resultPattern = String.format(RESULT_MATCHING_PATTERN, getOperation(), getOperation());
        Pattern pattern = Pattern.compile(resultPattern);
        Matcher matcher = pattern.matcher(response);
        if (!matcher.find()) {
            throw new Exception();
        }
        return Integer.parseInt(matcher.group(1));
    }

    private String getResponse(HttpURLConnection connection) throws IOException {
        String response;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            response = in.readLine();
        }
        return response;
    }
}