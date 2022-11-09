package KodlamaIoDay4.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIoDay4.Kodlama.io.Devs.business.abstracts.IProgramingLanguageService;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreatePLRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateUpdatePLRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.response.GetAllPLResponse;
import KodlamaIoDay4.Kodlama.io.Devs.dataAccess.abstracts.IProgramingLanguageRepository;
import KodlamaIoDay4.Kodlama.io.Devs.entites.concretes.ProgramingLanguage;

@Service
public class ProgramingLanguageManager implements IProgramingLanguageService{

	public IProgramingLanguageRepository programingLanguageRepository;
	
	
	@Autowired
	public ProgramingLanguageManager(IProgramingLanguageRepository programingLanguageRepository) {
		//super();
		this.programingLanguageRepository = programingLanguageRepository;
	}


	@Override
	public List<GetAllPLResponse> getAll() {
		
		List<ProgramingLanguage> pl = programingLanguageRepository.findAll();
		List<GetAllPLResponse> plResponse = new ArrayList<GetAllPLResponse>();
		for(ProgramingLanguage programingLanguage : pl) {
			GetAllPLResponse response = new GetAllPLResponse();
			response.setId(programingLanguage.getId());
			response.setName(programingLanguage.getLanguageName());
			plResponse.add(response);
			
			
		}
		
		return plResponse;
		
	}


	@Override
	public void add(CreatePLRequest createPLRequest) {
		ProgramingLanguage pl = new ProgramingLanguage();
		pl.setLanguageName(createPLRequest.getName());
		this.programingLanguageRepository.save(pl);
		
		
	}


	@Override
	public void delete(int id) {
		this.programingLanguageRepository.deleteById(id);
		
	}


	@Override
	public void update(int id, CreateUpdatePLRequest createUpdatePLRequest) {
		// TODO Auto-generated method stub
		
	}


	



	
	
	

}
