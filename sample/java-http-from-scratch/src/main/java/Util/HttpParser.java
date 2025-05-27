package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpParser {

    public String[] parseStatusLine(InputStream inputStream) throws IOException {

        BufferedReader httReader = new BufferedReader(new InputStreamReader(inputStream));

        String httpStatusLine = httReader.readLine();

        String[] httpRequestParams = httpStatusLine.split(" ");

        return httpRequestParams;
    }
    
}
