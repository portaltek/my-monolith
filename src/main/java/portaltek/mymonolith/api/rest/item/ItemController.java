package portaltek.mymonolith.api.rest.item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ItemController {

	@GetMapping("/")
	public String helloWorld() {
		return "HelloWorld!";
	}

	@PostMapping("/api/rest/v1/item/create")
	public String createItem(ItemReq itemReq) {
		return "HelloWorld1";
	}

	@GetMapping("/api/rest/v1/item/list")
	public String listItem(ItemReq itemReq) {
		return "HelloWorld2";
	}


}
