package KodlamaIoDay4.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import KodlamaIoDay4.Kodlama.io.Devs.business.abstracts.IFrameworkService;
import KodlamaIoDay4.Kodlama.io.Devs.business.abstracts.constants.Messages;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateFrameworkRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateUpdateFreameworkRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.response.GetAllFrameWorkResponse;
import KodlamaIoDay4.Kodlama.io.Devs.dataAccess.abstracts.IFrameworkRepository;
import KodlamaIoDay4.Kodlama.io.Devs.dataAccess.abstracts.IProgramingLanguageRepository;
import KodlamaIoDay4.Kodlama.io.Devs.entites.concretes.Framework;
import KodlamaIoDay4.Kodlama.io.Devs.entites.concretes.ProgramingLanguage;

@Service
public class FrameworkManager implements IFrameworkService{

	
	private IFrameworkRepository frameworkRepository;
	private IProgramingLanguageRepository programingLanguageRepository;
	
	public FrameworkManager(IFrameworkRepository frameworkRepository,
			IProgramingLanguageRepository programingLanguageRepository) {
		super();
		this.frameworkRepository = frameworkRepository;
		this.programingLanguageRepository = programingLanguageRepository;
	}

	@Override
	public List<GetAllFrameWorkResponse> getAll() {
		List<Framework> frameworks = frameworkRepository.findAll();
		List<GetAllFrameWorkResponse> frameWorkResponses = new ArrayList<GetAllFrameWorkResponse>();
		
		for(Framework framework : frameworks) {
			GetAllFrameWorkResponse responseItem = new GetAllFrameWorkResponse();
			
			responseItem.setId(framework.getId());
			responseItem.setName(framework.getName());
			responseItem.setLanguageId(framework.getProgramingLanguage().getId());
			frameWorkResponses.add(responseItem);
		}
		return frameWorkResponses;
	}

	@Override
	public void add(CreateFrameworkRequest req) throws Exception {
		
		isNameEmpty(req.getName());
		isNameExist(req.getName());
		Framework framework = new Framework();
		ProgramingLanguage programingLanguage = programingLanguageRepository.findById(req.getLanguageId()).get();
		framework.setName(req.getName());
		framework.setProgramingLanguage(programingLanguage);
		
		frameworkRepository.save(framework);
		
		
	}

	@Override
	public void delete(int id) {
		
		frameworkRepository.deleteById(id);
		
	}

	@Override
	public void update(int id, CreateUpdateFreameworkRequest createUpdateFreameworkRequest) throws Exception {
		
		isNameEmpty(createUpdateFreameworkRequest.getName());
		isNameExist(createUpdateFreameworkRequest.getName());
		ProgramingLanguage programingLanguage = programingLanguageRepository.findById(createUpdateFreameworkRequest.getLanguageId()).get();
		Framework framework = frameworkRepository.findById(id).get();
		
		framework.setName(createUpdateFreameworkRequest.getName());
		framework.setProgramingLanguage(programingLanguage);
		frameworkRepository.save(framework);
		
		
	}
	private void isNameEmpty(String name) throws Exception{
		if(name.isEmpty() || name.isBlank()) {
			throw new Exception(Messages.nameEmpty);
			
		}
	}
	private void isNameExist(String name) throws Exception{
		var frameworkList = frameworkRepository.findAll();
		for(Framework framework : frameworkList) {
			if(framework.getName().toLowerCase().equals(name.toLowerCase())) {
				throw new Exception(Messages.nameExist);
			}
		}
	}

	

}
