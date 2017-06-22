package com.joerg.pages;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.joerg.WicketApplication;
import com.joerg.components.ShoppingCartPanel;

public class CheckoutPageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
		tester.startPage(Checkout.class);
	}

	@Test
	public void testPage() {
		tester.assertRenderedPage(Checkout.class);
		tester.assertComponent("form", Form.class);
		tester.assertComponent("cart", ShoppingCartPanel.class);
	}

	@Test
	public void testFeedbackPanel() {
		tester.assertComponent("feedback", FeedbackPanel.class);
		tester.assertNoInfoMessage();
		tester.assertNoErrorMessage();
	}
}