package org.hammernight.selenium_grid_ui;

import com.cadrlife.jhaml.JHaml;
import org.openqa.grid.internal.utils.HtmlRenderer;
import org.openqa.grid.selenium.proxy.WebDriverRemoteProxy;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class HamlHtmlRenderer implements HtmlRenderer {

    private WebDriverRemoteProxy proxy;

    public HamlHtmlRenderer(WebDriverRemoteProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public String renderSummary() {
        try {
            return new JHaml().parse(readFile("template.haml"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    private static String readFile(String path) throws IOException {
        FileInputStream stream = new FileInputStream(new File(path));
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            /* Instead of using default, pass in a decoder. */
            return Charset.forName("utf-8").decode(bb).toString();
        }
        finally {
            stream.close();
        }
    }
}
