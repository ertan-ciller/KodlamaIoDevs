package KodlamaIoDay4.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIoDay4.Kodlama.io.Devs.business.abstracts.IFrameworkService;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateFrameworkRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateUpdateFreameworkRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.response.GetAllFrameWorkResponse;


@RestController
@RequestMapping("/api/frameworks")
public class FrameworkController {
	
	IFrameworkService frameworkService;

	public FrameworkController(IFrameworkService frameworkService) {
		super();
		this.frameworkService = frameworkService;
	}
	
	@GetMapping("getall")
	public List<GetAllFrameWorkResponse> getAll(){
		return frameworkService.getAll();
		
	}
	
	@PostMapping("add")
	public void add(CreateFrameworkRequest request) throws Exception{
		frameworkService.add(request);
	}
	
	@DeleteMapping("delete")
	public void delete(int id) {
		frameworkService.delete(id);
	}
	
	@PutMapping("update")
	public void update(int id, CreateUpdateFreameworkRequest request) throws Exception{
		
		frameworkService.update(id, request);
	}
	
	
	
	

}
