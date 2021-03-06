package com.joerg.pages;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import com.gfu.wicket.backend.BOServices;
import com.gfu.wicket.backend.bo.Address;
import com.gfu.wicket.backend.bo.Cart;
import com.joerg.components.ShoppingCartPanel;

public class Checkout extends CheesrPage {
	private static final long serialVersionUID = 1L;

	public Checkout() {
		add(new FeedbackPanel("feedback"));
		Form<Address> form = new Form<Address>("form");
		add(form);
		Address address = getCart().getBillingAddress();
		form.add(new TextField<String>("name", new PropertyModel<String>(address, "name")).setRequired(true));
		form.add(new TextField<String>("street", new PropertyModel<String>(address, "street")).setRequired(true));
		form.add(new TextField<String>("zipcode", new PropertyModel<String>(address, "zipcode")).setRequired(true));
		form.add(new TextField<String>("city", new PropertyModel<String>(address, "city")).setRequired(true));

		form.add(new Link("cancel") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(Index.class);
			}
		});
		form.add(new Button("order") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				BOServices.get().proccessOrder(getCart());
				Cart cart = getCart();
				cart.getCheeses().clear();
				setResponsePage(Index.class);
			};
		});

		add(new ShoppingCartPanel("cart", getCartModel()));
	}
}
