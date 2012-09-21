package org.hammernight.selenium_grid_ui;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.Registry;
import org.openqa.grid.internal.TestSession;
import org.openqa.grid.internal.listeners.TestSessionListener;
import org.openqa.grid.internal.utils.HtmlRenderer;
import org.openqa.grid.selenium.proxy.WebDriverRemoteProxy;

public class MyWebDriverRemoteProxy extends WebDriverRemoteProxy implements TestSessionListener {

    private int totalTests = 0;

    public MyWebDriverRemoteProxy(RegistrationRequest request, Registry registry) {
        super(request, registry);
    }

    @Override
    public void beforeSession(TestSession session) {
        super.beforeSession(session);
        synchronized (this) {
            totalTests++;
        }
    }


    public synchronized int getTotalTests() {
        return totalTests;
    }

    private HtmlRenderer renderer = new HamlHtmlRenderer(this);

    @Override
    public HtmlRenderer getHtmlRender() {
        return renderer;
    }
}
