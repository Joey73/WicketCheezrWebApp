package com.joerg;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import com.gfu.wicket.backend.bo.Cart;

public class CheesrSession extends WebSession {
	private static final long serialVersionUID = 1L;
	private Cart cart = new Cart();

	public CheesrSession(Request request) {
		super(request);
	}

	public Cart getCart() {
		return cart;
	}
}
