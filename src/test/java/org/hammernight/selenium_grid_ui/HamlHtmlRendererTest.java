package org.hammernight.selenium_grid_ui;

import org.junit.Test;
import org.openqa.grid.internal.utils.HtmlRenderer;
import org.openqa.grid.selenium.proxy.WebDriverRemoteProxy;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class HamlHtmlRendererTest {

    private HamlHtmlRenderer renderer;
    private WebDriverRemoteProxy proxy;

    public HamlHtmlRendererTest() {
        proxy = mock(WebDriverRemoteProxy.class);
        renderer = new HamlHtmlRenderer(proxy);
    }


    @Test
    public void shouldCreateHtmlRenderer() {
        assertTrue(renderer instanceof HtmlRenderer);
    }

    @Test
    public void shouldLoadHamlTemplate() {
        assertEquals("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">", renderer.renderSummary().split("\n")[0]);
    }

    @Test
    public void shouldShowCorrectNumberOfNodes() {

    }
}
