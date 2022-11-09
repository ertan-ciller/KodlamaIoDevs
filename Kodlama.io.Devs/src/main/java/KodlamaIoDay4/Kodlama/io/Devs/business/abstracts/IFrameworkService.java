package KodlamaIoDay4.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateFrameworkRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.request.CreateUpdateFreameworkRequest;
import KodlamaIoDay4.Kodlama.io.Devs.business.response.GetAllFrameWorkResponse;

public interface IFrameworkService {
	
	List<GetAllFrameWorkResponse> getAll();
	void add(CreateFrameworkRequest req) throws Exception;
	void delete(int id);
	void update(int id, CreateUpdateFreameworkRequest createUpdateFreameworkRequest) throws Exception;
	
	
	

}
