package com.soccerjerseystore.resource;

@RestController
@RequestMapping("/cart")
public class ShoppingCartResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JerseyService jerseyService;
	
	@Autowired
	private cartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	

}
