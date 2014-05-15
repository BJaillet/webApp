package fr.treeptik.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.model.Client;
import fr.treeptik.service.ClientService;
import fr.treeptik.service.ServiceException;
import fr.treeptik.validator.ClientValidator;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientValidator clientValidator;
	
	@RequestMapping (value = "/init.do", method = RequestMethod.GET)
	public ModelAndView initForm(Client client) {
		ModelAndView modelAndView = new ModelAndView("client");
		
		if (client.getId() == null) {
			client = new Client();
		} else {
			client = clientService.findById(client.getId());
		}
		
		modelAndView.addObject("cl", client);
		return modelAndView;
	}
	
	@RequestMapping (value = "/save.do", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute(value = "cl") Client client, BindingResult result) throws ServiceException{
		
		clientValidator.validate(client, result);
		
		ModelAndView modelAndView = new ModelAndView("client_submitted");
		
		if (client.getId() == null) {
			client = clientService.save(client);
		} else {
			client = clientService.update(client);
		}
		
		if (result.hasErrors()) {
			return new ModelAndView("client" ,"cl", client);
		}
		
		modelAndView.addObject("cl2", client);
		return modelAndView;
	}
	
	@RequestMapping (value = "/list.do", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("list-client", "clients", clientService.findAll());
		return modelAndView;
	}
	
	@RequestMapping (value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete (Client client) {
		ModelAndView modelAndView = new ModelAndView("redirect:list.do");
		clientService.remove(client);
		return modelAndView;
	}
	
}
