package controller.SHARE;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return (new ObjectMapper()).readValue(this.value, tClass);
        } catch (Exception var3) {
            System.out.print(var3.getMessage());
            return null;
        }
    }

    public static HttpUtil of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException var3) {
            System.out.print(var3.getMessage());
        }

        return new HttpUtil(sb.toString());
    }
}
