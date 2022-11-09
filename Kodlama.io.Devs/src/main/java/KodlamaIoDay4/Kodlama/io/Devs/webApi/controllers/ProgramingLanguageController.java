package KodlamaIoDay4.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIoDay4.Kodlama.io.Devs.business.abstracts.IProgramingLanguageService;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreatePLRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateUpdatePLRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.response.GetAllPLResponse;

@RestController
@RequestMapping("/api/programingLanguages")
public class ProgramingLanguageController {
	
	IProgramingLanguageService programingLanguageService;

	@Autowired
	public ProgramingLanguageController(IProgramingLanguageService programingLanguageService) {
		this.programingLanguageService = programingLanguageService;
	}
	

	@GetMapping("/getall")
	List<GetAllPLResponse> getAll(){
		
		return programingLanguageService.getAll();		
	}
	@PostMapping("/add")
	void add(CreatePLRequest createPLRequest) throws Exception {
		
		programingLanguageService.add(createPLRequest);
		
	}
	
	@DeleteMapping("/delete")
	void delete(int id) throws Exception {
		
		programingLanguageService.delete(id);
		
	}
	@PutMapping("update")
	void update(int id, CreateUpdatePLRequest request) throws Exception{
		programingLanguageService.update(id, request);
	}
	
	

}
