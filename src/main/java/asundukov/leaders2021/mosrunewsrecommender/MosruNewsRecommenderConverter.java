package asundukov.leaders2021.mosrunewsrecommender;

import asundukov.leaders2021.mosrunewsrecommender.model.News;
import asundukov.leaders2021.mosrunewsrecommender.model.NewsItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MosruNewsRecommenderConverter {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("ttt.txt");
        File file = new File(url.getPath());
        InputStream in = new FileInputStream(file);
        BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));

		News news = mapper.readValue(r, News.class);

		FileWriter fw = new FileWriter("out.txt");

		for (NewsItem item : news) {
			fw.write("INSERT INTO news (it, title, importance, is_powered, preview_text, full_text) VALUES ("
                    +item.id+","
                    + escapeString(item.title)+","
                    + escapeString(item.importance)+""
                    + escapeString(item.is_powered)+""
                    + escapeString(item.preview_text)+""
                    + escapeString(item.full_text)+""
                    + ");\n");
		}
		fw.close();
		System.out.println();
	}

    public static String escapeString(String x) {
	    if (x == null) {
	        return "null";
        }
        StringBuilder sBuilder = new StringBuilder(x.length() * 11/10);

        int stringLength = x.length();

        for (int i = 0; i < stringLength; ++i) {
            char c = x.charAt(i);

            switch (c) {
                case 0: /* Must be escaped for 'mysql' */
                    sBuilder.append('\\');
                    sBuilder.append('0');

                    break;

                case '\n': /* Must be escaped for logs */
                    sBuilder.append('\\');
                    sBuilder.append('n');

                    break;

                case '\r':
                    sBuilder.append('\\');
                    sBuilder.append('r');

                    break;

                case '\\':
                    sBuilder.append('\\');
                    sBuilder.append('\\');

                    break;

                case '\'':
                    sBuilder.append('\\');
                    sBuilder.append('\'');

                    break;

                case '"': /* Better safe than sorry */
                        sBuilder.append('\\');

                    sBuilder.append('"');

                    break;

                case '\032': /* This gives problems on Win32 */
                    sBuilder.append('\\');
                    sBuilder.append('Z');

                    break;

                case '\u00a5':
                case '\u20a9':
                    // escape characters interpreted as backslash by mysql
                    // fall through

                default:
                    sBuilder.append(c);
            }
        }

        return "\"" + sBuilder.toString() + "\"";
    }
}
