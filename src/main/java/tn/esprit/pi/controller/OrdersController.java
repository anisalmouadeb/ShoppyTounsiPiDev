package tn.esprit.pi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import tn.esprit.pi.entities.OrderLine;
import tn.esprit.pi.entities.Orders;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.OrderLineRepository;
import tn.esprit.pi.repository.OrdersRepository;
import tn.esprit.pi.repository.ShoppingCartRepository;
import tn.esprit.pi.service.IOrderLineService;
import tn.esprit.pi.service.IOrdersService;
import tn.esprit.pi.service.PDFExporter;

@RestController
public class OrdersController {

	@Autowired
	OrdersRepository OrdersRepo;
	@Autowired
	ShoppingCartRepository ShoppingCartRepo;
	@Autowired
	OrderLineRepository OrderLineRepo;
	@Autowired
	IOrdersService OrdersService;

	@Autowired
	IOrderLineService OrderLineService;

	@RequestMapping(value = "/ConfirmOrder/{ShoppingCartId}", method = RequestMethod.POST)
	@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN') ")
	public String ConfirmOrder(@PathVariable("ShoppingCartId") long ShoppingCartId) {
		return OrdersService.ConfirmOrder(ShoppingCartId);
	}
	/*
	 * @RequestMapping(value = "/InsertOrderLineToOrder/{orderLineId}", method =
	 * RequestMethod.POST)
	 * 
	 * @PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN') ") public String
	 * InsertOrderLineToOrder(@PathVariable("orderLineId") long orderLineId) {
	 * return OrdersService.InsertOrderLineToOrder(orderLineId); }
	 */

	@GetMapping("/export/pdf/{id}")
	public void exportToPDF(HttpServletResponse response, @PathVariable("id") long id)
			throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Invoice_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<OrderLine> orders = new ArrayList<OrderLine>();
		orders = OrdersRepo.findById(id).get().getOrderLine();
		PDFExporter exporter = new PDFExporter(orders);
		exporter.export(response);

	}

	@GetMapping(value = "/GetOrderOftheMonth")
	@ResponseBody
	public Orders GetOrderOftheMonth() {
		return OrdersService.GetOrderOftheMonth();
	}
	
	
	@GetMapping(value = "/GetStarUserOftheMonth")
	@ResponseBody
	public User GetStarUserOftheMonth() {
		return OrdersService.GetStarUserOftheMonth();
	}
	
	@PostMapping(value = "/CancelOrder/{orderId}")
	@ResponseBody
	public String CancelOrder(@PathVariable("orderId")long orderId) {
		return OrdersService.CancelOrder(orderId);
	}
}
