package api.msvacina.service;


import api.msvacina.model.Exception.ObjectConflictException;
import api.msvacina.model.Exception.ObjectInternalErrorException;
import api.msvacina.model.Vacina;
import api.msvacina.repository.VacinaRepository;
import api.msvacina.model.Exception.ObjectNotFoundException;
import io.swagger.model.VacinaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    public VacinaRepository vacinaRepository;



    public Vacina findByName(String nome){
        Optional<Vacina> vacina = vacinaRepository.findByNome(nome);
        if (!vacina.isPresent()){
            throw new ObjectNotFoundException("Vacina não encontrada!");
        }
        return vacina.get();
    }

    public void notExistVacina(String nome){
        if(vacinaRepository.existsByNome(nome)) {
            throw new ObjectConflictException("Conflito: vacina já existe");
        }
    }

    @Transactional
    public void save(VacinaRequest vacinaRequest){
        try{
            Vacina vacina = new Vacina();
            vacina.setNome(vacinaRequest.getNome());
            vacina.setMarca(vacinaRequest.getMarca());
            vacinaRepository.save(vacina);
        }catch(RuntimeException e){
            throw new ObjectInternalErrorException(e.getMessage());
        }

    }

}
