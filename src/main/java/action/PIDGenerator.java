package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import model.PIDIdResponse;

public class PIDGenerator {

    public List<PIDIdResponse> getIds(int number) {
        List<PIDIdResponse> ids = new ArrayList<PIDIdResponse>();
        InputStream input;
        Properties prop = new Properties();

        try {
            input = this.getClass().getClassLoader().getResourceAsStream("staging.properties");
            prop.load(input);

            int count = 0;
            URL urlID = new URL(prop.getProperty("PIDurl") + number);
            URLConnection con = urlID.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String buffer;
            while ((buffer = reader.readLine()) != "" && reader.ready()) {
                count++;
                PIDIdResponse resp = new PIDIdResponse();
                resp.setId(buffer.replace("id: ", ""));
                resp.setNumber(count);
                ids.add(resp);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ids;
    }
}
