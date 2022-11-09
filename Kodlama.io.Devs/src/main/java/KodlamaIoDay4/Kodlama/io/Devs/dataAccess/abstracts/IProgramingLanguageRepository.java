package KodlamaIoDay4.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIoDay4.Kodlama.io.Devs.entites.concretes.ProgramingLanguage;

public interface IProgramingLanguageRepository extends JpaRepository<ProgramingLanguage, Integer> {
	

}
