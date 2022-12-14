package KodlamaIoDay4.Kodlama.io.Devs.entites.concretes;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "programingLanguage")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProgramingLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@NotEmpty
	@Column(name = "languageName")
	private String languageName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "programingLanguage" , fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Framework> frameworkList;
	




	
}
