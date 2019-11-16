//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.csumb.Webstore.model.Cart;
import edu.csumb.Webstore.repositories.CartRepository;
import io.swagger.annotations.ApiOperation;
@RestController
public class CartController
{

    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    CartRepository cartRepository;

    //REQUESTMAPPING
    //We are setting a request mapping with request type GET. You can change these to POST or anything else you want!
    //The value is the location of the api. So this would be HEROKU/products/example

    //APIOPERATION
    //This is comments that will be displayed in swagger. Remember to do this or you will lose points!

    //EXAMPLE()
    //We are returning an Iterable, which means a List! Use Iterable<Datatype> when you want to return many.
    //For example Iterable<Product>
    @ApiOperation(value = "Adds products and their quantity to the cart")
    @PostMapping("/cart/add")
    public Cart addCart(@RequestBody Cart cart)
    {
        Cart curr = cartRepository.findByUserName(cart.getUserName());
        if(curr != null){
            HashMap<String,Integer> currProducts = curr.getProducts();
            HashMap<String,Integer> newProducts = cart.getProducts();
            for(String product : newProducts.keySet()){
                if(currProducts.containsKey(product)){
                    Integer currVal = currProducts.get(product);
                    currVal += cart.getProducts().get(product);
                    currProducts.put(product, currVal);
                } else {
                    currProducts.put(product, newProducts.get(product));
                }
            }
            return curr;
        } else {
            return cartRepository.save(cart);
        }
    }
    @ApiOperation(value = "Clears a users cart")
    @PostMapping("/checkout")
    public Cart checkout(@RequestParam String userName)
    {
        Cart cart = cartRepository.findByUserName(userName);
        cart.getProducts().clear();
        return cart;
    }
    @ApiOperation(value = "Adjusts the quantity of a certain product")
    @PostMapping("/cart/quantity")
    public Cart changeQuant(@RequestParam String userName, @RequestParam String productId, @RequestParam Integer count)
    {
        Cart cart = cartRepository.findByUserName(userName);
        if(count == 0){
            cart.getProducts().remove(productId);
        } else {
            cart.getProducts().put(productId, count);
        }
        return cart;
    }



    //NETWORKING QUICK REFERENCE
    //IF @RequestMapping(method = RequestMethod.GET, value = "/example/{var}")
    //Then you should use @RequestParam to get the variable, like so
    // public returnType getVar(@RequestParam DataType var)

    //IF  @RequestMapping(method = RequestMethod.POST, value = "/example")
    //Then you should use @RequestBody to get the variable, like so.
    //public returnType foo(@RequestBody dataType var)

    //Put and Delete will use either. They can also be compiled.
    // So IF @RequestMapping(value = "/{pathVar}", method = RequestMethod.PUT)
    //public void foo(@RequestParam dataType pathVar, @RequestBody dataType postVar)


}