package edu.miu.cs.cs425.sweonlinemarketproject.controller;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Order;
import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;
import edu.miu.cs.cs425.sweonlinemarketproject.service.OrderService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping(value="/all")
    public String getAllOrders(Model model){

        model.addAttribute("orders", orderService.getAllOrders());
        return "order/list";
    }

    @GetMapping(value="/{id}")
    public String getOrderById(@PathVariable("id") long id, Model model){
        model.addAttribute("orders", orderService.getOrderById(id));
        return "order/order-view";
    }



    @PostMapping(value="/save-order")
    public String saveOrder(@Valid @RequestBody Model model, @Valid @ModelAttribute("order") Order order, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "order/order-form";
        }
        orderService.saveOrder(order);
        return "redirect:/order/list";
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteOrder(@PathVariable("id") long id){
        orderService.deleteOrderById(id);
        return "redirect:/order/list";
    }

    @GetMapping("/user/{userId}")
    public ModelAndView getOrdersByOwnerUserId(@PathVariable("userId") Long userId){
        var order= orderService.getOrdersByOwnerUserId(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders", order);
        modelAndView.setViewName("secured/services/buyer/order/orderPage");
        return modelAndView;
    }

}
