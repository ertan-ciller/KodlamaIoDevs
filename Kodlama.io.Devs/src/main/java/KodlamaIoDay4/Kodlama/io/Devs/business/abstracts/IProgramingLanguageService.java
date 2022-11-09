package KodlamaIoDay4.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreatePLRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateUpdatePLRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.response.GetAllPLResponse;

public interface IProgramingLanguageService {
	
	public List<GetAllPLResponse> getAll();
	void add(CreatePLRequest createPLRequest) throws Exception;
	void delete(int id);
	void update(int id, CreateUpdatePLRequest createUpdatePLRequest) throws Exception;
	

}
