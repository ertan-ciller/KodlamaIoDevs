package KodlamaIoDay4.Kodlama.io.Devs.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFrameworkRequest {

	private int languageId;
	private String name;
}
